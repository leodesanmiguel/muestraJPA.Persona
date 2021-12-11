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

import javax.persistence.OneToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leo Martinez
 */
@Entity
public class Cliente extends Persona implements Serializable {

    private String tipoCliente;
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    //private String forma1Pago;
    //@OneToMany(mappedBy = "cliente_forma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    private FormaD1Pago formaD1Pago;
    public Cliente() {

    }

    //SIN PAGO  o solo puede en efectivo
    public Cliente(String tipoCliente, Date fechaAlta,
            String nombre, String apellido, int dni, Date fechaNacio,
            String paisOrigen, String celular, String email) {
        super(nombre, apellido, dni, fechaNacio, paisOrigen,
                celular, email);
        this.tipoCliente = tipoCliente;
        this.fechaAlta = fechaAlta;
        //this.formasDPago = (List<FormaDPago>) new FormaDPago(1, "EFECtivo");
        
    }

    public Cliente(String tipoCliente, Date fechaAlta,
            List<FormaDPago> formasDPago, String forma1pago, FormaD1Pago formaD1Pago,
            String nombre, String apellido, int dni,
            Date fechaNacio, String paisOrigen, String celular, String email) {
        super(nombre, apellido, dni, fechaNacio, paisOrigen, celular, email);
        this.tipoCliente = tipoCliente;
        this.fechaAlta = fechaAlta;
        //this.formasDPago = formasDPago;
        //this.forma1Pago = forma1pago;
        this.formaD1Pago = formaD1Pago;
    }

    
    
    public FormaD1Pago getFormaD1Pago() {
        return formaD1Pago;
    }

    public void setFormaD1Pago(FormaD1Pago formaD1Pago) {
        this.formaD1Pago = formaD1Pago;
    }

    
    
    
    /*  ESTO ES PARA UNA LISTA DE PAGOS
    public List<FormaDPago> getFormasDPago() {
        return formasDPago;
    }

    public void setFormasDPago(List<FormaDPago> formasDPago) {
        this.formasDPago = formasDPago;
    }
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "tipoCliente=" + tipoCliente
                + ", fechaAlta=" + fechaAlta + '}';
    }

}
