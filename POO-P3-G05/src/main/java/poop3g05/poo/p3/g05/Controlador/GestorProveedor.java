/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

/**
 *
 * @author Enmanuel
 */
import poop3g05.poo.p3.g05.Modelo.Proveedor;

public class GestorProveedor extends GestorUsuario<Proveedor> {
    public void editarDescripcionProveedor(String id, String descripcion) {
        ((Proveedor)usuarios.get(usuarios.indexOf(buscarUsuario(id)))).setDescripcion(descripcion);
    }
}

