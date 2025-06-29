/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

/**
 *
 * @author Rafael Cosmo
 */

public class Proveedor extends Usuario{

    private String descripcion;

    public Proveedor(String descripcion, String telefono, String username) {
        super(telefono, username);
        this.descripcion = descripcion;
    }
    
    // Getters y Setters
    
    public String getContacto() { return telefono; }
    public void setContacto(String contacto) { this.telefono = contacto; }
}