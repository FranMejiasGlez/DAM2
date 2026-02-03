
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class ClienteSocketObject {

    public static void main(String[] args) {
        Socket cliente = null;
        Integer numero;
        Random random;
        int num;
        InetAddress ipLocal = null;
        ObjectOutputStream objeto;


        try {
            ipLocal = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteSocketObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cliente = new Socket(ipLocal, 5000);
        } catch (IOException ex) {
            System.out.println("Conexion rechazada.");
        }
        try {
            try {
                random = new Random(1000);
                num = random.nextInt(10) + 1;
                numero = num;
                objeto = new ObjectOutputStream(cliente.getOutputStream());
                objeto.writeObject(numero);
                cliente.close();
            } catch (NullPointerException npe) {
                System.out.println("La conexion no ha podido establecerse");
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            System.out.println("Tipo de error: " + ex.getClass().getSimpleName());
        }
    }
}
