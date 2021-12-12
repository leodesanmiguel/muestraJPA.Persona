/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra.jpa.personas;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Leo Martinez
 */
@Entity
//@PrimaryKeyJpoinColumn(name="idPersona")
public class Empleado extends Persona implements Serializable {

    @Id
    private int idEmpleado;

    private double sueldo;
    private String cargo;

    public Empleado() {
        super();
    }

    public Empleado(int idEmpleado, double sueldo, String cargo,
            String nombre, String apellido,
            int dni, Date fechaNacio, String paisOrigen,
            String celular, String email) {
        super(nombre, apellido, dni, fechaNacio, paisOrigen,
                celular, email);
        this.idEmpleado = idEmpleado;
        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    public Empleado(int idEmpleado, double sueldo, String cargo,
            int idPersona, String nombre, String apellido,
            int dni, Date fechaNacio, String paisOrigen,
            String celular, String email) {
        super(idPersona, nombre, apellido, dni, fechaNacio, paisOrigen,
                celular, email);
        this.idEmpleado = idEmpleado;
        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado: " + "idEmpleado=" + idEmpleado
                + "\n cargo: " + cargo + " ($" + sueldo + ")";
    }

}
