/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

import poop3g05.poo.p3.g05.Modelo.Tecnico;

/**
 * Clase que representa el controlador especializado para objetos de tipo
 * Tecnico. Hereda de GestorPersona y extiende la funcionalidad para permitir
 * operaciones relacionadas con técnicos registrados en el sistema, como editar
 * su especialidad o eliminarlos del registro.
 * 
 * Esta clase centraliza la lógica asociada a la gestión de técnicos.
 * 
 * @author Rafael Cosmo
 */
public class GestorTecnico extends GestorPersona<Tecnico> {

    /**
     * Sobrescribe el método de búsqueda de Persona para retornar específicamente
     * instancias de tipo Tecnico, o null si el ID no pertenece a un técnico.
     *
     * @param id identificador del técnico a buscar
     * @return instancia de Tecnico si se encuentra, de lo contrario null
     */
    @Override
    public Tecnico buscarPersona(String id) {
        if (!(super.buscarPersona(id) instanceof Tecnico tecnico)) {
            return null;
        }
        return tecnico;
    }

    /**
     * Modifica la especialidad del técnico con el ID dado.
     *
     * @param id identificador del técnico a editar
     * @param especialidad nueva especialidad a asignar
     */
    public void editarEspecialidadTecnico(String id, String especialidad) {
        ((Tecnico) personas.get(personas.indexOf(buscarPersona(id)))).setEspecialidad(especialidad);
    }

    /**
     * Elimina del sistema al técnico identificado por el ID dado.
     *
     * @param id identificador del técnico a eliminar
     */
    public void eliminarTecnico(String id) {
        personas.remove(buscarPersona(id));
    }
}
