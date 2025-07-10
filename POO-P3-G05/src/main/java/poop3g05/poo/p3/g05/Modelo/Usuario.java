/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

/**
 *
 * @author Rafael Cosmo
 */
public abstract class Usuario {
    protected String id;
    protected String telefono;
    protected String username;

    public Usuario(String id,String telefono, String username) {
        this.id = id;
        this.telefono = telefono;
        this.username = username;
    }
    

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(", ").append(username);
        sb.append(", ").append(telefono);
        return sb.toString();
    }

}
