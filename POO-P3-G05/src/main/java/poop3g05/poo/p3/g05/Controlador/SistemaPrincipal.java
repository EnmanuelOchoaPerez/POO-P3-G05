/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

/**
 *
 * @author Rafael Cosmo
 */
//Para este avance no estan implementadas la mayoria de funcionalidades de la aplicacion. Gracias por la comprension
import poop3g05.poo.p3.g05.Modelo.*;

import poop3g05.poo.p3.g05.Vista.Menu;

public class SistemaPrincipal {

    public static void main(String[] args) {
        GestorCliente gestorClientes = new GestorCliente();
        GestorServicio gestorServicios = new GestorServicio();
        GestorTecnico gestorTecnicos = new GestorTecnico();
        GestorOrden gestorOrdenes = new GestorOrden();
        GestorFactura gestorFacturas = new GestorFactura();
        GestorProveedor gestorProveedor = new GestorProveedor();

        // Datos de prueba
        inicializarApp(gestorClientes, gestorServicios, gestorTecnicos,gestorProveedor);

        Menu.mostrarMenuPrincipal(
                gestorClientes,
                gestorServicios,
                gestorTecnicos,
                gestorOrdenes,
                gestorFacturas,
                gestorProveedor
        );
    }

    private static void inicializarApp(
            GestorCliente gc,
            GestorServicio gs,
            GestorTecnico gt,
            GestorProveedor gp
    ) {
        // Agregar clientes
        gc.agregarUsuario(new Cliente("0824937125001", "0994871623", "Juan Pérez", "direccion", TipoCliente.PERSONAL));
        gc.agregarUsuario(new Cliente("0637592816001", "0912748690", "Empresa XYZ", "direccion", TipoCliente.EMPRESA));
        gc.agregarUsuario(new Cliente("0741068357", "0931820475", "María Gómez", "direccion", TipoCliente.PERSONAL));
        gc.agregarUsuario(new Cliente("0519283742001", "0975086214", "Constructora Delta", "direccion", TipoCliente.EMPRESA));

        // Agregar servicios
        gs.agregarServicio(new Servicio("Cambio de aceite", 50.0));
        gs.agregarServicio(new Servicio("Cambio de llantas", 20.0));
        gs.agregarServicio(new Servicio("Alineación y balanceo", 35.0));
        gs.agregarServicio(new Servicio("Lavado de motor en seco ", 30.0));
        gs.agregarServicio(new Servicio("Revisión de frenos", 45.0));
        gs.agregarServicio(new Servicio("Diagnóstico electrónico", 60.0));

        // Agregar técnicos
        gt.agregarUsuario(new Tecnico("0458926173", "0967812049", "Carlos López", "Mecánico general"));
        gt.agregarUsuario(new Tecnico("0367819402", "0924031687", "Andrea Ramírez", "Especialista en suspensión"));


        // Agregar proveedores
        gp.agregarUsuario(new Proveedor("0741067125001", "0954728136","Filtros y Accesorios", "AutoFrenos Quito"));
        gp.agregarUsuario(new Proveedor("0824992816001", "0973461820","Distribuidora Eléctrica", "TecnoVolt Guayaquil"));
    }
}
