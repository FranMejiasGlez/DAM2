
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class ServerSocketStream2 {

    public static void main(String[] args) {
        ServerSocket server;
        Socket socketCliente, socketServer;
        BufferedReader comunicacion;
        try {
            server = new ServerSocket(5000);
            System.out.println("Servidor escuchando por: " + server.getLocalPort());
            for (int i = 1; i <= 5; i++) {
                socketCliente = server.accept();//Recibe el socket de conexion de cliente
                if (socketCliente.isConnected()) {
                    comunicacion = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                    System.out.println(comunicacion.readLine());
                    comunicacion.close();
                    socketCliente.close();
                    System.out.println("Socket cliente cerrado");
                }
            }
            server.close();
            System.out.println("Servidor cerrado después de 5 conexiones");
        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            System.out.println("Tipo de error: " + ex.getClass().getSimpleName());
        }
    }
}
