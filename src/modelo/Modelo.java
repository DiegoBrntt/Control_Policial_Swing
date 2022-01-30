/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Grandalf
 */
public class Modelo {

    // Atributos
    private ActionListener listener;
    private RegistrosDeInformacion registros;

    // Contructor
    public Modelo() {
        registros = new RegistrosDeInformacion();

        altaUsuario("Vigilante", "01", "48", "vig001");
        altaUsuario("Vigilante", "02", "38", "vig002");
        altaUsuario("Administrador", "01", "52", "adm001");
        altaUsuario("Investigador", "01", "29", "inv001");

        altaEntidad("Emilio Mitre 950", "01");
        altaEntidad("Eva Peron 1980", "02");

        altaSucursal("E01", "Pedro Goyena 1339", "01", 50, LocalDate.parse("2021-09-28"), 15);
        altaSucursal("E01", "Av. La Plata 3786", "02", 37, LocalDate.parse("2021-09-11"), 60);
        altaSucursal("E02", "Av. Directorio 3018", "01", 88, LocalDate.parse("2021-09-13"), 15);
        altaSucursal("E02", "Baldomer Fernandez 2566", "02", 47, LocalDate.parse("2021-09-01"), 30);

        altaContrato("E01S01", "001", "V01", false, LocalDate.parse("2021-09-13"), 30);
        altaContrato("E01S02", "001", "V01", true, LocalDate.parse("2021-10-01"), 50);
        altaContrato("E02S01", "001", "V01", true, LocalDate.parse("2021-10-13"), 60);

        altaBanda("0");
        altaBanda("1");
        altaBanda("2");

        altaIntegrante("B0", "01", "Jorge Perez");
        altaIntegrante("B0", "02", "Miguel Sanchez");
        altaIntegrante("B1", "01", "Juan Aguirre");
        altaIntegrante("B1", "02", "Luis Enrique Miño");
        altaIntegrante("B2", "01", "Damian Mengue");
        altaIntegrante("B2", "02", "Leticia Bustos");

        altaJuez("20", "991", "Edgardo Reyes");
        altaJuez("28", "992", "Reymundo Ortiz");
    }

    // Metodos para manejo de informacion de usuarios
    public Usuario inicioSesion(String codigo, String pass) {
        return registros.validarUsuario(codigo, pass);
    }

    public Boolean altaUsuario(String tipo, String codigo, String edad, String pass) {
        return registros.registrarUsuario(tipo, codigo, edad, pass);
    }

    public Boolean bajaUsuario(String codigo) {
        return registros.eliminarRegistroDeUsuario(codigo);
    }

    public Usuario buscarUsuario(String codigo) {
        return registros.buscarUsuario(codigo);
    }

    public ArrayList<Vigilante> obtenerVigilantes() {
        return registros.obtenerVigilantes();
    }

    public ArrayList<Usuario> obtenerUusarios() {
        return registros.obtenerUsuarios();
    }

    // Metodos para manejo de informacion de entidades
    public Boolean altaEntidad(String central, String codEnt) {
        return registros.registrarEntidad(central, codEnt);
    }

    public Boolean bajaEntidad(String codEnt) {
        return registros.bajaEnt(codEnt);
    }

    public Entidad buscarEntidad(String ent) {
        return registros.buscarEntidad(ent);
    }

    public ArrayList<Entidad> obtenerEntidades() {
        return registros.obtenerTodasLasEntidades();
    }

    // Metodos para manejo de informacion de sucursales
    public Boolean altaSucursal(String codEnt, String domicilio, String codSuc, Integer cantEmp, LocalDate fechaDeContratacion, Integer frecuenciaDeContratacion) {
        return registros.registrarSucursal(codEnt, domicilio, codEnt + "S" + codSuc, cantEmp, fechaDeContratacion, frecuenciaDeContratacion);
    }

    public Boolean bajaSucursal(String codSuc) {
        return registros.bajaSucursal(codSuc);
    }

    public Sucursal buscarSucursal(String codSuc) {
        return registros.buscarSucursal(codSuc);
    }

