
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
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
public class ServerSocketObject {

    public static void main(String[] args) {
        ServerSocket server;
        Socket socketCliente;
        ObjectInputStream objeto;
        Object ob;
        try {
            server = new ServerSocket(5000);
            System.out.println("Servidor escuchando por: " + server.getLocalPort());
            while (true) {
                socketCliente = server.accept();//Recibe el socket de conexion de cliente
                if (socketCliente.isConnected()) {
                    objeto = new ObjectInputStream(socketCliente.getInputStream());
                    try {
                        ob = objeto.readObject();
                        if (ob != null) {
                            System.out.println(ob.toString());
                        }
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Clase no encontrada");
                    }
                    socketCliente.close();
                    System.out.println("Socket cliente cerrado");
                }
            }

        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            System.out.println("Tipo de error: " + ex.getClass().getSimpleName());
        }
    }
}
