
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Servidor {

    public static void main(String[] args) {
        ServerSocket server;
        Socket socketCliente;
        DataOutputStream salida;
        try {
            server = new ServerSocket(5000);
            System.out.println("Servidor escuchando por: " + server.getLocalPort());
            while (true) {
                socketCliente = server.accept(); //Servidor escucha peticion
                if (socketCliente.isConnected()) {
                    AtendedorCliente atendedor = new AtendedorCliente(socketCliente);
                    atendedor.start();
                }
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            System.out.println("Tipo de error: " + ex.getClass().getSimpleName());
        }
    }
}
