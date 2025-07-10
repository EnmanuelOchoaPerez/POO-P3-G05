/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

/**
 *
 * @author Rafael Cosmo
 */

import poop3g05.poo.p3.g05.Modelo.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorOrden {
    private List<Orden> ordenes = new ArrayList<>();

    public void crearOrden(Orden orden) {
        ordenes.add(orden);
    }

    public Orden buscarOrden(int id) {
        for (Orden orden : ordenes) {
            if (orden.getId() == id) {
                return orden;
            }
        }
        return null;
    }

    public List<Orden> getOrdenes() {
        return new ArrayList<>(ordenes);
    }
}
