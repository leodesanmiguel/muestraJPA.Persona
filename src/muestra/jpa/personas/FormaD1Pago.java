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
@Table(name = "formapago")
public class FormaD1Pago implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idForma;
    
    private String formade1Pago;

    public FormaD1Pago() {

    }

    public FormaD1Pago(int idForma, String formade1Pago) {
        this.formade1Pago = formade1Pago;
        this.idForma = idForma;
    }

    public int getIdForma() {
        return idForma;
    }

    public void setIdForma(int idForma) {
        this.idForma = idForma;
    }

    
    
    public String getFormade1Pago() {
        return formade1Pago;
    }

    public void setFormade1Pago(String formade1Pago) {
        this.formade1Pago = formade1Pago;
    }

}
