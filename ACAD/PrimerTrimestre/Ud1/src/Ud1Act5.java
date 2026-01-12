
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*Crear un fichero de texto con el notepad de nombre Prueba.txt y mediante
 * una aplicación Java, mostrarlo en pantalla carácter a carácter.*/
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ud1Act5 {

    public static void main(String[] args) throws FileNotFoundException {
        File fichero;
        fichero = new File("./src/Carpetita/Prueba.txt");
        FileReader lector = null;
        int c;
        try {
            lector = new FileReader(fichero);

            if (fichero.canRead()) { //Si tienes permisos de lectura
                if (fichero.length() > 0) {//Si no esta vacio
                    //read devuelve un int en unicode o -1 si no hay mas
                    while ((c = lector.read()) != -1) {
                        char caracter = (char) c; //convierto a char
                        System.out.println(caracter);
                    }
                } else {
                    System.out.println("El fichero esta vacio");
                }
            } else {
                System.out.println("No hay permisos de lectura");
            }
        } catch (IOException ioe) {
            System.out.println("Error E/S");
        } finally {
            //Cerrar siempre FileReader
            try {
                if (lector != null) {
                    lector.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error de E/S");
            }
        }
    }
}
