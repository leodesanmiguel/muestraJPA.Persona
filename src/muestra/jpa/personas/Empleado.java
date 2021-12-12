/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra.jpa.personas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "empleado")
public class Empleado extends Persona implements Serializable {

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEmpleado;
     */
    
    private double sueldo;
    private String cargo;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    private List<Venta> ventas;

    public Empleado() {
        super();
    }

    public Empleado( double sueldo, String cargo,
            String nombre, String apellido,
            int dni, Date fechaNacio, String paisOrigen,
            String celular, String email) {
        super(nombre, apellido, dni, fechaNacio, paisOrigen,
                celular, email);
        
        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    public Empleado( double sueldo, String cargo,
            int idPersona, String nombre, String apellido,
            int dni, Date fechaNacio, String paisOrigen,
            String celular, String email) {
        super(idPersona, nombre, apellido, dni, fechaNacio, paisOrigen,
                celular, email);
        
        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
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

   

}
