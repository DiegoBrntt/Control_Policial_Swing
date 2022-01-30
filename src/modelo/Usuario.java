/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.Vista;

/**
 *
 * @author Grandalf
 */
public abstract class Usuario {

    // Atributos
    private String codigo;
    private String pass;
    private String edad;

    // Getters
    public Usuario(String codigo, String edad, String pass) {
        this.codigo = codigo;
        this.edad = edad;
        this.pass = pass;
    }

    // metodos abstractos
    public abstract Vista proceder(Modelo m);

    // Getters
    public Boolean coincidenCodigoYPassDeUsuario(String codigo, String pass) {
        return this.codigo.equals(codigo) && this.pass.equals(pass);
    }

    public Boolean coincidenCodigoDeUsuario(String codigo) {
        return this.codigo.equals(codigo);
    }

    public String obtenerCodigoDeUsuario() {
        return this.codigo;
    }

    public Boolean permisosAdministrativos() {
        return this.getClass().getSimpleName().equals("Administrador");
    }

    public boolean obtenerTipoUsuarioNoAdministrativo() {
        return this.getClass().getSimpleName().equals("Vigilante");
    }
}
