/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Helpers.Funciones;

/**
 *
 * @author Diego
 */
public class Modalidad extends javax.swing.JFrame {

    /**
     * Creates new form Modalidad
     */
    public Modalidad() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    Funciones tool = new Funciones();
    protected static boolean competencia;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rSPanelBorder2 = new RSMaterialComponent.RSPanelBorder();
        lblIndividual = new javax.swing.JLabel();
        rSButtonMaterialOne2 = new RSMaterialComponent.RSButtonMaterialOne();
        rSPanelBorder1 = new RSMaterialComponent.RSPanelBorder();
        lblCompetencia = new javax.swing.JLabel();
        rSButtonMaterialOne1 = new RSMaterialComponent.RSButtonMaterialOne();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        rSButtonShapeIcon1 = new RSMaterialComponent.RSButtonShapeIcon();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        rSPanelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelBorder2.setWidthBorder(2);
        rSPanelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIndividual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/modalidadIndividual.png"))); // NOI18N
        rSPanelBorder2.add(lblIndividual, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 260));

        rSButtonMaterialOne2.setBackground(new java.awt.Color(153, 0, 153));
        rSButtonMaterialOne2.setText("Modo Individual");
        rSButtonMaterialOne2.setBackgroundHover(new java.awt.Color(153, 153, 153));
        rSButtonMaterialOne2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        rSButtonMaterialOne2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialOne2ActionPerformed(evt);
            }
        });
        rSPanelBorder2.add(rSButtonMaterialOne2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 320, 50));

        rSPanelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelBorder1.setWidthBorder(2);
        rSPanelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCompetencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/modalidadDuo.png"))); // NOI18N
        rSPanelBorder1.add(lblCompetencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 260));

        rSButtonMaterialOne1.setBackground(new java.awt.Color(153, 51, 0));
        rSButtonMaterialOne1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rSButtonMaterialOne1.setText("Modo Competencia");
        rSButtonMaterialOne1.setBackgroundHover(new java.awt.Color(153, 153, 153));
        rSButtonMaterialOne1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        rSButtonMaterialOne1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialOne1ActionPerformed(evt);
            }
        });
        rSPanelBorder1.add(rSButtonMaterialOne1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 320, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel1.setText("Seleccione la modalidad en la que desea jugar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(124, 124, 124))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(rSPanelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSPanelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSPanelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(rSPanelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 690, 410));

        rSButtonShapeIcon1.setBackground(new java.awt.Color(0, 153, 153));
        rSButtonShapeIcon1.setText("  Regresar al menu");
        rSButtonShapeIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ARROW_BACK);
        rSButtonShapeIcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonShapeIcon1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonShapeIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoModalidad.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMaterialOne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialOne2ActionPerformed
        new Login("Individual").setVisible(true);
        competencia = false;
        this.dispose();
    }//GEN-LAST:event_rSButtonMaterialOne2ActionPerformed

    private void rSButtonMaterialOne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialOne1ActionPerformed
        new LoginCompetencia("Competencia").setVisible(true);
        competencia = true;
        this.dispose();
    }//GEN-LAST:event_rSButtonMaterialOne1ActionPerformed

    private void rSButtonShapeIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonShapeIcon1ActionPerformed
        new MenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonShapeIcon1ActionPerformed

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
            java.util.logging.Logger.getLogger(Modalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modalidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCompetencia;
    private javax.swing.JLabel lblIndividual;
    private RSMaterialComponent.RSButtonMaterialOne rSButtonMaterialOne1;
    private RSMaterialComponent.RSButtonMaterialOne rSButtonMaterialOne2;
    private RSMaterialComponent.RSButtonShapeIcon rSButtonShapeIcon1;
    private RSMaterialComponent.RSPanelBorder rSPanelBorder1;
    private RSMaterialComponent.RSPanelBorder rSPanelBorder2;
    // End of variables declaration//GEN-END:variables
}
