/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

import poop3g05.poo.p3.g05.Modelo.Proveedor;

/**
 * Clase que representa el controlador especializado para objetos de tipo
 * Proveedor. Hereda de GestorPersona y extiende la funcionalidad para permitir
 * la edición de atributos propios de los proveedores registrados en el sistema.
 * 
 * Está diseñada para centralizar la lógica asociada a la gestión de proveedores.
 * 
 * @author Enmanuel
 */
public class GestorProveedor extends GestorPersona<Proveedor> {

    /**
     * Modifica la descripción del proveedor identificado por el ID dado.
     *
     * @param id identificador del proveedor a editar
     * @param descripcion nueva descripción a asignar
     */
    public void editarDescripcionProveedor(String id, String descripcion) {
        ((Proveedor) personas.get(personas.indexOf(buscarPersona(id)))).setDescripcion(descripcion);
    }
}