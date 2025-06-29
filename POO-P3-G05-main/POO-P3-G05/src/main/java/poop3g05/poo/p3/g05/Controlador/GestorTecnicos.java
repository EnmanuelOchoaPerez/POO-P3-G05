/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

/**
 *
 * @author Rafael Cosmo
 */

import poop3g05.poo.p3.g05.Modelo.Tecnico;
import java.util.ArrayList;
import java.util.List;

public class GestorTecnicos {
    private List<Tecnico> tecnicos = new ArrayList<>();
    private int nextId = 1;

    public void agregarTecnico(Tecnico tecnico) {
        tecnico.setId(nextId++);
        tecnicos.add(tecnico);
    }

    public Tecnico buscarTecnico(int id) {
        for (Tecnico tecnico : tecnicos) {
            if (tecnico.getId() == id) {
                return tecnico;
            }
        }
        return null;
    }

    public List<Tecnico> getTecnicos() {
        return new ArrayList<>(tecnicos);
    }
}
