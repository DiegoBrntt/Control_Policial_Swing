/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Grandalf
 */
public class RegistrosDeInformacion {

    // Atributos
    private ArrayList<Usuario> usuarios;
    private ArrayList<Entidad> entidades;
    private ArrayList<Banda> bandas;
    private ArrayList<Juez> jueces;

    // Constructor
    public RegistrosDeInformacion() {
        usuarios = new ArrayList<>();
        bandas = new ArrayList<>();
        entidades = new ArrayList<>();
        jueces = new ArrayList<>();
    }

    // Metodos para la informacion de usuarios
    public Boolean registrarUsuario(String tipoUsuario, String codigoUsuario, String edad, String passUsuario) {
        if (buscarUsuario(tipoUsuario.charAt(0) + codigoUsuario) == null) {
            switch(tipoUsuario){
                case "Administrador":
                    usuarios.add(new Administrador(tipoUsuario.charAt(0) + codigoUsuario, edad, passUsuario));
                    break;
                case "Investigador":
                    usuarios.add(new Investigador(tipoUsuario.charAt(0) + codigoUsuario, edad, passUsuario));
                    break;
                case "Vigilante":
                    usuarios.add(new Vigilante(tipoUsuario.charAt(0) + codigoUsuario, edad, passUsuario));
                    break;
            }
            return true;
        } else {
            return false;
        }
    }
    public Usuario validarUsuario(String usr, String pwd) {
        for (Usuario usuario : usuarios) {  // Enhanced for
            if (usuario.coincidenCodigoYPassDeUsuario(usr, pwd)) {
                return usuario;
            }
        }
        return null;
    }
    public Usuario buscarUsuario(String cod) {
        for (Usuario usuario : usuarios) {  // Enhanced for
            if (usuario.coincidenCodigoDeUsuario(cod)) {
                return usuario;
            }
        }
        return null;
    }
    public Vigilante buscarVigilante(String cod) {
        for (Vigilante usuario : obtenerVigilantes()) {  // Enhanced for
            if (usuario.coincidenCodigoDeUsuario(cod)) {
                return usuario;
            }
        }
        return null;
    }
    public ArrayList<Vigilante> obtenerVigilantes() {
        ArrayList<Vigilante> vigilantes = new ArrayList<>();
        for (Usuario vigilante : usuarios) {
            if (vigilante.obtenerTipoUsuarioNoAdministrativo()) {
                vigilantes.add((Vigilante) vigilante);
            }
        }
        return vigilantes;
    }
    public ArrayList<Usuario> obtenerUsuarios() {
        return usuarios;
    }
    public Boolean eliminarRegistroDeUsuario(String codigo) {
        if(buscarUsuario(codigo) != null){
            usuarios.remove(buscarUsuario(codigo));
            return true;
        }
        return false;
    }

    // Metodos para la informacion de entidades
    public Boolean registrarEntidad(String central, String codEnt) {
        if (buscarEntidad("E" + codEnt) == null) {
            entidades.add(new Entidad(central, codEnt));
            return true;
        } else {
            return false;
        }
    }

    public Boolean bajaEnt(String codEnt) {
        for (Entidad entidad : entidades) {
            if (entidad.coincidenCod(codEnt)) {
                entidades.remove(entidad);
                return true;
            }
        }
        return false;
    }

    public Entidad buscarEntidad(String cod) {
        for (Entidad entidad : entidades) {  // Enhanced for
            if (entidad.coincidenCod(cod)) {
                return entidad;
            }
        }
        return null;
    }

    public ArrayList<Entidad> obtenerTodasLasEntidades() {
        return entidades;
    }

    // Metodos para la informacion de sucursales
    public Boolean registrarSucursal(String codEnt, String domicilio, String codSuc, Integer cantEmp, LocalDate fechaDeContratacion, Integer frecuenciaDeContratacion) {
        for (Entidad entidad : entidades) {
            if (entidad.coincidenCod(codEnt)) {
                return entidad.abrirSucursal(domicilio, codSuc, cantEmp, fechaDeContratacion, frecuenciaDeContratacion);
            }
        }
        return false;
    }

    public Boolean bajaSucursal(String codSuc) {
        for (Entidad entidad : entidades) {
            if (entidad.buscarSucursal(codSuc) != null) {
                return entidad.cerrarSucursal(codSuc);
            }
        }
        return false;
    }

    public Sucursal buscarSucursal(String codSuc) {
        for (Entidad entidad : entidades) {
            if (entidad.buscarSucursal(codSuc) != null) {
                return entidad.buscarSucursal(codSuc);
            }
        }
        return null;
    }

    public ArrayList<Sucursal> obtenerTodasLasSucursales() {
        ArrayList<Sucursal> suc = new ArrayList<>();
        for (Entidad entidad : entidades) {  // Enhanced for
            suc.addAll(entidad.obtenerSucursales());
        }
        return suc;
    }

