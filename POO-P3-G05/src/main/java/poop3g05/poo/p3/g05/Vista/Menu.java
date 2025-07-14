/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package poop3g05.poo.p3.g05.Vista;

import poop3g05.poo.p3.g05.Controlador.*;
/**
 * Esta clase es la encargada de mostrar el menu principal que deriva en todos
 * los demas submenus y opciones de la aplicacion.
 * @author Rafael Cosmo
 */

import java.util.Scanner;

public class Menu {

    /**
     * Objeto scanner que va a usar para recibir las entradas del usuario en
     * toda la clase.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Este metodo es el encargado de mostrar el menu principal que deriva en
     * todos los demas submenus y opciones de la aplicacion.
     * @param gestorCliente
     * @param gestorServicio
     * @param gestorTecnico
     * @param gestorOrdenes
     * @param gestorFactura
     * @param gestorProveedor
     * @param gestorInsumo
     */
    public static void mostrarMenuPrincipal(
            GestorCliente gestorCliente,
            GestorServicio gestorServicio,
            GestorTecnico gestorTecnico,
            GestorOrden gestorOrdenes,
            GestorFactura gestorFactura,
            GestorProveedor gestorProveedor,
            GestorInsumo gestorInsumo) {

        String opcion;
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
                    AdministrarOrden.crearOrdenServicio(gestorCliente, gestorServicio, gestorTecnico, gestorOrdenes);
                case "6" ->
                    AdministrarInsumo.registrarInsumoFaltante(gestorInsumo, gestorTecnico, gestorProveedor);
                case "7" ->
                    AdministrarFactura.imprimirFactura(AdministrarFactura.registrarFactura(gestorFactura, gestorCliente, gestorOrdenes));
                case "8" ->
                    AdministrarServicio.obtenerRecaudoServicios(gestorServicio);
                case "9" ->
                    AdministrarTecnico.obtenerGananciaTecnicos(gestorTecnico);
                case "0" -> {
                    continuar = false;
                    System.out.println("Saliendo de la aplicacion...");
                }
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.\n");
            }
        } while (continuar);
    }
}
