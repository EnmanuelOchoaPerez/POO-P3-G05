
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Vista;

import java.util.Scanner;
import poop3g05.poo.p3.g05.Controlador.GestorInsumo;
import poop3g05.poo.p3.g05.Controlador.GestorProveedor;
import poop3g05.poo.p3.g05.Controlador.GestorPersona;
import poop3g05.poo.p3.g05.Modelo.Insumo;
import poop3g05.poo.p3.g05.Modelo.Proveedor;

/**
 * Esta clase es la encargada de la interaccion por consola con el usuario para
 * recibir los datos con los que se va a registrar una falta de insumos y cual
 * proveedor deveria ser contactado y mostrar la confirmacion.
 *
 * @author Enmanuel
 */
public class AdministrarInsumo {

    /**
     * Objeto scanner que se va a usar para recibir las entradas del usuario en
     * toda la clase.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Este metodo es el encargado de la interaccion por consola con el usuario
     * para recibir los datos con los que se va a registrar una falta de insumos
     * y cual proveedor deveria ser contactado y mostrar la confirmacion.
     *
     * @param gestorInsumo
     * @param gestorUsuario
     * @param gestorProveedor
     */
    static void registrarInsumoFaltante(GestorInsumo gestorInsumo,
            GestorPersona gestorUsuario, GestorProveedor gestorProveedor) {
        System.out.println("\n--- REGISTRAR FALTA DE INSUMO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        AdministrarProveedor.listarProveedores(gestorProveedor);
        System.out.print("Digite id del proveedor: ");
        String idProveedor = scanner.nextLine();
        if (gestorProveedor.buscarPersona(idProveedor) instanceof Proveedor proveedor) {
            gestorInsumo.agregarInsumo(new Insumo(nombre, proveedor));
            System.out.println("Registro exitoso!\n");
            return;
        }
        System.out.println("Proveedor no contrado, intente de nuevo...");
    }
}
