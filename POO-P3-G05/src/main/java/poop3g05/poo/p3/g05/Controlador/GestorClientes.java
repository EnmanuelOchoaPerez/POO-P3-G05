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
import java.util.ArrayList;
import java.util.List;

public class GestorClientes {
    private List<Cliente> clientes = new ArrayList<>();
    private int nextId = 1;

    public void agregarCliente(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
    }

    public Cliente buscarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }
}