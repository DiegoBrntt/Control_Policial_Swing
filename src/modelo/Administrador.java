/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.Vista;
import vista.VistaAdministrador;

/**
 *
 * @author Grandalf
 */
public class Administrador extends Usuario{
    
    /**
     * Instancia un usuario de tipo Administrador
     * @param codigo codigo del nuevo administrador
     * @param edad edad del nuevo administrador
     * @param pass contraseña del nuevo administrador
     */
    public Administrador(String codigo, String edad, String pass) {
        super(codigo, edad, pass);
    }

    /**
     * Instancia la vista del administrador con permisos administrativos
     * pasandole un modelo y el usuario validado
     * @param m Modelo ya instanciado y pasado por el controlador
     * @return Vista De Administrador
     */
    @Override
    public Vista proceder(Modelo m) {
        return new VistaAdministrador(m, this);
    } 
}
