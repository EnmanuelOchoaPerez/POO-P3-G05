/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Vista;

import java.util.Scanner;
import poop3g05.poo.p3.g05.Controlador.GestorServicio;
import poop3g05.poo.p3.g05.Modelo.Servicio;

/**
 *
 * @author Enmanuel
 */
public class AdministrarServicio {

    private static final Scanner scanner = new Scanner(System.in);

    static void listarServicios(GestorServicio gestorServicio) {
        System.out.println("\n--- LISTA DE SERVICIOS ---\n");
        for (Servicio servicio : gestorServicio.getServicios()) {
            System.out.println(servicio);
        }
        System.out.println("");
    }

    static void subMenuServicio(GestorServicio gestorServicio) {
        boolean continuar = true;
        String opcion;
        listarServicios(gestorServicio);
        while (continuar) {

            System.out.println("=== SubMenu ===\n=== Administrar Servicios ===");

            listarServicios(gestorServicio);

            System.out.println("1. Agregar servicio");
            System.out.println("2. Editar servicio");
            System.out.println("0. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" ->
                    registrarServicio(gestorServicio);
                case "2" ->
                    editarServicio(gestorServicio);
                case "0" -> {
                    continuar = false;
                    System.out.println("Regresando al menú principal...\n");
                }
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.\n");
            }

        }
    }

    private static void registrarServicio(GestorServicio gestorServicio) {
        System.out.println("\n--- REGISTRAR SERVICIO ---");
        System.out.print("Nombre del servicio: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del servicio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        gestorServicio.agregarServicio(new Servicio(nombre, precio));
        System.out.println("Servicio registrado exitosamente!");
    }

    private static void editarServicio(GestorServicio gestorServicio) {
        System.out.println("\n--- EDITAR SERVICIO ---");
        System.out.print("Codigo del servicio: ");
        int id = Integer.parseInt(scanner.nextLine());  //"1"=1

        if (gestorServicio.buscarServicio(id) != null) {
            boolean continuar = true;
            while (continuar) {
                System.out.println(gestorServicio.buscarServicio(id));
                String[] opciones = {
                    "Precio",};
                System.out.println("\nSeleccione el campo a editar:");
                for (int i = 0; i < opciones.length; i++) {
                    System.out.println((i + 1) + ". " + opciones[i]);
                }
                System.out.println("0. Finalizar edición");
                System.out.print("Opción: ");
                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1" -> {
                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = Double.parseDouble(scanner.nextLine());
                        gestorServicio.editarPrecioServicio(id, nuevoPrecio);
                    }
                    case "0" -> {
                        continuar = false;
                        System.out.println("Edición finalizada.");
                    }
                    default ->
                        System.out.println("Opción no válida.");
                }
            }
            System.out.println("Servicio editado exitosamente!");
        } else {
            System.out.println("Servicio no existe.");
        }
    }

}
