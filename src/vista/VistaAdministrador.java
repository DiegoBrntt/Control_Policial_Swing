/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import modelo.*;

/**
 *
 * @author Grandalf
 */
public class VistaAdministrador extends Vista {

    private JFrame marco;
    private JPanel panelGeneral;
    private JTabbedPane pestañas;
    private JLabel admin;
    private JButton btnSalir;
    // Atributos visuales de Usuario
    private JPanel panelUsuarios;
    private JButton agregarUsuario;
    private JButton eliminarUsuario;
    private JTextField txtCodigoUsuario;
    private JTextField txtPassUsuario;
    private JTextField txtEdadUsuario;
    private JLabel lblCodigoUsuario;
    private JLabel lblPassUsuario;
    private JLabel lblTipoUsuario;
    private JLabel lblEdadUsuario;
    private JLabel lblBajaUsuario;
    private JComboBox<String> comboTiposUsuarios;
    private JComboBox<String> comboUsuarios;
    // Atributos visuales de Entidades
    private JPanel panelEntidades;
    private JButton agregarEntidad;
    private JButton eliminarEntidad;
    private JTextField txtCodigoEntidad;
    private JTextField txtDireccionEntidad;
    private JLabel lblCodigoEntidad;
    private JLabel lblDireccionEntidad;
    private JComboBox<String> comboEntidadesEnt;
    // Atributos visuales de Sucursales
    private JPanel panelSucursales;
    private JButton agregarSucursal;
    private JButton eliminarSucursal;
    private JTextField txtCodigoSucursal;
    private JTextField txtDireccionSucursal;
    private JTextField txtCantEmpleados;
    private JTextField txtFrecuenciaContratacion; 
    private JTextField txtDiaContratacion; 
    private JTextField txtMesContratacion; 
    private JTextField txtAnioContratacion;
    private JLabel lblCodigoEntidadSuc;
    private JLabel lblCodigoSucursalSuc;
    private JLabel lblDireccionSucursal;
    private JLabel lblCantEmpleados;
    private JLabel lblFrecuenciaContratacion; 
    private JLabel lblDiaContratacion; 
    private JLabel lblMesContratacion; 
    private JLabel lblAnioContratacion;
    private JComboBox<String> comboEntidadesSuc;
    private JComboBox<String> comboSucursalesSuc;
    // Atributos visuales de Contratos
    private JPanel panelContratos;
    private JButton agregarContrato;
    private JButton eliminarContrato;
    private JTextField txtCodigoContrato;
    private JTextField txtDiaContrato;
    private JTextField txtMesContrato;
    private JTextField txtAnioContrato;
    private JTextField txtDiasContratados;
    private JLabel lblCodigoContrato;
    private JLabel lblVigilanteContrato;
    private JLabel lblSucursalContrato;
    private JLabel lblDiaContrato;
    private JLabel lblMesContrato;
    private JLabel lblAnioContrato;
    private JLabel lblArmado;
    private JLabel lblDiasContratados;
    private JComboBox<String> comboVigilantesCon;
    private JComboBox<String> comboSucursalesCon;
    private JCheckBox checkArmado;
    // Atributos visuales de Bandas
    private JPanel panelBandas;
    private JButton agregarBanda;
    private JButton eliminarBanda;
    private JTextField txtCodigoBanda;
    private JLabel lblCodigoBanda;
    private JLabel lblCodigoBajaDeBanda;
    private JComboBox<String> comboBandas;
    // Atributos visuales de Integrantes
    private JPanel panelIntegrantes;
    private JButton agregarIntegrante;
    private JButton eliminarIntegrante;
    private JTextField txtClaveIntegrante;
    private JTextField txtNomApeIntegrante;
    private JLabel lblClaveIntegrante;
    private JLabel lblNomApeIntegrante;
    private JLabel lblBajaIntegrante;
    private JLabel lblCodigoBandaInt;
    private JComboBox<String> comboBandasInt;
    private JComboBox<String> comboIntegrantes;
    // Atributos visuales de Delitos
    private JPanel panelDelitos;
    private JButton agregarDelito;
    private JButton eliminarDelito;
    private JTextField txtClaveCaso;
    private JTextField txtTiempoCondena;
    private JTextField txtDiaDelito;
    private JTextField txtMesDelito;
    private JTextField txtAnioDelito;
    private JLabel lblAsaltantes;
    private JLabel lblBajaDelito;
    private JLabel lblSucursalDel;
    private JLabel lblDiaDelito;
    private JLabel lblMesDelito;
    private JLabel lblAnioDelito;
    private JLabel lblCondenado;
    private JLabel lblClaveCaso;
    private JLabel lblTiempoCondena;
    private JLabel lblJuezEncargado;
    private JComboBox<String> comboSucursalesDel;
    private JComboBox<String> comboJuecesDel;
    private JComboBox<String> comboDelitos;
    private JCheckBox checkCondenado;
    private JList<String> listaAsaltantes;
    private DefaultListModel modListaAsaltantes;
    private JScrollPane scrllListaAsaltantes;
    // Atributos visuales de Jueces
    private JPanel panelJueces;
    private JButton agregarJuez;
    private JButton eliminarJuez;
    private JTextField txtNomApeJuez;
    private JTextField txtTiempoServicioJuez;
    private JTextField txtNumJuzgado;
    private JLabel lblNumJuzgado;
    private JLabel lblNomApeJuez;
    private JLabel lblBajaJuez;
    private JLabel lblTiempoServicioJuez;
    private JComboBox<String> comboJueces;

