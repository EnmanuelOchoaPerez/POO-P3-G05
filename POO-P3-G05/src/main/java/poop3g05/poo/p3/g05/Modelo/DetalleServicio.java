/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

/**
 *
 * @author Rafael Cosmo
 */


public class DetalleServicio {
    private Servicio servicio;
    private int cantidad;

    public DetalleServicio(Servicio servicio, int cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return servicio.getPrecio() * cantidad;
    }

    // Getters y Setters
    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(servicio);
        sb.append(" x ").append(cantidad);
        sb.append(" = ").append(servicio.getPrecio()*cantidad);
        return sb.toString();
    }
    
}
