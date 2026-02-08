
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
public class ServerSocketBidireccional {

    public static void main(String[] args) {
        ServerSocket server;
        Socket socketCliente;
        DataInputStream comunicacion;
        BufferedWriter envio;
        try {
            server = new ServerSocket(5000);
            System.out.println("Servidor escuchando por: " + server.getLocalPort());
            for (int i = 1; i <= 5; i++) {
                socketCliente = server.accept();//Recibe el socket de conexion de cliente
                if (socketCliente.isConnected()) {
                    comunicacion = new DataInputStream((socketCliente.getInputStream()));
                    System.out.println(comunicacion.readUTF());
                    envio = new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream()));
                    envio.write("Bienvenido");
                    envio.newLine();
                    envio.flush();
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
