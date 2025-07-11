/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

/**
 *
 * @author Rafael Cosmo
 */

import poop3g05.poo.p3.g05.Modelo.Servicio;
import java.util.ArrayList;

public class GestorServicio {
    private final ArrayList<Servicio> servicios;

    public GestorServicio() {
        this.servicios = new ArrayList<>();
    }

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public Servicio buscarServicio(int id) {
        for (Servicio servicio : servicios) {
            if (servicio.getCodigo()== id) {
                return servicio;
            }
        }
        return null;
    }

    public ArrayList<Servicio> getServicios() {
        return new ArrayList<>(servicios);
    }
    
    
    public void editarPrecioServicio(int id, double nuevoPrecio) {
                buscarServicio(id).setPrecio(nuevoPrecio);
    }
}
