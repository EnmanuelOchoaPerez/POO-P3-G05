/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Vista;

import java.util.Scanner;
import poop3g05.poo.p3.g05.Controlador.GestorProveedor;
import poop3g05.poo.p3.g05.Modelo.Proveedor;
import poop3g05.poo.p3.g05.Modelo.Persona;

/**
 * Esta clase se encarga de mostrar y recibir datos referentes a la clase
 * Proveedor para las operaciones correspondientes enviando las entradas a los
 * controladores.
 *
 * @author Enmanuel
 */
public class AdministrarProveedor {

    /**
     * Objeto scanner que se va a usar para recibir las entradas del usuario en
     * toda la clase.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Este metodo se encarga de visibilizar por consola la informacion de todos
     * los proveedores disponibles para el taller.
     *
     * @param gestorProveedor
     */
    static void listarProveedores(GestorProveedor gestorProveedor) {
        System.out.println("\n--- LISTA DE PROVEEDORES ---\n");
        for (Persona usuario : gestorProveedor.getPersonas()) {
            if (usuario instanceof Proveedor proveedor) {
                System.out.println(proveedor);
            }
        }
        System.out.println("");
    }

    /**
     * Este metodo se encarga de mostrar por consola el submenu desde el cual se
     * agregaran proveedores y se editaran los existentes.
¡     * @param gestorProveedor
     */
    static void subMenuProveedor(GestorProveedor gestorProveedor) {
        boolean continuar = true;
        String opcion;

        while (continuar) {

            System.out.println("=== SubMenu ===\n=== Administrar Proveedores ===");

            listarProveedores(gestorProveedor);

            System.out.println("1. Agregar Proveedor");
            System.out.println("2. Editar Proveedor");
            System.out.println("0. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" ->
                    registrarProveedor(gestorProveedor);
                case "2" ->
                    editarProveedor(gestorProveedor);
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
     * para recibir los datos con los que se va a registrar el proveedor y
     * mostrar la confirmacion.
     *
     * @param gestorProveedor
     */
    private static void registrarProveedor(GestorProveedor gestorProveedor) {
        System.out.println("\n--- REGISTRAR PROVEEDOR ---");
        System.out.print("Cedula o RUC: ");
        String identificacion = scanner.nextLine();
        if (gestorProveedor.buscarPersona(identificacion) == null) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Descripcion: ");
            String descripcion = scanner.nextLine();
            System.out.print("Numero de contacto: ");
            String telefono = scanner.nextLine();
            gestorProveedor.agregarPersona(new Proveedor(identificacion, telefono, nombre, descripcion));
            System.out.println("Proveedor registrado exitosamente!");
        } else {
            System.out.println("Proveedor ya existe.");
        }
    }

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir los datos con los que se va editar el proveedor y mostrar la
     * confirmacion.
     *
     * @param gestorProveedor
     */
    private static void editarProveedor(GestorProveedor gestorProveedor) {
        System.out.println("\n--- EDITAR PROVEEDOR ---");
        System.out.print("Cedula o RUC: ");
        String identificacion = scanner.nextLine();
        if (gestorProveedor.buscarPersona(identificacion) instanceof Proveedor proveedor) {
            boolean continuar = true;
            while (continuar) {
                System.out.println(proveedor);
                String[] opciones = {
                    "Nombre",
                    "Teléfono",
                    "Descripcion"
                };
                System.out.println("\nSeleccione el campo a editar:");
                for (int i = 0; i < opciones.length; i++) {
                    System.out.println((i + 1) + ". " + opciones[i]);
                }
                System.out.println("0. Finalizar edición");
                System.out.print("Opción: ");
                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1" -> {
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        gestorProveedor.editarNombre(identificacion, nuevoNombre);
                    }
                    case "2" -> {
                        System.out.print("Nuevo teléfono: ");
                        String nuevoTelefono = scanner.nextLine();
                        gestorProveedor.editarTelefono(identificacion, nuevoTelefono);
                    }
                    case "3" -> {
                        System.out.print("Nueva descripcion: ");
                        String nuevaDescripcion = scanner.nextLine();
                        gestorProveedor.editarDescripcionProveedor(identificacion, nuevaDescripcion);
                    }
                    case "0" -> {
                        continuar = false;
                        System.out.println("Edición finalizada.");
                    }
                    default ->
                        System.out.println("Opción no válida.");
                }
            }
            System.out.println("Proveedor editado exitosamente!");
        } else {
            System.out.println("Proveedor no existe.");
        }

    }
}
