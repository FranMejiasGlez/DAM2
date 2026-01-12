
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
        String comando = "C:\\Windows\\System32\\notepad.exe";
        try {
            Runtime.getRuntime().exec(comando);
        } catch (IOException ioe) {
            System.out.println("Error de E/S");
        }

    }
}
