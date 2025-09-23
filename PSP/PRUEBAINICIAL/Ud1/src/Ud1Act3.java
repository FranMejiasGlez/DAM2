
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*Realizar un programa en Java que cree el directorio NUEVODIR en el
 * directorio actual, con dos ficheros vacíos. A continuación, renombrará uno de ellos.*/
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ud1Act3 {

    public static void main(String[] args) {
        File fichero;
        BufferedReader teclado;
        String nombre;

        teclado = new BufferedReader(new InputStreamReader(System.in));
        try {
            nombre = teclado.readLine();
        } catch (IOException ioe) {
            System.out.println("Error de E/S");
        }

    }
}
