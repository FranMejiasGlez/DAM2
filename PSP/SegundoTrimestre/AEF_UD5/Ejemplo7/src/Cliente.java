
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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
public class Cliente extends Thread {

    private Socket cliente = null;
    private InetAddress ipLocal = null;
    private DataInputStream comunicacion;

    @Override
    public void run() {
        try {
            ipLocal = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println("Host desconocido");
        }
        try {
            cliente = new Socket(ipLocal, 5000);
        } catch (IOException ex) {
            System.out.println("Conexion rechazada.");
        }
        try {
            comunicacion = new DataInputStream(cliente.getInputStream());

            System.out.println("Cliente " + Thread.currentThread().getName() + ": "
                    + comunicacion.readUTF());

            System.out.println("Cliente " + Thread.currentThread().getName() + ": "
                    + comunicacion.readUTF());
            comunicacion.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