    public ArrayList<Sucursal> obtenerSucursales() {
        return registros.obtenerTodasLasSucursales();
    }

    public ArrayList<String> obtenerSucursalesPorEnt(String codEnt) {
        return registros.obtenerSucursalesPorEnt(codEnt);
    }

    // Metodos para manejo de informacion de contratos
    public Boolean altaContrato(String codSuc, String codCon, String contratado, Boolean armado, LocalDate fecha, Integer diasContratados) {
        return registros.registrarContrato(codSuc, codCon, contratado, armado, fecha, diasContratados);
    }

    public Boolean bajaContrato(String codSuc, String codCon) {
        return registros.eliminarContrato(codSuc, codCon);
    }

    public ArrayList<Contrato> obtenerContratosPorVigilante(String Cod) {
        ArrayList<Contrato> con = new ArrayList<>();
        for (Entidad entidad : registros.obtenerTodasLasEntidades()) {
            con.addAll(entidad.buscarContratosPorVigilante(Cod));
        }
        return con;
    }

    public ArrayList<Contrato> obtenerTodosLosContratos() {
        ArrayList<Contrato> con = new ArrayList<>();
        for (Entidad entidad : registros.obtenerTodasLasEntidades()) {
            con.addAll(entidad.obtenerTodosLosContratos());
        }
        return con;
    }

    public Boolean comprobarFechaDeContratacion(String codSuc, LocalDate fechaDeContrato) {
        return registros.buscarSucursal(codSuc).validarFechaContrato(fechaDeContrato);
    }

    // Metodos para manejo de informacion de bandas
    public Boolean altaBanda(String codBand) {
        return registros.registrarBanda(codBand);
    }

    public Boolean bajaBanda(String codBand) {
        return registros.eliminarBanda(codBand);
    }

    public ArrayList<Banda> obtenerBandas() {
        return registros.obtenerTodasLasrBandas();
    }

    public Banda buscarBandaPorCodigo(String codBand) {
        return registros.buscarBanda(codBand);
    }

    // Metodos para manejo de informacion de integrantes
    public Boolean altaIntegrante(String codBand, String clave, String nomApe) {
        return registros.registrarIntegrante(codBand, codBand + "I" + clave, nomApe);
    }

    public Boolean bajaIntegrante(String codInt) {
        return registros.eliminarIntegrante(codInt);
    }

    public Asaltante buscarIntegrante(String claveIntegrante) {
        return registros.buscarIntegrante(claveIntegrante);
    }

    // Metodos para manejo de informacion de jueces
    public Boolean altaJuez(String tiempoServicio, String numeroJuzgado, String nomApe) {
        return registros.registrarJuez(tiempoServicio, numeroJuzgado, nomApe);
    }

    public Boolean bajaJuez(String nomApe) {
        return registros.eliminarJuez(nomApe);
    }

    public Asaltante buscarJuez(String nomApeJuez) {
        return registros.buscarIntegrante(nomApeJuez);
    }

    public ArrayList<Juez> obtenerJueces() {
        return registros.obtenerJueces();
    }

    // Metodos para manejo de informacion de Delitos
    public Boolean altaDelito(LocalDate fechaDelito, Integer tiempoCondena, Boolean condenado, String codSuc, String nomApejuez, ArrayList<String> actores, String claveCaso) {
        return registros.registrarDelito(fechaDelito, condenado, tiempoCondena, codSuc, nomApejuez, actores, claveCaso);
    }

    public Boolean bajaDelito(String claveCaso) {
        return registros.eliminarDelito(claveCaso);
    }

    public ArrayList<Delito> obtenerDelitos() {
        return registros.obtenerTodosLosDelitos();
    }
    public Boolean comprobarDelitoInvalido(ArrayList<String> actores, LocalDate fechaDelito) {
        for (String actore : actores) {
            for (Delito delito : registros.obtenerTodosLosDelitos()) {
                if(delito.comprobarDelito(actore, fechaDelito)){
                    return true;
                }
            }
        }
        return false;
 
    }

    //Listeners de excepcion
    protected void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }

    public void addExceptionListener(ActionListener listener) {
        this.listener = listener;
    }
}
