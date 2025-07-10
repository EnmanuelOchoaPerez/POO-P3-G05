/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Vista;

import java.util.Scanner;
import poop3g05.poo.p3.g05.Controlador.GestorTecnico;
import poop3g05.poo.p3.g05.Modelo.Tecnico;
import poop3g05.poo.p3.g05.Modelo.Usuario;

/**
 *
 * @author Enmanuel
 */
public class AdministrarTecnico {

    private static final Scanner scanner = new Scanner(System.in);

    static void listarTecnicos(GestorTecnico gestorTecnico) {
        System.out.println("\n--- LISTA DE TECNICOS ---\n");
        for (Usuario usuario : gestorTecnico.getUsuarios()) {
            if (usuario instanceof Tecnico tecnico) {
                System.out.println(tecnico);
            }
        }
        System.out.println("");
    }

    static void subMenuTecnicos(GestorTecnico gestorTecnico) {
        boolean continuar = true;
        String opcion;

        while (continuar) {

            System.out.println("=== SubMenu ===\n=== Administrar Tecnicos ===");

            listarTecnicos(gestorTecnico);

            System.out.println("1. Agregar Tecnico");
            System.out.println("2. Editar Tecnico");
            System.out.println("3. Eliminar Tecnico");
            System.out.println("0. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" ->
                    registrarTecnico(gestorTecnico);
                case "2" ->
                    editarTecnico(gestorTecnico);
                case "3" -> {
                    eliminarTecnico(gestorTecnico);
                }
                case "0" -> {
                    continuar = false;
                    System.out.println("Regresando al menú principal...\n");
                }
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.\n");
            }

        }
    }

    private static void eliminarTecnico(GestorTecnico gestorTecnico) {
        System.out.println("\n--- ELIMINAR TECNICO ---");
        System.out.print("Cedula o RUC: ");
        String identificacion = scanner.nextLine();
        if (gestorTecnico.buscarUsuario(identificacion) != null) {
            gestorTecnico.eliminarTecnico(identificacion);
            System.out.println("Tecnico eliminado exitosamente!");
        } else {
            System.out.println("Tecnico no existe.");
        }
    }

    private static void registrarTecnico(GestorTecnico gestorTecnico) {
        System.out.println("\n--- REGISTRAR TECNICO ---");
        System.out.print("Cedula o RUC: ");
        String identificacion = scanner.nextLine();
        if (gestorTecnico.buscarUsuario(identificacion) == null) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Especialidad: ");
            String especialidad = scanner.nextLine();
            System.out.print("Numero de telefono: ");
            String telefono = scanner.nextLine();
            gestorTecnico.agregarUsuario(new Tecnico(identificacion, telefono, nombre, especialidad));
            System.out.println("Tecnico registrado exitosamente!");
        } else {
            System.out.println("Tecnico ya existe.");
        }
    }

    private static void editarTecnico(GestorTecnico gestorTecnico) {
        System.out.println("\n--- EDITAR TECNICO ---");
        System.out.print("Cedula o RUC: ");
        String identificacion = scanner.nextLine();
        if (gestorTecnico.buscarUsuario(identificacion) != null) {
            System.out.println(gestorTecnico.buscarUsuario(identificacion));
            boolean continuar = true;
            while (continuar) {
                String[] opciones = {
                    "Nombre",
                    "Teléfono",
                    "Especialidad"
                };
                System.out.println("\nSeleccione el campo a editar:");
                for (int i = 0; i < opciones.length; i++) {
                    System.out.println((i + 1) + ". " + opciones[i]);
                }
                System.out.print("0. Finalizar edición");
                System.out.print("Opción: ");
                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1" -> {
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        gestorTecnico.editarNombre(identificacion, nuevoNombre);
                    }
                    case "2" -> {
                        System.out.print("Nuevo teléfono: ");
                        String nuevoTelefono = scanner.nextLine();
                        gestorTecnico.editarTelefono(identificacion, nuevoTelefono);
                    }
                    case "3" -> {
                        System.out.print("Nueva especialidad: ");
                        String nuevaEspecialidad = scanner.nextLine();
                        gestorTecnico.editarEspecialidadTecnico(identificacion, nuevaEspecialidad);
                    }
                    case "0" -> {
                        continuar = false;
                        System.out.println("Edición finalizada.");
                    }
                    default ->
                        System.out.println("Opción no válida.");
                }
            }
            System.out.println("Tecnico editado exitosamente!");
        } else {
            System.out.println("Tecnico no existe.");
        }

    }
}
