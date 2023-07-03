/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Castroll
 */
public class ThreadEfects extends Thread {
    
    private static boolean reproducir = true;
    private static String urlAudio;
    
    public static Player Sound;
    
    private void play() throws InterruptedException, FileNotFoundException, JavaLayerException {
        Sound = new Player(new FileInputStream(getUrlAudio()));
        Sound.play();
    }
    
    @Override
    public void run(){
        try {     
            this.play();
        } catch (InterruptedException ex) {
            System.out.println("Error critico al reproducir audio:" + ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ThreadEfects.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(ThreadEfects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    public static boolean getReproducir() {
        return reproducir;
    }

    public static void setReproducir(boolean aReproducir) {
        reproducir = aReproducir;
    }
    
    public static String getUrlAudio() {
        return urlAudio;
    }

    public static void setUrlAudio(String aUrlAudio) {
        urlAudio = aUrlAudio;
    }
}