    public ArrayList<String> obtenerSucursalesPorEnt(String codEnt) {
        ArrayList<String> suc = new ArrayList<>();
        for (Entidad entidad : entidades) {  // Enhanced for
            if (entidad.coincidenCod(codEnt)) {
                suc.addAll(entidad.obtenerCodigosSucursales());
            }
        }
        return suc;
    }
    

    // Metodos para la informacion de contratos
    public Boolean registrarContrato(String codSuc, String codigo, String contratado, Boolean armado, LocalDate fecha, Integer diasContratados) {
        for (Sucursal sucursal : obtenerTodasLasSucursales()) {
            if (sucursal.coincideCodigoDeSucursal(codSuc)) {
                return sucursal.agregarContrato(codigo, buscarVigilante(contratado), armado, fecha, diasContratados);
            }
        }
        return false;
    }
    public Boolean eliminarContrato(String codSuc, String codCon) {
        if(buscarSucursal(codSuc).buscarContrato(codCon) != null){
            return buscarSucursal(codSuc).borrarContrato(codCon);
        }
        return false;
    }

    // Metodos para la informacion de bandas
    public Boolean registrarBanda(String codBand) {
        if (buscarBanda("B" + codBand) == null) {
            bandas.add(new Banda(codBand));
            return true;
        }
        
        return false;
    }

    public Banda buscarBanda(String cod) {
        for (Banda banda : bandas) {  // Enhanced for
            if (banda.coincideCodigoBanda(cod)) {
                return banda;
            }
        }
        return null;
    }

    public ArrayList<Banda> obtenerTodasLasrBandas() {
        return bandas;
    }
    public Boolean eliminarBanda(String codBand) {
        if (buscarBanda(codBand) != null) {
            bandas.remove(buscarBanda(codBand));
            return true;
        }
        
        return false;
    }

    // Metodos para la informacion de Integrantes
    public Boolean registrarIntegrante(String codBand, String clave, String nomApe) {
        for (Banda banda : obtenerTodasLasrBandas()) {
            if (banda.coincideCodigoBanda(codBand)) {
                banda.reclutarIntegrante(clave, nomApe);
                return true;
            }
        }
        return false;
    }
    public Boolean eliminarIntegrante(String codInt) {
        for (Banda banda : obtenerTodasLasrBandas()) {
            Asaltante a = banda.buscarIntegrante(codInt);
            if(a != null){
                banda.expulsarIntegrante(a);
                return true;
            }
        }
        return false;
    }
    public Asaltante buscarIntegrante(String claveIntegrante) {
        for (Asaltante asaltante : obtenerAsaltantes()) {
            if(asaltante.coincideClave(claveIntegrante)){
                return asaltante;
            }
        }
        return null;
    }
    public ArrayList<Asaltante> obtenerAsaltantes() {
        ArrayList<Asaltante> asaltantes = new ArrayList<>();
        for (Banda banda : bandas) {
            asaltantes.addAll(banda.obtenerIntegrantes());
        }
        return asaltantes;
    }

    // Metodos para la informacion de Jueces
    public Boolean registrarJuez(String tiempoServicio, String numeroJuzgado, String nomApe) {
        if (buscarJuez(nomApe) == null) {
            jueces.add(new Juez(tiempoServicio, numeroJuzgado, nomApe));
            return true;
        }
        return false; 
    }
    public Boolean eliminarJuez(String nomApe) {
        Juez j = buscarJuez(nomApe);
        if (j != null) {
            jueces.remove(j);
            return true;
        }
        return false;
    }
    public Juez buscarJuez(String nomApe) {
        for (Juez juez : jueces) {  // Enhanced for
            if (juez.coincideNomApeJuez(nomApe)) {
                return juez;
            }
        }
        return null;
    }

    public ArrayList<Juez> obtenerJueces() {
        return jueces;
    }

    //Metodos para la informacion de Delitos
    public Boolean registrarDelito(LocalDate fechaDelito, Boolean condenado, Integer tiempoCondena, String codSuc, String nomApejuez, ArrayList<String> actores, String claveCaso) {
        ArrayList<Asaltante> actoresA = new ArrayList<>();
        for (String asaltante : actores) {
            actoresA.add(buscarIntegrante(asaltante));
        }
        return buscarJuez(nomApejuez).asignarCaso(fechaDelito, tiempoCondena, condenado, buscarSucursal(codSuc), actoresA, claveCaso);
    }
    public Boolean eliminarDelito(String claveCaso) {
        for (Delito delito : obtenerTodosLosDelitos()) {
            if(delito.coincideClaveCaso(claveCaso)){
                buscarJuez(delito.obtenerJuezEncargado()).desecharCaso(delito);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Delito> obtenerTodosLosDelitos() {
        ArrayList<Delito> delitos = new ArrayList<>();
        for (Juez juez : jueces) {
            delitos.addAll(juez.obtenerCasos());
        }
        return delitos;
    }

    

    

    

    
}
