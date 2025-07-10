/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

/**
 *
 * @author Rafael Cosmo
 */
public class Proveedor extends Usuario {

    private String descripcion;

    public Proveedor(String id, String contacto, String username, String descripcion) {
        super(id, contacto, username);
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getContacto() {
        return super.getTelefono();
    }

    public void setContacto(String contacto) {
        super.setTelefono(contacto);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proveedor : ");
        sb.append(super.toString());
        sb.append(", ").append(descripcion);
        return sb.toString();
    }
}
