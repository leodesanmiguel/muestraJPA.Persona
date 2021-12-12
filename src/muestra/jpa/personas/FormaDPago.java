/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra.jpa.personas;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import javax.persistence.Table;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name="formas_dePago")
public class FormaDPago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormaDPago;
    private String medioDPago;
    
    
    @Enumerated(EnumType.ORDINAL)
    private MetodoDPago medioDEPago;

    public FormaDPago() {
    }

    public FormaDPago( String medioDPago, MetodoDPago medioDEPago) {
        //this.idFormaDPago = idFormaDPago;
        this.medioDPago = medioDPago;
        this.medioDEPago = medioDEPago;
    }

    public MetodoDPago getMedioDEPago() {
        return medioDEPago;
    }

    public void setMedioDEPago(MetodoDPago medioDEPago) {
        this.medioDEPago = medioDEPago;
    }

    
    
    public int getIdFormaDPago() {
        return idFormaDPago;
    }

    public void setIdFormaDPago(int idFormaDPago) {
        this.idFormaDPago = idFormaDPago;
    }

    public String getMedioDPago() {
        return medioDPago;
    }

    public void setMedioDPago(String medioDPago) {
        this.medioDPago = medioDPago;
    }

    @Override
    public String toString() {
        return "FormaDPago{" + "idFormaDPago=" + idFormaDPago + ", medioDPago=" + medioDPago + '}';
    }

}
