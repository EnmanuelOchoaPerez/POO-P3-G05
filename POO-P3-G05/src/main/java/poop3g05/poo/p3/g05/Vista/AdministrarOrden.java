/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import poop3g05.poo.p3.g05.Controlador.*;
import poop3g05.poo.p3.g05.Modelo.*;

/**
 *
 * @author Enmanuel
 */
public class AdministrarOrden {

    private static final Scanner scanner = new Scanner(System.in);

    private static String seleccionarCliente(GestorCliente gestorClientes) {
        String idCliente = null;
        while (idCliente == null) {
            System.out.println("Clientes disponibles:");
            AdministrarCliente.listarClientes(gestorClientes);
            System.out.print("Seleccione ID cliente: ");
            idCliente = scanner.nextLine();
            if (gestorClientes.buscarUsuario(idCliente) instanceof Cliente) {
                return idCliente;
            } else {
                System.out.println("Cliente no encontrado, intente nuevamente.");
                idCliente = null;
            }
        }
        return idCliente;
    }

    private static Vehiculo definirVehiculo() {
        System.out.println("\nRegistre los datos del vehículo:");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        System.out.println("Tipo de vehículo:");
        System.out.println("1. Auto");
        System.out.println("2. Bus");
        System.out.println("3. Motocicleta");
        System.out.print("Seleccione: ");
        String tipoVehiculo = scanner.nextLine();

        TipoVehiculo tipo = TipoVehiculo.AUTO;
        switch (tipoVehiculo) {
            case "1" ->
                tipo = TipoVehiculo.AUTO;
            case "2" ->
                tipo = TipoVehiculo.BUS;
            case "3" ->
                tipo = TipoVehiculo.MOTOCICLETA;
        }
        return new Vehiculo(placa, tipo);
    }

    private static ArrayList<DetalleServicio> seleccionarServicios(GestorServicio gestorServicios) {
        ArrayList<DetalleServicio> detalles = new ArrayList<>();
        boolean continuarSeleccionServicios = true;
        do {
            System.out.println("\nServicios disponibles para realizar:");
            AdministrarServicio.listarServicios(gestorServicios);
            System.out.print("Seleccione ID servicio (0 para terminar): ");
            int idServicio = Integer.parseInt(scanner.nextLine());

            if (idServicio == 0) {
                continuarSeleccionServicios = false;
            } else {
                Servicio servicio = gestorServicios.buscarServicio(idServicio);
                if (servicio == null) {
                    System.out.println("Servicio no encontrado!");
                } else {
                    System.out.print("Cantidad: ");
                    int cantidad = Integer.parseInt(scanner.nextLine());
                    detalles.add(new DetalleServicio(servicio, cantidad));
                    System.out.println("Servicio agregado!");
                }
            }
        } while (continuarSeleccionServicios);
        return detalles;
    }

    public static void crearOrdenServicio(
            GestorCliente gestorClientes,
            GestorServicio gestorServicios,
            GestorTecnico gestorTecnicos,
            GestorOrden gestorOrdenes) {

        System.out.println("\n--- CREAR ORDEN DE SERVICIO ---");

        // Seleccionar cliente
        String idCliente = seleccionarCliente(gestorClientes);
        // Datos del vehículo
        Vehiculo vehiculo = definirVehiculo();
        // Seleccionar servicios
        ArrayList<DetalleServicio> detalles = seleccionarServicios(gestorServicios);

        // Crear orden
        Orden orden = new Orden(idCliente, new Date(), vehiculo, detalles);
        System.out.println(orden);
        gestorOrdenes.agregarOrden(orden);
        System.out.println("\n¡Orden creada exitosamente!");
    }
}

//        // Seleccionar técnico
//        System.out.println("\nTécnicos disponibles:");
//        AdministrarTecnico.listarTecnicos(gestorTecnicos);
//        System.out.print("Seleccione ID técnico: ");
//        String idTecnico = scanner.nextLine();
//        Tecnico tecnico = (Tecnico) gestorTecnicos.buscarUsuario(idTecnico);
//
//        if (tecnico == null) {
//            System.out.println("Técnico no encontrado!");
//            return;
//        }

