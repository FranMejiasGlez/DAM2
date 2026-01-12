
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejemplo2Lin {

    public static void main(String[] args) {
        ProcessBuilder procesoNotepad;
        String comando;
        comando = "/usr/lib/gedit";

        procesoNotepad = new ProcessBuilder(comando);
        try {
            procesoNotepad.start();
        } catch (IOException ioe) {
        }
    }
}
