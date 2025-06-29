/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

/**
 *
 * @author Rafael Cosmo
 */

import java.util.Date;
import java.util.List;

public class Factura {
    private int id;
    private Date fecha;
    private Cliente cliente;
    private List<DetalleServicio> detalles;
    private double total;

    public Factura(int id, Date fecha, Cliente cliente, List<DetalleServicio> detalles) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalles = detalles;
        calcularTotal();
    }

    private void calcularTotal() {
        total = 0;
        for (DetalleServicio detalle : detalles) {
            total += detalle.calcularSubtotal();
        }
    }

    // Getters
    public int getId() { return id; }
    public Date getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    public List<DetalleServicio> getDetalles() { return detalles; }
    public double getTotal() { return total; }
}
