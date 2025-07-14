/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

import java.util.ArrayList;
import poop3g05.poo.p3.g05.Modelo.Insumo;

/**
 * Controlador encargado de gestionar los insumos utilizados en el sistema.
 * Lleva el registro de todos los insumos registrados.
 * 
 * @author Enmanuel
 */
public class GestorInsumo {

    /**
     * Lista que almacena todos los insumos registrados en el sistema.
     */
    private final ArrayList<Insumo> insumos;

    /**
     * Constructor por defecto que inicializa la lista de insumos. Esta clase
     * está destinada a instanciarse una única vez en el método inicializarApp
     * de la clase SistemaPrincipal.
     */
    public GestorInsumo() {
        this.insumos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo insumo al registro del sistema.
     *
     * @param insumo instancia de Insumo a registrar
     */
    public void agregarInsumo(Insumo insumo) {
        insumos.add(insumo);
    }
}