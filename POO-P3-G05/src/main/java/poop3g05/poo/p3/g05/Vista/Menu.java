/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package poop3g05.poo.p3.g05.Vista;

import poop3g05.poo.p3.g05.Controlador.*;
import poop3g05.poo.p3.g05.Modelo.*;
/**
 *
 * @author Rafael Cosmo
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuPrincipal(
            GestorCliente gestorCliente,
            GestorServicio gestorServicio,
            GestorTecnico gestorTecnico,
            GestorOrden gestorOrdene,
            GestorFactura gestorFactura,
            GestorProveedor gestorProveedor) {

        String opcion;

        String mensaje = "Funcion no implementada aun. Intente nuevamente.\n";

        StringBuilder menu = new StringBuilder("#    MENU PRINCIPAL    #\n=========================\n");
        String[] opciones = {
            "Admini1strar clientes",
            "Administrar proveedores",
            "Administrar técnicos",
            "Administrar servicios",
            "Generar orden de servicios",
            "Registrar falta de insumos",
            "Generar facturas a empresas",
            "Reporte de ingresos por servicios",
            "Reporte de atenciones por técnico",
            "Salir"
        };
        for (int i = 0; i < opciones.length; i++) {
            menu.append(i == opciones.length - 1 ? 0 : i + 1).append(". ").append(opciones[i]).append("\n");
        }
        boolean continuar = true;

        do {

            System.out.print(menu);
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" ->
                    AdministrarCliente.subMenuClientes(gestorCliente);
                case "2" ->
                    AdministrarProveedor.subMenuProveedor(gestorProveedor);
                case "3" ->
                    AdministrarTecnico.subMenuTecnicos(gestorTecnico);
                case "4" ->
                    AdministrarServicio.subMenuServicio(gestorServicio);
                case "5" ->
                    crearOrdenServicio(gestorCliente, gestorServicio, gestorTecnico, gestorOrdene);
                case "6" ->
                    System.out.println(mensaje);
                case "7" ->
                    generarFactura(gestorFactura, gestorCliente, gestorOrdene);
                case "8" ->
                    System.out.println(mensaje);
                case "9" ->
                    System.out.println(mensaje);
                case "0" -> {
                    continuar = false;
                    System.out.println("Saliendo de la aplicacion...");
                }
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (continuar);
    }

    private static void crearOrdenServicio(
            GestorCliente gestorClientes,
            GestorServicio gestorServicios,
            GestorTecnico gestorTecnicos,
            GestorOrden gestorOrdenes) {

        System.out.println("\n--- CREAR ORDEN DE SERVICIO ---");

        // Seleccionar cliente
        System.out.println("Clientes disponibles:");
        AdministrarCliente.listarClientes(gestorClientes);
        System.out.print("Seleccione ID cliente: ");
        String idCliente = scanner.nextLine();
        Cliente cliente = (Cliente) gestorClientes.buscarUsuario(idCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado!");
            return;
        }

        // Datos del vehículo
        System.out.println("\nDatos del vehículo:");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Tipo de vehículo:");
        System.out.println("1. Auto");
        System.out.println("2. Camioneta");
        System.out.println("3. Motocicleta");
        System.out.print("Seleccione: ");
        int tipoVehiculo = scanner.nextInt();
        scanner.nextLine();

        TipoVehiculo tipo = TipoVehiculo.AUTO;
        switch (tipoVehiculo) {
            case 1 ->
                tipo = TipoVehiculo.AUTO;
            case 2 ->
                tipo = TipoVehiculo.CAMIONETA;
            case 3 ->
                tipo = TipoVehiculo.MOTOCICLETA;
        }

        Vehiculo vehiculo = new Vehiculo(placa, tipo);

        // Seleccionar servicios
        ArrayList<DetalleServicio> detalles = new ArrayList<>();
        do {
            System.out.println("\nServicios disponibles:");
            AdministrarServicio.listarServicios(gestorServicios);
            System.out.print("Seleccione ID servicio (0 para terminar): ");
            int idServicio = scanner.nextInt();
            scanner.nextLine();

            if (idServicio == 0) {
                break;
            }

            Servicio servicio = gestorServicios.buscarServicio(idServicio);
            if (servicio == null) {
                System.out.println("Servicio no encontrado!");
                continue;
            }

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            detalles.add(new DetalleServicio(servicio, cantidad));
            System.out.println("Servicio agregado!");

        } while (true);

        // Seleccionar técnico
        System.out.println("\nTécnicos disponibles:");
        AdministrarTecnico.listarTecnicos(gestorTecnicos);
        System.out.print("Seleccione ID técnico: ");
        String idTecnico = scanner.nextLine();
        Tecnico tecnico = (Tecnico) gestorTecnicos.buscarUsuario(idTecnico);

        if (tecnico == null) {
            System.out.println("Técnico no encontrado!");
            return;
        }

        // Crear orden
        Orden orden = new Orden(0, new Date(), cliente, vehiculo, detalles, tecnico);
        gestorOrdenes.crearOrden(orden);
        System.out.println("\n¡Orden creada exitosamente!");
    }

    private static void generarFactura(
            GestorFactura gestorFacturas,
            GestorCliente gestorClientes,
            GestorOrden gestorOrdenes) {

        System.out.println("\n--- GENERAR FACTURA ---");

        // Seleccionar cliente
        System.out.println("Clientes disponibles:");
        AdministrarCliente.listarClientes(gestorClientes);
        System.out.print("Seleccione ID cliente: ");
        String idCliente = scanner.nextLine();
        Cliente cliente = (Cliente) gestorClientes.buscarUsuario(idCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado!");
            return;
        }

        // Buscar órdenes del cliente
        ArrayList<Orden> ordenesCliente = new ArrayList<>();
        for (Orden orden : gestorOrdenes.getOrdenes()) {
            if (!orden.getCliente().getId().equals(idCliente)) {
            } else {
                ordenesCliente.add(orden);
            }
        }

        if (ordenesCliente.isEmpty()) {
            System.out.println("El cliente no tiene órdenes pendientes");
            return;
        }

        System.out.println("\nÓrdenes pendientes:");
        for (Orden orden : ordenesCliente) {
            System.out.println("ID: " + orden.getId() + " - Fecha: " + orden.getFecha());
        }

        System.out.print("Seleccione ID orden: ");
        int idOrden = scanner.nextInt();
        scanner.nextLine();

        Orden ordenSeleccionada = null;
        for (Orden orden : ordenesCliente) {
            if (orden.getId() == idOrden) {
                ordenSeleccionada = orden;
                break;
            }
        }

        if (ordenSeleccionada == null) {
            System.out.println("Orden no encontrada!");
            return;
        }

        // Generar factura
        Factura factura = gestorFacturas.generarFactura(cliente, ordenSeleccionada.getServicios());
        System.out.println("\n--- FACTURA GENERADA ---");
        System.out.println("Número: " + factura.getId());
        System.out.println("Fecha: " + factura.getFecha());
        System.out.println("Cliente: " + factura.getCliente().getUsername());
        System.out.println("\nDetalles:");
        for (DetalleServicio detalle : factura.getDetalles()) {
            System.out.println(detalle.getServicio().getNombre()
                    + " x " + detalle.getCantidad()
                    + " = $" + detalle.calcularSubtotal());
        }
        System.out.println("\nTOTAL: $" + factura.getTotal());
    }
}
