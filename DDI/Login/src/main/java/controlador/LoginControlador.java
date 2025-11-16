/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import modelo.LoginModelo;
import vista.LoginView;
import modelo.User;
import vista.RegisterView;

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

            // Validar campos vacíos
            if (usuarioIngresado.isEmpty() || contraseniaIngresada.isEmpty()) {
                vista.getLabelCredenciales().setForeground(Color.red);
                vista.getLabelCredenciales().setText("Complete todos los campos");
                return;
            }

            User loginUsuario = new User(usuarioIngresado, contraseniaIngresada);
            try {
                // Llamamos a esValido con el objeto
                // que contiene las credenciales INGRESADAS por el usuario.

                if (modelo.esValido(loginUsuario)) {
                    // Si esValido es true, el nombre y la contraseña coinciden con una entrada del archivo.
                    vista.getLabelCredenciales().setForeground(Color.green);
                    vista.getLabelCredenciales().setText("Credenciales correctas");
                    JOptionPane.showMessageDialog(
                            vista,
                            "Credenciales correctas.", // Mensaje
                            " Inicio de Sesión",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    // Si esValido es false, el usuario no existe o la contraseña es incorrecta.
                    // Mostramos un mensaje genérico por seguridad.
                    vista.getLabelCredenciales().setForeground(Color.red);
                    vista.getLabelCredenciales().setText("Credenciales incorrectas");
                    JOptionPane.showMessageDialog(
                            vista,
                            "El nombre de usuario o la contraseña son incorrectos. Inténtelo de nuevo.", // Mensaje
                            "Error de Inicio de Sesión",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            } catch (IOException ex) {
                vista.getLabelCredenciales().setForeground(Color.red);
                vista.getLabelCredenciales().setText("Error al validar usuario");
                System.out.println("Error de E/S al logear o buscar user: " + ex.getMessage());
            }

        } else if (e.getSource() == vista.getBotonRegistro()) {
            // Si el boton accionado es el de Registro
            try {
                RegisterView registerView = new RegisterView();
                LoginModelo modeloRegistro = new LoginModelo();
                RegisterController registerController = new RegisterController(modeloRegistro, registerView);
                registerController.iniciarVista();
                vista.dispose();
            } catch (IOException ex) {
                System.out.println("Error al abrir registro: " + ex.getMessage());
            }
        } else if (e.getSource() == vista.getBotonLimpiar()) {
            //Si el boton es el de limpiar
            vista.getInputContra().setText("");
            vista.getInputUser().setText("");
            vista.getLabelCredenciales().setText("");
        }
    }
}
