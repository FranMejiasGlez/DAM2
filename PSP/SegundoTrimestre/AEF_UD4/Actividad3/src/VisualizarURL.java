
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
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
public class VisualizarURL {

    public static void main(String[] args) {
        URL url1, url2, url3;
        String protocol, host, file;
        int port;
        protocol = "https";
        host = "localhost";
        port = 3000;
        file = "B2Ej1.htm";

        try {
            url1 = new URL("https://www.youtube.com");
            url2 = new URL(protocol, host, port, "/" + file);
            System.out.println(url2.toString());
            System.out.println("URL2: ");
            System.out.println(url2.getProtocol() + "://" + url2.getHost() 
                    + ":" + url2.getPort() + url2.getFile()
                    + " - " + url2.getUserInfo()+" - "+url2.getAuthority()+" - "+url2.getPath());
        } catch (MalformedURLException ex) {
            System.out.println("Error, la URL no existe.");
        }
    }
}
