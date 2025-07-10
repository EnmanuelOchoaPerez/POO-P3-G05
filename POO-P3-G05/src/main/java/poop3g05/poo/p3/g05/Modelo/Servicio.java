/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

/**
 *
 * @author Rafael Cosmo
 */
import java.util.List;

public class Servicio {

    private static int contadorId = 1;
    private int codigo;
    private String nombre;
    private double precio;
    private List<Insumo> insumos;

    public Servicio(String nombre, double precio) {
        this.codigo = contadorId++;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Servicio : ");
        sb.append("").append(codigo);
        sb.append(", ").append(nombre);
        sb.append(", $").append(precio);
        return sb.toString();
    }
}
