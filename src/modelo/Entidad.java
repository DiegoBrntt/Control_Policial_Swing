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
public class Entidad {
    // Atributos
    private String domicilioCentral;
    private String codigo;
    private ArrayList<Sucursal> sucursales;
    // Contructor
    public Entidad(String domicilioCentral, String codigo) {
        this.domicilioCentral = domicilioCentral;
        this.codigo = "E" + codigo;
        sucursales = new ArrayList<>();
    }

    // Metodos para sucursales
    public Boolean abrirSucursal(String domicilio, String codSuc, Integer cantEmp, LocalDate fechaDeContratacion, Integer frecuenciaDeContratacion) {
        if (buscarSucursal(codSuc) == null) {
            sucursales.add(new Sucursal(domicilio,codSuc, cantEmp, fechaDeContratacion, frecuenciaDeContratacion));
            return true;
        } else {
            return false;
        }
    }
    public Sucursal buscarSucursal(String cod) {
        for (Sucursal sucursal : sucursales) {  // Enhanced for
            if (sucursal.coincideCodigoDeSucursal(cod)) {
                return sucursal;
            }
        }
        return null;
    }
    public Boolean cerrarSucursal(String codSuc) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.coincideCodigoDeSucursal(codSuc)) {
                sucursales.remove(sucursal);
                return true;
            }
        }
        return false;
    }

    // Metodos para contratos
    public ArrayList<Contrato> buscarContratosPorVigilante(String cod) {
        ArrayList<Contrato> con = new ArrayList<>();
        for (Sucursal sucursal : sucursales) {  // Enhanced for

            con.addAll(sucursal.obtenerContratosPorVigilante(cod));

        }
        return con;
    }
    public ArrayList<Contrato> obtenerTodosLosContratos() {
        ArrayList<Contrato> con = new ArrayList<>();
        for (Sucursal sucursal : sucursales) {  // Enhanced for

            con.addAll(sucursal.obtenerContratosDeSucursal());

        }
        return con;
    }

    //Getters
    public Boolean coincidenCod(String cod) {
        return this.codigo.equals(cod);
    }
    public String obtenerCodEnt() {
        return codigo;
    }
    public String obtenerDomicilio() {
        return domicilioCentral;
    }
    public String obtenerCantSuc() {
        return String.valueOf(sucursales.size());
    }
    public ArrayList<Sucursal> obtenerSucursales() {
        return sucursales;
    }
    public ArrayList<String> obtenerCodigosSucursales() {
        ArrayList<String> codsSucs = new ArrayList<>();
        for (Sucursal suc : sucursales) {
            codsSucs.add(suc.obtenerCodSuc());
        }
        return codsSucs;
    }
}
