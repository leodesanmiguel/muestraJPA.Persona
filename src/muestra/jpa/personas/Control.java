/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra.jpa.personas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import muestra.jpa.persistencia.ControlaPersistencia;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Leo Martinez
 */
public class Control {

    ControlaPersistencia ctrl = new ControlaPersistencia();

    Empleado vende1, vende2;
    Cliente compra1, compra2;

    public void crearClienteCONPago() {
        Date nacio = new Date(1995, 11, 11);
        Date alta = new Date(2019, 5, 10);

        Date nacio2 = new Date(1600, 1, 1);
        Date alta2 = new Date(1719, 8, 21);

        List<FormaDPago> formasP = new ArrayList<>();

        /*
        FormaDPago pagoEfectivo = new FormaDPago(1, MetodoDPago.EFECTIVO);
        FormaDPago pagoDebito = new FormaDPago(2, MetodoDPago.DEBITO);
        FormaDPago pagoCredito = new FormaDPago(3, MetodoDPago.CREDITO);
        FormaDPago pagoMonedero = new FormaDPago(4, MetodoDPago.MONEDERO);
        FormaDPago pagoTransferencia = new FormaDPago(5, MetodoDPago.TRANSFERENCIA);
        
        formasP.add(pagoEfectivo);
        formasP.add(pagoDebito);
        formasP.add(pagoCredito);
        formasP.add(pagoMonedero);
        formasP.add(pagoTransferencia);
         */
        FormaDPago f1 = new FormaDPago("EFECTIVO", MetodoDPago.EFECTIVO);
        FormaDPago f2 = new FormaDPago("OTRA COSA", MetodoDPago.MONEDERO);
        FormaDPago f3 = new FormaDPago("CANJE", MetodoDPago.TRANSFERENCIA);
        formasP.add(f1);
        formasP.add(f2);
        formasP.add(f3);

        FormaD1Pago f4 = new FormaD1Pago("Para pagar con las monedas");
        FormaD1Pago f5 = new FormaD1Pago("Que dios te lo pague");

        Cliente c1 = new Cliente("PAGADOR", alta, formasP, "CASI EFECTIVO", f4,
                "José", "Pagador", 4565785, nacio, "argentino", "1165325421", "paga.primero@gmail.com");
        if (!ctrl.crearClienteJPA(c1)) {
            System.out.println(">>> UPA!! NO PASO EL CLIENTE 1");
            compra1 = c1;
        }

        Cliente c2 = new Cliente("PAGADOR COMPULSIVO", alta2, formasP, "CASI EFECTIVO", f5,
                "CACHO", "CASTAÑA", 123456, nacio2, "ENAMORADO", "02320", "ELCACHO@gmail.com");

        if (!ctrl.crearClienteJPA(c2)) {
            System.out.println(">>> AH PAPAª!! CON EL CLIENTE << DOS >> ");
            compra2 = c2;
        }

    }

    public void crearCliente() {
        Date nacio = new Date(1987, 10, 12);
        Date alta = new Date(2000, 2, 15);

        Cliente c1 = new Cliente("Nuevo", alta,
                "Juan", "Perez", 20123456,
                nacio, "argentino", "11455678", "juanperez123@gmail.com");

        if (!ctrl.crearClienteJPA(c1)) {
            System.out.println(">>> TODO MAL CON EL CLIENTE");
        }

    }

    public void crearEmpleado() {
        Date nacio = new Date(1969, 5, 14);
        Date alta = new Date(2010, 12, 25);

        Empleado e1 = new Empleado( 65468.23, "jobato",
                "Esteban", "Quito", 16456789,
                nacio, "argentino", "11988798", "Esteban.Quito123@gmail.com");

        if (!ctrl.crearEmpleadoJPA(e1)) {
            System.out.println(">>> U.U.U TODO MAL CON EL jobato");
            vende1 = e1;
        }

        Date nacio2 = new Date(1800, 1, 14);
        Date alta2 = new Date(1910, 12, 25);

        Empleado e2 = new Empleado( 150120.23, "LIBERTADOR",
                "josejo", "SAN MARTIN", 1021225,
                nacio, "argentino o español", "+1 2544 365", "libertador.de.america@gmail.com");

        if (!ctrl.crearEmpleadoJPA(e2)) {
            System.out.println(">>> TODO MAL CON EL libertador ****");
            vende2 = e2;
        }

    }

    public void crearPersona() {
        Date nacio = new Date(2000, 6, 30);
        Date alta = new Date(2015, 8, 18);

        Persona p1 = new Persona(
                "Elsa", "Pato", 30852741,
                nacio, "argentino", "02320-6665588", "pato.al.agua@gmail.com");

        if (!ctrl.crearPersonaJPA(p1)) {
            System.out.println(">>> U.U.U TODO MAL CON EL EMPLEADO");
        }

    }

    public void crearVentas() {

        //var ahoraVta =  LocalDateTime.now();
        //Date fecVta = new Date(ahoraVta.getYear(), ahoraVta.getMonthValue(), ahoraVta.getDayOfMonth());
        Date ahoraVta = new Date(System.currentTimeMillis());

        double importeTotal = 123654.23;
        Date fechaVenta = ahoraVta;
        //long horaVenta = ahoraVta.getTime();

        Empleado vendedor = vende1;
        Cliente comprador = compra1;

        String contratacion= "PaqueteDigo";
        boolean estaPago= true;

        Venta vta= new Venta(importeTotal, fechaVenta, ahoraVta
                , vendedor, comprador, contratacion, estaPago);
        
        if (!ctrl.crearVentaJPA(vta)) {
            System.out.println("*** CONTROL ---> NO SE GUARDÓ LA VENTA *****");
        }
    }

}
