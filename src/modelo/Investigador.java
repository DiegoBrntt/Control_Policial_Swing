/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.Vista;
import vista.VistaInvestigador;

/**
 *
 * @author Grandalf
 */
public class Investigador extends Usuario{
    
    public Investigador(String codigo, String edad, String pass) {
        super(codigo, edad, pass);
    }

    @Override
    public Vista proceder(Modelo m) {
        return new VistaInvestigador(m, this);
    }
    
}
