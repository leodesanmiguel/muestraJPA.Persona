/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra.jpa.personas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVenta;

    private double importeTotal;

    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    @Temporal(TemporalType.TIME)
    private Date horaVenta;

    @ManyToOne
    private Empleado vendedor;

    @ManyToOne
    private Cliente comprador;

    private String contratacion;

    private boolean estaPago;

    public Venta() {

    }

    public Venta(double importeTotal, Date fechaVenta, Date horaVenta,
            Empleado vendedor, Cliente comprador,
            String contratacion, boolean estaPago) {
        this.importeTotal = importeTotal;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.contratacion = contratacion;
        this.estaPago = estaPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public Date getHoraVenta() {
        return horaVenta;
    }

    public Empleado getVendedor() {
        return vendedor;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public String getContratacion() {
        return contratacion;
    }

    public boolean isEstaPago() {
        return estaPago;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setHoraVenta(Date horaVenta) {
        this.horaVenta = horaVenta;
    }

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public void setContratacion(String contratacion) {
        this.contratacion = contratacion;
    }

    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }

}
