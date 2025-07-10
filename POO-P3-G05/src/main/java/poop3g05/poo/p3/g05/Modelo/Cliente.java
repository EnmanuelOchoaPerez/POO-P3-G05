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
    private String direccion;

    public Cliente(String id, String telefono, String nombre, String direccion, TipoCliente tipoCliente) {
        super(id, telefono, nombre);
        this.tipoCliente = tipoCliente;
        this.direccion = direccion;
    }

    // Getters y Setters
    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente : ");
        sb.append(super.toString());
        sb.append(", ").append(direccion);
        sb.append(", ").append(tipoCliente);
        return sb.toString();
    }
}
