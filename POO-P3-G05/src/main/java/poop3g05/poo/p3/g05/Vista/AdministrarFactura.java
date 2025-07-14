/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Vista;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import poop3g05.poo.p3.g05.Controlador.GestorCliente;
import poop3g05.poo.p3.g05.Controlador.GestorFactura;
import poop3g05.poo.p3.g05.Controlador.GestorOrden;
import poop3g05.poo.p3.g05.Modelo.Cliente;
import poop3g05.poo.p3.g05.Modelo.DetalleServicio;
import poop3g05.poo.p3.g05.Modelo.Factura;
import poop3g05.poo.p3.g05.Modelo.TipoCliente;

/**
 * Esta clase se encarga de la interaccion con el usuario para registrar las
 * facturas y de mostrar los datos de las mismas por consola.
 *
 * @author Enmanuel
 */
public class AdministrarFactura {

    /**
     * Objeto scanner que se va a usar para recibir las entradas del usuario en
     * toda la clase.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir los datos con los que se va a registrar la factura.
     *
     * @param gestorFactura
     * @param gestorCliente
     * @param gestorOrden
     * @return
     */
    static Factura registrarFactura(GestorFactura gestorFactura, GestorCliente gestorCliente, GestorOrden gestorOrden) {
        AdministrarCliente.listarClientes(gestorCliente, TipoCliente.EMPRESA);
        System.out.print("Digite RUC de la empresa: ");
        Cliente empresa = gestorCliente.buscarPersona(scanner.nextLine());
        if (empresa == null || !gestorCliente.trueEmpresa(empresa) || !gestorOrden.tieneOrden(empresa)) {
            return null;
        }
        System.out.print("Periodo de facturacion(Como en el documento): ");
        YearMonth mesAño = gestorFactura.definirFecha(scanner.nextLine());
        if (mesAño == null) {
            return null;
        }
        return new Factura(mesAño, empresa, gestorOrden.flitrarOrdenes(mesAño, empresa.getId()));

    }

    /**
     * Este metodo es el encargado de mostrar por consola la factura registrada
     * en el anterior metodo o mostrar la denegacion.
     *
     * @param factura
     */
    static void imprimirFactura(Factura factura) {
        if (factura == null) {
            System.out.println("No se pudo generar la factura...\n");
            return;
        }
        System.out.println("Detalles de servicios: ");
        System.out.printf("%-15s %-15s %-20s %-30s %10s %15s%n",
                "Placa", "Fecha", "Tipo de vehiculo", "Servicio", "Cantidad", "Total");
        System.out.println("-".repeat(95));

        for (int i = 0; i < factura.getOrdenes().size(); i++) {
            String placa = factura.getOrdenes().get(i).getVehiculo().getPlaca();
            String fecha = factura.getOrdenes().get(i).getFechaServicio().format(DateTimeFormatter.ofPattern("dd-MM"));
            String tipoVehiculo = factura.getOrdenes().get(i).getVehiculo().getTipo().name();

            for (DetalleServicio ds : factura.getOrdenes().get(i).getServicios()) {
                String servicio = ds.getServicio().getNombre();
                int cantidad = ds.getCantidad();
                double subtotal = ds.calcularSubtotal();
                System.out.printf("%-15s %-15s %-20s %-30s %7s %18s%n",
                        placa, fecha, tipoVehiculo, servicio, cantidad, subtotal);
            }
        }
        System.out.println("-".repeat(95));
        System.out.printf("%-15s %83s%n", "Membresia para empresas:", "50");
        System.out.println("Total : " + factura.getTotal());
    }
}
