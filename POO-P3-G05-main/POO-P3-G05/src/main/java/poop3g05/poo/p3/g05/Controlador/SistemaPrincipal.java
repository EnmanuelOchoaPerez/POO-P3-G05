/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

/**
 *
 * @author Rafael Cosmo
 */

import poop3g05.poo.p3.g05.Modelo.Cliente;
import poop3g05.poo.p3.g05.Modelo.Servicio;
import poop3g05.poo.p3.g05.Modelo.Tecnico;
import poop3g05.poo.p3.g05.Modelo.TipoCliente;
import poop3g05.poo.p3.g05.Vista.Menu;

public class SistemaPrincipal {
    public static void main(String[] args) {
        GestorClientes gestorClientes = new GestorClientes();
        GestorServicios gestorServicios = new GestorServicios();
        GestorTecnicos gestorTecnicos = new GestorTecnicos();
        GestorOrdenes gestorOrdenes = new GestorOrdenes();
        GestorFacturas gestorFacturas = new GestorFacturas();
        
        // Datos de prueba
        inicializarDatos(gestorClientes, gestorServicios, gestorTecnicos);
        
        Menu.mostrarMenuPrincipal(
            gestorClientes, 
            gestorServicios, 
            gestorTecnicos, 
            gestorOrdenes, 
            gestorFacturas
        );
    }
    
    private static void inicializarDatos(
        GestorClientes gc, 
        GestorServicios gs,
        GestorTecnicos gt
    ) {
        // Agregar clientes
        gc.agregarCliente(new Cliente(1, "Juan Pérez", TipoCliente.PERSONA_NATURAL));
        gc.agregarCliente(new Cliente(2, "Empresa XYZ", TipoCliente.EMPRESA));
        
        // Agregar servicios
        gs.agregarServicio(new Servicio(1, "Cambio de aceite", 50.0));
        gs.agregarServicio(new Servicio(2, "Rotación de llantas", 30.0));
        
        // Agregar técnicos
        gt.agregarTecnico(new Tecnico(1, "Carlos López", "Mecánico general"));
    }
}