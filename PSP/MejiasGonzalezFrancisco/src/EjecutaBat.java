
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
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
public class EjecutaBat {

    public static void main(String[] args) {
        String nombreFich;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        Process p;
        ProcessBuilder pb;
        File errorBat, salidaBat;
        try {
            errorBat = new File("./src/errorBat.txt");
            salidaBat = new File("./src/salidaBat.txt");
            System.out.println("Nombre del archivo bat: ");
            nombreFich = teclado.readLine();
            pb = new ProcessBuilder("cmd", "/c", nombreFich);
            pb.redirectError(ProcessBuilder.Redirect.to(errorBat));
            pb.redirectOutput(ProcessBuilder.Redirect.to(salidaBat));
            p = pb.start();
            p.waitFor();
        } catch (IOException ioe) {
            System.out.println("Error de E/S de teclado");;
        } catch (InterruptedException ex) {
            Logger.getLogger(EjecutaBat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
