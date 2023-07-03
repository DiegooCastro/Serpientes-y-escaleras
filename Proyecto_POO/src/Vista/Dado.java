/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author ordon
 */
public class Dado extends javax.swing.JFrame {
    
    int n = 0;
    Icon gif = new javax.swing.ImageIcon(getClass().getResource("../Recursos/dado.gif"));
    
    public Dado(String numeroDado, String modalidad) {
        initComponents();
        lblDado.setIcon(gif);
        setLocationRelativeTo(null);
        btnContinuar.setVisible(false);
        this.numeroDado = Integer.parseInt(numeroDado);
        this.modalidad = modalidad;
    }
    private String modalidad;
    private int numeroDado;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDado = new javax.swing.JLabel();
        btnTirada = new javax.swing.JButton();
        lblResultado = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/dado.gif"))); // NOI18N

        btnTirada.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnTirada.setText("Tirada");
        btnTirada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiradaActionPerformed(evt);
            }
        });

        lblResultado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblResultado.setText("El resultado de la tirarda es:");

        btnContinuar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnContinuar.setText("Ok");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(lblResultado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(btnContinuar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(btnTirada))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(lblDado, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnTirada)
                .addGap(4, 4, 4)
                .addComponent(lblDado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnContinuar)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnTiradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiradaActionPerformed
       
    n = numeroDado;    
    try{  
        switch(n){
            case 1:
                BufferedImage bufferedImage = ImageIO.read(getClass().getResource("../Recursos/Uno.png"));
                Image image = bufferedImage.getScaledInstance(227, 218, Image.SCALE_DEFAULT);
                ImageIcon icon = new ImageIcon(image);
                lblDado.setIcon(icon);
                lblResultado.setText("El resultado de la tirada es Uno");
                btnTirada.setVisible(false);
              
                btnContinuar.setVisible(true);
                break;
            case 2:
                BufferedImage bufferedImage2 = ImageIO.read(getClass().getResource("../Recursos/Dos.png"));
                Image image2 = bufferedImage2.getScaledInstance(227, 218, Image.SCALE_DEFAULT);
                ImageIcon icon2 = new ImageIcon(image2);
                lblDado.setIcon(icon2);
                lblResultado.setText("El resultado de la tirada es Dos");
                btnTirada.setVisible(false);
               
                btnContinuar.setVisible(true);
                break;
            case 3:
                BufferedImage bufferedImage3 = ImageIO.read(getClass().getResource("../Recursos/Tres.png"));
                Image image3 = bufferedImage3.getScaledInstance(227, 218, Image.SCALE_DEFAULT);
                ImageIcon icon3 = new ImageIcon(image3);
                lblDado.setIcon(icon3);             
                lblResultado.setText("El resultado de la tirada es Tres");
                btnTirada.setVisible(false);
               
                btnContinuar.setVisible(true);
                break;
            case 4:
                BufferedImage bufferedImage4 = ImageIO.read(getClass().getResource("../Recursos/Cuatro.png"));
                Image image4 = bufferedImage4.getScaledInstance(227, 218, Image.SCALE_DEFAULT);
                ImageIcon icon4 = new ImageIcon(image4);
                lblDado.setIcon(icon4);
                lblResultado.setText("El resultado de la tirada es Cuatro");
                btnTirada.setVisible(false);
              
                btnContinuar.setVisible(true);
                break;
            case 5:
                BufferedImage bufferedImage5 = ImageIO.read(getClass().getResource("../Recursos/Cinco.png"));
                Image image5 = bufferedImage5.getScaledInstance(227, 218, Image.SCALE_DEFAULT);
                ImageIcon icon5 = new ImageIcon(image5);
                lblDado.setIcon(icon5);
                lblResultado.setText("El resultado de la tirada es Cinco");
                btnTirada.setVisible(false);
               
                btnContinuar.setVisible(true);
                break;
            case 6:
                BufferedImage bufferedImage6 = ImageIO.read(getClass().getResource("../Recursos/Seis.png"));
                Image image6 = bufferedImage6.getScaledInstance(227, 218, Image.SCALE_DEFAULT);
                ImageIcon icon6 = new ImageIcon(image6);
                lblDado.setIcon(icon6);
                lblResultado.setText("El resultado de la tirada es Seis");
                btnTirada.setVisible(false);
               
                btnContinuar.setVisible(true);
                break;    
        }
}
     catch(Exception e){
        System.out.println("Error critico al cargar la imagen" + e);
        }
    }//GEN-LAST:event_btnTiradaActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        if (modalidad.equals("Individual")) {
            Partida.moverFicha();
        } else {
            PartidaCompetencia.controladorFichas();
        }
        this.dispose();
    }//GEN-LAST:event_btnContinuarActionPerformed

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
            java.util.logging.Logger.getLogger(Dado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dado(args[0],args[1]).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnTirada;
    private javax.swing.JLabel lblDado;
    private javax.swing.JLabel lblResultado;
    // End of variables declaration//GEN-END:variables
}