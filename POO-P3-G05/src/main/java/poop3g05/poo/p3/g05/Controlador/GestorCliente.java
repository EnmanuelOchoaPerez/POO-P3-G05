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

/**
 * Clase que representa el controlador especializado para objetos de tipo
 * Cliente. Hereda de GestorPersona y extiende la lógica para manejar atributos
 * y operaciones específicas de los clientes, como tipo y dirección.
 * 
 * Esta clase está destinada a centralizar y gestionar la lógica relacionada con
 * clientes registrados en el sistema.
 * 
 * @author Rafael Cosmo
 */
public class GestorCliente extends GestorPersona<Cliente> {

    /**
     * Sobrescribe el método de búsqueda de Persona para retornar específicamente
     * instancias de tipo Cliente, o null si el ID no pertenece a un Cliente.
     *
     * @param id identificador del cliente a buscar
     * @return instancia de Cliente si se encuentra, de lo contrario null
     */
    @Override
    public Cliente buscarPersona(String id) {
        if (!(super.buscarPersona(id) instanceof Cliente cliente)) {
            return null;
        }
        return cliente;
    }

    /**
     * Modifica el tipo de cliente (PERSONAL o EMPRESA) del cliente con el ID dado.
     *
     * @param id identificador del cliente a editar
     * @param tipo nuevo tipo de cliente a asignar
     */
    public void editarTipoCliente(String id, TipoCliente tipo) {
        ((Cliente) buscarPersona(id)).setTipoCliente(tipo);
    }

    /**
     * Modifica la dirección del cliente con el ID dado.
     *
     * @param id identificador del cliente a editar
     * @param direccioNueva nueva dirección a asignar
     */
    public void editarDireccionCliente(String id, String direccioNueva) {
        ((Cliente) buscarPersona(id)).setDireccion(direccioNueva);
    }

    /**
     * Verifica si el cliente proporcionado es del tipo EMPRESA.
     *
     * @param cliente cliente a evaluar
     * @return true si el cliente es de tipo EMPRESA, false en caso contrario
     */
    public boolean trueEmpresa(Cliente cliente) {
        return TipoCliente.EMPRESA.equals(cliente.getTipoCliente());
    }
}