/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.*;
import java.time.LocalDate;
import modelo.*;
import vista.*;

/**
 *
 * @author Grandalf
 */
public class Controlador {

    //Atributos
    private Modelo modelo;
    private VistaLogin vista;

    //constructor

    /**
     * Instancia el controlador con un modelo y una vista de login
     * @param modelo recibe un modelo ya instanciado
     * @param vista recibe una vista ya instanciado
     */
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = (VistaLogin) vista;
    }

    //metodos

    /**
     * Arranque de sistema pidiendole a la vista que se muestre
     * y pasandole los listeners de inicio de sesion y salir del programa
     */
    public void arrancar() {
        vista.mostrar();
        vista.addInicioSesionListener(new InicioListener());
        vista.agregarListeners(new CerrarListener());
    }

    //Listeners para vista login.
    private class InicioListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String cod = vista.getTxtCodigo();
            String pass = (String) vista.getTxtPass();

            Usuario usuario = modelo.inicioSesion(cod, pass);

            if (usuario != null) {
                vista.cerrar();
                Vista v = usuario.proceder(modelo);

                if (usuario.permisosAdministrativos()) {
                    v.mostrar();
                    v.agregarListeners(new AdministracionListener(v));
                } else {
                    v.mostrar();
                    v.agregarListeners(new CerrarSesionListener(v));
                }
            } else {
                vista.mostrarException("Usuario y/o contraseña invalido.");
            }
        }
    }

    private class CerrarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    //Listeners generales para las vistas de usuario.
    private class CerrarSesionListener implements ActionListener {

        private Vista v;

        public CerrarSesionListener(Vista v) {
            this.v = v;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            v.cerrar();
            vista.mostrar();
        }
    }

    //Listeners para vista de administrador.
    private class AdministracionListener implements ActionListener {

        private VistaAdministrador v;

        public AdministracionListener(Vista v) {
            this.v = (VistaAdministrador) v;

            this.v.agregarListeners(new CerrarSesionListener(this.v));

            //Usuarios cargas de Listeners en la vista administrativa
            this.v.agregarRegistrarUsuarioListeners(new AgregarUsuarioListener());
            this.v.agregarEliminarUsuarioListeners(new EliminarUsuarioListener());
            this.v.limitadorCodigoUsuario(new LimitadorCodigoUsuario());
            this.v.limitadorEdadUsuario(new LimitadorEdadUsuario());

            //Entidades cargas de Listeners en la vista administrativa
            this.v.agregarRegistrarEntidadListeners(new AgregarEntidadListener());
            this.v.agregarBajaEntidadListeners(new EliminarEntidadListener());
            this.v.limitadorCodigoEntidad(new LimitadorCodigoEntidad());

            //Sucursales cargas de Listeners en la vista administrativa
            this.v.agregarRegistrarSucursalListeners(new AgregarSucursalListener());
            this.v.agregarBajaSucursalListeners(new EliminarSucursalListener());
            this.v.limitadorCodigoSucursal(new LimitadorCodigoSucursal());
            this.v.limitadorCantDeEmpleados(new LimitadorCantDeEmpleados());
            this.v.limitadorDiaContratacion(new LimitadorDiaContratacion());
            this.v.limitadorMesContratacion(new LimitadorMesContratacion());
            this.v.limitadorAnioContratacion(new LimitadorAnioContratacion());

            //Contratos cargas de Listeners en la vista administrativa
            this.v.agregarRegistrarContratoListeners(new AltaContratoListener());
            this.v.agregarEliminarContratoListeners(new EliminarContratoListener());
            this.v.limitadorCodgiContrato(new LimitadorCodigoContrato());
            this.v.limitadorDiaContrato(new LimitadorDiaContrato());
            this.v.limitadorMesContrato(new LimitadorMesContrato());
            this.v.limitadorAnioContrato(new LimitadorAnioContrato());
            this.v.limitadorDiasContratados(new LimitadorDiasContratados());

            //Bandass cargas de Listeners en la vista administrativa
            this.v.agregarRegistrarBandaListeners(new AltaBandaListener());
            this.v.agregarEliminarBandaListeners(new EliminarBandaListener());
            this.v.limitadorCodigoBandaListeners(new LimitadorCodigoBanda());

            //Integrantes cargas de Listeners en la vista administrativa
            this.v.agregarRegistrarIntegranteListeners(new AltaIntegranteListener());
            this.v.agregarEliminarIntegranteListeners(new EliminarIntegranteListener());
            this.v.limitadorClaveIntegranteListeners(new LimitadorClaveIntegrante());

            //Jueces cargas de Listeners en la vista administrativa
            this.v.agregarRegistrarJuezListeners(new AltaJuezListener());
            this.v.agregarEliminarJuezListeners(new EliminarJuezListener());
            this.v.limitadorTiempoServicioListeners(new LimitadorTiempoServicio());

            //Delitos cargas de Listeners en la vista administrativa
            this.v.agregarRegistrarDelitoListeners(new AltaDelitoListener());
            this.v.agregarEliminarDelitoListeners(new EliminarDelitoListener());
            this.v.limitadorDiaDelito(new LimitadorDiaDelito());
            this.v.limitadorMesDelito(new LimitadorMesDelito());
            this.v.limitadorAnioDelito(new LimitadorAnioDelito());
        }

        //Usuario Listeners
        private class AgregarUsuarioListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.comprobarBlancosUsuario()) {
                    v.mostrarException("Error al cargar los datos.");
                } else {
                    if (modelo.altaUsuario(v.registrarTipoUsuario(), v.registrarCodigoUsuario(), v.registrarEdadDeUsuario(), v.registrarPassUsuario())) {
                        v.mostrarValidacion("Usuario cargado exitosamente.");
                        v.recargarComboUsu(modelo);
                    } else {
                        v.mostrarException("Este usuario ya existe");
                    }
                }
            }
        }

        private class EliminarUsuarioListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (modelo.bajaUsuario(v.registrarCodigoBajaDeUsuario())) {
                    v.mostrarValidacion("Usuario dado de baja exitosamente.");
                    v.recargarComboUsu(modelo);
                } else {
                    v.mostrarException("Este usuario no existe");
                }

            }
        }

        private class LimitadorCodigoUsuario extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarCodigoUsuario(evt);
            }
        }

        private class LimitadorEdadUsuario extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarEdadUsuario(evt);
            }
        }

        //Entidades Listeners
        private class AgregarEntidadListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.comprobarBlancosEntidad()) {
                    v.mostrarException("Error al cargar datos.");
                } else {
                    if (modelo.altaEntidad(v.registrarDireccionEntidad(), v.registrarCodigoEntidad())) {
                        v.mostrarValidacion("Entidad cargada exitosamente.");
                        v.vaciarEnt();
                        v.recargarComboEnt(modelo);
                        v.recargarCombosSuc(modelo);
                        v.recargarCombosCon(modelo);
                        v.recargarCombosInt(modelo);
                    } else {
                        v.mostrarException("Esta entidad ya exite.");
                    }
                }
            }
        }

        private class EliminarEntidadListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (modelo.bajaEntidad(v.registrarBajaDeEntidad())) {
                    v.mostrarException("Entidad dada de baja.");
                    v.recargarCombosSuc(modelo);
                    v.recargarComboEnt(modelo);
                    v.recargarCombosCon(modelo);
                    v.recargarCombosInt(modelo);
                } else {
                    v.mostrarException("Entidad inexistente.");
                }
            }
        }

        private class LimitadorCodigoEntidad extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarCodigoEntidad(evt);
            }
        }

        //Sucursales listeners
        private class AgregarSucursalListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.comprobarBlancosSucursal()) {
                    v.mostrarException("Error al cargar datos.");
                } else {
                    if (modelo.altaSucursal(v.registrarEntidadDeSucursal(), v.registrarDireccionDeSucursal(), v.registrarCodigoDeSucursal(), Integer.valueOf(v.registrarCantiDeEmpleados()), v.registrarFechaDecontratacion(), Integer.valueOf(v.registrarFrecuenciaDeContratacion()))) {
                        v.mostrarValidacion("Sucursal cargada exitosamente.");
                        v.vaciarSuc();
                        v.recargarCombosSuc(modelo);
                        v.recargarCombosCon(modelo);
                        v.recargarCombosInt(modelo);
                    } else {
                        v.mostrarException("Esta Sucursal ya existe.");
                    }
                }
            }
        }

        private class EliminarSucursalListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (modelo.bajaSucursal(v.registrarBajaDeSucursal())) {
                    v.mostrarValidacion("Sucursal dada de baja exitosamente.");
                    v.recargarCombosSuc(modelo);
                    v.recargarCombosCon(modelo);
                    v.recargarCombosInt(modelo);
                } else {
                    v.mostrarException("Esta Sucursal no existe.");
                }
            }
        }

        private class LimitadorCodigoSucursal extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarCodigoSucursal(evt);
            }
        }

        private class LimitadorCantDeEmpleados extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarCantEmpleados(evt);
            }
        }
        private class LimitadorMesContratacion extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarMesContratacion(evt);
            }
        }

        private class LimitadorAnioContratacion extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarAnioContratacion(evt);
            }
        }

        private class LimitadorDiaContratacion extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarDiaContratacion(evt);
            }
        }

        //Contratos listeners
        private class AltaContratoListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.comprobarBlancosContrato()) {
                    v.mostrarException("Error al cargar contrato.");
                } else {
                    if (modelo.comprobarFechaDeContratacion(v.registrarSucursalDeContrato(), v.registrarFechaDeContrato())) {
                        if (modelo.altaContrato(v.registrarSucursalDeContrato(), v.registrarCodigoDeContrato(), v.registrarVigilanteContratado(), v.registrarPortacionDeArma(), v.registrarFechaDeContrato(), v.registrarDiasContratados())) {
                            v.mostrarValidacion("Contrato cargado exitosamente.");
                            v.vaciarSuc();
                            v.recargarCombosSuc(modelo);
                            v.recargarCombosCon(modelo);
                            v.recargarCombosInt(modelo);
                        } else {
                            v.mostrarException("Este contrato ya fue registrado anteriormente.");
                        }
                    } else {
                        v.mostrarException("Fecha de contrato no coincide con la fecha de contratacion de la sucursal.");
                    }

                }
            }
        }

        private class EliminarContratoListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.comprobarBlancosBajaContrato()) {
                    v.mostrarException("Seleccione una sucursal en la lista y escriba el codigo numerico maximo de 4 digitos del contrato a borrar.");
                } else {
                    if (modelo.bajaContrato(v.registrarSucursalDeContrato(), v.registrarCodigoDeContrato())) {
                        v.mostrarValidacion("Contrato borrado exitosamente.");
                        v.vaciarSuc();
                        v.recargarCombosSuc(modelo);
                        v.recargarCombosCon(modelo);
                        v.recargarCombosInt(modelo);
                    } else {
                        v.mostrarException("Este contrato no existe.");
                    }
                }
            }
        }

        private class LimitadorCodigoContrato extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarCodigoContrato(evt);
            }
        }

        private class LimitadorDiaContrato extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarDiaContrato(evt);
            }
        }

        private class LimitadorMesContrato extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarMesContrato(evt);
            }
        }

        private class LimitadorAnioContrato extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarAnioContrato(evt);
            }
        }

        private class LimitadorDiasContratados extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarDiasContratados(evt);
            }
        }

        //Bandas listeners
        private class AltaBandaListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.comprobarBlancosBandas()) {
                    v.mostrarException("Error al cargar banda.");
                } else {

                    if (modelo.altaBanda(v.registrarCodigoDeBanda())) {
                        v.mostrarValidacion("Banda cargada exitosamente.");
                        v.recargarCombosInt(modelo);
                    } else {
                        v.mostrarException("Esta banda ya existe.");
                    }
                }
            }
        }

        private class EliminarBandaListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (modelo.bajaBanda(v.registrarCodigoBajaDeBanda())) {
                    v.mostrarValidacion("Contrato cargado exitosamente.");
                    v.vaciarSuc();
                    v.recargarComboBand(modelo);
                    v.recargarCombosInt(modelo);
                } else {
                    v.mostrarException("Este contrato no existe.");
                }
            }
        }

        private class LimitadorCodigoBanda extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarCodigoBanda(evt);
            }
        }

        //Integrantes listeners
        private class AltaIntegranteListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.comprobarBlancosIntegrantes()) {
                    v.mostrarException("Error al cargar integrante.");
                } else {
                    if (modelo.altaIntegrante(v.registrarBandaDeIntegrante(), v.registrarClaveDeIntegrante(), v.registrarNomApeIntegrate())) {
                        v.mostrarValidacion("Integrante cargado exitosamente.");
                        v.recargarCombosInt(modelo);
                    } else {
                        v.mostrarException("Este integrante ya existe.");
                    }
                }
            }
        }

        private class EliminarIntegranteListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (modelo.bajaIntegrante(v.registrarCodigoBajaDeIntegrante())) {
                    v.mostrarValidacion("Asaltante eliminado exitosamente.");
                    v.vaciarSuc();
                    v.recargarComboBand(modelo);
                    v.recargarCombosInt(modelo);
                    v.recargarComboDel(modelo);
                } else {
                    v.mostrarException("Este asaltante no existe.");
                }
            }
        }

        private class LimitadorClaveIntegrante extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarClaveIntegrante(evt);
            }
        }

        //Jueces listeners
        private class AltaJuezListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.comprobarBlancosJueces()) {
                    v.mostrarException("Error al cargar juez.");
                } else {
                    if (modelo.altaJuez(v.registrarTiempoDeServicioJuez(), v.registrarNumeroJuzgadoJuez(), v.registrarNomApeJuez())) {
                        v.mostrarValidacion("Juez cargado exitosamente.");
                        v.recargarComboJueces(modelo);
                        v.recargarComboDel(modelo);
                    } else {
                        v.mostrarException("Este juez ya existe.");
                    }
                }
            }
        }

        private class EliminarJuezListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (modelo.bajaJuez(v.registrarBajaDeJuez())) {
                    v.mostrarValidacion("Juez eliminado exitosamente.");
                    v.recargarComboJueces(modelo);
                    v.recargarComboDel(modelo);
                } else {
                    v.mostrarException("Este juez no existe.");
                }
            }
        }

        private class LimitadorTiempoServicio extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarTiempoServicio(evt);
            }
        }

        //Delitos listeners
        private class AltaDelitoListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!modelo.comprobarDelitoInvalido(v.registrarAsaltantes(), v.registrarFechaDeDelito())) {
                    if (modelo.altaDelito(v.registrarFechaDeDelito(), v.registrarTiempoCondena(), v.registrarSentancia(), v.registrarSucursalAsaltada(), v.registrarJuezEncargado(), v.registrarAsaltantes(), v.registrarClaveCaso())) {
                        v.mostrarValidacion("Delito cargado exitosamente.");
                        v.recargarComboDel(modelo);
                    } else {
                        v.mostrarException("Este delito ya fue cargado.");
                    }
                } else {
                    v.mostrarException("La fecha coincide con otro delito de algun actor.");
                }
            }
        }

        private class EliminarDelitoListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (modelo.bajaDelito(v.registrarBajaDelito())) {
                    v.mostrarValidacion("Delito eliminado exitosamente.");
                    v.recargarComboJueces(modelo);
                    v.recargarComboDel(modelo);
                } else {
                    v.mostrarException("Este Delito no existe.");
                }
            }
        }
        private class LimitadorMesDelito extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarMesDelito(evt);
            }
        }

        private class LimitadorAnioDelito extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarAnioDelito(evt);
            }
        }

        private class LimitadorDiaDelito extends KeyAdapter {

            @Override
            public void keyTyped(KeyEvent evt) {
                v.limitarDiaDelito(evt);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        }

    }
}
