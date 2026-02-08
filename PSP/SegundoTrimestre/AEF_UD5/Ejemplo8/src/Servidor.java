
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
        int contadorCliente = 0;
        DataOutputStream salida = null;
        DataInputStream entrada = null;
        try {
            server = new ServerSocket(5000);
            System.out.println("Servidor escuchando por: " + server.getLocalPort());
            while (true) {
                socketCliente = server.accept(); //Servidor escucha peticion
                if (socketCliente.isConnected()) {
                    
                    AtendedorCliente atendedor = new AtendedorCliente(socketCliente);
                    atendedor.setName("Cliente-" + contadorCliente);
                    atendedor.start();
                    contadorCliente++;
                }
                if (salida != null && entrada != null) {
                    entrada.close();
                    salida.close();
                }
            }

        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            System.out.println("Tipo de error: " + ex.getClass().getSimpleName());
        }
    }
}
