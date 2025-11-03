/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author DAM2
 */
public class LoginModelo {

    private final List<User> usuarios;

    public LoginModelo() {
        usuarios = new LinkedList<>();
    }

    public boolean esValido(User usuario) {
        boolean esValido;
        esValido = usuario.getNombre().equals(usuario.getNombre())
                && usuario.getContrasenia().equals(usuario.getContrasenia());
        return esValido;
    }

    public void registrarUser(User nuevoUser) {
        usuarios.add(nuevoUser);
    }

    public User buscarUser(User us) {
        User user = null;
        for (User usuario : usuarios) {
            if (us.getNombre().equals(usuario.getNombre())
                    && us.getContrasenia().equals(usuario.getContrasenia())) {
                user = usuario;
            }
        }
        return user;
    }
}
