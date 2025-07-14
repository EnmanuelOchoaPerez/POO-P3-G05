/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import poop3g05.poo.p3.g05.Modelo.Factura;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Controlador que lleva el registro de las facturas y maneja la lógica de
 * negocio relacionada con la generación, almacenamiento y búsqueda de facturas
 * dentro del sistema.
 * 
 * Esta clase permite agregar nuevas facturas y convertir cadenas de texto en
 * fechas estructuradas para facilitar búsquedas por periodo.
 * 
 * @author Rafael Cosmo
 */
public class GestorFactura {

    /**
     * Lista que contiene todas las facturas generadas en el sistema.
     */
    private final ArrayList<Factura> facturas;

    /**
     * Constructor por defecto que inicializa la lista de facturas.
     */
    public GestorFactura() {
        this.facturas = new ArrayList<>();
    }

    /**
     * Agrega una nueva factura al registro del sistema.
     *
     * @param factura instancia de Factura a registrar
     */
    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    /**
     * Retorna una copia de la lista actual de facturas.
     *
     * @return lista de facturas registradas
     */
    public ArrayList<Factura> getFacturas() {
        return new ArrayList<>(facturas);
    }

    /**
     * Convierte un texto con formato "mes año" (por ejemplo, "julio 2025")
     * a un objeto YearMonth utilizando el idioma español.
     *
     * @param periodo cadena de texto representando el mes y año
     * @return objeto YearMonth correspondiente, o null si el mes es inválido
     */
    public YearMonth definirFecha(String periodo) {
        periodo = periodo.trim();
        String[] partes = periodo.split("\\s+");
        String mes = partes[0];
        int año = Integer.parseInt(partes[1]);
        Locale locale = new Locale("es", "ES");
        for (Month m : Month.values()) {
            if (m.getDisplayName(TextStyle.FULL, locale).equalsIgnoreCase(mes)) {
                return YearMonth.of(año, m);
            }
        }
        return null;
    }
}