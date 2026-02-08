
import java.io.BufferedReader;
import java.io.DataInputStream;
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
public class SocketStream1 {

    public static void main(String[] args) {
        ServerSocket server;
        Socket socketCliente, socketServer;
        DataInputStream comunicacion;
        try {
            server = new ServerSocket(5000);
            System.out.println("Servidor escuchando por: " + server.getLocalPort());

            socketCliente = server.accept();//Recibe el socket de conexion de cliente
            if (socketCliente.isConnected()) {
                comunicacion = new DataInputStream(socketCliente.getInputStream());
                System.out.println(comunicacion.readUTF());
                comunicacion.close();
                socketCliente.close();
                System.out.println("Socket cliente cerrado");
            }
            server.close();
            System.out.println("Se cierra el servidor");
        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            System.out.println("Tipo de error: " + ex.getClass().getSimpleName());
        }
    }
}
