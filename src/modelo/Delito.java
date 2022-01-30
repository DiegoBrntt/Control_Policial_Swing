/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Grandalf
 */
public class Delito {
    // Atributos
    private LocalDate fechaDelito;
    private Integer tiempoCondena;
    private String claveCaso;
    public Boolean condena;
    private Sucursal lugar;
    private Juez juez;
    private ArrayList<Asaltante> actores;
    // Constructor

    /**
     * Genera un nuevo caso/delito
     * @param fechaDelito
     * @param tiempoCondena
     * @param condena
     * @param lugar
     * @param juez
     * @param actores
     * @param claveCaso
     */
    public Delito(LocalDate fechaDelito, Integer tiempoCondena, Boolean condena, Sucursal lugar, Juez juez, ArrayList<Asaltante> actores, String claveCaso) {
        this.fechaDelito = fechaDelito;
        this.tiempoCondena = tiempoCondena;
        this.condena = condena;
        this.lugar = lugar;
        this.juez = juez;
        this.actores = actores;
        this.claveCaso = "J" + juez.consultarNumeroJuzgado() + "D" + claveCaso;
    }
    
    /**
     * devuelve verdadero o false segun coincidencia de laclave del caso
     * @param claveCaso Clave del caso
     * @return
     */
    public Boolean coincideClaveCaso(String claveCaso) {
        return this.claveCaso.equals(claveCaso);
    }
    // Getters
    public String obtenerJuezEncargado() {
        return juez.consultarNomApe();
    }
    public String obtenerClaveDelCaso() {
        return claveCaso;
    }
    public ArrayList<String> obteneActores() {
        ArrayList<String> actors = new ArrayList<>();
        for (Asaltante actor : actores) {
            actors.add(actor.obtenerNomApeDeIntegrante());
        }
        return actors;
    }
    public String obtenerLugarDelHecho() {
        return lugar.obtenerDireccionSucursal();
    }
    public String obtenerFechaDelActo() {
        return fechaDelito.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public Boolean obtenerEstadoDelCaso() {
        return condena;
    }
    public Boolean obtenerCondenaCumplida() {
        return fechaDelito.plusMonths(tiempoCondena).isBefore(LocalDate.now());
    }  
    public String obtenerTiempoCondena() {
        return String.valueOf(tiempoCondena);
    }  

    String comprobarFecha(LocalDate fechaDelito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean comprobarDelito(String actore, LocalDate fechaNuevoDelito) {
        for(Asaltante actor : actores){
            if(actor.coincideClave(actore) && fechaDelito.isEqual(fechaNuevoDelito)){
                return true;
            }
        }
        return false;
    }
}
