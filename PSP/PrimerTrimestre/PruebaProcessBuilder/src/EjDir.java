
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class EjDir {

    public static void main(String[] args) {
        Process procesoDir;
        ProcessBuilder pb;
        File log, salida;
        String archivoLog, archivoTxt;
        archivoLog = "./src/salida.log";
        archivoLog.replace("/", File.separator);
        archivoTxt = "./src/salida.txt";
        archivoTxt.replace("/", File.separator);
        log = new File(archivoLog);
        salida = new File(archivoTxt);
        try {
            pb = new ProcessBuilder("cmd", "/c", "dr");
            pb.redirectError(log);
            pb.redirectOutput(salida);
            procesoDir = pb.start();
        } catch (IOException ioe) {
        }

    }
}
