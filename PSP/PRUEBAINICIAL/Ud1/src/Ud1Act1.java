
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*Ud1Act1. Hacer un programa Java que muestre la siguiente información del fichero
 * indicado por teclado si existe:
 * INFORMACIÓN SOBRE EL FICHERO 
 * nombre: 
 * Ruta relativa:
 * Ruta absoluta:
 * Se puede escribir: S/N
 * Se puede leer: S/N
 * Tamaño:
 * Es un directorio /Es un fichero*/
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ud1Act1 {

    public static void main(String[] args) {
        File fichero;
        BufferedReader teclado;
        String nombre;
        try {
            teclado = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println("Ingresa el nombre del fichero: ");
                nombre = teclado.readLine();
                fichero = new File("./src/Carpetita/" + nombre);
            } while (!(nombre instanceof String));

            if (fichero.exists()) {

                System.out.println("Nombre del fichero: ");
                System.out.println(fichero.getName());

                System.out.println("Ruta relativa: ");
                System.out.println(fichero.getPath());

                System.out.println("Ruta absoluta: ");
                System.out.println(fichero.getAbsolutePath());

                System.out.println("Se puede escribir?: ");
                System.out.println(fichero.canRead() ? "Si" : "No");

                System.out.println("Se puede leer?: ");
                System.out.println(fichero.canWrite() ? "Si" : "No");

                System.out.println("Tamanio: ");
                System.out.println(fichero.length());

                System.out.println("Es un directorio?: ");
                System.out.println(fichero.isDirectory() ? "Si" : "No");

            } else {
                System.out.println("No existe el fichero.");
            }

        } catch (IOException ioe) {
            System.out.println("Error de E/S");
        }
    }
}
