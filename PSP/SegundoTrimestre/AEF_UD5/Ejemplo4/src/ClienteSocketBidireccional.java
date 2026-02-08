
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class ClienteSocketBidireccional {

    public static void main(String[] args) {
        Socket cliente = null;

        InetAddress ipLocal = null;
        DataOutputStream salida;
        BufferedReader llegada;

        try {
            ipLocal = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteSocketBidireccional.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cliente = new Socket(ipLocal, 5000);
        } catch (IOException ex) {
            System.out.println("Conexion rechazada.");
        }
        try {
            try {
                salida = new DataOutputStream((cliente.getOutputStream()));
                System.out.println("Escribe un mensaje: ");

                String texto = "Hola mi ip es: " + ipLocal.getHostAddress();
                salida.writeUTF(texto);

                llegada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                System.out.println(llegada.readLine());//Aqui debo leer lo que me envio el servidor
                cliente.close();
            } catch (NullPointerException npe) {
                System.out.println("La conexion no ha podido establecerse");
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            System.out.println("Tipo de error: " + ex.getClass().getSimpleName());
        }finally{
            try {
                cliente.close();
            } catch (IOException ex) {
                Logger.getLogger(ClienteSocketBidireccional.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
