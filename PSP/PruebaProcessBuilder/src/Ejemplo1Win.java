
import java.io.IOException;
import java.util.List;

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
