/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Vista;

import java.util.Scanner;
import poop3g05.poo.p3.g05.Controlador.GestorCliente;
import poop3g05.poo.p3.g05.Modelo.Cliente;
import poop3g05.poo.p3.g05.Modelo.TipoCliente;
import poop3g05.poo.p3.g05.Modelo.Usuario;

/**
 *
 * @author Enmanuel
 */
public class AdministrarCliente {

    private static final Scanner scanner = new Scanner(System.in);

    static void listarClientes(GestorCliente gestorCliente) {
        System.out.println("\n--- LISTA DE CLIENTES ---\n");
        for (Usuario usuario : gestorCliente.getUsuarios()) {
            if (usuario instanceof Cliente cliente) {
                System.out.println(cliente);
            }
        }
        System.out.println("");
    }

    static void subMenuClientes(GestorCliente gestorCliente) {
        boolean continuar = true;
        String opcion;

        while (continuar) {

            System.out.println("=== SubMenu ===\n=== Administrar Clientes ===");

            listarClientes(gestorCliente);

            System.out.println("1. Agregar Clientes");
            System.out.println("2. Editar Clientes");
            System.out.println("0. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" ->
                    registrarClientes(gestorCliente);
                case "2" ->
                    editarCliente(gestorCliente);
                case "0" -> {
                    continuar = false;
                    System.out.println("Regresando al menú principal...\n");
                }
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.\n");
            }

        }
    }

    private static void registrarClientes(GestorCliente gestorCliente) {
        System.out.println("\n--- REGISTRAR CLIENTE ---");
        System.out.print("Cedula o RUC: ");
        String identificacion = scanner.nextLine();
        if (gestorCliente.buscarUsuario(identificacion) == null) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Direccion: ");
            String direccion = scanner.nextLine();
            System.out.print("Numero de telefono: ");
            String telefono = scanner.nextLine();
            System.out.println("Escoja el tipo de Cliente");
            System.out.println("1. Empresa");
            System.out.println("2. Personal");
            TipoCliente tipo = scanner.nextLine().equals("1") ? TipoCliente.EMPRESA : TipoCliente.PERSONAL;
            gestorCliente.agregarUsuario(new Cliente(identificacion, telefono, nombre, direccion, tipo));
            System.out.println("Cliente registrado exitosamente!");
        } else {
            System.out.println("Cliente ya existe.");
        }
    }

    private static void editarCliente(GestorCliente gestorCliente) {
        System.out.println("\n--- EDITAR CLIENTE ---");
        System.out.print("Cedula o RUC: ");
        String identificacion = scanner.nextLine();
        if (gestorCliente.buscarUsuario(identificacion) != null) {
            boolean continuar = true;
            while (continuar) {
                System.out.println(gestorCliente.buscarUsuario(identificacion));
                String[] opciones = {
                    "Nombre",
                    "Teléfono",
                    "Direccion",
                    "Tipo",
                    "Finalizar edición"
                };
                System.out.println("\nSeleccione el campo a editar:");
                for (int i = 0; i < opciones.length; i++) {
                    System.out.println((i + 1) + ". " + opciones[i]);
                }
                System.out.print("Opción: ");
                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1" -> {
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        gestorCliente.editarNombre(identificacion, nuevoNombre);
                    }
                    case "2" -> {
                        System.out.print("Nuevo teléfono: ");
                        String nuevoTelefono = scanner.nextLine();
                        gestorCliente.editarTelefono(identificacion, nuevoTelefono);
                    }
                    case "3" -> {
                        System.out.print("Nueva direccion: ");
                        String nuevaDireccion = scanner.nextLine();
                        gestorCliente.editarDireccionCliente(identificacion, nuevaDireccion);
                    }
                    case "4" -> {
                        System.out.println("Escoja el tipo de Cliente");
                        System.out.println("1. Empresa");
                        System.out.println("2. Personal");
                        TipoCliente nuevoTipo = scanner.nextLine().equals("1") ? TipoCliente.EMPRESA : TipoCliente.PERSONAL;
                        gestorCliente.editarTipoCliente(identificacion, nuevoTipo);
                    }
                    case "5" -> {
                        continuar = false;
                        System.out.println("Edición finalizada.");
                    }
                    default ->
                        System.out.println("Opción no válida.");
                }
            }
            System.out.println("Cliente editado exitosamente!");
        } else {
            System.out.println("Cliente no existe.");
        }

    }
}
