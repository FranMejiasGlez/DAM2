
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejemplo1Win {

    public static void main(String[] args) {
        ProcessBuilder procesoNotepad;
        String comando;
        comando = "C:\\WINDOWS\\system32\\notepad.exe";

        procesoNotepad = new ProcessBuilder(comando);
        try {
            procesoNotepad.start();
        } catch (IOException ioe) {
        }
    }
}
