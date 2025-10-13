
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejemplo1Lin {
    public static void main(String[] args) {
        String comando = "/usr/lib/gedit";
        try {
            Runtime.getRuntime().exec(comando);
        } catch (IOException ioe) {
            System.out.println("Error de E/S");
        }
    }
}
