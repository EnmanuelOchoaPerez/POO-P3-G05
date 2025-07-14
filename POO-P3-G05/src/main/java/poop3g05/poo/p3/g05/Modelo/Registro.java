/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta calse almacena el registro de precios de los diferentes servicios asi
 * como las fechas en que se fijaron dichos precios.
 *
 * @author Enmanuel
 */
public class Registro {

    /**
     * Estos 2 arreglos paralelos son el registro de precios con su respectiva
     * fecha de modificacion.
     */
    private ArrayList<Double> precios;
    private ArrayList<LocalDate> fechas;

    /**
     * Este es el constructor de la clase donde se inicializan los arreglos
     * y se añaden el primer precio del servicio y la fecha de creacion del mismo
     * @param precio
     * @param fecha
     */
    public Registro(double precio, LocalDate fecha) {
        this.precios = new ArrayList<Double>();
        this.fechas = new ArrayList<LocalDate>();
        this.precios.add(precio);
        this.fechas.add(fecha);
    }

    /**
     * Getters y Setters necesarios para la clase en el sisitema.
     */

    public ArrayList<Double> getPrecios() {
        return precios;
    }

    public ArrayList<LocalDate> getFechas() {
        return fechas;
    }

    public void setFechas(LocalDate fecha) {
        this.fechas.add(fecha);
    }

    public void setPrecios(double precio) {
        this.precios.add(precio);
    }
}
