/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import poop3g05.poo.p3.g05.Controlador.*;
import poop3g05.poo.p3.g05.Modelo.*;

/**
 * Esta clase se encarga de mostrar y recibir datos referentes a la clase
 * Orden para las operaciones correspondientes enviando las entradas a los
 * controladores.
 *
 * @author Enmanuel
 */
public class AdministrarOrden {

    /**
     * Objeto scanner que se va a usar para recibir las entradas del usuario en
     * toda la clase.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir los datos con los que se va a seleccionar el cliente para la
     * nueva orden y mostrar la confirmacion.
     * Este metodo esta destinado a ser usado en el metodo crearOrdenServicio exclusivamente
     * @param gestorClientes
     * @return
     */
    private static Cliente seleccionarCliente(GestorCliente gestorClientes) {
        Cliente cliente = null;
        do {
            System.out.println("Clientes disponibles:");
            AdministrarCliente.listarClientes(gestorClientes, null);
            System.out.print("Digite ID de cliente: ");
            String idCliente = scanner.nextLine();
            cliente = gestorClientes.buscarPersona(idCliente) instanceof Cliente c ? c : null;
            if (cliente == null) {
                System.out.println("Cliente no encontrado, intente nuevamente.");
            }
        } while (cliente == null);
        return cliente;
    }

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir los datos con los que se va a seleccionar el tecnico para la
     * nueva orden y mostrar la confirmacion
     * Este metodo esta destinado a ser usado en el metodo crearOrdenServicio exclusivamente
     * @param gestorTecnico
     * @return
     */
    private static Tecnico seleccionarTecnico(GestorTecnico gestorTecnico) {
        Tecnico tecnico = null;
        do {
            System.out.println("Tecnicos disponibles:");
            AdministrarTecnico.listarTecnicos(gestorTecnico);
            System.out.print("Digite ID de tecnico: ");
            String idTecnico = scanner.nextLine();
            tecnico = gestorTecnico.buscarPersona(idTecnico) instanceof Tecnico t ? t : null;
            if (tecnico == null) {
                System.out.println("Tecnico no encontrado, intente nuevamente.");
            }
        } while (tecnico == null);
        return tecnico;
    }

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir los datos del vehiculo sobre el que se va a trabajar en la
     * nuva orden.
     * Este metodo esta destinado a ser usado en el metodo crearOrdenServicio exclusivamente
     * @return
     */
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

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir la fecha con los que se va a registrar la nueva orden.
     * Este metodo esta destinado a ser usado en el metodo crearOrdenServicio exclusivamente
     * @return
     */
    private static LocalDate recibirFecha() {
        System.out.println("Digite numero de año:");
        int año = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite numero de dia:");
        int dia = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite numero de mes:");
        int mes = Integer.parseInt(scanner.nextLine());

        return LocalDate.of(año, mes, dia);
    }

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir los datos con los que se va a seleccionar los servicios que
     * se van a agregar a la orden y la cantidad correspondiente de cada uno asi
     * como mostrar la confirmacion de que fue agregado a la orden correctamente.
     * Este metodo esta destinado a ser usado en el metodo crearOrdenServicio exclusivamente
     * @param gestorServicios
     * @return
     */
    private static ArrayList<DetalleServicio> seleccionarServicios(GestorServicio gestorServicios) {
        ArrayList<DetalleServicio> detalles = new ArrayList<>();
        boolean continuarSeleccionServicios = true;
        do {
            System.out.println("\nServicios disponibles para realizar:");
            AdministrarServicio.listarServicios(gestorServicios);
            System.out.print("Digite codigo de servicio (0 para terminar): ");
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

    /**
     * Este metodo es el encargado de registrar la orden con los datos recibidos 
     * y mostrar la confirmacion de la correcta creaciond de la orden.
     *
     * @param gestorClientes
     * @param gestorServicios
     * @param gestorTecnicos
     * @param gestorOrdenes
     */
    static void crearOrdenServicio(
            GestorCliente gestorClientes,
            GestorServicio gestorServicios,
            GestorTecnico gestorTecnicos,
            GestorOrden gestorOrdenes) {

        System.out.println("\n--- CREAR ORDEN DE SERVICIO ---");

        // Seleccionar cliente
        Cliente cliente = seleccionarCliente(gestorClientes);
        
        // Datos del vehículo
        Vehiculo vehiculo = definirVehiculo();
        
        // Seleccionar servicios
        ArrayList<DetalleServicio> detalles = seleccionarServicios(gestorServicios);
        
        // Definir fecha
        LocalDate fechaOrden = recibirFecha();
        
        // Seleccionar técnico
        Tecnico tecnico = seleccionarTecnico(gestorTecnicos);
        
        // Crear orden
        Orden orden = new Orden(cliente, tecnico, fechaOrden, vehiculo, detalles);
        System.out.println(orden);
        gestorOrdenes.agregarOrden(orden);
        System.out.println("\n¡Orden creada exitosamente!");
    }
}
