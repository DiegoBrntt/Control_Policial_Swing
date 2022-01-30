/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.*;
import javax.swing.*;
import modelo.Modelo;

/**
 *
 * @author Grandalf
 */
public abstract class Vista {
    private Modelo m;

    public Modelo getM() {
        return m;
    }

    public Vista(Modelo m) {
        this.m = m;
        this.m.addExceptionListener(new ExceptionListener());
    }

    public abstract void mostrar();
    public abstract void cerrar();
    public abstract void agregarListeners(ActionListener al);
    
    public void mostrarValidacion(String exception) {
        JOptionPane.showMessageDialog(null, exception,
                "Vista de validacion", JOptionPane.INFORMATION_MESSAGE);
    }
    public void mostrarException(String exception) {
        JOptionPane.showMessageDialog(null, "ERROR: " + exception,
                "Vista de Error", JOptionPane.ERROR_MESSAGE);
    }

    private class ExceptionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            mostrarException(event.getActionCommand());
        }
    }
}
