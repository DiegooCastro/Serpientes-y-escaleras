/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Helpers.ThreadFicha;
import Helpers.ThreadEfects;
import javax.swing.JLabel;

/**
 *
 * @author Diego
 */
public class CasillaEspecialHard extends javax.swing.JFrame {

    /**
     * Creates new form Aceptar
     * @param tipoCasilla
     * @param posicionFinal
     * @param modalidad
     */
    public CasillaEspecialHard(String tipoCasilla, String posicionFinal,String modalidad, String jugador) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.modalidad = modalidad;
        this.jugador = jugador;
        if ("".equals(jugador)) {
            lblTitulo.setText("Caiste en una casilla " + tipoCasilla);
        } else {
            lblTitulo.setText("Has sido desbancado por el " + jugador);
        }
        
        this.posicionFinal = Integer.parseInt(posicionFinal);
        
        if ("Serpiente".equals(tipoCasilla)) {
            btnAceptar.setText("Retroceder");
            ThreadEfects.setUrlAudio("src//Audio/audioSerpiente.mp3");
            lblGift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/serpiente.gif")));
            ThreadEfects audio = new ThreadEfects();
            audio.start();
        } else if("Escalera".equals(tipoCasilla)) {
            btnAceptar.setText("Avanzar");
            ThreadEfects.setUrlAudio("src//Audio/audioEscalera.mp3");
            ThreadEfects audio = new ThreadEfects();
            audio.start();
            lblGift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/escalera.gif")));
        } else if ("Desbanque".equals(tipoCasilla)) {
            btnAceptar.setText("Aceptar");
            ThreadEfects.setUrlAudio("src//Audio/audioSerpiente.mp3");
            ThreadEfects audio = new ThreadEfects();
            audio.start();
            lblGift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/desbanque.gif")));
        }
        
    }

    private int posicionFinal, x, y;
    private String modalidad;
    private String jugador;
    
    protected void cargarDatos(Object[][] datos,int posicionFinal){
        try{
            x =  Integer.parseInt(datos[1][posicionFinal].toString());
            y =  Integer.parseInt(datos[2][posicionFinal].toString());            
        }catch(NumberFormatException e){
            System.out.println("Vacio: " + e);
        }
    }
    
    protected void moverFicha(JLabel lblFicha){
        try{
            ThreadFicha hilo = new ThreadFicha();
            hilo.setLblFicha(lblFicha);
            hilo.setTiempo(500);
            hilo.setPosicionX(x);
            hilo.setPosicionY(y);
            hilo.start();
            if (PartidaCompetenciaHard.contadorJ1  == PartidaCompetenciaHard.contadorJ2 && Modalidad.competencia) {
                if (PartidaCompetenciaHard.turnoJ1) {
                    PartidaCompetenciaHard.numeroDesbanqueJ1 = PartidaCompetenciaHard.numeroDesbanqueJ1 + 1;
                    new CasillaEspecialHard("Desbanque",String.valueOf(0),"Competencia","J2").setVisible(true);
                } else {
                    PartidaCompetenciaHard.numeroDesbanqueJ2 = PartidaCompetenciaHard.numeroDesbanqueJ2 + 1;
                    new CasillaEspecialHard("Desbanque",String.valueOf(0),"Competencia","J1").setVisible(true);
                }
                
            }
        }catch(NumberFormatException e){
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblGift = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/escalera.gif"))); // NOI18N
        jPanel1.add(lblGift, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 500, 410));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitulo.setText("CAISTE EN UNA CASILLA ESCALERA");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, 50));

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAceptar.setText("Avanzar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 460, 44));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 500, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (modalidad.equals("Individual")) {
            cargarDatos(PartidaHard.datos, posicionFinal-1);
            moverFicha(PartidaHard.lblFicha1);
            PartidaHard.contadorJ1 = posicionFinal-1;
        } else {
            if (jugador.equals("")) {
                if (!PartidaCompetenciaHard.turnoJ1) {
                    cargarDatos(PartidaCompetenciaHard.datos, posicionFinal-1);
                    PartidaCompetenciaHard.contadorJ1 = posicionFinal-1;
                    moverFicha(PartidaCompetenciaHard.lblFicha1);
                    
                } else {
                    cargarDatos(PartidaCompetenciaHard.datos, posicionFinal-1);
                    PartidaCompetenciaHard.contadorJ2 = posicionFinal-1;
                    moverFicha(PartidaCompetenciaHard.lblFicha2);
                    
                }
            } else {
                if (jugador.equals("J1")) {
                    cargarDatos(PartidaCompetenciaHard.datos, posicionFinal);
                    PartidaCompetenciaHard.contadorJ2 = posicionFinal;
                    moverFicha(PartidaCompetenciaHard.lblFicha2);
                    
                } else {
                    cargarDatos(PartidaCompetenciaHard.datos, posicionFinal);
                    PartidaCompetenciaHard.contadorJ1 = posicionFinal;
                    moverFicha(PartidaCompetenciaHard.lblFicha1);
                    
                }
            }
            
        }
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CasillaEspecialHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CasillaEspecialHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CasillaEspecialHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CasillaEspecialHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CasillaEspecialHard(args[0], args[1], args[2], args[3]).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblGift;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
