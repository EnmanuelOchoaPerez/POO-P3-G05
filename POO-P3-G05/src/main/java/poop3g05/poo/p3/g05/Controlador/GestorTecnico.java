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

public class GestorTecnico extends GestorUsuario<Tecnico> {

    public void editarEspecialidadTecnico(String id, String especialidad) {
        ((Tecnico) usuarios.get(usuarios.indexOf(buscarUsuario(id)))).setEspecialidad(especialidad);
    }

    public void eliminarTecnico(String id) {
        usuarios.remove(buscarUsuario(id));
    }

}
