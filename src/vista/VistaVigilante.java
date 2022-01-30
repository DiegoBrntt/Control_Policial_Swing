/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.table.*;
import modelo.*;

/**
 *
 * @author Grandalf
 */
public class VistaVigilante extends Vista {

    private JFrame marco;
    private JPanel panelGeneral;
    private JLabel titulo;
    private JTable tabla;
    private DefaultTableModel mTabla;
    private JScrollPane scrTabla;
    private JButton btnSalir;

    public VistaVigilante(Modelo m, Usuario usu) {
        super(m);
        marco = new JFrame();
        marco.setTitle("Menu de Vigilante");
        marco.setResizable(false);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        titulo = new JLabel("Contratos del vigilante: " + usu.obtenerCodigoDeUsuario());

        panelGeneral = new JPanel();

        String[] columnas = {"Fecha", "Sucursal", "Armado", "Vigente"};
        
        mTabla = new DefaultTableModel(columnas, 0);
        for (Contrato contrato : m.obtenerContratosPorVigilante(usu.obtenerCodigoDeUsuario())) {
            if(contrato != null){
            Object[] row = {contrato.obtenerFechaDeContrato(), contrato.obtenerContratador(), contrato.obtenerPortacionDeArma(), contrato.obtenerVigencia()};
            mTabla.addRow(row);
            }
            else{
            Object[] row = {"", "", ""};
            mTabla.addRow(row);
            }
        }
        
        tabla = new JTable(mTabla);
        tabla.setToolTipText("JTable");
        tabla.getTableHeader().setBackground(Color.BLUE);
        tabla.getTableHeader().setForeground(Color.WHITE);
                                                                               
        scrTabla = new JScrollPane(tabla);

        btnSalir = new JButton("Cerrar Sesión");

        panelGeneral.setLayout(new BorderLayout());
        panelGeneral.add(titulo, BorderLayout.NORTH);
        panelGeneral.add(scrTabla, BorderLayout.CENTER);
        panelGeneral.add(btnSalir, BorderLayout.SOUTH);
    }
    
    @Override
    public void mostrar() {
        marco.setContentPane(panelGeneral);
        marco.pack();
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
    }
    
    @Override
    public void cerrar() {
        marco.dispose();
    }

    @Override
    public void agregarListeners(ActionListener al) {
        btnSalir.addActionListener(al);
    }
}
