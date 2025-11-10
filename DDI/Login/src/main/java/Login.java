
import controlador.LoginControlador;
import java.io.IOException;
import modelo.LoginModelo;
import vista.LoginView;

public class Login {

    public static void main(String[] args) {
        // Iniciar la aplicación en el hilo de EDT
        java.awt.EventQueue.invokeLater(() -> {
            try {
                LoginView vista = new LoginView();
                LoginModelo modelo = new LoginModelo();
                LoginControlador controlador = new LoginControlador(modelo, vista);
                controlador.iniciarVista();
            } catch (IOException ex) {
                System.out.println("Error al iniciar la aplicación: " + ex.getMessage());
            }
        });
    }
}
