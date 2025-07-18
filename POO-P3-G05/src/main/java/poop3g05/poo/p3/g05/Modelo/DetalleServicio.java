/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

/**
 * Esta clase representa el detalle de un servicio realizado,
 * incluyendo el servicio específico y la cantidad de veces que se aplicó.
 * También se encarga de actualizar el recaudo total del servicio.
 * 
 * @author Rafael Cosmo
 */
public class DetalleServicio {

    /**
     * Servicio al que corresponde este detalle.
     */
    private Servicio servicio;

    /**
     * Cantidad de veces que se realizó el servicio.
     */
    private int cantidad;

    /**
     * Constructor que inicializa el detalle con un servicio y su cantidad,
     * y actualiza el recaudo total del servicio en base al subtotal.
     *
     * @param servicio servicio aplicado
     * @param cantidad número de veces que se realizó el servicio
     */
    public DetalleServicio(Servicio servicio, int cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.servicio.setRecaudo(calcularSubtotal());
    }

    /**
     * Calcula el subtotal del servicio según su precio y cantidad aplicada.
     *
     * @return subtotal del servicio
     */
    public double calcularSubtotal() {
        return servicio.getPrecio() * cantidad;
    }

    /**
     * Getters necesarios para la clase en el sistema.
     *
     * @return el servicio asociado o la cantidad
     */
    public Servicio getServicio() {
        return servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    /**
     * Representación en texto del detalle del servicio, incluyendo la cantidad,
     * el servicio y el total calculado.
     *
     * @return detalle formateado del servicio
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(servicio);
        sb.append(" x ").append(cantidad);
        sb.append(" = ").append(servicio.getPrecio() * cantidad);
        return sb.toString();
    }
}