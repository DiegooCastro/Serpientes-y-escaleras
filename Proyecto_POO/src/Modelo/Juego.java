/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Helpers.Conexion;
import Vista.Partida;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class Juego extends Conexion{
    private boolean retorno;
    private PreparedStatement ps;
    private ResultSet rs;
    private ResultSetMetaData rm;
    private String query;
    
    public int numeroCasillas() {
        int numCasillas = 0;
        try {
            query = "SELECT COUNT(*) FROM Casillas_tablero WHERE id_tablero = ?";
            ps = super.getConnection().prepareStatement(query);
            ps.setInt(1, Juego.getIdTablero());
            rs = ps.executeQuery();
            if (rs.next()) {
                numCasillas = rs.getInt(1);
            }      
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error critico al ingresar : " + e);
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return numCasillas;
    }
    
    public Object[][] cargarFichas() {
        Object[][] datos = {};
        try { 
            
            query = "SELECT * FROM Casillas_tablero c WHERE id_tablero = ?";
            ps = super.getConnection().prepareStatement(query);
            ps.setInt(1, Juego.getIdTablero());
            rs = ps.executeQuery();
            int filas = 0, j = 0;
            while(rs.next()){
                filas ++;
            }
            query = "SELECT c.numero_casilla,posicion_x,posicion_y,t.tipo_casilla,posicion_final \n" +
            "FROM Casillas_tablero c\n" +
            "INNER JOIN Tipo_casilla t ON c.id_tipo_casilla = t.id\n" +
            "WHERE id_tablero = ?\n" +
            "ORDER BY numero_casilla ASC";
            ps = super.getConnection().prepareStatement(query);
            ps.setInt(1, Juego.getIdTablero());
            rs = ps.executeQuery();
            rm = rs.getMetaData();
            
            int columnas = rm.getColumnCount();
            Partida.rows = filas;
            datos = new Object[columnas][filas];
            
            while (rs.next()) {
                for (int i = 0; i < columnas; i++) {
                    datos[i][j] = rs.getObject(i + 1);
                }
                j++;
            }         
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error critico al cargar datos : " + e);
            return null;
        }
        return datos;
    }
    
    public boolean iniciarPartidaIndividual() {
        retorno = false;
        try {
            query = "exec iniciarPartidaIndividual ?,?,?";
            ps = super.getConnection().prepareStatement(query);
            ps.setInt(1, Juego.getIdTablero());
            ps.setInt(2, Juego.getIdFicha1());
            ps.setInt(3, Jugador.getIdJugador());
            if (!ps.execute()) {
                System.out.println("Partida individual iniciada!!!");
                retorno = true;
            }      
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error critico al ingresar : " + e);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }
    
    public boolean iniciarPartidaCompetencia() {
        retorno = false;
        try {
            query = "exec iniciarPartidaCompetencia ?,?,?,?,?";
            ps = super.getConnection().prepareStatement(query);
            ps.setInt(1, Juego.getIdTablero());
            ps.setInt(2, Juego.getIdFicha1());
            ps.setInt(3, Jugador.getIdJugador());
            ps.setInt(4, Juego.getIdFicha2());
            ps.setInt(5, Jugador.getIdJugador2());
            if (!ps.execute()) {
                retorno = true;
            }      
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error critico al ingresar : " + e);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }
    
    private static int idTablero;
    private static int idFichaJ1;
    private static int idFichaJ2;
    private static String urlFichaJ1;
    private static String urlFichaJ2;
    private static String urlTablero;
    
    public static String getUrlTablero() {
        return urlTablero;
    }

    public static void setUrlTablero(String aUrlTablero) {
        urlTablero = aUrlTablero;
    }
    
    public static int getIdFicha1() {
        return idFichaJ1;
    }

    public static void setIdFicha1(int aIdFicha1) {
        idFichaJ1 = aIdFicha1;
    }

    public static int getIdFicha2() {
        return idFichaJ2;
    }

    public static void setIdFicha2(int aIdFicha2) {
        idFichaJ2 = aIdFicha2;
    }
    
    public static int getIdTablero() {
        return idTablero;
    }

    public static void setIdTablero(int aIdTablero) {
        idTablero = aIdTablero;
    }
    
    public static String getUrlFichaJ1() {
        return urlFichaJ1;
    }

    public static void setUrlFichaJ1(String aUrlFichaJ1) {
        urlFichaJ1 = aUrlFichaJ1;
    }

    public static String getUrlFichaJ2() {
        return urlFichaJ2;
    }

    public static void setUrlFichaJ2(String aUrlFichaJ2) {
        urlFichaJ2 = aUrlFichaJ2;
    }
}
