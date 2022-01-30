/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Grandalf
 */
public class Banda {
    // Atributos
    private String codigo;
    private ArrayList<Asaltante> integrantes;
    // Constructor

    /**
     * Instancia una nueva banda sin integrantes
     * @param codigo
     */
    public Banda(String codigo) {
        this.codigo = "B" + codigo;
        integrantes = new ArrayList<>();
    }

    // Metodos para Integrantes

    /**
     * agrega un integrante a la Banda
     * @param clave clave del integrante    
     * @param nomApe nombre y apellido del integrante
     */
    public void reclutarIntegrante(String clave, String nomApe) {
        if (buscarIntegrante(clave) == null) {
            integrantes.add(new Asaltante(clave, nomApe));
        }
    }

    /**
     * busca y devuelve un integrante de la banda por su clave
     * @param clave clave del integrante a buscar
     * @return integrante si lo encuentra, sino nulo
     */
    public Asaltante buscarIntegrante(String clave) {
        for (Asaltante integrante : integrantes) {  // Enhanced for
            if (integrante.coincideClave(clave)) {
                return integrante;
            }
        }
        return null;
    }

    /**
     * Elimina un integrante de la banda
     * @param integrante integrante a eliminar
     * @return verdadero o falso si pudo eliminarlo
     */
    public Boolean expulsarIntegrante(Asaltante integrante) {
        if (integrantes.contains(integrante)) {
            integrantes.remove(integrante);
            return true;
        }
        return false;
    }

    //Getters

    /**
     * Compara y devuelve verdadero o falso segun coincidencia
     * del codigo recibido con el copdiogo de banda
     * @param codigo codigo de banda a buscar
     * @return verdadero o falso
     */
    public Boolean coincideCodigoBanda(String codigo) {
        return this.codigo.equals(codigo);
    }

    /**
     * Devuelve el codigo de banda
     * @return codigo de banda
     */
    public String obtenerCodigoBanda() {
        return codigo;
    }

    /**
     * Devuelve la cantidad de integrantes de una banda
     * @return cant. de integrantes
     */
    public Integer obtenerCantidadDeIntegrantes() {
        return integrantes.size();
    }

    /**
     * Devuelve los integrantes de la banda
     * @return integrantes de la banda
     */
    public ArrayList<Asaltante> obtenerIntegrantes() {
        return integrantes;
    }
}
