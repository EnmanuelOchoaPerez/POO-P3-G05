/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

import java.time.YearMonth;
import java.util.ArrayList;

/**
 * Esta clase representa una factura generada para una empresa por los servicios
 * prestados durante un mes específico. Contiene la fecha, cliente, las órdenes
 * asociadas y el total a pagar, incluyendo una tarifa de membresia que
 * solo pagan las empresas por tener prioridad y por el servicio de facturacion.
 * 
 * @author Rafael Cosmo
 */
public class Factura {

    /**
     * Atributos de la factura:
     * - fecha: mes y año al que corresponde la factura.
     * - cliente: cliente al que se le genera la factura.
     * - ordenes: lista de órdenes realizadas por el cliente en ese período.
     * - total: monto total de la factura (suma de órdenes + tarifa base).
     */
    private YearMonth fecha;
    private Cliente cliente;
    private ArrayList<Orden> ordenes;
    private double total;

    /**
     * Constructor que inicializa la factura con la fecha, el cliente y sus órdenes,
     * y calcula automáticamente el total de la factura.
     *
     * @param fecha 
     * @param cliente
     * @param ordenes
     */
    public Factura(YearMonth fecha, Cliente cliente, ArrayList<Orden> ordenes) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.ordenes = ordenes;
        calcularTotal();
    }

    /**
     * Método privado que calcula el total de la factura sumando una tarifa base
     * de 50 unidades más el total de cada orden incluida.
     * Este metodo esta destinado a ser usado unicamente en el constructor.
     * 
     */
    private void calcularTotal() {
        total = 50;
        for (Orden orden : ordenes) {
            total += orden.getTotal();
        }
    }

    /**
     * Getters necesarios para acceder a los datos de la factura.
     * Esta clase no necesita setters.
     *
     * @return los valores de fecha, cliente, órdenes y total
     */
    public YearMonth getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }

    public double getTotal() {
        return total;
    }
}