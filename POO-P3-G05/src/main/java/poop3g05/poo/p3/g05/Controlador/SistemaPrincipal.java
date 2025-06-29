/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

/**
 *
 * @author Rafael Cosmo
 */
import poop3g05.poo.p3.g05.Modelo.*;

import poop3g05.poo.p3.g05.Vista.Menu;

public class SistemaPrincipal {

    public static void main(String[] args) {
        GestorClientes gestorClientes = new GestorClientes();
        GestorServicios gestorServicios = new GestorServicios();
        GestorTecnicos gestorTecnicos = new GestorTecnicos();
        GestorOrdenes gestorOrdenes = new GestorOrdenes();
        GestorFacturas gestorFacturas = new GestorFacturas();

        // Datos de prueba
        inicializarApp(gestorClientes, gestorServicios, gestorTecnicos);

        Menu.mostrarMenuPrincipal(
                gestorClientes,
                gestorServicios,
                gestorTecnicos,
                gestorOrdenes,
                gestorFacturas
        );
    }

    private static void inicializarApp(
            GestorClientes gc,
            GestorServicios gs,
            GestorTecnicos gt
    ) {
        // Agregar clientes
        gc.agregarCliente(new Cliente("Juan Pérez", "0994871623", TipoCliente.PERSONAL));
        gc.agregarCliente(new Cliente("Empresa XYZ", "0912748690", TipoCliente.EMPRESA));
        gc.agregarCliente(new Cliente("María Gómez", "0931820475", TipoCliente.PERSONAL));
        gc.agregarCliente(new Cliente("Constructora Delta", "0975086214", TipoCliente.EMPRESA));

        // Agregar servicios
        gs.agregarServicio(new Servicio("Cambio de aceite", 50.0));
        gs.agregarServicio(new Servicio("Cambio de llantas", 20.0));
        gs.agregarServicio(new Servicio("Alineación y balanceo", 35.0));
        gs.agregarServicio(new Servicio("Lavado de motor en seco ", 30.0));
        gs.agregarServicio(new Servicio("Revisión de frenos", 45.0));
        gs.agregarServicio(new Servicio("Diagnóstico electrónico", 60.0));

        // Agregar técnicos
        gt.agregarTecnico(new Tecnico("0967812049", "Carlos López", "Mecánico general"));
        gt.agregarTecnico(new Tecnico("0924031687", "Andrea Ramírez", "Especialista en suspensión"));
        
//        new Proveedor("Filtros y Accesorios", "0954728136", "AutoFrenos Quito");
//        new Proveedor("Distribuidora Eléctrica", "0973461820", "TecnoVolt Guayaquil");

    }
}
/*

*/
