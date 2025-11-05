/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import modelo.LoginModelo;
import vista.LoginView;
import modelo.User;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class LoginControlador implements ActionListener {

    private LoginModelo modelo;
    private LoginView vista;

    public LoginControlador(LoginModelo modelo, LoginView vista) {
        this.modelo = modelo;
        this.vista = vista;

        // El Controlador se suscribe a los eventos de la Vista
        this.vista.getBotonLogin().addActionListener(this);
        this.vista.getBotonRegistro().addActionListener(this);
        this.vista.getBotonLimpiar().addActionListener(this);
    }

    public void iniciarVista() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Si el boton accionado es el de logeo
        if (e.getSource() == vista.getBotonLogin()) {
            // Obtener los valores ingresados por el usuario
            String usuarioIngresado = vista.getInputUser().getText().trim();
            String contraseniaIngresada = vista.getInputContra().getText();
            User loginUsuario = new User(usuarioIngresado, contraseniaIngresada);
            // Validar si existe algun usuario con ese nombre
            if (modelo.buscarUser(loginUsuario) == null) {
                vista.getLabelCredenciales().setForeground(Color.red);
                vista.getLabelCredenciales().setText("No existe usuario");
            } else {
                //Si existe proseguimos al logeo y verificamos credenciales
                if (modelo.esValido(modelo.buscarUser(loginUsuario))) {
                    vista.getLabelCredenciales().setForeground(Color.green);
                    vista.getLabelCredenciales().setText("Credenciales correctas");
                } else {
                    vista.getLabelCredenciales().setForeground(Color.red);
                    vista.getLabelCredenciales().setText("Credenciales incorrectas");
                }
            }

        } else {
            // Si el boton accionado es el de Registro
            if (e.getSource() == vista.getBotonRegistro()) {
                //Si los campos estan vacios
                if (!vista.getInputUser().getText().isEmpty()
                        || !vista.getInputContra().getText().isEmpty()) {
                    String usuarioIngresado = vista.getInputUser().getText();
                    String contraseniaIngresada = vista.getInputContra().getText();
                    if (contraseniaIngresada.length() < 6) {
                        vista.getLabelCredenciales().setForeground(Color.red);
                        vista.getLabelCredenciales().setText("Contraseña minimo 6 caracteres");
                    } else {
                        //Si tienen datos proseguimos con el registro

                        // Buscamos primero si existe algun usuario con ese nombre
                        if (modelo.buscarUser(new User(usuarioIngresado, contraseniaIngresada)) instanceof User) {
                            vista.getLabelCredenciales().setForeground(Color.red);
                            vista.getLabelCredenciales().setText(
                                    "Ya existe usuario "
                                    + vista.getInputUser().getText());
                        } else {
                            //Si no existe proseguimos con el registro
                            modelo.registrarUser(new User(usuarioIngresado, contraseniaIngresada));
                            vista.getLabelCredenciales().setForeground(Color.green);
                            vista.getLabelCredenciales().setText("Usuario registrado");
                            vista.getInputContra().setText("");
                            vista.getInputUser().setText("");
                            

                        }
                    }
                } else {
                    //Si algun campo esta vacio
                    vista.getLabelCredenciales().setForeground(Color.red);
                    vista.getLabelCredenciales().setText("Complete todos los campos");
                }
            } else {
                //Si el botom es el de limpiar
                if (e.getSource() == vista.getBotonLimpiar()) {
                    vista.getInputContra().setText("");
                    vista.getInputUser().setText("");
                    vista.getLabelCredenciales().setText("");
                }
            }
        }

    }
}
