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
public class Juez {
    // Atributos
    private String tiempoDeServicio;
    private String numeroJuzgado;
    private String nomApe;
    private ArrayList<Delito> casos;
    // Constructor
    public Juez(String tiempoServicio, String numeroJuzgado, String nomApe) {
        this.tiempoDeServicio = tiempoServicio;
        this.numeroJuzgado = numeroJuzgado;
        this.nomApe = nomApe;
        casos = new ArrayList<>();
    }
    
    public Boolean asignarCaso(LocalDate fechaDelito, Integer tiempoCondena, Boolean condenado, Sucursal lugar, ArrayList<Asaltante> actores, String claveCaso) {
        if(buscarCaso(claveCaso) == null){
            casos.add(new Delito(fechaDelito, tiempoCondena, condenado, lugar, this, actores, claveCaso));
            return true;
        }
        return false;
    }
    public Delito buscarCaso(String claveCaso) {
        for (Delito caso : casos) {
            if(caso.coincideClaveCaso(claveCaso)){
                return caso;
            }
        }
        return null;
    }
    public Boolean desecharCaso(Delito caso) {
            if(casos.contains(caso)){
                casos.remove(caso);
                return true;
            }
        return false;
    }
    // Getters
    public boolean coincideNomApeJuez(String nomApe) {
        return this.nomApe.equals(nomApe);
    }
    public String consultarNomApe() {
        return nomApe;
    }public String consultarNumeroJuzgado() {
        return numeroJuzgado;
    }
    public String consultarTiempoServicio() {
        return tiempoDeServicio;
    }

    public ArrayList<Delito> obtenerCasos() {
        return casos;
    }
}
