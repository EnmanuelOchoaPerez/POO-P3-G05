/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

import java.time.YearMonth;
import java.util.ArrayList;
import poop3g05.poo.p3.g05.Modelo.Cliente;
import poop3g05.poo.p3.g05.Modelo.Orden;
/**
 * Controlador encargado de gestionar las órdenes de servicio registradas
 * en el sistema. Permite agregar órdenes, filtrarlas por periodo y empresa,
 * verificar si un cliente tiene órdenes, y calcular ingresos.
 * 
 * Esta clase está destinada a instanciarse una única vez en el método
 * {@code inicializarApp} de la clase {@code SistemaPrincipal}.
 * 
 * @author Rafael Cosmo
 */
public class GestorOrden {

    /**
     * Lista que almacena todas las órdenes de servicio registradas en el sistema.
     */
    private final ArrayList<Orden> ordenes;

    /**
     * Constructor por defecto que inicializa la lista de órdenes. Esta clase
     * está destinada a instanciarse una única vez en el método
     * {@code inicializarApp} de la clase {@code SistemaPrincipal}.
     */
    public GestorOrden() {
        this.ordenes = new ArrayList<>();
    }

    /**
     * Agrega una nueva orden de servicio al registro del sistema.
     *
     * @param orden instancia de Orden a registrar
     */
    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
    }

    /**
     * Filtra y retorna las órdenes que coincidan con el periodo (mes y año)
     * y el ID de la empresa dada.
     *
     * @param periodo periodo de la orden (YearMonth)
     * @param idEmpresa ID de la empresa cliente
     * @return lista de órdenes que coincidan con los criterios
     */
    public ArrayList<Orden> flitrarOrdenes(YearMonth periodo, String idEmpresa) {
        ArrayList<Orden> ordenesFiltradas = new ArrayList<>();

        for (Orden o : ordenes) {
            if (YearMonth.from(o.getFechaServicio()).equals(periodo)
                    && o.getCliente().getId().equals(idEmpresa)) {
                ordenesFiltradas.add(o);
            }
        }
        return ordenesFiltradas;
    }

    /**
     * Retorna una copia de la lista de órdenes registradas.
     *
     * @return lista de órdenes actuales
     */
    public ArrayList<Orden> getOrdenes() {
        return new ArrayList<>(ordenes);
    }

    /**
     * Verifica si un cliente específico tiene al menos una orden registrada.
     *
     * @param cliente cliente a verificar
     * @return true si tiene al menos una orden, false en caso contrario
     */
    public boolean tieneOrden(Cliente cliente) {
        for (Orden orden : ordenes) {
            if (orden.getCliente().equals(cliente)) {
                return true;
            }
        }
        return false;
    }

}
