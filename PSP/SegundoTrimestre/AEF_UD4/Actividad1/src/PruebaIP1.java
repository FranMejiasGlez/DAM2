
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
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
public class PruebaIP1 {

    public static void main(String[] args) {
        InetAddress ia;
        BufferedReader teclado;
        String linea = "", ip;
        teclado = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Introduce el nombre de host para resolver la IP: ");
            try {
                linea = teclado.readLine();
            } catch (IOException ex) {
                System.out.println("Error de E/S con teclado");
            }
        } while (linea.isEmpty());
        try {

            ia = InetAddress.getByName(linea);
            ip = ia.getHostAddress();
            System.out.println(ip);
        } catch (UnknownHostException ex) {
            System.out.println("Host desconocido, no se pudo resolver la IP.");
        }
    }
}
