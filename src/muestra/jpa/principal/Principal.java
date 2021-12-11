package muestra.jpa.principal;

import muestra.jpa.personas.Control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leo Martinez
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Control ctrlN = new Control();
        
        ctrlN.crearClienteCONPago();
        ctrlN.crearCliente();
        ctrlN.crearEmpleado();
        ctrlN.crearPersona();
        
        
        
    }
    
}
