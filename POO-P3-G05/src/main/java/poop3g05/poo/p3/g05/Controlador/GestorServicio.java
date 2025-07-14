/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

import java.time.LocalDate;
import poop3g05.poo.p3.g05.Modelo.Servicio;
import java.util.ArrayList;

/**
 * Controlador encargado de gestionar los servicios disponibles en el sistema.
 * Permite registrar nuevos servicios, buscarlos por su código, editarlos y
 * acceder a la lista general.
 * 
 * Esta clase está destinada a instanciarse una única vez en el método
 * {@code inicializarApp} de la clase {@code SistemaPrincipal}.
 * 
 * @author Rafael Cosmo
 */
public class GestorServicio {

    /**
     * Lista que almacena todos los servicios registrados en el sistema.
     */
    private final ArrayList<Servicio> servicios;

    /**
     * Constructor por defecto que inicializa la lista de servicios.
     * Esta clase debe ser instanciada una única vez desde el método
     * {@code inicializarApp} de la clase {@code SistemaPrincipal}.
     */
    public GestorServicio() {
        this.servicios = new ArrayList<>();
    }

    /**
     * Agrega un nuevo servicio al registro del sistema.
     *
     * @param servicio instancia de Servicio a registrar
     */
    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    /**
     * Busca y retorna un servicio registrado según su código.
     *
     * @param id código único del servicio
     * @return el Servicio correspondiente o null si no se encuentra
     */
    public Servicio buscarServicio(int id) {
        for (Servicio servicio : servicios) {
            if (servicio.getCodigo() == id) {
                return servicio;
            }
        }
        return null;
    }

    /**
     * Retorna una copia de la lista de servicios registrados en el sistema.
     *
     * @return lista de servicios registrados
     */
    public ArrayList<Servicio> getServicios() {
        return new ArrayList<>(servicios);
    }

    /**
     * Edita el precio de un servicio específico y registra la fecha de
     * modificación.
     *
     * @param id código del servicio a modificar
     * @param nuevoPrecio nuevo valor del servicio
     * @param fecha fecha en que se realiza la modificación
     */
    public void editarPrecioServicio(int id, double nuevoPrecio, LocalDate fecha) {
        buscarServicio(id).setPrecio(nuevoPrecio, fecha);
    }
}
