/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

/**
 *
 * @author Rafael Cosmo
 */

public class Cliente extends Usuario {

    private TipoCliente tipoCliente;

    public Cliente(String nombre, String telefono, TipoCliente tipoCliente) {
        super(telefono, nombre);
        this.tipoCliente = tipoCliente;
    }

    // Getters y Setters
    public TipoCliente getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(TipoCliente tipoCliente) { this.tipoCliente = tipoCliente; }
    
    @Override
    public String toString() {
        return username + " (" + tipoCliente + ")";
    }
}