    // Constructor
    public VistaAdministrador(Modelo m, Usuario usu) {
        super(m);
        marco = new JFrame();
        marco.setTitle("Menu de Administrador");
        marco.setResizable(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnSalir = new JButton("Cerrar Sesion");

        panelGeneral = new JPanel();
        panelGeneral.setLayout(new BorderLayout());

        // Panel de administracion Usuarios
        lblCodigoUsuario = new JLabel("Codigo de usuario:");
        lblPassUsuario = new JLabel("Contraseña:");
        lblEdadUsuario = new JLabel("Edad:");
        lblTipoUsuario = new JLabel("Categoria:");
        lblBajaUsuario = new JLabel("Baja de usuario:");
        agregarUsuario = new JButton("Agregar usuario");
        eliminarUsuario = new JButton("Eliminar usuario");
        txtCodigoUsuario = new JTextField(4);
        txtEdadUsuario = new JTextField(2);
        txtPassUsuario = new JTextField(10);
        comboTiposUsuarios = new JComboBox();
        comboUsuarios = new JComboBox();

        comboTiposUsuarios.addItem("Administrador");
        comboTiposUsuarios.addItem("Investigador");
        comboTiposUsuarios.addItem("Vigilante");
        
        recargarComboUsu(m);

        panelUsuarios = new JPanel();
        panelUsuarios.add(lblTipoUsuario);
        panelUsuarios.add(comboTiposUsuarios);
        panelUsuarios.add(lblCodigoUsuario);
        panelUsuarios.add(txtCodigoUsuario);
        panelUsuarios.add(lblPassUsuario);
        panelUsuarios.add(txtPassUsuario);
        panelUsuarios.add(lblEdadUsuario);
        panelUsuarios.add(txtEdadUsuario);
        panelUsuarios.add(agregarUsuario);
        panelUsuarios.add(lblBajaUsuario);
        panelUsuarios.add(comboUsuarios);
        panelUsuarios.add(eliminarUsuario);

        // Panel de administracion Entidades
        lblCodigoEntidad = new JLabel("Codigo de entidad:");
        lblDireccionEntidad = new JLabel("Domicilio central:");
        agregarEntidad = new JButton("Agregar Entidad");
        eliminarEntidad = new JButton("Eliminar Entidad");
        txtCodigoEntidad = new JTextField(4);
        txtDireccionEntidad = new JTextField(10);
        comboEntidadesEnt = new JComboBox();

        recargarComboEnt(m);

        panelEntidades = new JPanel();
        panelEntidades.add(lblCodigoEntidad);
        panelEntidades.add(txtCodigoEntidad);
        panelEntidades.add(lblDireccionEntidad);
        panelEntidades.add(txtDireccionEntidad);
        panelEntidades.add(agregarEntidad);
        panelEntidades.add(comboEntidadesEnt);
        panelEntidades.add(eliminarEntidad);

        // Panel de administracion Sucursales
        lblCodigoEntidadSuc = new JLabel("Entidad:");
        lblCodigoSucursalSuc = new JLabel("Codigo de Sucursal:");
        lblDireccionSucursal = new JLabel("Domicilio Sucursal:");
        lblCantEmpleados = new JLabel("Cantidad de empleados:");
        lblDiaContratacion = new JLabel("Dia:");
        lblMesContratacion = new JLabel("Mes:");
        lblAnioContratacion = new JLabel("Año:");
        lblFrecuenciaContratacion = new JLabel("Frecuencia de contratacion (dias):");
        agregarSucursal = new JButton("Agregar Sucursal");
        eliminarSucursal = new JButton("Eliminar Sucursal");
        txtCodigoSucursal = new JTextField(4);
        txtDireccionSucursal = new JTextField(10);
        txtCantEmpleados = new JTextField(3);
        txtFrecuenciaContratacion = new JTextField(3);
        txtDiaContratacion = new JTextField(2);
        txtMesContratacion = new JTextField(2);
        txtAnioContratacion = new JTextField(4);
        comboSucursalesSuc = new JComboBox();
        comboEntidadesSuc = new JComboBox();

        recargarCombosSuc(m);

        panelSucursales = new JPanel();
        panelSucursales.add(lblCodigoEntidadSuc);
        panelSucursales.add(comboEntidadesSuc);
        panelSucursales.add(lblCodigoSucursalSuc);
        panelSucursales.add(txtCodigoSucursal);
        panelSucursales.add(lblDireccionSucursal);
        panelSucursales.add(txtDireccionSucursal);
        panelSucursales.add(lblCantEmpleados);
        panelSucursales.add(txtCantEmpleados);
        panelSucursales.add(lblDiaContratacion);
        panelSucursales.add(txtDiaContratacion);
        panelSucursales.add(lblMesContratacion);
        panelSucursales.add(txtMesContratacion);
        panelSucursales.add(lblAnioContratacion);
        panelSucursales.add(txtAnioContratacion);
        panelSucursales.add(lblFrecuenciaContratacion);
        panelSucursales.add(txtFrecuenciaContratacion);
        panelSucursales.add(agregarSucursal);
        panelSucursales.add(comboSucursalesSuc);
        panelSucursales.add(eliminarSucursal);

        //Panel de administracion Contratos.
        lblCodigoContrato = new JLabel("Codigo de contrato:");
        lblSucursalContrato = new JLabel("Sucursal:");
        lblVigilanteContrato = new JLabel("Vigilante:");
        lblDiaContrato = new JLabel("Dia:");
        lblMesContrato = new JLabel("Mes:");
        lblAnioContrato = new JLabel("Año:");
        lblArmado = new JLabel("Armado:");
        lblDiasContratados = new JLabel("Cantidad de dias contratados:");
        agregarContrato = new JButton("Agregar Contrato");
        eliminarContrato = new JButton("Eliminar Contrato");
        txtCodigoContrato = new JTextField(2);
        txtDiaContrato = new JTextField(2);
        txtMesContrato = new JTextField(2);
        txtAnioContrato = new JTextField(2);
        txtDiasContratados = new JTextField(4);
        comboSucursalesCon = new JComboBox();
        comboVigilantesCon = new JComboBox();
        checkArmado = new JCheckBox();

        recargarCombosCon(m);

        panelContratos = new JPanel();
        panelContratos.add(lblSucursalContrato);
        panelContratos.add(comboSucursalesCon);
        panelContratos.add(lblCodigoContrato);
        panelContratos.add(txtCodigoContrato);
        panelContratos.add(lblVigilanteContrato);
        panelContratos.add(comboVigilantesCon);
        panelContratos.add(lblDiaContrato);
        panelContratos.add(txtDiaContrato);
        panelContratos.add(lblMesContrato);
        panelContratos.add(txtMesContrato);
        panelContratos.add(lblAnioContrato);
        panelContratos.add(txtAnioContrato);
        panelContratos.add(lblArmado);
        panelContratos.add(checkArmado);
        panelContratos.add(lblDiasContratados);
        panelContratos.add(txtDiasContratados);
        panelContratos.add(agregarContrato);
        panelContratos.add(eliminarContrato);

        // Panel de administracion Bandas
        lblCodigoBanda = new JLabel("Codigo de Banda:");
        lblCodigoBajaDeBanda = new JLabel("Eliminar Banda:");
        txtCodigoBanda = new JTextField(4);
        agregarBanda = new JButton("Agregar Banda");
        eliminarBanda = new JButton("Eliminar Banda");
        comboBandas = new JComboBox<>();
        
        recargarComboBand(m);

        panelBandas = new JPanel();
        panelBandas.add(lblCodigoBanda);
        panelBandas.add(txtCodigoBanda);
        panelBandas.add(agregarBanda);
        panelBandas.add(lblCodigoBajaDeBanda);
        panelBandas.add(comboBandas);
        panelBandas.add(eliminarBanda);

        // Panel de administracion Asaltantes
        lblCodigoBandaInt = new JLabel("Banda:");
        lblClaveIntegrante = new JLabel("Clave de Integrante:");
        lblNomApeIntegrante = new JLabel("Nombre y Apellido:");
        lblBajaIntegrante = new JLabel("Integrante:");
        txtClaveIntegrante = new JTextField(4);
        txtNomApeIntegrante = new JTextField(15);
        agregarIntegrante = new JButton("Agregar integrante");
        eliminarIntegrante = new JButton("Eliminar integrante");
        comboBandasInt = new JComboBox();
        comboIntegrantes = new JComboBox();

        recargarCombosInt(m);

        panelIntegrantes = new JPanel();
        panelIntegrantes.add(lblCodigoBandaInt);
        panelIntegrantes.add(comboBandasInt);
        panelIntegrantes.add(lblClaveIntegrante);
        panelIntegrantes.add(txtClaveIntegrante);
        panelIntegrantes.add(lblNomApeIntegrante);
        panelIntegrantes.add(txtNomApeIntegrante);
        panelIntegrantes.add(agregarIntegrante);
        panelIntegrantes.add(lblBajaIntegrante);
        panelIntegrantes.add(comboIntegrantes);
        panelIntegrantes.add(eliminarIntegrante);

        //Panel de administracion Delitos.
        lblClaveCaso = new JLabel("Clave del Caso:");
        lblBajaDelito = new JLabel("Casos:");
        lblAsaltantes = new JLabel("Asaltantes:");
        lblJuezEncargado = new JLabel("Juez encargado:");
        lblSucursalDel = new JLabel("Sucursal:");
        lblDiaDelito = new JLabel("Dia:");
        lblMesDelito = new JLabel("Mes:");
        lblAnioDelito = new JLabel("Año:");
        lblCondenado = new JLabel("Condenado:");
        lblTiempoCondena = new JLabel("meses de condena:");
        agregarDelito = new JButton("Agregar Delito");
        eliminarDelito = new JButton("Eliminar Delito");
        txtClaveCaso = new JTextField(2);
        txtDiaDelito = new JTextField(2);
        txtMesDelito = new JTextField(2);
        txtAnioDelito = new JTextField(2);
        txtTiempoCondena = new JTextField(4);
        comboSucursalesDel = new JComboBox();
        comboJuecesDel = new JComboBox();
        comboDelitos = new JComboBox();
        modListaAsaltantes = new DefaultListModel();
        listaAsaltantes = new JList<>(modListaAsaltantes);
        scrllListaAsaltantes = new JScrollPane();
        checkCondenado = new JCheckBox();
        listaAsaltantes.add(scrllListaAsaltantes);

        recargarComboDel(m);

        panelDelitos = new JPanel();
        panelDelitos.add(lblSucursalDel);
        panelDelitos.add(comboSucursalesDel);
        panelDelitos.add(lblDiaDelito);
        panelDelitos.add(txtDiaDelito);
        panelDelitos.add(lblMesDelito);
        panelDelitos.add(txtMesDelito);
        panelDelitos.add(lblAnioDelito);
        panelDelitos.add(txtAnioDelito);
        panelDelitos.add(lblAsaltantes);
        panelDelitos.add(listaAsaltantes);
        panelDelitos.add(lblCondenado);
        panelDelitos.add(checkCondenado);
        panelDelitos.add(lblTiempoCondena);
        panelDelitos.add(txtTiempoCondena);
        panelDelitos.add(lblClaveCaso);
        panelDelitos.add(txtClaveCaso);
        panelDelitos.add(lblJuezEncargado);
        panelDelitos.add(comboJuecesDel);
        panelDelitos.add(agregarDelito);
        panelDelitos.add(lblBajaDelito);
        panelDelitos.add(comboDelitos);
        panelDelitos.add(eliminarDelito);

        //Panel de administracion Jueces.
        lblNomApeJuez = new JLabel("Nombre y Apellido:");
        agregarJuez = new JButton("Agregar Juez");
        eliminarJuez = new JButton("Eliminar Juez");
        lblTiempoServicioJuez = new JLabel("Años de servicio:");
        lblNumJuzgado = new JLabel("Numero de juzgado:");
        lblBajaJuez = new JLabel("Juez:");
        txtNomApeJuez = new JTextField(20);
        txtTiempoServicioJuez = new JTextField(2);
        txtNumJuzgado = new JTextField(5);
        comboJueces = new JComboBox();

        recargarComboJueces(m);
        
        panelJueces = new JPanel();
        panelJueces.add(lblNomApeJuez);
        panelJueces.add(txtNomApeJuez);
        panelJueces.add(lblNumJuzgado);
        panelJueces.add(txtNumJuzgado);
        panelJueces.add(lblTiempoServicioJuez);
        panelJueces.add(txtTiempoServicioJuez);
        panelJueces.add(agregarJuez);
        panelJueces.add(lblBajaJuez);
        panelJueces.add(comboJueces);
        panelJueces.add(eliminarJuez);

        pestañas = new JTabbedPane();
        pestañas.add("Usuarios", panelUsuarios);
        pestañas.add("Entidades", panelEntidades);
        pestañas.add("Sucursales", panelSucursales);
        pestañas.add("Contratos", panelContratos);
        pestañas.add("Bandas", panelBandas);
        pestañas.add("Integrantes", panelIntegrantes);
        pestañas.add("Delitos", panelDelitos);
        pestañas.add("Jueces", panelJueces);

        panelGeneral.add(pestañas, BorderLayout.CENTER);
        panelGeneral.add(btnSalir, BorderLayout.SOUTH);
    }

    // Metodos en Vista administrativa de delitos
    

    // Metodos abstractos
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

    // Metodos en Vista administrativa de usuarios
    public void recargarComboUsu(Modelo m) {
        comboUsuarios.removeAllItems();
        for (Usuario usuario : m.obtenerUusarios()) {
            comboUsuarios.addItem(usuario.obtenerCodigoDeUsuario());
        }
    }
    
    public Boolean comprobarBlancosUsuario() {
        if (registrarCodigoUsuario().trim().isEmpty() || registrarPassUsuario().trim().isEmpty() || registrarEdadDeUsuario().trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public String registrarTipoUsuario() {
        return (String) comboTiposUsuarios.getSelectedItem();
    }

    public String registrarCodigoUsuario() {
        return txtCodigoUsuario.getText();
    }

    public String registrarPassUsuario() {
        return txtPassUsuario.getText();
    }

    public String registrarEdadDeUsuario() {
        return txtEdadUsuario.getText();
    }
    
    public String registrarCodigoBajaDeUsuario() {
        return (String) comboUsuarios.getSelectedItem();
    }

    // Metodos limitadores usuarios
    public void limitarCodigoUsuario(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (registrarCodigoUsuario().length() >= 4 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros. Maximo 4 digitos");
            evt.consume();
        }
    }

    public void limitarEdadUsuario(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (String.valueOf(registrarEdadDeUsuario()).length() >= 2 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros. Maximo 2 digitos");
            evt.consume();
        }
    }

    // Listeners pestaña Usuarios
    public void agregarRegistrarUsuarioListeners(ActionListener al) {
        agregarUsuario.addActionListener(al);
    }
    
    public void agregarEliminarUsuarioListeners(ActionListener al) {
        eliminarUsuario.addActionListener(al);
    }

    public void limitadorCodigoUsuario(KeyAdapter k) {
        txtCodigoUsuario.addKeyListener(k);
    }

    public void limitadorEdadUsuario(KeyAdapter k) {
        txtEdadUsuario.addKeyListener(k);
    }

    // Metodos en Vista administrativa de entidades
    public Boolean comprobarBlancosEntidad() {
        if (registrarCodigoEntidad().trim().isEmpty() || registrarDireccionEntidad().trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public void recargarComboEnt(Modelo m) {
        comboEntidadesEnt.removeAllItems();
        for (Entidad entidad : m.obtenerEntidades()) {
            comboEntidadesEnt.addItem(entidad.obtenerCodEnt());
        }
    }

    public void vaciarEnt() {
        txtCodigoEntidad.setText("");
        txtDireccionEntidad.setText("");
    }

    public void vaciarComboEnt() {
        comboEntidadesEnt.removeItem(comboEntidadesEnt.getSelectedItem());
    }

    public String registrarCodigoEntidad() {
        return txtCodigoEntidad.getText();
    }

    public String registrarDireccionEntidad() {
        return txtDireccionEntidad.getText();
    }

    public String registrarBajaDeEntidad() {
        return (String) comboEntidadesEnt.getSelectedItem();
    }

    // Metodos limitadores entidad
    public void limitarCodigoEntidad(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (registrarCodigoEntidad().length() >= 4 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros. Maximo 4 digitos");
            evt.consume();
        }
    }

    // Listeners pestaña entidades
    public void agregarRegistrarEntidadListeners(ActionListener al) {
        agregarEntidad.addActionListener(al);
    }

    public void agregarBajaEntidadListeners(ActionListener al) {
        eliminarEntidad.addActionListener(al);
    }

    public void limitadorCodigoEntidad(KeyAdapter k) {
        txtCodigoEntidad.addKeyListener(k);
    }

    //Sucursales metodos en vista administrativa
    public Boolean comprobarBlancosSucursal() {
        if (registrarCodigoDeSucursal().trim().isEmpty() || String.valueOf(registrarCantiDeEmpleados()).trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public void recargarCombosSuc(Modelo m) {
        comboEntidadesSuc.removeAllItems();
        comboSucursalesSuc.removeAllItems();
        for (Entidad entidad : m.obtenerEntidades()) {
            comboEntidadesSuc.addItem(entidad.obtenerCodEnt());
            for (Sucursal sucursal : entidad.obtenerSucursales()) {
                comboSucursalesSuc.addItem(sucursal.obtenerCodSuc());
            }
        }
    }

    public void vaciarSuc() {
        txtCodigoSucursal.setText("");
        txtDireccionSucursal.setText("");
        txtCantEmpleados.setText("");
    }

    public void vaciarComboSuc() {
        comboSucursalesSuc.removeItem(comboSucursalesSuc.getSelectedItem());
    }

    public String registrarBajaDeSucursal() {
        return (String) comboSucursalesSuc.getSelectedItem();
    }

    public String registrarEntidadDeSucursal() {
        return (String) comboEntidadesSuc.getSelectedItem();
    }

    public String registrarCodigoDeSucursal() {
        return txtCodigoSucursal.getText();
    }

    public String registrarDireccionDeSucursal() {
        return txtDireccionSucursal.getText();
    }

    public String registrarCantiDeEmpleados() {
        return txtCantEmpleados.getText();
    }
    
    public LocalDate registrarFechaDecontratacion(){
        return LocalDate.parse(txtAnioContratacion.getText() + "-" + txtMesContratacion.getText() + "-" + txtDiaContratacion.getText());
    }
    
    public String registrarFrecuenciaDeContratacion() {
        return txtCantEmpleados.getText();
    }

    // Metodos limitadores sucursal
    public void limitarCodigoSucursal(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (registrarCodigoDeSucursal().length() >= 4 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros. Maximo 4 digitos");
            evt.consume();
        }
    }

    public void limitarCantEmpleados(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (registrarCantiDeEmpleados().length() >= 3 || !Character.isDigit(c)) {
            mostrarException("Ingrese solo numeros. Maximo 3 digitos");
            evt.consume();
        }
    }
    public void limitarDiaContratacion(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (txtDiaContratacion.getText().length() >= 2 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros. Maximo 2 digitos (del 1 al 31).");
            evt.consume();
        }
    }

    public void limitarMesContratacion(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (txtMesContratacion.getText().length() >= 2 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros. Maximo 2 digitos (del 1 al 12).");
            evt.consume();
        }
    }

    public void limitarAnioContratacion(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (txtAnioContratacion.getText().length() >= 4 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese numero de 4 digitos solamente.");
            evt.consume();
        }
    }

    // Listeners pestaña sucursales
    public void agregarRegistrarSucursalListeners(ActionListener al) {
        agregarSucursal.addActionListener(al);
    }

    public void agregarBajaSucursalListeners(ActionListener al) {
        eliminarSucursal.addActionListener(al);
    }

    public void limitadorCodigoSucursal(KeyAdapter k) {
        txtCodigoSucursal.addKeyListener(k);
    }

    public void limitadorCantDeEmpleados(KeyAdapter k) {
        txtCantEmpleados.addKeyListener(k);
    }
    
    public void limitadorDiaContratacion(KeyAdapter k) {
        txtDiaContratacion.addKeyListener(k);
    }

    public void limitadorMesContratacion(KeyAdapter k) {
        txtMesContratacion.addKeyListener(k);
    }

    public void limitadorAnioContratacion(KeyAdapter k) {
        txtAnioContratacion.addKeyListener(k);
    }
    

    //Contratos metodos en vista administrativa
    public void recargarCombosCon(Modelo m) {
        comboSucursalesCon.removeAllItems();
        comboVigilantesCon.removeAllItems();
        for (Entidad entidad : m.obtenerEntidades()) {
            for (Sucursal sucursal : entidad.obtenerSucursales()) {
                comboSucursalesCon.addItem(sucursal.obtenerCodSuc());
            }
        }
        for (Vigilante usuario : m.obtenerVigilantes()) {
            comboVigilantesCon.addItem(usuario.obtenerCodigoDeUsuario());
        }
    }

    public Boolean comprobarBlancosContrato() {
        if (registrarCodigoDeContrato().trim().isEmpty() || txtDiaContrato.getText().trim().isEmpty() || txtMesContrato.getText().trim().isEmpty() || txtAnioContrato.getText().trim().isEmpty() || txtDiasContratados.getText().trim().isEmpty()) {
            return true;
        }
        return false;
    }
    public Boolean comprobarBlancosBajaContrato() {
        return registrarCodigoDeContrato().trim().isEmpty();
    }

    public String registrarSucursalDeContrato() {
        return (String) comboSucursalesCon.getSelectedItem();
    }

    public String registrarCodigoDeContrato() {
        return txtCodigoContrato.getText();
    }

    public String registrarVigilanteContratado() {
        return (String) comboVigilantesCon.getSelectedItem();
    }

    public Boolean registrarPortacionDeArma() {
        return checkArmado.isSelected();
    }

    public LocalDate registrarFechaDeContrato() {
        return LocalDate.parse(txtAnioContrato.getText() + "-" + txtMesContrato.getText() + "-" + txtDiaContrato.getText());
    }

    public Integer registrarDiasContratados() {
        return Integer.valueOf(txtDiasContratados.getText());
    }

    // Limitadores pestaña contratos
    public void limitarCodigoContrato(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (registrarCodigoDeContrato().length() >= 4 || !Character.isDigit(c)) {
            mostrarException("Ingrese solo numeros. Maximo 4 digitos");
            evt.consume();
        }
    }

    public void limitarDiaContrato(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (txtDiaContrato.getText().length() >= 2 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros. Maximo 2 digitos (del 1 al 31).");
            evt.consume();
        }
    }

    public void limitarMesContrato(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (txtMesContrato.getText().length() >= 2 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros. Maximo 2 digitos (del 1 al 12).");
            evt.consume();
        }
    }

    public void limitarAnioContrato(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (txtAnioContrato.getText().length() >= 4 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese numero de 4 digitos solamente.");
            evt.consume();
        }
    }

    public void limitarDiasContratados(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (txtDiasContratados.getText().length() >= 4 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros. Maximo 4 digitos");
            evt.consume();
        }
    }

    // Listeners pestaña contratos
    public void agregarRegistrarContratoListeners(ActionListener al) {
        agregarContrato.addActionListener(al);
    }
    public void agregarEliminarContratoListeners(ActionListener al) {
        eliminarContrato.addActionListener(al);
    }
    public void limitadorCodgiContrato(KeyAdapter k) {
        txtCodigoContrato.addKeyListener(k);
    }

    public void limitadorDiaContrato(KeyAdapter k) {
        txtDiaContrato.addKeyListener(k);
    }

    public void limitadorMesContrato(KeyAdapter k) {
        txtMesContrato.addKeyListener(k);
    }

    public void limitadorAnioContrato(KeyAdapter k) {
        txtAnioContrato.addKeyListener(k);
    }

    public void limitadorDiasContratados(KeyAdapter k) {
        txtDiasContratados.addKeyListener(k);
    }

    // Metodos en Vista administrativa de Bandas
    public Boolean comprobarBlancosBandas() {
        if (registrarCodigoDeBanda().trim().isEmpty()) {
            return true;
        }
        return false;
    }
    public void recargarComboBand(Modelo m) {
        comboBandas.removeAllItems();
        for (Banda banda : m.obtenerBandas()) {
            comboBandas.addItem(banda.obtenerCodigoBanda());
        }
    }

    public String registrarCodigoDeBanda() {
        return txtCodigoBanda.getText();
    }
    public String registrarCodigoBajaDeBanda() {
        return (String) comboBandas.getSelectedItem();
    }
    // Limitadores pestaña Bandas
    public void limitarCodigoBanda(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (registrarCodigoDeBanda().length() >= 4 || !Character.isDigit(c)) {
            mostrarException("Ingrese solo numeros. Maximo 4 digitos");
            evt.consume();
        }
    }
    // Listeners pestaña bandas
    public void agregarRegistrarBandaListeners(ActionListener al) {
        agregarBanda.addActionListener(al);
    }
    public void agregarEliminarBandaListeners(ActionListener al) {
        eliminarBanda.addActionListener(al);
    }

    public void limitadorCodigoBandaListeners(KeyAdapter al) {
        txtCodigoBanda.addKeyListener(al);
    }

    // Metodos en Vista administrativa de Integrantes
    public boolean comprobarBlancosIntegrantes() {
        if (registrarClaveDeIntegrante().trim().isEmpty() || registrarNomApeIntegrate().trim().isEmpty()) {
            return true;
        }
        return false;
    }
    public void recargarCombosInt(Modelo m) {
        comboBandasInt.removeAllItems();
        comboIntegrantes.removeAllItems();
        for (Banda banda : m.obtenerBandas()) {
            comboBandasInt.addItem(banda.obtenerCodigoBanda());
            for (Asaltante asaltante : banda.obtenerIntegrantes()) {
                comboIntegrantes.addItem(asaltante.obtenerClaveDeIntegrante());
            }
        }
    }
    public String registrarClaveDeIntegrante() {
        return txtClaveIntegrante.getText();
    }
    public String registrarBandaDeIntegrante() {
        return (String) comboBandasInt.getSelectedItem();
    }
    public String registrarNomApeIntegrate() {
        return txtNomApeIntegrante.getText();
    }
    public String registrarCodigoBajaDeIntegrante() {
        return (String) comboIntegrantes.getSelectedItem();
    }
    // Limitadores pestaña Integrantes
    public void limitarClaveIntegrante(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (registrarClaveDeIntegrante().length() >= 4 || !Character.isDigit(c)) {
            mostrarException("Ingrese solo numeros. Maximo 4 digitos");
            evt.consume();
        }
    }
    // Listeners pestaña Integrantes
    public void agregarRegistrarIntegranteListeners(ActionListener al) {
        agregarIntegrante.addActionListener(al);
    }
    public void agregarEliminarIntegranteListeners(ActionListener al) {
        eliminarIntegrante.addActionListener(al);
    }
    public void limitadorClaveIntegranteListeners(KeyAdapter al) {
        txtClaveIntegrante.addKeyListener(al);
    }

    // Metodos en Vista administrativa de Jueces
    public void recargarComboJueces(Modelo m) {
        comboJueces.removeAllItems();
        for (Juez juez : m.obtenerJueces()) {
            comboJueces.addItem(juez.consultarNomApe());
        }
    }
    public boolean comprobarBlancosJueces() {
        if (registrarTiempoDeServicioJuez().trim().isEmpty() || registrarNomApeJuez().trim().isEmpty() || registrarNumeroJuzgadoJuez().trim().isEmpty()) {
            return true;
        }
        return false;
    }
    public String registrarNomApeJuez() {
        return txtNomApeJuez.getText();
    }
    public String registrarTiempoDeServicioJuez() {
        return txtTiempoServicioJuez.getText();
    }
    public String registrarNumeroJuzgadoJuez() {
        return txtNumJuzgado.getText();
    }
    public String registrarBajaDeJuez() {
        return (String) comboJueces.getSelectedItem();
    }
    // Limitadores pestaña Jueces
    public void limitarTiempoServicio(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (registrarTiempoDeServicioJuez().length() >= 4 || !Character.isDigit(c)) {
            mostrarException("Ingrese solo numeros. Maximo 4 digitos");
            evt.consume();
        }
    }
    // Listeners pestaña Jueces
    public void agregarRegistrarJuezListeners(ActionListener al) {
        agregarJuez.addActionListener(al);
    }
    public void agregarEliminarJuezListeners(ActionListener al) {
        eliminarJuez.addActionListener(al);
    }
    public void limitadorTiempoServicioListeners(KeyAdapter al) {
        txtTiempoServicioJuez.addKeyListener(al);
    }
    
    // Metodos en Vista administrativa de Delitos
    public void recargarComboDel(Modelo m) {
        comboSucursalesDel.removeAllItems();
        comboJuecesDel.removeAllItems();
        modListaAsaltantes.removeAllElements();
        comboDelitos.removeAllItems();
        for (Entidad entidad : m.obtenerEntidades()) {
            for (Sucursal sucursal : entidad.obtenerSucursales()) {
                comboSucursalesDel.addItem(sucursal.obtenerCodSuc());
            }
        }
        for (Juez juez : m.obtenerJueces()) {
            comboJuecesDel.addItem(juez.consultarNomApe());
            for (Delito delito : m.obtenerDelitos()) {
                comboDelitos.addItem(delito.obtenerClaveDelCaso());
            }
        }
        for (Banda banda : m.obtenerBandas()) {
            for (Asaltante integrante : banda.obtenerIntegrantes()) {
                modListaAsaltantes.addElement(integrante.obtenerClaveDeIntegrante());
            }
        }
    }
    public Boolean comprobarBlancosDelitos() {
        if (registrarTiempoDeServicioJuez().trim().isEmpty() || registrarNomApeJuez().trim().isEmpty() || registrarNumeroJuzgadoJuez().trim().isEmpty()) {
            return true;
        }
        return false;
    }
    public LocalDate registrarFechaDeDelito() {
        return LocalDate.parse(txtAnioDelito.getText() + "-" + txtMesDelito.getText() + "-" + txtDiaDelito.getText());
    }
    public Boolean registrarSentancia() {
        return checkCondenado.isSelected();
    }
    public Integer registrarTiempoCondena() {
        return Integer.valueOf(txtTiempoCondena.getText());
    }
    public String registrarClaveCaso() {
        return txtClaveCaso.getText();
    }
    public String registrarSucursalAsaltada() {
        return (String) comboSucursalesDel.getSelectedItem();
    }
    public String registrarJuezEncargado() {
        return (String) comboJuecesDel.getSelectedItem();
    }
    public ArrayList<String> registrarAsaltantes() {
        return (ArrayList<String>) listaAsaltantes.getSelectedValuesList();
    }
    public String registrarBajaDelito() {
        return (String) comboDelitos.getSelectedItem();
    }
    public void limitarDiaDelito(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (txtDiaDelito.getText().length() >= 2 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros. Maximo 2 digitos (del 1 al 31).");
            evt.consume();
        }
    }

    public void limitarMesDelito(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (txtMesDelito.getText().length() >= 2 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros. Maximo 2 digitos (del 1 al 12).");
            evt.consume();
        }
    }

    public void limitarAnioDelito(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (txtAnioDelito.getText().length() >= 4 || !Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Ingrese numero de 4 digitos solamente.");
            evt.consume();
        }
    }
    // Listeners pestaña Delitos
    public void agregarRegistrarDelitoListeners(ActionListener al) {
        agregarDelito.addActionListener(al);
    }
    public void agregarEliminarDelitoListeners(ActionListener al) {
        eliminarDelito.addActionListener(al);
    }
    
    public void limitadorDiaDelito(KeyAdapter k) {
        txtDiaDelito.addKeyListener(k);
    }
    
    public void limitadorMesDelito(KeyAdapter k) {
        txtMesDelito.addKeyListener(k);
    }

    public void limitadorAnioDelito(KeyAdapter k) {
        txtAnioDelito.addKeyListener(k);
    }
}
