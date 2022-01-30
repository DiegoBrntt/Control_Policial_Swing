/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author Grandalf
 */
public class VistaInvestigador extends Vista {

    private JFrame marco;
    private JTabbedPane pestañas;
    private JPanel panelG;
    private JLabel invest;
    //Entidades
    private JPanel panelEntidades;
    private JTable tablaEntidades;
    private DefaultTableModel mTablaEntidades;
    private JScrollPane scrTablaEntidades;
    //Sucursales
    private JPanel panelSucursales;
    private JTable tablaSucursales;
    private DefaultTableModel mTablaSucursales;
    private JScrollPane scrTablaSucursales;
    //Contratos
    private JPanel panelContratos;
    private JTable tablaContratos;
    private DefaultTableModel mTablaContratos;
    private JScrollPane scrTablaContratos;
    //Bandas
    private JPanel panelBandas;
    private JTable tablaBandas;
    private DefaultTableModel mTablaBandas;
    private JScrollPane scrTablaBandas;
    //Integrantes
    private JPanel panelIntegrantes;
    private JTable tablaIntegrantes;
    private DefaultTableModel mTablaIntegrantes;
    private JScrollPane scrTablaIntegrantes;
    //Delitos
    private JPanel panelDelitos;
    private JTable tablaDelitos;
    private DefaultTableModel mTablaDelitos;
    private JScrollPane scrTablaDelitos;

    private JButton btnSalir;

    public VistaInvestigador(Modelo m, Usuario usu) {
        super(m);
        marco = new JFrame();
        marco.setTitle("Menu de Vigilante");
        marco.setResizable(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setExtendedState(Integer.MAX_VALUE);

        invest = new JLabel("Investigador: " + usu.obtenerCodigoDeUsuario());

        panelG = new JPanel();
        panelG.setLayout(new BorderLayout());

        btnSalir = new JButton("Cerrar Sesion");

        //Panel de consultas Entidades.
        panelEntidades = new JPanel();

        String[] columEnt = {"Codigo", "Domicilio", "Cant. Suc."};
        mTablaEntidades = new DefaultTableModel(columEnt, 0);

        for (Entidad entidad : m.obtenerEntidades()) {
            if (entidad != null) {
                Object[] row = {entidad.obtenerCodEnt(),
                    entidad.obtenerDomicilio(),
                    entidad.obtenerCantSuc()
                };
                mTablaEntidades.addRow(row);
            } else {
                Object[] row = {"", "", ""};
                mTablaEntidades.addRow(row);
            }
        }

        tablaEntidades = new JTable(mTablaEntidades);
        tablaEntidades.setEnabled(false);
        tablaEntidades.setToolTipText("JTable");
        tablaEntidades.getTableHeader().setBackground(Color.BLUE);
        tablaEntidades.getTableHeader().setForeground(Color.WHITE);

        scrTablaEntidades = new JScrollPane(tablaEntidades);
        scrTablaEntidades.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));

        panelEntidades.add(scrTablaEntidades);

        //Panel de consultas Sucursales.
        panelSucursales = new JPanel();

        String[] columSuc = {"Codigo Entidad", "Codigo Sucursal", "Domicilio Sucursal", "Cant. Empleados."};
        mTablaSucursales = new DefaultTableModel(columSuc, 0);

        for (Entidad entidad : m.obtenerEntidades()) {
            for (Sucursal sucursal : entidad.obtenerSucursales()) {
                if (sucursal != null) {
                    Object[] row = {entidad.obtenerCodEnt(),
                        sucursal.obtenerCodSuc(),
                        sucursal.obtenerDireccionSucursal(),
                        sucursal.obtenerCantEmpleados()
                    };
                    mTablaSucursales.addRow(row);
                } else {
                    Object[] row = {"", "", ""};
                    mTablaSucursales.addRow(row);
                }
            }
        }
        tablaSucursales = new JTable(mTablaSucursales);
        tablaSucursales.setEnabled(false);
        tablaSucursales.setToolTipText("JTable");
        tablaSucursales.getTableHeader().setBackground(Color.BLUE);
        tablaSucursales.getTableHeader().setForeground(Color.WHITE);
        tablaSucursales.sizeColumnsToFit(4);

