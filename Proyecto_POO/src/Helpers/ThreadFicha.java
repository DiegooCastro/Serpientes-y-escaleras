/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import javax.swing.JLabel;

/**
 *
 * @author Diego
 */
public class ThreadFicha extends Thread {
    
    // Atributos obtenidos del arreglo generado con la base de datos 
    private int tiempo;
    private static int posicionX;
    private static int posicionY;
    private JLabel lblFicha;  

    @Override
    public void run() {
        try {
            Thread.sleep(this.getTiempo());
            lblFicha.setLocation(this.getPosicionX(), this.getPosicionY());
        } catch (InterruptedException e) {
            System.out.println("Error en hilo ficha: " + e);
        }
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        ThreadFicha.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        ThreadFicha.posicionY = posicionY;
    }

    public JLabel getLblFicha() {
        return lblFicha;
    }

    public void setLblFicha(JLabel lblFicha) {
        this.lblFicha = lblFicha;
    }
    
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

}




