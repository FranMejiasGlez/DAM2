
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
public class Ej2 {

    public static void main(String[] args) {
        FileWriter escritura;
        File archivoTexto;
        try {
            archivoTexto = new File("./src/Ficheros/muestra.txt");
            escritura = new FileWriter(archivoTexto, true);
            escritura.write("Fin");
            escritura.close();
        } catch (IOException ioe) {
        }
    }
}
