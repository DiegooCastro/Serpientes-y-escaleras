/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Vista.MenuPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Main extends Conexion{
    
    public static void main(String[] args){
        try{
            ThreadMusic.Sound.close();
        }catch(Exception e){}
        ThreadMusic.setUrlAudio("src/Audio/audioMenu.mp3");
        ThreadMusic audio = new ThreadMusic();
        audio.start();
        new MenuPrincipal().setVisible(true); 
        if (Conexion.getConnection() == null) {
            JOptionPane.showMessageDialog(null,"Debes crear la base de datos para poder jugar" ,"Error al conectar a la base de datos",2);
            System.exit(1);
        }  
    }
}
