/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

/**
 *
 * @author Rafael Cosmo
 */

public class Tecnico extends Usuario{

    private String especialidad;

    public Tecnico(String id, String telefono, String nombre, String especialidad) {
        super(id, telefono, nombre);
        this.especialidad = especialidad;
    }

    // Getters y Setters

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tecnico : ");
        sb.append(super.toString());
        sb.append(", ").append(especialidad);
        return sb.toString();
    }
}
