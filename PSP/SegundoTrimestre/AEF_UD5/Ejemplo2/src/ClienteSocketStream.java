
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
public class ClienteSocketStream {

    public static void main(String[] args) {
        Socket cliente = null;

        InetAddress ipLocal = null;
        BufferedWriter salida;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        try {
            ipLocal = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteSocketStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cliente = new Socket(ipLocal, 5000);
        } catch (IOException ex) {
            System.out.println("Conexion rechazada.");
        }
        try {
            try {
                salida = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
                System.out.println("Escribe un mensaje: ");
                String texto;
                texto = teclado.readLine();
                salida.write(texto);
                salida.newLine();
                salida.flush();
                cliente.close();
            } catch (NullPointerException npe) {
                System.out.println("La conexion no ha podido establecerse");
            }
        } catch (IOException ex) {
            Logger.getLogger(ClienteSocketStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
