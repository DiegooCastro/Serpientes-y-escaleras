/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Castroll
 */
public abstract class Conexion {

    private static Connection con;

    // Conexion para JAVA 8 y Netbeans 8.2
    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PROYECTO_POO;IntegratedSecurity=true");
        } catch (ClassNotFoundException | SQLException e) {
            con = null;
            System.out.println(e);
        }
        return con;
    }
}
