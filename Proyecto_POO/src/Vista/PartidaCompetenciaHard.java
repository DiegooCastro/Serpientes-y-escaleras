/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Helpers.Funciones;
import Helpers.ThreadMusic;
import Helpers.ThreadFicha;
import Modelo.Jugador;
import Modelo.Juego;
import Modelo.Resultado;
import javax.swing.JLabel;

/**
 *
 * @author Diego
 */
public class PartidaCompetenciaHard extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     * @param modalidad
     */
    
    public PartidaCompetenciaHard(String modalidad,String fichaJ1,String fichaJ2) {
        initComponents();
        this.setLocationRelativeTo(null);       
        String urlFichaJ1Icono = "",urlFichaJ2Icono = "";
        try{
            switch(fichaJ1){
            case "purple-guy":
                urlFichaJ1Icono = "/Recursos/ficha-purple-guy-icono.png";
                break;
                
            case "jett":
                urlFichaJ1Icono = "/Recursos/ficha-jett-icono.png";
                break;
                
            case "spiderman":
                urlFichaJ1Icono = "/Recursos/ficha-spiderman-icono.png";
                break;
                
            case "sailormoon":
                urlFichaJ1Icono = "/Recursos/ficha-sailormoon-icono.png";
                break;
            }

            switch(fichaJ2){
                case "purple-guy":
                    urlFichaJ2Icono = "/Recursos/ficha-purple-guy-icono.png";
                    break;

                case "jett":
                    urlFichaJ2Icono = "/Recursos/ficha-jett-icono.png";
                    break;

                case "spiderman":
                    urlFichaJ2Icono = "/Recursos/ficha-spiderman-icono.png";
                    break;

                case "sailormoon":
                    urlFichaJ2Icono = "/Recursos/ficha-sailormoon-icono.png";
                    break;
            }
            
        } catch(Exception e) {
            System.out.println("Error asignando rutas de fichas");
        }     
        // Detenemos la ejecucion de la musica del MenuPrincipal
        ThreadMusic.Sound.close();
        // Creamos el nuevo registro en la tabla Juego de la base de datos 
        if (partida.iniciarPartidaCompetencia()) {
            System.out.println("Partida competencia iniciada correctamente!!!");
        } else {
            System.out.println("Error al iniciar partida competencia...");
        }   
        // Colocamos la url de la musica del juego y la reproducimos 
        ThreadMusic.setUrlAudio("src/Audio/audioJuego.mp3");
        ThreadMusic sound = new ThreadMusic();
        sound.start();
        // Cargamos la imagen de la ficha de forma dinamica
        try {
            lblTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource(Modelo.Juego.getUrlTablero())));
            lblFicha1.setIcon(new javax.swing.ImageIcon(getClass().getResource(Juego.getUrlFichaJ1())));
            btnDadoJ1.setText("J1: "  + Jugador.getNickname());
            lblFicha2.setIcon(new javax.swing.ImageIcon(getClass().getResource(Juego.getUrlFichaJ2())));
            btnDadoJ2.setText("J2: "  + Jugador.getNickname2());
            btnDadoJ1.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlFichaJ1Icono)));
            btnDadoJ2.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlFichaJ2Icono)));
        } catch(Exception e){
            System.out.println("Error cargando los iconos: " + e);
        }
        // Retorno de datos: numero casilla, posicion x, posicion y, tipo casilla, posicion final
        datos = partida.cargarFichas();
        // Guardamos el numero de casillas en base al numero de registros en la base
        numCasillas = partida.numeroCasillas();
        formulario = this;
        // Reiniciar los valores de las variables en caso que previamente se haya jugado una partida
        reiniciarValores();
    }
    
    // Declarando objetos de las clases a utilizar
    Funciones funcion = new Funciones();
    Juego partida = new Juego();
    Resultado resultado = new Resultado();
    
    // Declarando variables numericas
    public static int rows, numCasillas;     
    public static int posicion , x , y , posicionFinal;
    private int numeroDado;
    protected static String tipoFicha;
    
    // Declarando atributo para hacer referencia al JFrame en funciones estaticas
    private static PartidaCompetenciaHard formulario; 
    
    // Declarando matriz cuadrada para guardar la informacion de las casillas traida de la base de datos
    public static Object[][] datos;  
   
    // Declarando contadores para el transcurso de la partida (Se enviaran a la base de datos al finalizar la partida)
    protected static int contadorJ1 = 0, contadorJ2 = 0;  
    protected static int resultadoJ1, numeroTirosJ1 = 0, numeroSerpienteJ1 = 0, numeroEscaleraJ1 = 0, numeroDesbanqueJ1 = 0;
    protected static int resultadoJ2, numeroTirosJ2 = 0, numeroSerpienteJ2 = 0, numeroEscaleraJ2 = 0, numeroDesbanqueJ2 = 0;
    
    // Variable para indicar el turno de cada jugador
    public static boolean turnoJ1 = true;
    
    // Funcion para reiniciar los contadores de las variables locales y contadores
    private void reiniciarValores(){
        numeroTirosJ1 = 0;
        numeroSerpienteJ1 = 0;
        numeroEscaleraJ1 = 0;
        numeroDesbanqueJ1 = 0;
        numeroTirosJ2 = 0;
        numeroSerpienteJ2 = 0;
        numeroEscaleraJ2 = 0;
        numeroDesbanqueJ2 = 0;
        resultadoJ1 = 0;
        resultadoJ2 = 0;
        contadorJ1 = 0;
        contadorJ2 = 0;
        btnDadoJ2.setEnabled(false);
        turnoJ1 = true;
    }
    
    // Obtenemos los datos de la posicion en la que se encuentra el jugador y las guardamos en las variables locales 
    private static void cargarDatos(Object[][] datos,int contador){
        try{
            posicion = Integer.parseInt(datos[0][contador].toString());
            x =  Integer.parseInt(datos[1][contador].toString());
            y =  Integer.parseInt(datos[2][contador].toString());
            tipoFicha = datos[3][contador].toString();
            if (datos[4][contador] != null) {
                posicionFinal = Integer.parseInt(datos[4][contador].toString());
            } 
        }catch(Exception e){
            System.out.println("Vacio: " + e);
        }
    }
    
    // Asignamos los valores necesarios a los atributos de la clase ThreadFicha para que se mueva
    private static void moverFicha(JLabel lblFicha){
        try{
            ThreadFicha hilo = new ThreadFicha();
            hilo.setLblFicha(lblFicha);
            hilo.setTiempo(800);
            hilo.setPosicionX(x);
            hilo.setPosicionY(y);
            hilo.start();
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
        lblFicha1 = new javax.swing.JLabel();
        lblFicha2 = new javax.swing.JLabel();
        btnDadoJ2 = new javax.swing.JButton();
        btnDadoJ1 = new javax.swing.JButton();
        lblTablero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFicha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ficha-purple-guy-tablero.png"))); // NOI18N
        jPanel1.add(lblFicha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, 90));

        lblFicha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ficha-jett-tablero.png"))); // NOI18N
        jPanel1.add(lblFicha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 90, 90));

        btnDadoJ2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDadoJ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ficha-jett-icono.png"))); // NOI18N
        btnDadoJ2.setText("   J2");
        btnDadoJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadoJ2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDadoJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 200, -1));

        btnDadoJ1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDadoJ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ficha-purple-guy-icono.png"))); // NOI18N
        btnDadoJ1.setText("   J1");
        btnDadoJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadoJ1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDadoJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, -1));

        lblTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tablero_dificil.jpg"))); // NOI18N
        jPanel1.add(lblTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1710, 900));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1710, 910));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    protected static void controladorFichas(){
        if (contadorJ1 >= numCasillas - 1 || contadorJ2 >= numCasillas -1) {
            // Colocamos la ficha en la ultima posicion del tablero numCasillas -1
            cargarDatos(datos,numCasillas-1);
            if (turnoJ1) {
                moverFicha(lblFicha1);  
                btnDadoJ1.setEnabled(false);
                btnDadoJ2.setEnabled(true);
                turnoJ1 = false;
                contadorJ1 = contadorJ1 + 1;
                resultadoJ1 = 1;
                resultadoJ2= 2;
            } else {
                moverFicha(lblFicha2);
                btnDadoJ1.setEnabled(true);
                btnDadoJ2.setEnabled(false);
                turnoJ1 = true;
                contadorJ2 = contadorJ2 + 1;
                resultadoJ1 = 2;
                resultadoJ2 = 1;
            }
            // Guardamos los resultados de la partida invidividual
            String resultado = "";      
            // Esperamos ocupamos ThreadSleep para esperar a que se mueva la ficha
            try {
                Thread.sleep(1500);
                // Invocamos el metodo para finalizar la partida 
                Resultado.finalizarPartidaCompetencia(resultadoJ1,numeroTirosJ1,numeroEscaleraJ1,numeroSerpienteJ1,numeroDesbanqueJ1,
                resultadoJ2,numeroTirosJ2,numeroEscaleraJ2,numeroSerpienteJ2,numeroDesbanqueJ2);
                // Actualizamos las estadisticas de los dos jugadores (Partidas jugadas y partidas ganadas)
                Resultado.actualizarEstadisticasJugador(Jugador.getIdJugador());
                Resultado.actualizarEstadisticasJugador(Jugador.getIdJugador2());
            } catch (InterruptedException ex) {
                System.out.println("Ocurrio un error al finalizar partida: " + ex);
            }              
            ThreadMusic.Sound.close();      
            formulario.dispose();
            // Abrimos la ventana de resultados de juego competencia          
            new ResultadoCompetencia(Jugador.getNickname(),Jugador.getNickname2(),String.valueOf(numeroTirosJ1),String.valueOf(numeroTirosJ2),String.valueOf(numeroSerpienteJ1),
            String.valueOf(numeroSerpienteJ2),String.valueOf(numeroEscaleraJ1),String.valueOf(numeroEscaleraJ2), String.valueOf(numeroDesbanqueJ1),String.valueOf(numeroDesbanqueJ2),String.valueOf(resultadoJ1)).setVisible(true);              
        } else {
                
            if (turnoJ1) {
                cargarDatos(datos,contadorJ1);
                moverFicha(lblFicha1);  
                btnDadoJ1.setEnabled(false);
                btnDadoJ2.setEnabled(true);
                turnoJ1 = false;
            } else {
                cargarDatos(datos,contadorJ2);
                moverFicha(lblFicha2);
                btnDadoJ1.setEnabled(true);
                btnDadoJ2.setEnabled(false);
                turnoJ1 = true;
            }
            if (contadorJ1  == contadorJ2) {
                if (turnoJ1) {
                    numeroDesbanqueJ1 = numeroDesbanqueJ1 + 1;
                    new CasillaEspecialHard("Desbanque",String.valueOf(0),"Competencia","J2").setVisible(true);
                } else {
                    numeroDesbanqueJ2 = numeroDesbanqueJ2 + 1;
                    new CasillaEspecialHard("Desbanque",String.valueOf(0),"Competencia","J1").setVisible(true);
                }
                
            } else {
                // Si no es una casilla normal tenemos que moverla a su posicion final
                if (!"Normal".equals(tipoFicha)) {
                    try {
                        // Esperamos a que finalice la animacion del dado
                        Thread.sleep(1500);     
                        if (!turnoJ1) {
                            if (tipoFicha.equals("Serpiente")) {
                                numeroSerpienteJ1 = numeroSerpienteJ1 + 1;
                            } else if (tipoFicha.equals("Escalera")) {
                                numeroEscaleraJ1 = numeroEscaleraJ1 + 1;
                            }
                        } else {
                            if (tipoFicha.equals("Serpiente")) {
                                numeroSerpienteJ2 = numeroSerpienteJ1 + 1;
                            } else if (tipoFicha.equals("Escalera")) {
                                numeroEscaleraJ2 = numeroEscaleraJ1 + 1;
                            }
                        }                    
                        // Abrimos la ventana informativa de casilla especial
                        new CasillaEspecialHard(tipoFicha,String.valueOf(posicionFinal),"Competencia","").setVisible(true);
                        System.out.println("Mover 2 veces / ficha especial");
                    } catch (InterruptedException ex) {
                        System.out.println("Ocurrio un error en casilla especial: " + ex);
                    }
                } else {
                    System.out.println("Solo mover / ficha normal");
                }
            }
            
        }
    }
    private void btnDadoJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadoJ1ActionPerformed
        numeroTirosJ1 = numeroTirosJ1 + 1;     
        numeroDado = funcion.numeroAleatorio();      
        contadorJ1 = contadorJ1 + numeroDado;       
        new DadoHard(String.valueOf(numeroDado),"Competencia").setVisible(true);       
    }//GEN-LAST:event_btnDadoJ1ActionPerformed

    private void btnDadoJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadoJ2ActionPerformed
        numeroTirosJ2 = numeroTirosJ2 + 1;     
        numeroDado = funcion.numeroAleatorio();      
        contadorJ2 = contadorJ2 + numeroDado;       
        new DadoHard(String.valueOf(numeroDado),"Competencia").setVisible(true);   
    }//GEN-LAST:event_btnDadoJ2ActionPerformed

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
            java.util.logging.Logger.getLogger(PartidaCompetenciaHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartidaCompetenciaHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartidaCompetenciaHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartidaCompetenciaHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PartidaCompetenciaHard(args[0],args[1],args[2]).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnDadoJ1;
    private static javax.swing.JButton btnDadoJ2;
    private static javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblFicha1;
    public static javax.swing.JLabel lblFicha2;
    private static javax.swing.JLabel lblTablero;
    // End of variables declaration//GEN-END:variables
}
