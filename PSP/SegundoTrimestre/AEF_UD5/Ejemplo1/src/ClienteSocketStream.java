
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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
public class ClienteSocketStream {

    public static void main(String[] args) {
        Socket cliente = null;

        InetAddress ipLocal = null;
        DataOutputStream salida;
        try {
            ipLocal = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteSocketStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            cliente = new Socket(ipLocal, 5000);

        } catch (IOException ex) {
            System.out.println("Conexion rechazada");
        }
        try {
            try {
                salida = new DataOutputStream((cliente.getOutputStream()));

                String texto = "Hola mi ip es: " + ipLocal.getHostAddress();
                salida.writeUTF(texto);
                cliente.close();
            } catch (NullPointerException npe) {
                System.out.println("No pudo establecerse la conexion");
            }
        } catch (IOException ex) {
            System.out.println("Error de E/S con canal de comunicacion");
        }
        try {
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteSocketStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
