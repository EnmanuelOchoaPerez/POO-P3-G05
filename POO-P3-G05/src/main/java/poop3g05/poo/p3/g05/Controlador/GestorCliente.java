/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;
import poop3g05.poo.p3.g05.Modelo.Cliente;

/**
 *
 * @author Rafael Cosmo
 */
import poop3g05.poo.p3.g05.Modelo.TipoCliente;

public class GestorCliente extends GestorUsuario<Cliente> {

    public void editarTipoCliente(String id, TipoCliente tipo) {
        ((Cliente) buscarUsuario(id)).setTipoCliente(tipo);
    }

    public void editarDireccionCliente(String id, String direccioNueva) {
        ((Cliente) buscarUsuario(id)).setDireccion(direccioNueva);
    }
}
