/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

import java.util.ArrayList;
import poop3g05.poo.p3.g05.Modelo.Persona;

/**
 * Clase de tipo Controlador que sirve como clase padre para los demás
 * controladores asociados a la clase Persona. Esta clase es la encargada de
 * llevar el registro de todos los tipos de "Persona" en el sistema, así como la
 * lógica de negocio general relacionada.
 *
 * @author Enmanuel
 * @param <U> tipo de persona que hereda de la clase Persona
 */
public class GestorPersona<U extends Persona> {

    /**
     * Lista general de personas registrados en el sistema, sin importar su
     * tipo.
     */
    protected final ArrayList<Persona> personas;

    /**
     * Constructor por defecto que inicializa la lista de personas. Este
     * constructor esta destinado a instanciar la clase una unica vez en el
     * metodo inicializarApp del clase SistemaPrincipal.
     */
    public GestorPersona() {
        this.personas = new ArrayList<>();
    }

    /**
     * Agrega una nueva instancia de alguna clase que esxtienda de (Persona) a
     * la lista de personas.
     *
     * @param persona instancia de Persona a registrar
     */
    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    /**
     * Busca y retorna una persona que este en la lista según su ID.
     *
     * @param id identificador único de la persona
     * @return la Persona con el ID correspondiente o null si no se encuentra.
     */
    public Persona buscarPersona(String id) {
        for (Persona persona : personas) {
            if (persona.getId().equals(id)) {
                return persona;
            }
        }
        return null;
    }

    /**
     * Retorna una copia de la lista actual de personas registrados.
     *
     * @return lista de personas registrados
     */
    public ArrayList<Persona> getPersonas() {
        return new ArrayList<>(personas);
    }

    /**
     * Edita el nombre de una persona existente en el sistema.
     *
     * @param id ID de la persona a editar
     * @param nombreNuevo nuevo nombre o username a asignar
     */
    public void editarNombre(String id, String nombreNuevo) {
        personas.get(personas.indexOf(buscarPersona(id))).setUsername(nombreNuevo);
    }

    /**
     * Edita el teléfono de un persona existente en el sistema.
     *
     * @param id ID del persona a modificar
     * @param telefono nuevo número de teléfono a asignar
     */
    public void editarTelefono(String id, String telefono) {
        personas.get(personas.indexOf(buscarPersona(id))).setTelefono(telefono);
    }
}
