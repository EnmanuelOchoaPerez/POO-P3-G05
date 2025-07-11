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
                   AdministrarOrden.crearOrdenServicio(gestorCliente, gestorServicio, gestorTecnico, gestorOrdene);
                case "6" ->
                    System.out.println(mensaje);
                case "7" ->
                    System.out.println(mensaje);
//                  generarFactura(gestorFactura, gestorCliente, gestorOrdene);
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
}
