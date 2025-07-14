/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import poop3g05.poo.p3.g05.Controlador.GestorServicio;
import poop3g05.poo.p3.g05.Modelo.Servicio;

/**
 * Esta clase se encarga de imprimir por pantalla y de recibir los datos para
 * enviarlos al controlador sobre la mayoria de lo relacionado con la clase
 * Servicio
 *
 * @author Enmanuel
 */
public class AdministrarServicio {

    /**
     * Objeto scanner que se va a usar para recibir las entradas del usuario en
     * toda la clase.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Este metodo se encarga de visibilizar por consola la informacion de todos
     * los servicios disponibles en el taller.
     *
     * @param gestorServicio
     */
    static void listarServicios(GestorServicio gestorServicio) {
        System.out.println("\n--- LISTA DE SERVICIOS ---\n");
        for (Servicio servicio : gestorServicio.getServicios()) {
            System.out.println(servicio);
        }
        System.out.println("");
    }

    /**
     * Este metodo se encarga de mostrar por consola el submenu desde el cual se
     * agregaran servicios y se editaran los existentes
     *
     * @param gestorServicio
     */
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

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir los datos con los que se va a registrar el Servicio y
     * mostrar la confirmacion.
     *
     * @param gestorServicio
     */
    private static void registrarServicio(GestorServicio gestorServicio) {
        System.out.println("\n--- REGISTRAR SERVICIO ---");
        System.out.print("Nombre del servicio: ");
        String nombre = scanner.nextLine();
        System.out.print("Fecha de registro del servicio(dd-MM-yyyy): ");
        LocalDate fecha = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.print("Precio del servicio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        gestorServicio.agregarServicio(new Servicio(nombre, precio, fecha));
        System.out.println("Servicio registrado exitosamente!");
    }

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir los datos con los que se va a editar el servicio y mostrar
     * la confirmacion.
     *
     * @param gestorServicio
     */
    private static void editarServicio(GestorServicio gestorServicio) {
        System.out.println("\n--- EDITAR SERVICIO ---");
        System.out.print("Codigo del servicio: ");
        int id = Integer.parseInt(scanner.nextLine());

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
                        System.out.print("Fecha de edicion del servicio(dd-MM-yyyy): ");
                        LocalDate fecha = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        gestorServicio.editarPrecioServicio(id, nuevoPrecio, fecha);
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

    /**
     * Este metodo imprime por consola las ganancincias recaudadas por cada tipo
     * de servicio. No esta incluido el valor de las memembrecias de las
     * empresas.
     *
     * @param gestorServicio
     */
    public static void obtenerRecaudoServicios(GestorServicio gestorServicio) {
        System.out.printf("%-50s %15s%n", "Servicio", "Total");
        System.out.printf("%-15s %40s%n", ("-").repeat(25), ("-").repeat(5));

        for (Servicio s : gestorServicio.getServicios()) {
            Servicio servicio = gestorServicio.buscarServicio(s.getCodigo());

            String nombre = servicio.getNombre();
            double recaudo = servicio.getRecaudo();

            System.out.printf("%-50s %,15.2f%n", nombre, recaudo);
        }
    }

}
