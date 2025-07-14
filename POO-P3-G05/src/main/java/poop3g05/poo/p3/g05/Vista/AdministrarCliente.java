/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Vista;

import java.util.Scanner;
import poop3g05.poo.p3.g05.Controlador.GestorCliente;
import poop3g05.poo.p3.g05.Modelo.Cliente;
import poop3g05.poo.p3.g05.Modelo.TipoCliente;
import poop3g05.poo.p3.g05.Modelo.Persona;

/**
 * Esta clase se encarga de imprimir por pantalla y de recibir los datos para
 * enviarlos al controlador sobre la mayoria de lo relacionado con la clase
 * Cliente.
 *
 * @author Enmanuel
 */
public class AdministrarCliente {

    /**
     * Objeto scanner que se va a usar para recibir las entradas del usuario en
     * toda la clase.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Este metodo se encarga de visibilizar por consola la informacion de todos
     * los clientes que tiene el taller y filtrar por tipo de cliente en caso de
     * ser requerido.
     *
     * @param gestorCliente
     * @param tipo
     */
    static void listarClientes(GestorCliente gestorCliente, TipoCliente tipo) {
        System.out.println("\n--- LISTA DE CLIENTES ---\n");
        for (Persona usuario : gestorCliente.getPersonas()) {
            if (tipo == null || gestorCliente.buscarPersona(usuario.getId()).getTipoCliente().equals(tipo)) {
                System.out.println(gestorCliente.buscarPersona(usuario.getId()));
            }
        }
        System.out.println("");
    }

    /**
     * Este metodo se encarga de mostrar por consola el submenu desde el cual se
     * agregaran clientes y se editaran los existentes.
     *
     * @param gestorCliente
     */
    static void subMenuClientes(GestorCliente gestorCliente) {
        boolean continuar = true;
        String opcion;

        while (continuar) {

            System.out.println("=== SubMenu ===\n=== Administrar Clientes ===");

            listarClientes(gestorCliente, null);

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

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir los datos con los que se va a registrar el cliente y mostrar
     * la confirmacion.
     *
     * @param gestorCliente
     */
    private static void registrarClientes(GestorCliente gestorCliente) {
        System.out.println("\n--- REGISTRAR CLIENTE ---");
        System.out.print("Cedula o RUC: ");
        String identificacion = scanner.nextLine();
        if (gestorCliente.buscarPersona(identificacion) == null) {
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
            gestorCliente.agregarPersona(new Cliente(identificacion, telefono, nombre, direccion, tipo));
            System.out.println("Cliente registrado exitosamente!");
        } else {
            System.out.println("Cliente ya existe.");
        }
    }

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir los datos con los que se va a editar el cliente y mostrar la
     * confirmacion.
     *
     * @param gestorCliente
     */
    private static void editarCliente(GestorCliente gestorCliente) {
        System.out.println("\n--- EDITAR CLIENTE ---");
        System.out.print("Cedula o RUC: ");
        String identificacion = scanner.nextLine();
        if (gestorCliente.buscarPersona(identificacion) != null) {
            boolean continuar = true;
            while (continuar) {
                System.out.println(gestorCliente.buscarPersona(identificacion));
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
