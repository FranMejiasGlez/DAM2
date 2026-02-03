
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class ServerSocketUsuario {

    public static void main(String[] args) {
        ServerSocket server;
        Socket socketCliente;
        Usuario user;
        ObjectOutputStream objetoSalida;
        ObjectInputStream objetoEntrada;

        try {
            server = new ServerSocket(5000);
            System.out.println("Servidor escuchando por: " + server.getLocalPort());

            socketCliente = server.accept(); //Servidor escucha peticion

            if (socketCliente.isConnected()) {
                user = new Usuario();
                objetoSalida = new ObjectOutputStream(socketCliente.getOutputStream());
                objetoSalida.writeObject(user);
                objetoSalida.flush();

                System.out.println("Password Enviada a cliente");
                System.out.println("Esperando respuesta...");
                objetoEntrada = new ObjectInputStream(socketCliente.getInputStream());
                System.out.println("Leyendo usuario..");
                try {
                    user = (Usuario) objetoEntrada.readObject();
                } catch (ClassNotFoundException ex) {
                    System.out.println("Clase no encontrada");
                }
                System.out.println("Username: " + user.getNombre());
                System.out.println("Password: " + user.getPassword());
                System.out.println("User IP: " + user.getIp());
                
                objetoSalida.close();
                objetoEntrada.close();
                socketCliente.close();
            }

        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            System.out.println("Tipo de error: " + ex.getClass().getSimpleName());
        }

    }
}
