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
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuPrincipal(
        GestorClientes gestorClientes,
        GestorServicios gestorServicios,
        GestorTecnicos gestorTecnicos,
        GestorOrdenes gestorOrdenes,
        GestorFacturas gestorFacturas) {

        int opcion;
        do {
            System.out.println("\n--- SISTEMA TALLER MECÁNICO ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Crear orden de servicio");
            System.out.println("3. Generar factura");
            System.out.println("4. Listar clientes");
            System.out.println("5. Listar servicios");
            System.out.println("6. Listar técnicos");
            System.out.println("7. Salir");
            System.out.print("Seleccione opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer
            
            switch (opcion) {
                case 1 -> registrarCliente(gestorClientes);
                case 2 -> crearOrdenServicio(gestorClientes, gestorServicios, gestorTecnicos, gestorOrdenes);
                case 3 -> generarFactura(gestorFacturas, gestorClientes, gestorOrdenes);
                case 4 -> listarClientes(gestorClientes);
                case 5 -> listarServicios(gestorServicios);
                case 6 -> listarTecnicos(gestorTecnicos);
                case 7 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 7);
    }

    private static void registrarCliente(GestorClientes gestorClientes) {
        System.out.println("\n--- REGISTRAR CLIENTE ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Numero de telefono: ");
        String telefono = scanner.nextLine();
        
        System.out.println("Tipo de cliente:");
        System.out.println("1. Persona Natural");
        System.out.println("2. Empresa");
        System.out.print("Seleccione: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        TipoCliente tipoCliente = (tipo == 1) ? TipoCliente.PERSONAL : TipoCliente.EMPRESA;
        
        Cliente cliente = new Cliente( nombre, telefono, tipoCliente);
        gestorClientes.agregarCliente(cliente);
        System.out.println("Cliente registrado exitosamente!");
    }

    private static void crearOrdenServicio(
        GestorClientes gestorClientes,
        GestorServicios gestorServicios,
        GestorTecnicos gestorTecnicos,
        GestorOrdenes gestorOrdenes) {
        
        System.out.println("\n--- CREAR ORDEN DE SERVICIO ---");
        
        // Seleccionar cliente
        System.out.println("Clientes disponibles:");
        listarClientes(gestorClientes);
        System.out.print("Seleccione ID cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = gestorClientes.buscarCliente(idCliente);
        
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
            case 1 -> tipo = TipoVehiculo.AUTO;
            case 2 -> tipo = TipoVehiculo.CAMIONETA;
            case 3 -> tipo = TipoVehiculo.MOTOCICLETA;
        }
        
        Vehiculo vehiculo = new Vehiculo(placa, tipo);
        
        // Seleccionar servicios
        List<DetalleServicio> detalles = new ArrayList<>();
        int opcionServicio;
        do {
            System.out.println("\nServicios disponibles:");
            listarServicios(gestorServicios);
            System.out.print("Seleccione ID servicio (0 para terminar): ");
            int idServicio = scanner.nextInt();
            scanner.nextLine();
            
            if (idServicio == 0) break;
            
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
        listarTecnicos(gestorTecnicos);
        System.out.print("Seleccione ID técnico: ");
        int idTecnico = scanner.nextInt();
        scanner.nextLine();
        Tecnico tecnico = gestorTecnicos.buscarTecnico(idTecnico);
        
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
        GestorFacturas gestorFacturas,
        GestorClientes gestorClientes,
        GestorOrdenes gestorOrdenes) {
        
        System.out.println("\n--- GENERAR FACTURA ---");
        
        // Seleccionar cliente
        System.out.println("Clientes disponibles:");
        listarClientes(gestorClientes);
        System.out.print("Seleccione ID cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = gestorClientes.buscarCliente(idCliente);
        
        if (cliente == null) {
            System.out.println("Cliente no encontrado!");
            return;
        }
        
        // Buscar órdenes del cliente
        List<Orden> ordenesCliente = new ArrayList<>();
        for (Orden orden : gestorOrdenes.getOrdenes()) {
            if (orden.getCliente().getId() == idCliente) {
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
            System.out.println(detalle.getServicio().getNombre() + 
                " x " + detalle.getCantidad() + 
                " = $" + detalle.calcularSubtotal());
        }
        System.out.println("\nTOTAL: $" + factura.getTotal());
    }

    private static void listarClientes(GestorClientes gestorClientes) {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        for (Cliente cliente : gestorClientes.getClientes()) {
            System.out.println(cliente.getId() + " - " + cliente.getUsername() + 
                " (" + cliente.getTipoCliente() + ")");
        }
    }

    private static void listarServicios(GestorServicios gestorServicios) {
        System.out.println("\n--- LISTA DE SERVICIOS ---");
        for (Servicio servicio : gestorServicios.getServicios()) {
            System.out.println(servicio.getId() + " - " + servicio.getNombre() + 
                " - $" + servicio.getPrecio());
        }
    }

    private static void listarTecnicos(GestorTecnicos gestorTecnicos) {
        System.out.println("\n--- LISTA DE TÉCNICOS ---");
        for (Tecnico tecnico : gestorTecnicos.getTecnicos()) {
            System.out.println(tecnico.getId() + " - " + tecnico.getUsername() + 
                " - " + tecnico.getEspecialidad());
        }
    }
}