/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Helpers.Conexion;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class Resultado extends Conexion {
    
    // Atributos para la conexion con la base 
    private static PreparedStatement ps;
    private static boolean retorno;
    private static String query;
    
    public static boolean finalizarPartidaIndividual(int cantidadTiros,int cantidadEscalera, int cantidadSerpiente) {
        retorno = false;
        try {
            query = "exec finalizarPartidaIndividual ?,?,?,?,?";
            ps = Conexion.getConnection().prepareStatement(query);
            ps.setObject(1, null);
            ps.setInt(2, Jugador.getIdJugador());
            ps.setInt(3, cantidadTiros);
            ps.setInt(4, cantidadEscalera);
            ps.setInt(5, cantidadSerpiente);
            if (!ps.execute()) {
                System.out.println("Partida individual finalizada!!!");
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
    
    public static boolean actualizarEstadisticasJugador(int id_jugador) {
        retorno = false;
        try {
            query = "exec actualizarEstadisticasJugador ?";
            ps = Conexion.getConnection().prepareStatement(query);
            ps.setInt(1, id_jugador);
            if (!ps.execute()) {
                System.out.println("Estadisticas de jugador actualizadas!!!");
                retorno = true;
            }      
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error critico al ejecutar proceso actualizarEstadisticasJugador : " + e);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }
    
    public static boolean finalizarPartidaCompetencia(int idResultadoJ1, int tirosJ1, int escaleraJ1, int serpienteJ1,int desbanqueJ1,
           int idResultadoJ2, int tirosJ2, int escaleraJ2, int serpienteJ2,int desbanqueJ2) {
        retorno = false;
        try {
            query = "exec finalizarPartidaCompetencia ?,?,?,?,?,?,?,?,?,?,?,?";
            ps = Conexion.getConnection().prepareStatement(query);
            ps.setInt(1, idResultadoJ1);
            ps.setInt(2, Jugador.getIdJugador());
            ps.setInt(3, tirosJ1);
            ps.setInt(4, escaleraJ1);
            ps.setInt(5, serpienteJ1);
            ps.setInt(6, desbanqueJ1);
            ps.setInt(7, idResultadoJ2);
            ps.setInt(8, Jugador.getIdJugador2());
            ps.setInt(9, tirosJ2);
            ps.setInt(10, escaleraJ2);
            ps.setInt(11, serpienteJ2);
            ps.setInt(12, desbanqueJ2);
            if (!ps.execute()) {
                System.out.println("Partida competencia finalizada!!!");
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
}
