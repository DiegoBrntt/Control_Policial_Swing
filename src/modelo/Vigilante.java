/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.Vista;
import vista.VistaVigilante;

/**
 *
 * @author Grandalf
 */
public class Vigilante extends Usuario {

    public Vigilante(String codigo, String edad, String pass) {
        super(codigo, edad, pass);
    }

    @Override
    public Vista proceder(Modelo m) {
        return new VistaVigilante(m, this);
    }
}
