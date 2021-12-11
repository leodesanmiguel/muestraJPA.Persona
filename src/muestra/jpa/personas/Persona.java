/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra.jpa.personas;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;

    private String nombre;
    private String apellido;
    private int dni;
    private String paisOrigen;
    private String celular;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date fechaNacio;

    public Persona() {

    }

    public Persona(String nombre, String apellido, int dni,
            Date fechaNacio, String paisOrigen, String celular,
            String email) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacio = fechaNacio;
        this.paisOrigen = paisOrigen;
        this.celular = celular;
        this.email = email;
    }

    public Persona(int idPersona, String nombre, String apellido, int dni,
            Date fechaNacio, String paisOrigen, String celular,
            String email) {

        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacio = fechaNacio;
        this.paisOrigen = paisOrigen;
        this.celular = celular;
        this.email = email;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaNacio() {
        return fechaNacio;
    }

    public void setFechaNacio(Date fechaNacio) {
        this.fechaNacio = fechaNacio;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona " + "ID: " + idPersona
                + "\n nombre: " + nombre + " " + apellido + " (" + dni + ")"
                + "\n Nacimiento: " + fechaNacio + " pais: " + paisOrigen
                + "\n TEL: " + celular + ", email: " + email;
    }

}
