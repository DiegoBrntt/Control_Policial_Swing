/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import modelo.Modelo;

/**
 *
 * @author Grandalf
 */
public class VistaLogin extends Vista {

    private Modelo m;
    private JFrame marco;
    private JPanel panel;
    private JLabel codigo;
    private JLabel pass;
    private JTextField txtCodigo;
    private JPasswordField txtPass;
    private JButton inicio;
    private JButton salir;

    public VistaLogin(Modelo m) {
        super(m);
        marco = new JFrame();
        marco.setResizable(false);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        codigo = new JLabel("Codigo de Usuario:");
        pass = new JLabel("Contraseña:");
        txtCodigo = new JTextField(10);
        txtPass = new JPasswordField(10);
        inicio = new JButton("Iniciar sesion");
        salir = new JButton("Salir");

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(codigo);
        panel.add(txtCodigo);
        panel.add(pass);
        panel.add(txtPass);
        panel.add(inicio);
        panel.add(salir);
    }

    /**
     * Extrae el codigo del campo de texto
     * @return Codigo de Usuario
     * 
     */
    public String getTxtCodigo() {
        return txtCodigo.getText();
    }

    /**
     * Extrae la contraseña del campo de contraseña
     * @return Contraseña de Usuario
     * 
     */
    public Object getTxtPass() {
        return String.valueOf(txtPass.getPassword());
    }

    /**
     * Agrega el Listener al boton de inicio de sesion
     * @param al
     * 
     */
    public void addInicioSesionListener(ActionListener al) {
        inicio.addActionListener(al);
    }
    
    /**
     * Agrega el Listener al boton salir del programa
     * @param al
     * 
     */
    @Override
    public void agregarListeners(ActionListener al){
        salir.addActionListener(al);
    }

    /**
     * Muestra mensaje de error recibiendo un mensaje de excepcion
     * @param exception
     */
    @Override
    public void mostrarException(String exception) {
        JOptionPane.showMessageDialog(null, "ERROR: " + exception,
                "Vista de Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Setea titulo, contenido y muestra la vista
     */
    @Override
    public void mostrar() {
        marco.setTitle("LOGIN");
        marco.setContentPane(panel);
        marco.pack();
        marco.setLocationRelativeTo(null);
        txtCodigo.setText("");
        txtPass.setText("");
        marco.setVisible(true);
    }

    /**
     * Cierre de ventana y salida del programa
     */
    @Override
    public void cerrar() {
        marco.dispose();
    }
}
