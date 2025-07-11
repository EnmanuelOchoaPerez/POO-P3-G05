/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

/**
 *
 * @author Rafael Cosmo
 */
import java.util.ArrayList;
import java.util.Date;

public class Orden {

    private String idCliente;
    private Date fechaServicio;
    private Vehiculo vehiculo;
    private ArrayList<DetalleServicio> servicios;
    private double total;

    public Orden(String id, Date fecha, Vehiculo vehiculo, ArrayList<DetalleServicio> servicios) {
        this.idCliente = id;
        this.fechaServicio = fecha;
        this.vehiculo = vehiculo;
        this.servicios = servicios;
        this.total = this.calcularTotal();
    }
    
    private double calcularTotal() {
        double total = 0;
        for (DetalleServicio s : servicios) {
            total += s.calcularSubtotal();
        }
        return total;
    }
    // Getters y Setters
    public String getIdCliente() {
        return idCliente;
    }

    public double getTotal() {
        return total;
    }
    
    public Date getFechaServicio() {
        return fechaServicio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public ArrayList<DetalleServicio> getServicios() {
        return servicios;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha :");
        sb.append("").append(fechaServicio);
        sb.append("; ").append(vehiculo);
        sb.append("; ").append(servicios);
        sb.append("\nTotal = ").append(total);
        return sb.toString();
    }
    
}
