/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

/**
 *
 * @author Rafael Cosmo
 */
import poop3g05.poo.p3.g05.Modelo.Cliente;
import poop3g05.poo.p3.g05.Modelo.DetalleServicio;
import poop3g05.poo.p3.g05.Modelo.Factura;
import java.util.ArrayList;
import java.util.Date;

public class GestorFactura {
    private final ArrayList<Factura> facturas;
    private int nextId = 1;

    public GestorFactura() {
        this.facturas = new ArrayList<>();
    }

    public Factura generarFactura(Cliente cliente, ArrayList<DetalleServicio> detalles) {
        Factura factura = new Factura(nextId++, new Date(), cliente, detalles);
        facturas.add(factura);
        return factura;
    }

    public Factura buscarFactura(int id) {
        for (Factura factura : facturas) {
            if (factura.getId() == id) {
                return factura;
            }
        }
        return null;
    }

    public ArrayList<Factura> getFacturas() {
        return new ArrayList<>(facturas);
    }
}