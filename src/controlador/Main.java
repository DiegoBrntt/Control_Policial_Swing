/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.*;
import vista.*;

/**
 *
 * @author Grandalf
 */
public class Main {

    public static void main(String args[]) throws Exception {  
        Modelo m = new Modelo();
        Vista v = new VistaLogin(m);
        Controlador c = new Controlador(m, v);
        
        c.arrancar();
    }
}