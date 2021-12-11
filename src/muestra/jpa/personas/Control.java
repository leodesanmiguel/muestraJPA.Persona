/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra.jpa.personas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import muestra.jpa.persistencia.ControlaPersistencia;

/**
 *
 * @author Leo Martinez
 */
public class Control {

    ControlaPersistencia ctrl = new ControlaPersistencia();

    public void crearClienteCONPago() {
        Date nacio = new Date(1995, 11, 11);
        Date alta = new Date(2019, 5, 10);

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
        FormaDPago f1 = new FormaDPago(100, "EFECTIVO");
        FormaDPago f2 = new FormaDPago(200, "OTRA COSA");
        FormaDPago f3 = new FormaDPago(300, "CANJE");
        formasP.add(f1);
        formasP.add(f2);
        formasP.add(f3);

        Cliente c1 = new Cliente("PAGADOR", alta, formasP, "CASI EFECTIVO",
                "José", "Pagador", 4565785, nacio, "argentino", "1165325421", "paga.primero@gmail.com");
        //Cliente c1 = new Cliente("PAGADOR", alta, formasP,
        //        "José", "Pagador", 4565785, nacio, "argentino", "1165325421", "paga.primero@gmail.com");

        if (!ctrl.crearClienteJPA(c1)) {
            System.out.println(">>> AH PAPAª!! CON EL CLIENTE PAGADOR");
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

        Empleado e1 = new Empleado(123, 65468.23, "jobato",
                "Esteban", "Quito", 16456789,
                nacio, "argentino", "11988798", "Esteban.Quito123@gmail.com");

        if (!ctrl.crearEmpleadoJPA(e1)) {
            System.out.println(">>> U.U.U TODO MAL CON EL EMPLEADO");
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
}
