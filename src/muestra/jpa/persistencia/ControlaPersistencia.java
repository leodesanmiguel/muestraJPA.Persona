/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra.jpa.persistencia;

import muestra.jpa.personas.Cliente;
import muestra.jpa.personas.Empleado;
import muestra.jpa.personas.Persona;

/**
 *
 * @author Leo Martinez
 */
public class ControlaPersistencia {

    PersonaJpaController persJPA = new PersonaJpaController();
    ClienteJpaController cliJPA = new ClienteJpaController();
    EmpleadoJpaController empJPA = new EmpleadoJpaController();
    FormaD1PagoJpaController fd1JPA = new FormaD1PagoJpaController();
    FormaDPagoJpaController fdpJPA= new FormaDPagoJpaController();
    

    public boolean crearClienteJPA(Cliente pp) {

        try {
            cliJPA.create(pp);
            return true;
        } catch (Exception e) {
            System.out.println("\n\n *** FALLO EN LA CARGA DE CLIENTE\n\n" + e);
        }

        return false;
    }
    
        public boolean crearEmpleadoJPA(Empleado pp) {

        try {
            empJPA.create(pp);
            return true;
        } catch (Exception e) {
            System.out.println("\n\n *** FALLO EN LA CARGA DE EMPLEADO\n\n" + e);
        }

        return false;
    }
        
    public boolean crearPersonaJPA(Persona pp) {

        try {
            persJPA.create(pp);
            return true;
        } catch (Exception e) {
            System.out.println("\n\n *** FALLO EN LA CARGA DE PERSONA\n\n" + e);
        }

        return false;
    }        
    
}
