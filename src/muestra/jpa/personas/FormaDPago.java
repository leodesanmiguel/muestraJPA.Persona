/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra.jpa.personas;

import java.io.Serializable;
import javax.persistence.Entity;
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
    
    //@Enumerated(EnumType.ORDINAL)
    //private MetodoDPago medioDPago;

    public FormaDPago() {
    }

    public FormaDPago(int idFormaDPago, String medioDPago) {
        this.idFormaDPago = idFormaDPago;
        this.medioDPago = medioDPago;
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
