/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.*;
import java.time.format.*;

/**
 *
 * @author Grandalf
 */
public class Contrato {
    // Atributos
    private String codigo;
    private Usuario contratado;
    private Sucursal contratador;
    private LocalDate fecha;
    private Boolean armado;
    private Integer diasContratados;
    // Constructor

    /**
     * Genera un nuevo contrato
     * @param codigo
     * @param contratado
     * @param contratador
     * @param armado
     * @param fecha
     * @param diasContratados
     */
    public Contrato(String codigo, Usuario contratado, Sucursal contratador, Boolean armado, LocalDate fecha, Integer diasContratados) {
        this.codigo = "C" + codigo;
        this.contratado = contratado;
        this.contratador = contratador;
        this.armado = armado;
        this.fecha = fecha;
        this.diasContratados = diasContratados;
    }
    // Getters

    /**
     * Indica si el codigo recibido coincide con el del vigilante contratado
     * @param codigo
     * @return
     */
    public Boolean coincideeContratado(String codigo) {
        return contratado.obtenerCodigoDeUsuario().equals(codigo);
    }

    /**
     * Indica si el codigo recibido coincide con el del contrato
     * @param codigo
     * @return
     */
    public Boolean coincideCodigoContrato(String codigo) {
        return this.codigo.equals(codigo);
    }

    /**
     * Devuelve la fecha de contratacion
     * @return fecha de contratacion
     */
    public String obtenerFechaDeContrato() {
        return fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * Devuelve el codigo de contrato
     * @return codigo
     */
    public String obtenerCodigoDeContrato() {
        return codigo;
    }

    /**
     * Devuelve el vigilante contratado
     * @return vigilante contratado
     */
    public String obtenerContratado() {
        return contratado.obtenerCodigoDeUsuario();
    }

    /**
     * Devuelve la direccion de la sucursal del contrato
     * @return direccion de sucursal
     */
    public String obtenerContratador() {
        return contratador.obtenerDireccionSucursal();
    }

    /**
     * devuelve verdadero o false si es que porta un arma el vigilante contratado
     * @return verificacion de portacion
     */
    public Boolean obtenerPortacionDeArma() {
        return armado;
    }

    /**
     * devuelve verdadero o false si es que el contrato esta en vigencia
     * @return verificacion de portacion
     */
    public Boolean obtenerVigencia() {
        return fecha.plusDays(diasContratados).isBefore(LocalDate.now());
    }

    /**
     * Devuelve la cantidad de dias que fue contratado el vigilante
     * @return
     */
    public Integer obtenerDiasContratados() {
        return diasContratados;
    }
}