        scrTablaSucursales = new JScrollPane(tablaSucursales);
        scrTablaSucursales.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));

        panelSucursales.add(scrTablaSucursales);

        //Panel de consultas Contratos.
        panelContratos = new JPanel();

        String[] columCon = {"Fecha", "Entidad", "Sucursal", "Contrato", "Vigilante", "Armado", "Cant. Dias", "Vigencia"};
        mTablaContratos = new DefaultTableModel(columCon, 0);

        for (Entidad entidad : m.obtenerEntidades()) {
            for (Sucursal sucursal : entidad.obtenerSucursales()) {
                for (Contrato contrato : sucursal.obtenerContratosDeSucursal()) {
                    try {
                        Object[] row = {
                            contrato.obtenerFechaDeContrato(),
                            entidad.obtenerCodEnt(),
                            sucursal.obtenerCodSuc(),
                            contrato.obtenerCodigoDeContrato(),
                            contrato.obtenerContratado(),
                            contrato.obtenerPortacionDeArma() ? "Si" : "No",
                            contrato.obtenerDiasContratados(),
                            contrato.obtenerVigencia() ? "Caduco" : "Vigente"
                        };
                        mTablaContratos.addRow(row);
                    } catch (NullPointerException e) {
                        Object[] row = {"", "", ""};
                        mTablaContratos.addRow(row);
                    }
                }
            }
        }
        tablaContratos = new JTable(mTablaContratos);
        tablaContratos.setEnabled(false);
        tablaContratos.setToolTipText("JTable");
        tablaContratos.getTableHeader().setBackground(Color.BLUE);
        tablaContratos.getTableHeader().setForeground(Color.WHITE);
        tablaContratos.sizeColumnsToFit(5);

        scrTablaContratos = new JScrollPane(tablaContratos);
        scrTablaContratos.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));

        panelContratos.add(scrTablaContratos);

        //Panel de consultas Bandas.
        panelBandas = new JPanel();

        String[] columBan = {"Banda", "Cantidad de integrantes"};
        mTablaBandas = new DefaultTableModel(columBan, 0);

        for (Banda banda : m.obtenerBandas()) {

            if (banda != null) {
                Object[] row = {banda.obtenerCodigoBanda(),
                    banda.obtenerCantidadDeIntegrantes()
                };
                mTablaBandas.addRow(row);
            } else {
                Object[] row = {"", "", ""};
                mTablaBandas.addRow(row);
            }

        }
        tablaBandas = new JTable(mTablaBandas);
        tablaBandas.setEnabled(false);
        tablaBandas.setToolTipText("JTable");
        tablaBandas.getTableHeader().setBackground(Color.BLUE);
        tablaBandas.getTableHeader().setForeground(Color.WHITE);
        tablaBandas.sizeColumnsToFit(2);

        scrTablaBandas = new JScrollPane(tablaBandas);
        scrTablaBandas.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));

        panelBandas.add(scrTablaBandas);

        //Panel de consultas Integrantes.
        panelIntegrantes = new JPanel();

        String[] columInt = {"Banda", "Integrante", "Nombre y Apellido"};
        mTablaIntegrantes = new DefaultTableModel(columInt, 0);

        for (Banda banda : m.obtenerBandas()) {
            for (Asaltante integrante : banda.obtenerIntegrantes()) {
                if (integrante != null) {
                    Object[] row = {banda.obtenerCodigoBanda(),
                        integrante.obtenerClaveDeIntegrante(),
                        integrante.obtenerNomApeDeIntegrante()
                    };
                    mTablaIntegrantes.addRow(row);
                } else {
                    Object[] row = {"", "", ""};
                    mTablaIntegrantes.addRow(row);
                }
            }
        }
        tablaIntegrantes = new JTable(mTablaIntegrantes);
        tablaIntegrantes.setEnabled(false);
        tablaIntegrantes.setToolTipText("JTable");
        tablaIntegrantes.getTableHeader().setBackground(Color.BLUE);
        tablaIntegrantes.getTableHeader().setForeground(Color.WHITE);
        tablaIntegrantes.sizeColumnsToFit(3);

        scrTablaIntegrantes = new JScrollPane(tablaIntegrantes);
        scrTablaIntegrantes.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));

        panelIntegrantes.add(scrTablaIntegrantes);

        //Panel de consultas Delitos.
        panelDelitos = new JPanel();

        String[] columDel = {"Juez", "Clave del caso", "Actores", "Lugar", "Fecha del delito", "Condenado", "Tiempo de condena"};
        mTablaDelitos = new DefaultTableModel(columDel, 0);

        for (Delito delito : m.obtenerDelitos()) {
            if (delito != null) {
                Object[] row = {delito.obtenerJuezEncargado(),
                    delito.obtenerClaveDelCaso(),
                    delito.obteneActores(),
                    delito.obtenerLugarDelHecho(),
                    delito.obtenerFechaDelActo(),
                    delito.obtenerEstadoDelCaso()?"Condenado":"Sin Condena",
                    delito.obtenerEstadoDelCaso()?delito.obtenerCondenaCumplida()?"Cumplio " + delito.obtenerTiempoCondena() + " meses":"Cumpliendo " +delito.obtenerTiempoCondena() + " meses":"---"
                };
                mTablaDelitos.addRow(row);
            } else {
                Object[] row = {"", "", ""};
                mTablaDelitos.addRow(row);
            }
        }

        tablaDelitos = new JTable(mTablaDelitos);
        tablaDelitos.setEnabled(false);
        tablaDelitos.setToolTipText("JTable");
        tablaDelitos.getTableHeader().setBackground(Color.BLUE);
        tablaDelitos.getTableHeader().setForeground(Color.WHITE);
        tablaDelitos.sizeColumnsToFit(7);

        scrTablaDelitos = new JScrollPane(tablaDelitos);
        scrTablaDelitos.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));

        panelDelitos.add(scrTablaDelitos);

        pestañas = new JTabbedPane();
        pestañas.add("Entidades", panelEntidades);
        pestañas.add("Sucursales", panelSucursales);
        pestañas.add("Contratos", panelContratos);
        pestañas.add("Bandas", panelBandas);
        pestañas.add("Integrantes", panelIntegrantes);
        pestañas.add("Delitos", panelDelitos);

        panelG.add(invest, BorderLayout.NORTH);
        panelG.add(pestañas, BorderLayout.CENTER);
        panelG.add(btnSalir, BorderLayout.SOUTH);
    }

    @Override
    public void agregarListeners(ActionListener al) {
        btnSalir.addActionListener(al);
    }

    @Override
    public void mostrar() {
        marco.setContentPane(panelG);
        marco.pack();
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
    }

    @Override
    public void cerrar() {
        marco.dispose();
    }

}
