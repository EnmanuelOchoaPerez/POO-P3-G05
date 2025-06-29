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
import java.util.List;

public class GestorServicios {
    private List<Servicio> servicios = new ArrayList<>();
    private int nextId = 1;

    public void agregarServicio(Servicio servicio) {
        servicio.setId(nextId++);
        servicios.add(servicio);
    }

    public Servicio buscarServicio(int id) {
        for (Servicio servicio : servicios) {
            if (servicio.getId() == id) {
                return servicio;
            }
        }
        return null;
    }

    public List<Servicio> getServicios() {
        return new ArrayList<>(servicios);
    }
}
