
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*Repetir la actividad 1pero realizando el proceso línea a línea.*/
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ud1Act7 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File archivo;
        FileReader lector;
        BufferedReader br;
        archivo = new File("./src/Carpetita/Prueba.txt");
        lector = new FileReader(archivo);
        br = new BufferedReader(lector);
        try {
            if (archivo.canRead()) {
                if (archivo.length() > 0) {
                    String linea = br.readLine();
                    while (linea != null) {
                        System.out.println(linea);
                        linea = br.readLine();
                    }
                } else {
                    System.out.println("Archivo vacio");
                }
            } else {
                System.out.println("No hay permisos de lectura");
            }
        } catch (IOException ioe) {
        } finally {
            br.close();
        }
    }
}
