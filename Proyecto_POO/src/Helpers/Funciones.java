/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Diego
 */
public class Funciones {
    
    public void cargarImagen(String ruta, JLabel lbl) {
        try{
            Icon imagen;
            imagen = new ImageIcon(getClass().getResource(ruta));                       
            lbl.setIcon(imagen);
        } catch(Exception e){
            System.out.println("Error al cargar imagen: " + e);
        }
    }
    
    public String encriptarClave(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int numeroAleatorio(){
        int n;
        // Número aleatorio del 1 al 6;
        n = (int) (Math.floor(Math.random() * (6-1+1)) + 1);
        return n;
    }
}
