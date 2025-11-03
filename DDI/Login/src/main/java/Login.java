
import controlador.LoginControlador;
import modelo.LoginModelo;
import vista.LoginView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author DAM2
 */
public class Login {

    public static void main(String[] args) {
        // 1. Crear las piezas
        LoginModelo modelo = new LoginModelo();
        LoginView vista = new LoginView();

        // 2. Crear el Controlador y conectar todo
        LoginControlador controlador = new LoginControlador(modelo, vista);

        // 3. Arrancar la aplicación
        javax.swing.SwingUtilities.invokeLater(() -> {
            controlador.iniciarVista();
        });

    }
}
