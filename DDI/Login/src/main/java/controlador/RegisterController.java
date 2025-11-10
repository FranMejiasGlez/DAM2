package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modelo.LoginModelo;
import modelo.User;
import vista.LoginView;
import vista.RegisterView;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class RegisterController implements ActionListener {

    private RegisterView vista;
    private LoginModelo model;

    public RegisterController(LoginModelo modelo, RegisterView vista) {
        this.model = modelo;
        this.vista = vista;
        // El Controlador se suscribe a los eventos de la Vista
        this.vista.getBotonRegistro().addActionListener(this);
    }

    public void iniciarVista() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getBotonRegistro()) {

            if (!vista.getInputUser().getText().isEmpty()
                    && !vista.getInputContra().getText().isEmpty()
                    && vista.getInputConfirmarContra().getPassword().length > 0) {

                String usuarioIngresado = vista.getInputUser().getText().trim();
                String contraseniaIngresada = vista.getInputContra().getText();
                String confirmarContrasenia = new String(vista.getInputConfirmarContra().getPassword());

                // Validaciones
                if (contraseniaIngresada.length() < 6) {
                    vista.getLabelCredenciales().setForeground(Color.red);
                    vista.getLabelCredenciales().setText("Contraseña mínimo 6 caracteres");
                    return;
                }

                if (!contraseniaIngresada.equals(confirmarContrasenia)) {
                    vista.getLabelCredenciales().setForeground(Color.red);
                    vista.getLabelCredenciales().setText("Las contraseñas no coinciden");
                    return;
                }

                try {
                    // Buscamos primero si existe algún usuario con ese nombre
                    if (model.buscarUser(new User(usuarioIngresado, contraseniaIngresada)) != null) {
                        vista.getLabelCredenciales().setForeground(Color.red);
                        vista.getLabelCredenciales().setText(
                                "Ya existe usuario " + usuarioIngresado);
                    } else {
                        // Si no existe proseguimos con el registro
                        model.registrarUser(new User(usuarioIngresado, contraseniaIngresada));
                        vista.getLabelCredenciales().setForeground(Color.green);
                        vista.getLabelCredenciales().setText("Usuario registrado exitosamente");

                        // Esperar un momento y volver al login
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                            @Override
                            public void run() {
                                java.awt.EventQueue.invokeLater(() -> {
                                    volverALogin();
                                });
                            }
                        },
                                1500 // 1.5 segundos
                        );
                    }
                } catch (IOException ex) {
                    vista.getLabelCredenciales().setForeground(Color.red);
                    vista.getLabelCredenciales().setText("Error al registrar usuario");
                    System.out.println("Error de E/S al Registrar user: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                // Si algún campo está vacío
                vista.getLabelCredenciales().setForeground(Color.red);
                vista.getLabelCredenciales().setText("Complete todos los campos");
            }
        }
    }

    private void volverALogin() {
        // Crear y configurar la nueva ventana de login con su controlador
        LoginView loginView = new LoginView();
        LoginModelo loginModel;
        try {
            loginModel = new LoginModelo();
            LoginControlador loginController = new LoginControlador(loginModel, loginView);
            loginController.iniciarVista();
            vista.dispose();
        } catch (IOException ex) {
            System.out.println("Error al crear modelo de login: " + ex.getMessage());
        }
    }
}
