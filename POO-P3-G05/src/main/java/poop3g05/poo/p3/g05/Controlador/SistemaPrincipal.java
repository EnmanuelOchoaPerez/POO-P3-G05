/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import poop3g05.poo.p3.g05.Modelo.*;
import poop3g05.poo.p3.g05.Vista.Menu;

/**
 * Esta clase es la clase pirncipal sobre la que se ejecuta la aplicacion,
 * ademas es la encargada de introducir los datos para el primer testeo.
 *
 * @author Rafael Cosmo
 */
public class SistemaPrincipal {

    /**
     * Este metodo es el pirncipal sobre el que se ejecuta la aplicacion
     *
     * @param args
     */
    public static void main(String[] args) {
        GestorCliente gestorClientes = new GestorCliente();
        GestorServicio gestorServicios = new GestorServicio();
        GestorTecnico gestorTecnicos = new GestorTecnico();
        GestorOrden gestorOrdenes = new GestorOrden();
        GestorFactura gestorFacturas = new GestorFactura();
        GestorProveedor gestorProveedor = new GestorProveedor();
        GestorInsumo gestorInsumo = new GestorInsumo();

        // Datos de prueba
        inicializarApp(gestorClientes, gestorServicios, gestorTecnicos, gestorProveedor, gestorOrdenes);

        Menu.mostrarMenuPrincipal(
                gestorClientes,
                gestorServicios,
                gestorTecnicos,
                gestorOrdenes,
                gestorFacturas,
                gestorProveedor,
                gestorInsumo
        );
    }

    /**
     * Este metodo es el encargado de introducir los datos de prueba
     *
     * @param gc
     * @param gs
     * @param gt
     * @param gp
     * @param go Este metodo no tiene retorno
     */
    private static void inicializarApp(
            GestorCliente gc,
            GestorServicio gs,
            GestorTecnico gt,
            GestorProveedor gp,
            GestorOrden go
    ) {
        // Agregar clientes
        gc.agregarPersona(new Cliente("0824937125", "0994871623", "Juan Pérez", "Calle Los Álamos  N45-180, La Floresta, Guayas", TipoCliente.PERSONAL));
        gc.agregarPersona(new Cliente("0637592816001", "0912748690", "Empresa XYZ", "Calle 12 de Octubre E6-320, Edificio Torre Azul, Guayas", TipoCliente.EMPRESA));
        gc.agregarPersona(new Cliente("0741068357", "0931820475", "María Gómez", "Av. El Inca Oe7-221, Urbanización Naranjos, Guayas", TipoCliente.PERSONAL));
        gc.agregarPersona(new Cliente("0519283742001", "0975086214", "Constructora Delta", "Pasaje San Martín S3-115, Pinar Alto, Guayas", TipoCliente.EMPRESA));
        gc.agregarPersona(new Cliente("0927593816001", "0975086214", "Grupo HG S.A", "Calle Robles N12-45, Urbanización La Colina, Guayas", TipoCliente.EMPRESA));

        // Agregar servicios
        gs.agregarServicio(new Servicio("Cambio de aceite", 50.0, LocalDate.of(2024, 7, 15)));
        gs.agregarServicio(new Servicio("Cambio de llantas", 20.0, LocalDate.of(2024, 7, 15)));
        gs.agregarServicio(new Servicio("Alineación y balanceo", 35.0, LocalDate.of(2024, 7, 15)));
        gs.agregarServicio(new Servicio("Lavado de motor en seco ", 30.0, LocalDate.of(2024, 7, 15)));
        gs.agregarServicio(new Servicio("Revisión de frenos", 45.0, LocalDate.of(2024, 7, 15)));
        gs.agregarServicio(new Servicio("Diagnóstico electrónico", 60.0, LocalDate.of(2024, 7, 15)));

        // Agregar técnicos
        gt.agregarPersona(new Tecnico("0458926173", "0967812049", "Carlos López", "Mecánico general"));
        gt.agregarPersona(new Tecnico("0367819402", "0924031687", "Andrea Ramírez", "Especialista en suspensión"));

        // Agregar proveedores
        gp.agregarPersona(new Proveedor("0741067125001", "0954728136", "Filtros y Accesorios", "AutoFrenos Quito"));
        gp.agregarPersona(new Proveedor("0824992816001", "0973461820", "Distribuidora Eléctrica", "TecnoVolt Guayaquil"));

        // Agregar ordenes
        ArrayList<DetalleServicio> servicios = new ArrayList<>();
        servicios.add(new DetalleServicio(gs.buscarServicio(2), 4));
        servicios.add(new DetalleServicio(gs.buscarServicio(1), 1));
        servicios.add(new DetalleServicio(gs.buscarServicio(4), 1));

        go.agregarOrden(new Orden(gc.buscarPersona("0927593816001"), gt.buscarPersona("0367819402"), LocalDate.of(2025, 5, 14), new Vehiculo("GUB-1603", TipoVehiculo.BUS), servicios));

        servicios.set(0, new DetalleServicio(gs.buscarServicio(2), 2));
        servicios.set(1, new DetalleServicio(gs.buscarServicio(1), 1));
        servicios.remove(2);

        go.agregarOrden(new Orden(gc.buscarPersona("0824937125"), gt.buscarPersona("0367819402"), LocalDate.of(2025, 7, 24), new Vehiculo("Gk195P", TipoVehiculo.MOTOCICLETA), servicios));

        servicios.set(0, new DetalleServicio(gs.buscarServicio(5), 2));
        servicios.set(1, new DetalleServicio(gs.buscarServicio(1), 1));
        servicios.add(new DetalleServicio(gs.buscarServicio(4), 1));

        go.agregarOrden(new Orden(gc.buscarPersona("0741068357"), gt.buscarPersona("0458926173"), LocalDate.of(2025, 7, 24), new Vehiculo("Ghc-1856", TipoVehiculo.AUTO), servicios));

        servicios.set(0, new DetalleServicio(gs.buscarServicio(6), 2));
        servicios.set(1, new DetalleServicio(gs.buscarServicio(1), 1));
        servicios.add(new DetalleServicio(gs.buscarServicio(2), 4));

        servicios.remove(2);

        go.agregarOrden(new Orden(gc.buscarPersona("0637592816001"), gt.buscarPersona("0458926173"), LocalDate.of(2025, 7, 24), new Vehiculo("Gpo575l", TipoVehiculo.MOTOCICLETA), servicios));
    }
}
