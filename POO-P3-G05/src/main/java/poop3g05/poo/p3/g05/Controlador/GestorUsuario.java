/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop3g05.poo.p3.g05.Controlador;

import java.util.ArrayList;
import poop3g05.poo.p3.g05.Modelo.Usuario;

/**
 *
 * @author Enmanuel
 * @param <U>
 */

public class GestorUsuario<U extends Usuario> {
    
    protected final ArrayList<Usuario> usuarios;
    
    public GestorUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public void editarNombre(String id, String nombreNuevo) {
        usuarios.get(usuarios.indexOf(buscarUsuario(id))).setUsername(nombreNuevo);
    }

    public void editarTelefono(String id, String telefono) {
        usuarios.get(usuarios.indexOf(buscarUsuario(id))).setTelefono(telefono);
    }
    
}
