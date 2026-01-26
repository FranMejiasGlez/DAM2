
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
public class PruebaIP2 {

    public static void main(String[] args) {
        //www.google.es
        //172.217.20.227
        InetAddress ia;
        String canonicalName, hostName, ip, url;
        url = "www.google.es";
        try {
            hostName = InetAddress.getByName(url).getHostName();
            System.out.println("Nombre de host: " + hostName);
            ip = InetAddress.getByName(url).getHostAddress();
            System.out.println("IP: " + ip);
            canonicalName = InetAddress.getByName(url).getCanonicalHostName();
            System.out.println("Nombre canonico: " + canonicalName);
            System.out.println("");
            System.out.println("Cadena de direccion: Hostname + IP + Tipo");
            System.out.println("");
            System.out.println("Hostname: " + url);
            System.out.println("IP: " + ip);
            System.out.println("Tipo: " + (ip.contains(":") ? "IPv6" : "IPv4"));

        } catch (UnknownHostException ex) {
            System.out.println("Host desconocido, no se pudo resolver");
        }

    }
}
