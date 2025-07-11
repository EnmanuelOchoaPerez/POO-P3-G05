/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

/**
 *
 * @author Rafael Cosmo
 */

import poop3g05.poo.p3.g05.Modelo.*;
import poop3g05.poo.p3.g05.Vista.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorOrden {
    private final List<Orden> ordenes;

    public GestorOrden() {
        this.ordenes = new ArrayList<>();
    }

    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
    }
    
   

//    public Orden buscarOrden(String id) {
//        for (Orden orden : ordenes) {
//            if (orden.getId() == id) {
//                return orden;
//            }
//        }
//        return null;
//    }

//        private static void generarFactura(
//            GestorFactura gestorFacturas,
//            GestorCliente gestorClientes,
//            GestorOrden gestorOrdenes) {
//
//        System.out.println("\n--- GENERAR FACTURA ---");
//
//        // Seleccionar cliente
//        System.out.println("Clientes disponibles:");
//        AdministrarCliente.listarClientes(gestorClientes);
//        System.out.print("Seleccione ID cliente: ");
//        String idCliente = scanner.nextLine();
//        Cliente cliente = (Cliente) gestorClientes.buscarUsuario(idCliente);
//
//        if (cliente == null) {
//            System.out.println("Cliente no encontrado!");
//            return;
//        }
//
//        // Buscar órdenes del cliente
//        ArrayList<Orden> ordenesCliente = new ArrayList<>();
//        for (Orden orden : gestorOrdenes.getOrdenes()) {
//            if (!orden.getIdCliente().equals(idCliente)) {
//            } else {
//                ordenesCliente.add(orden);
//            }
//        }
//
//        if (ordenesCliente.isEmpty()) {
//            System.out.println("El cliente no tiene órdenes pendientes");
//            return;
//        }
//
//        System.out.println("\nÓrdenes pendientes:");
//        for (Orden orden : ordenesCliente) {
//            System.out.println("ID: " + orden.getId() + " - Fecha: " + orden.getFechaServicio());
//        }
//
//        System.out.print("Seleccione ID orden: ");
//        String idOrden = scanner.nextLine();
//
//        Orden ordenSeleccionada = null;
//        for (Orden orden : ordenesCliente) {
//            if (orden.getId() == idOrden) {
//                ordenSeleccionada = orden;
//                break;
//            }
//        }
//
//        if (ordenSeleccionada == null) {
//            System.out.println("Orden no encontrada!");
//            return;
//        }
//
//        // Generar factura
//        Factura factura = gestorFacturas.generarFactura(cliente, ordenSeleccionada.getServicios());
//        System.out.println("\n--- FACTURA GENERADA ---");
//        System.out.println("Número: " + factura.getId());
//        System.out.println("Fecha: " + factura.getFecha());
//        System.out.println("Cliente: " + factura.getCliente().getUsername());
//        System.out.println("\nDetalles:");
//        for (DetalleServicio detalle : factura.getDetalles()) {
//            System.out.println(detalle.getServicio().getNombre()
//                    + " x " + detalle.getCantidad()
//                    + " = $" + detalle.calcularSubtotal());
//        }
//        System.out.println("\nTOTAL: $" + factura.getTotal());
//    }
//    
    public List<Orden> getOrdenes() {
        return new ArrayList<>(ordenes);
    }
}
