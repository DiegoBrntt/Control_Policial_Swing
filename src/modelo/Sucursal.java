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
public class Sucursal {

    // Atributos
    private String domicilio;
    private String codigoSuc;
    private Integer cantEmpleados;
    private Integer frecuenciaContratacion;
    private LocalDate fechaDeContratacion;
    private ArrayList<Contrato> contratos;

    // Constructor
    public Sucursal(String domicilio, String codigoSuc, Integer cantEmpleados, LocalDate fechaDeContratacion, Integer frecuenciaDeContratacion) {
        this.domicilio = domicilio;
        this.codigoSuc = codigoSuc;
        this.cantEmpleados = cantEmpleados;
        this.fechaDeContratacion = fechaDeContratacion;
        this.frecuenciaContratacion = frecuenciaDeContratacion;
        contratos = new ArrayList<>();
    }

    // Metodos para contratos
    public Boolean agregarContrato(String codigo, Usuario contratado, Boolean armado, LocalDate fecha, Integer diasContratados) {
        Integer i = 1;
        if (fechaDeContratacion.plusDays(frecuenciaContratacion * i).isAfter(fecha)) {
            while (fechaDeContratacion.minusDays(frecuenciaContratacion * i).isAfter(fecha)) {
                i++;
            }
            if (buscarContrato("C" + codigo) == null) {
                if (fechaDeContratacion.minusDays(frecuenciaContratacion * i).isEqual(fecha)) {
                    contratos.add(new Contrato(codigo, contratado, this, armado, fecha, diasContratados));
                    return true;
                }
            }
        }
        if (fechaDeContratacion.plusDays(frecuenciaContratacion * i).isBefore(fecha)) {
            while (fechaDeContratacion.plusDays(frecuenciaContratacion * i).isBefore(fecha)) {
                i++;
            }
            if (buscarContrato("C" + codigo) == null) {
                if (fechaDeContratacion.plusDays(frecuenciaContratacion * i).isEqual(fecha)) {
                    contratos.add(new Contrato(codigo, contratado, this, armado, fecha, diasContratados));
                    return true;
                }
            }
        }
        return false;
    }
    public Boolean validarFechaContrato(LocalDate fecha) {
        Integer i = 1;
        if (fechaDeContratacion.plusDays(frecuenciaContratacion * i).isAfter(fecha)) {
            while (fechaDeContratacion.minusDays(frecuenciaContratacion * i).isAfter(fecha)) {
                i++;
            }
                if (fechaDeContratacion.minusDays(frecuenciaContratacion * i).isEqual(fecha)) {
                    return true;
                }
        }
        
        if (fechaDeContratacion.plusDays(frecuenciaContratacion * i).isBefore(fecha)) {
            while (fechaDeContratacion.plusDays(frecuenciaContratacion * i).isBefore(fecha)) {
                i++;
            }
                if (fechaDeContratacion.plusDays(frecuenciaContratacion * i).isEqual(fecha)) {
                    return true;
                }
        }
        return false;
    }

    public Contrato buscarContrato(String cod) {
        for (Contrato contrato : contratos) {
            if (contrato.coincideCodigoContrato(cod)) {
                return contrato;
            }
        }
        return null;
    }

    public ArrayList<Contrato> obtenerContratosPorVigilante(String cod) {
        ArrayList<Contrato> con = new ArrayList<>();
        for (Contrato contrato : contratos) {
            if (contrato.coincideeContratado(cod)) {
                con.add(contrato);
            }
        }
        return con;
    }

    public ArrayList<Contrato> obtenerContratosDeSucursal() {
        return contratos;
    }

    public Boolean borrarContrato(String codCon) {
        Contrato c = buscarContrato("C" + codCon);
        if (c != null) {
            contratos.remove(c);
            return true;
        }
        return false;
    }

    // Getters
    public boolean coincideCodigoDeSucursal(String cod) {
        return this.codigoSuc.equals(cod);
    }

    public String obtenerDireccionSucursal() {
        return domicilio;
    }

    public String obtenerCodSuc() {
        return codigoSuc;
    }

    public Integer obtenerCantEmpleados() {
        return cantEmpleados;
    }

}
