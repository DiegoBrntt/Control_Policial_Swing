/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Grandalf
 */
public class Asaltante {
    // atributos
    private String clave;
    private String nomApe;
    // Constructor

    /**
     * Instancia un asaltante con su clave y nomebre-apellido
     * @param clave clave del asaltante
     * @param nomApe nombre y apellido del asaltante
     */
    public Asaltante(String clave, String nomApe) {
        this.clave = clave;
        this.nomApe = nomApe;
    }

    // Getters

    /**
     * Devuelve verdadero o falso si el codigo que llega coincide con el del asaltante
     * @param clave clave asaltante a consultar
     * @return
     */
    public boolean coincideClave(String clave) {
        return this.clave.equals(clave);
    }

    /**
     * Devuelve la clave del asaltante
     * @return clave de integrante
     */
    public String obtenerClaveDeIntegrante() {
        return clave;
    }
    /**
     * Devuelve el nombre y apellido del asaltante
     * @return nombre-apellido
     */
    public String obtenerNomApeDeIntegrante() {
        return nomApe;
    }
}
