/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Helpers.Funciones;
import Helpers.ThreadMusic;
import Helpers.ThreadFicha;
import Modelo.Juego;
import Modelo.Jugador;
import Modelo.Resultado;
import javax.swing.JLabel;

/**
 *
 * @author Diego
 */
public class Partida extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     * @param modalidad
     */
    
    public Partida(String modalidad,String ficha) {
        initComponents();
        this.setLocationRelativeTo(null); 
        // Detenemos la ejecucion de la musica del MenuPrincipal
        ThreadMusic.Sound.close();
        // Creamos el nuevo registro en la tabla Partida de la base de datos 
        if (partida.iniciarPartidaIndividual()) {
            System.out.println("Partida individual iniciada correctamente!!!");
        } else {
            System.out.println("Error al iniciar partida individual...");
        }   
        // Colocamos la url de la musica del juego y la reproducimos 
        ThreadMusic.setUrlAudio("src/Audio/audioJuego.mp3");
        ThreadMusic sound = new ThreadMusic();
        sound.start();
        
        String urlFichaIcono = "";
        
        switch(ficha){
            case "purple-guy":
                urlFichaIcono = "/Recursos/ficha-purple-guy-icono.png";
                break;
                
            case "jett":
                urlFichaIcono = "/Recursos/ficha-jett-icono.png";
                break;
                
            case "spiderman":
                urlFichaIcono = "/Recursos/ficha-spiderman-icono.png";
                break;
                
            case "sailormoon":
                urlFichaIcono = "/Recursos/ficha-sailormoon-icono.png";
                break;
        }
        
        // Cargamos la imagen de la ficha de forma dinamica
        lblFicha1.setIcon(new javax.swing.ImageIcon(getClass().getResource(Juego.getUrlFichaJ1())));
        
        lblTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource(Juego.getUrlTablero())));
        
        lblFicha1.setVisible(true);
        
        btnDado.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlFichaIcono)));
        
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
    Modelo.Juego partida = new Modelo.Juego();
    Resultado resultado = new Resultado();
    
    // Declarando variables numericas
    public static int rows, numCasillas;     
    public static int posicion , x , y , posicionFinal;
    private int numeroDado;
    protected static String tipoFicha;
    
    // Declarando atributo para hacer referencia al JFrame en funciones estaticas
    private static Partida formulario; 
    
    // Declarando matriz cuadrada para guardar la informacion de las casillas traida de la base de datos
    public static Object[][] datos;  
   
    // Declarando contadores para el transcurso de la partida (Se enviaran a la base de datos al finalizar la partida)
    protected static int contadorJ1 = 0;  
    private static int numeroTiros = 0, numeroSerpiente = 0, numeroEscalera = 0, numeroDesbanque = -1;
    
    // Funcion para reiniciar los contadores de las variables locales y contadores
    private void reiniciarValores(){
        numeroTiros = 0;
        numeroSerpiente = 0;
        numeroEscalera = 0;
        contadorJ1 = 0;
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

        btnDado = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblFicha1 = new javax.swing.JLabel();
        lblTablero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ficha-spiderman-icono.png"))); // NOI18N
        btnDado.setText("  Tirar dado ");
        btnDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDado, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 10, 160, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFicha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ficha-spiderman-tablero.png"))); // NOI18N
        jPanel1.add(lblFicha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 660, -1, 110));

        lblTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tablero_medio.jpg"))); // NOI18N
        jPanel1.add(lblTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1710, 900));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1720, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    protected static void moverFicha(){
        if (contadorJ1 >= numCasillas - 1) {
            // Colocamos la ficha en la ultima posicion del tablero numCasillas -1
            cargarDatos(datos,numCasillas-1);
            moverFicha(lblFicha1);       
            // Guardamos los resultados de la partida invidividual
            String resultado = "";      
            // Esperamos ocupamos ThreadSleep para esperar a que se mueva la ficha
            try {
                Thread.sleep(1500);
                // Invocamos el metodo para finalizar la partida 
                Resultado.finalizarPartidaIndividual(numeroTiros,numeroEscalera,numeroSerpiente);
                // Actualizamos las estadisticas del jugador (Partidas jugadas y partidas ganadas)
                Resultado.actualizarEstadisticasJugador(Jugador.getIdJugador());
            } catch (InterruptedException ex) {
                System.out.println("Ocurrio un error al finalizar partida: " + ex);
            }              
            ThreadMusic.Sound.close();      
            formulario.dispose();
            // Abrimos la ventana de resultados de juego individual
            new Resultados(String.valueOf(numeroTiros),String.valueOf(numeroSerpiente),String.valueOf(numeroEscalera),String.valueOf(numeroDesbanque),Jugador.getNickname(),resultado).setVisible(true);              
        } else {
            // Obtenemos la posicion y tipo de casilla en la que el jugador callo
            cargarDatos(datos,contadorJ1);
            // Invocamos funcion para mover la ficha 
            moverFicha(lblFicha1);
            // Si no es una casilla normal tenemos que moverla a su posicion final
            if (!"Normal".equals(tipoFicha)) {
                try {
                    // Esperamos a que finalice la animacion del dado
                    Thread.sleep(1500);         
                    if (tipoFicha.equals("Serpiente")) {
                        numeroSerpiente = numeroSerpiente + 1;
                    } else if (tipoFicha.equals("Escalera")) {
                        numeroEscalera = numeroEscalera + 1;
                    }
                    // Abrimos la ventana informativa de casilla especial
                    new CasillaEspecial(tipoFicha,String.valueOf(posicionFinal),"Individual","").setVisible(true);
                    System.out.println("Mover 2 veces / ficha especial");
                } catch (InterruptedException ex) {
                    System.out.println("Ocurrio un error en casilla especial: " + ex);
                }
            } else {
                System.out.println("Solo mover / ficha normal");
            }
        }
    }
    private void btnDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadoActionPerformed
        numeroTiros = numeroTiros + 1;     
        numeroDado = funcion.numeroAleatorio();      
        contadorJ1 = contadorJ1 + numeroDado;       
        new Dado(String.valueOf(numeroDado),"Individual").setVisible(true);  
    }//GEN-LAST:event_btnDadoActionPerformed

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
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Partida(args[0],args[1]).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnDado;
    private static javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblFicha1;
    private static javax.swing.JLabel lblTablero;
    // End of variables declaration//GEN-END:variables
}
