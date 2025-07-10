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
    private int id;
    private Date fecha;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private ArrayList<DetalleServicio> servicios;
    private Tecnico tecnico;
    private String estado;

    public Orden(int id, Date fecha, Cliente cliente, Vehiculo vehiculo, 
                ArrayList<DetalleServicio> servicios, Tecnico tecnico) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.servicios = servicios;
        this.tecnico = tecnico;
        this.estado = "Pendiente";
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public ArrayList<DetalleServicio> getServicios() { return servicios; }
    public void setServicios(ArrayList<DetalleServicio> servicios) { this.servicios = servicios; }
    public Tecnico getTecnico() { return tecnico; }
    public void setTecnico(Tecnico tecnico) { this.tecnico = tecnico; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
