
import java.io.File;
import java.io.IOException;
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
public class EjDate {

    public static void main(String[] args) {
        Process procesoDate;
        ProcessBuilder pb;
        File fecha;
        fecha = new File("./src/fecha.txt");
        pb = new ProcessBuilder("cmd", "/c", "date");
        pb.redirectInput(fecha);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try {
            procesoDate = pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
