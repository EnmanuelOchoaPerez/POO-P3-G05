/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

import poop3g05.poo.p3.g05.Modelo.Usuario;

/**
 *
 * @author Rafael Cosmo
 */

public class Cliente {
    private int id;
    private String nombre;
    private TipoCliente tipoCliente;

    public Cliente(int id, String nombre, TipoCliente tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public TipoCliente getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(TipoCliente tipoCliente) { this.tipoCliente = tipoCliente; }
    
    @Override
    public String toString() {
        return nombre + " (" + tipoCliente + ")";
    }
}