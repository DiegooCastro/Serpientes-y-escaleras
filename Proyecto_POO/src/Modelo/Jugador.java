/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Helpers.Conexion;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Jugador extends Conexion {
    
    // Atributos para la conexion con la base 
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean retorno;
    private String query;

    public boolean iniciarSesion() {
        retorno = false;
        try {
            query = "select id,nombre,partidas_jugadas,partidas_ganadas,edad "
                    + "from Jugador where nickname = ? AND clave = ?";
            ps = super.getConnection().prepareStatement(query);
            ps.setString(1, getNickname());
            ps.setString(2, getClave());
            rs = ps.executeQuery();
            if (rs.next()) {
                Jugador.setIdJugador(rs.getInt(1));
                Jugador.setNombre(rs.getString(2));
                Jugador.setPartidas_jugadas(rs.getInt(3));
                Jugador.setPartidas_ganadas(rs.getInt(4));
                Jugador.setEdad(rs.getInt(5));
                Jugador.setNickname(getNickname());
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Error critico al cargar datos : " + e);
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }

    // Iniciar sesion para el segundo jugador 
    public boolean iniciarSesionJugadorDos() {
        retorno = false;
        try {
            query = "select id,nombre,partidas_jugadas,partidas_ganadas,edad "
                    + "from Jugador where nickname = ? AND clave = ?";
            ps = super.getConnection().prepareStatement(query);
            ps.setString(1, getNickname2());
            ps.setString(2, getClave2());
            rs = ps.executeQuery();
            if (rs.next()) {
                Jugador.setIdJugador2(rs.getInt(1));
                Jugador.setNombre2(rs.getString(2));
                Jugador.setPartidas_jugadas2(rs.getInt(3));
                Jugador.setPartidas_ganadas2(rs.getInt(4));
                Jugador.setEdad2(rs.getInt(5));
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Error critico al cargar datos : " + e);
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }

    // Funcion para registrar un nuevo jugador en la base de datos 
    public boolean registrarJugador() {
        retorno = false;
        try {
            query = "select * from Jugador where nickname = ?";
            ps = super.getConnection().prepareStatement(query);
            ps.setString(1, getNickname());
            rs = ps.executeQuery();
            if (!rs.next()) {
                query = "exec registrarJugador ?,?,?,?,?";
                ps = super.getConnection().prepareStatement(query);
                ps.setString(1, Jugador.getNombre());
                ps.setString(2, Jugador.getNickname());
                ps.setInt(3, Jugador.getEdad());
                ps.setString(4, Jugador.getGenero());
                ps.setString(5, Jugador.getClave());
                if (!ps.execute()) {
                    retorno = true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nickname ya esta en uso");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error critico al ingresar : " + e);
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }
    
    
    // Atributos estaticos para el jugador 1
    private static int idJugador;
    private static String nombre;
    private static String nickname;
    private static String genero;
    private static int edad;
    private static int partidas_jugadas;
    private static int partidas_ganadas;
    private static String clave;

    public static int getIdJugador() {
        return idJugador;
    }

    public static void setIdJugador(int idJugador) {
        Jugador.idJugador = idJugador;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Jugador.nombre = nombre;
    }
    
    public static String getGenero() {
        return genero;
    }

    public static void setGenero(String aGenero) {
        genero = aGenero;
    }

    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        Jugador.nickname = nickname;
    }

    public static int getEdad() {
        return edad;
    }

    public static void setEdad(int edad) {
        Jugador.edad = edad;
    }

    public static int getPartidas_jugadas() {
        return partidas_jugadas;
    }

    public static void setPartidas_jugadas(int aPartidas_jugadas) {
        partidas_jugadas = aPartidas_jugadas;
    }

    public static int getPartidas_ganadas() {
        return partidas_ganadas;
    }

    public static void setPartidas_ganadas(int aPartidas_ganadas) {
        partidas_ganadas = aPartidas_ganadas;
    }

    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) {
        Jugador.clave = clave;
    }

    // Getters y setters para el jugador 2
    private static int idJugador2;
    private static String nombre2;
    private static String nickname2;
    private static String genero2;
    private static int edad2;
    private static int partidas_jugadas2;
    private static int partidas_ganadas2;
    private static String clave2;

    public static int getIdJugador2() {
        return idJugador2;
    }

    public static void setIdJugador2(int aIdJugador2) {
        idJugador2 = aIdJugador2;
    }

    public static String getNombre2() {
        return nombre2;
    }

    public static void setNombre2(String aNombre2) {
        nombre2 = aNombre2;
    }
    
    public static String getGenero2() {
        return genero2;
    }

    public static void setGenero2(String aGenero2) {
        genero2 = aGenero2;
    }

    public static String getNickname2() {
        return nickname2;
    }

    public static void setNickname2(String aNickname2) {
        nickname2 = aNickname2;
    }

    public static int getEdad2() {
        return edad2;
    }

    public static void setEdad2(int aEdad2) {
        edad2 = aEdad2;
    }

    public static int getPartidas_jugadas2() {
        return partidas_jugadas2;
    }

    public static void setPartidas_jugadas2(int aPartidas_jugadas2) {
        partidas_jugadas2 = aPartidas_jugadas2;
    }

    public static int getPartidas_ganadas2() {
        return partidas_ganadas2;
    }

    public static void setPartidas_ganadas2(int aPartidas_ganadas2) {
        partidas_ganadas2 = aPartidas_ganadas2;
    }

    public static String getClave2() {
        return clave2;
    }

    public static void setClave2(String aClave2) {
        clave2 = aClave2;
    }
}
