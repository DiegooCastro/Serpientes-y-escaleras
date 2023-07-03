/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class Perfil extends javax.swing.JFrame {

    /**
     * Creates new form Perfil
     */
    public Perfil(DefaultTableModel tb) {
        initComponents();
        lblTitulo.setText("ESTADISTICAS DEL JUGADOR: " + nickname.toUpperCase());
        lblModalidad.setText("PARTIDAS MODALIDAD: " + modalidad);
        lblVictorias.setText(" Victorias: " + partidasGanadas);
        lblPartidasJugadas.setText("Partidas jugadas: " + partidasJugadas);
        lblDerrotas.setText("Partidas perdidas: " + partidasPerdidas);
        lblIndividuales.setText(" Partidas Individuales: " + partidasIndividuales);
        lblCompetencia.setText(" Partidas Competencia: " + partidasCompetencia);
        this.setLocationRelativeTo(null);
        rSTableMetro1.setModel(tb);      
    }
    
    public static int partidasJugadas;
    public static int partidasGanadas;
    public static int partidasPerdidas;
    public static int partidasIndividuales;
    public static int partidasCompetencia;
    public static String modalidad;
    public static String nickname;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new RSMaterialComponent.RSTableMetro();
        lblModalidad = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblVictorias = new javax.swing.JLabel();
        lblIndividuales = new javax.swing.JLabel();
        lblCompetencia = new javax.swing.JLabel();
        lblDerrotas = new javax.swing.JLabel();
        lblPartidasJugadas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        rSTableMetro1.setColorPrimaryText(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setColorSecundaryText(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(rSTableMetro1);

        lblModalidad.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblModalidad.setText("PARTIDAS MODALIDAD: INDIVIDUAL");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitulo.setText("ESTADISTICAS DEL JUGADOR: CASTROLL ");

        lblVictorias.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblVictorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/maestria.png"))); // NOI18N
        lblVictorias.setText(" Victorias: 0");

        lblIndividuales.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblIndividuales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/individual.png"))); // NOI18N
        lblIndividuales.setText(" Partidas Individuales: 0");

        lblCompetencia.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblCompetencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/competencia.png"))); // NOI18N
        lblCompetencia.setText(" Partidas Competencia: 0");

        lblDerrotas.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblDerrotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/derrotado.png"))); // NOI18N
        lblDerrotas.setText("Derrotas: 0");

        lblPartidasJugadas.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblPartidasJugadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tablero.png"))); // NOI18N
        lblPartidasJugadas.setText(" Partidas jugadas: 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(lblTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(lblModalidad))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(lblPartidasJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(lblVictorias, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(lblIndividuales, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblDerrotas, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompetencia)
                    .addComponent(lblDerrotas)
                    .addComponent(lblIndividuales)
                    .addComponent(lblVictorias)
                    .addComponent(lblPartidasJugadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(lblModalidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 1330, 650));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoEstadisticas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(DefaultTableModel args[]) {
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
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perfil(args[0]).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCompetencia;
    private javax.swing.JLabel lblDerrotas;
    private javax.swing.JLabel lblIndividuales;
    private javax.swing.JLabel lblModalidad;
    private javax.swing.JLabel lblPartidasJugadas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVictorias;
    private RSMaterialComponent.RSTableMetro rSTableMetro1;
    // End of variables declaration//GEN-END:variables
}
