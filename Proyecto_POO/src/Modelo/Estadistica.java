/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Helpers.Conexion;
import Vista.DetalleCompetencia;
import Vista.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class Estadistica extends Conexion {
    
    // Atributos para la conexion con la base 
    private PreparedStatement ps;
    private ResultSet rs;
    private ResultSetMetaData rm;
    private String query;
    
    // Mostramos la lista de todos los jugadores registrados en la base de datos
    public void cargarJugadores(DefaultTableModel tb) throws SQLException {
        try { 
            tb.setRowCount(0);
            query = "select nickname,nombre,edad,genero, ISNULL((SELECT dbo.numeroPartidasIndividuales(id)),0) 'partidas individuales',\n" +
            "ISNULL((SELECT dbo.numeroPartidasCompetencia(id)),0) 'partidas competencia',partidas_ganadas 'partidas ganadas',  (ISNULL((SELECT dbo.numeroPartidasCompetencia(id)),0) - partidas_ganadas) 'partidas perdidas'\n" +
            "from Jugador\n" +
            "order by partidas_jugadas desc";
            ps = super.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            rm = rs.getMetaData();
            while (rs.next()) {
                Object[] o = new Object[rm.getColumnCount()];
                for (int i = 0; i < o.length; i++) {
                    o[i] = rs.getObject(i + 1);
                }
                tb.addRow(o);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error critico al cargar datos : " + e);
        } finally{
            ps.close();
            rs.close();
        }
    }
    
    // Si el usuario enviado es null cargara todos las las partidas pero si envia algun usuario se mostraran solo las de ese usuario
    public void cargarJuegosIndividuales(DefaultTableModel tb, String jugador) throws SQLException {
        try { 
            tb.setRowCount(0);
            query = "select p.fecha_inicio,p.fecha_fin, j.nombre,j.nickname,f.nombre_ficha, t.nombre_tablero, d.cantidad_tiros,d.cantidad_escalera,d.cantidad_serpiente\n" +
            "from Detalle_partida d\n" +
            "inner join Ficha f ON f.id = d.id_ficha\n" +
            "inner join Jugador j ON j.id = d.id_jugador\n" +
            "full join Resultado_partida r ON r.id = d.id_resultado_partida\n" +
            "inner join Partida p ON p.id = d.id_partida\n" +
            "inner join Tablero t ON t.id = p.id_tablero\n";
            if (jugador != null) {
               query = query + " where nickname = ? and (d.cantidad_desbanque is null) order by p.fecha_inicio desc";
               ps = super.getConnection().prepareStatement(query);
               ps.setString(1, jugador); 
            } else {
               query = query + " where (d.cantidad_desbanque is null) order by p.fecha_inicio desc";
               ps = super.getConnection().prepareStatement(query);
            }
            rs = ps.executeQuery();
            rm = rs.getMetaData();
            while (rs.next()) {
                Object[] o = new Object[rm.getColumnCount()];
                for (int i = 0; i < o.length; i++) {
                    o[i] = rs.getObject(i + 1);
                }
                tb.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("Error critico al cargar datos : " + e);
        } finally{
            ps.close();
            rs.close();
        }
    }
    
    // Si el usuario enviado es null cargara todos las las partidas pero si envia algun usuario se mostraran solo las de ese usuario
    public void cargarJuegosCompetitivo(DefaultTableModel tb, String jugador, JLabel lblDetalle) throws SQLException {
        try { 
            tb.setRowCount(0);
            query = "SELECT p.id,t.nombre_tablero,fecha_inicio,fecha_fin,(select dbo.obtenerJugador1(p.id)) 'Jugador 1',(select dbo.obtenerJugador2(p.id)) 'Jugador 2' ,(select dbo.obtenerGanador(p.id)) 'Ganador'\n" +
            "FROM Partida p\n" +
            "INNER JOIN Detalle_partida d ON d.id_partida = p.id\n" +
            "INNER JOIN Tablero t ON p.id_tablero = t.id";
            ps = super.getConnection().prepareStatement(query);
            if (jugador == null) {
                query = query + " WHERE d.cantidad_desbanque IS NOT NULL \n" +
                "GROUP BY p.id,t.nombre_tablero,fecha_inicio,fecha_fin\n" +
                "ORDER BY fecha_inicio DESC";
                ps = super.getConnection().prepareStatement(query);
            } else {
                query = query + " WHERE d.cantidad_desbanque IS NOT NULL AND (select dbo.obtenerJugador1(p.id)) = ?\n"+
                "GROUP BY p.id,t.nombre_tablero,fecha_inicio,fecha_fin\n" +
                "ORDER BY fecha_inicio DESC";
                ps = super.getConnection().prepareStatement(query);
                ps.setString(1, jugador);
            }   
            rs = ps.executeQuery();
            rm = rs.getMetaData();
            while (rs.next()) {
                Object[] o = new Object[rm.getColumnCount()+2];
                for (int i = 0; i < o.length-2; i++) {
                    o[i] = rs.getObject(i + 1);
                }

                if (o[4].equals(o[6])) {
                    o[7] = o[6];
                    o[6] = "Victoria";
                } else {
                    o[7] = o[6];
                    o[6] = "Derrota";
                }
                
                o[8] = lblDetalle;
                tb.addRow(o);
            }
        } catch (Exception e) {
            //System.out.println("Error critico al cargar datos : " + e);
        } finally{
            ps.close();
            rs.close();
        }
    }
    
    public void cargarJuegosCompetitivoDetalle(int id_partida) throws SQLException {
        try { 
            query = "SELECT j.nickname,d.cantidad_tiros,d.cantidad_escalera,d.cantidad_serpiente,d.cantidad_desbanque ,r.resultado_partida\n" +
            "FROM Detalle_partida d \n" +
            "INNER JOIN Ficha f ON d.id_ficha = f.id \n" +
            "INNER JOIN Jugador j ON j.id = d.id_jugador \n" +
            "INNER JOIN Resultado_partida r ON r.id = d.id_resultado_partida \n" +
            "WHERE d.id_partida = ?";
            ps = super.getConnection().prepareStatement(query);
            ps.setInt(1, id_partida);     
            rs = ps.executeQuery();
            rm = rs.getMetaData();
            String[] datos = new String[11];
            boolean jugador1 = true;
            while (rs.next()) {
                if (jugador1) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                    datos[5] = rs.getString(6);
                    jugador1 = false;
                } else {
                    datos[6] = rs.getString(1);
                    datos[7] = rs.getString(2);
                    datos[8] = rs.getString(3);
                    datos[9] = rs.getString(4);
                    datos[10] = rs.getString(5);
                }            
            }
            new DetalleCompetencia(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7],datos[8],datos[9],datos[10]).setVisible(true);
        } catch (Exception e) {
            System.out.println("Error critico al cargar datos : " + e);
        } finally{
            ps.close();
            rs.close();
        }
    }
    
    // Mostramos la lista los tres jugadosres con mas victorias en el modo competencia
    public void cargarMejoresCompetencia(DefaultTableModel tb) throws SQLException {
        try { 
            tb.setRowCount(0);
            query = "SELECT TOP 3 j.nombre,j.nickname,j.genero, j.edad, COUNT(d.id) as victorias\n" +
            "FROM Detalle_partida d\n" +
            "INNER JOIN Jugador j ON j.id = d.id_jugador\n" +
            "WHERE d.id_resultado_partida = 1\n" +
            "GROUP BY j.nombre,j.nickname,j.genero, j.edad\n" +
            "ORDER BY victorias DESC;";
            ps = super.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            rm = rs.getMetaData();
            int contador = 1;
            while (rs.next()) {
                Object[] o = new Object[rm.getColumnCount()+1];
                o[0] = contador;
                for (int i = 1; i < o.length; i++) {
                    o[i] = rs.getObject(i);
                }
                contador++;
                tb.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println("Error critico al cargar datos : " + e);
        } finally {
            ps.close();
            rs.close();
        }
    }
    
    // Mostramos la lista de todos los tableros registrados en la base de datos
    public void cargarTableros(DefaultTableModel tb) throws SQLException {
        try { 
            tb.setRowCount(0);
            query = "select id, nombre_tablero, ruta_tablero from Tablero order by id asc";
            ps = super.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            rm = rs.getMetaData();
            while (rs.next()) {
                Object[] o = new Object[rm.getColumnCount()];
                for (int i = 0; i < o.length; i++) {
                    o[i] = rs.getObject(i + 1);                 
                }
                tb.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("Error critico al cargar datos : " + e);
        } finally {
            ps.close();
            rs.close();
        }
    }
    
    // Mostramos la lista de tods los fichas registradas en la base de datos
    public void cargarFichas(DefaultTableModel tb) throws SQLException {
        try { 
            tb.setRowCount(0);
            query = "select id,nombre_ficha,ruta_ficha from Ficha order by id asc";
            ps = super.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            rm = rs.getMetaData();
            while (rs.next()) {
                Object[] o = new Object[rm.getColumnCount()];
                for (int i = 0; i < o.length; i++) {
                    o[i] = rs.getObject(i + 1);                 
                }
                tb.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("Error critico al cargar datos : " + e);
        } finally{
            ps.close();
            rs.close();
        }
    }  
    
    public boolean estadisticasJugador(String nickname) throws SQLException {
        boolean result = false;
        try { 
            query = "select partidas_jugadas,ISNULL((SELECT dbo.numeroPartidasIndividuales(id)),0) 'partidas individuales',\n" +
            "ISNULL((SELECT dbo.numeroPartidasCompetencia(id)),0) 'partidas competencia',partidas_ganadas 'partidas ganadas', ISNULL((select dbo.numeroPartidasPerdidas(id)),0) 'partidas perdidas'\n" +
            "from Jugador\n" +
            "where nickname = ?\n" +
            "order by partidas_jugadas desc;";
            ps = super.getConnection().prepareStatement(query);
            ps.setString(1, nickname);
            rs = ps.executeQuery();
            rm = rs.getMetaData();
            if (rs.next()) {
                Perfil.partidasJugadas = rs.getInt(1);
                Perfil.partidasIndividuales = rs.getInt(2);
                Perfil.partidasCompetencia = rs.getInt(3);
                Perfil.partidasGanadas = rs.getInt(4);
                Perfil.partidasPerdidas = rs.getInt(5);
                result = true;
            } else {
                JOptionPane.showMessageDialog(null, "El nickname ingresado no existe", "Jugador no encontrado", 2);
                result = false;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error critico al cargar datos : " + e);
        } finally{
            ps.close();
            rs.close();
        }
        return result;
    }
}
