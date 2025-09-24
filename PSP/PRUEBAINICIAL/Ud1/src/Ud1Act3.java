
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
        File directorio, fichero1, fichero2;

        System.out.println("Creando directorio: NUEVODIR");

        directorio = new File("./src/", "NUEVODIR");
        directorio.mkdir();

        System.out.println("En: " + directorio.getPath());
        System.out.println("Creando ficheros vacios..");
        try {
            new File("./src/NUEVODIR/", "fichero1vacio.txt").createNewFile();
            new File("./src/NUEVODIR/", "fichero2vacio.txt").createNewFile();
        } catch (IOException ioe) {
            System.out.println("Error E/S");
        }
        System.out.println("Listando: ");
        for (int i = 0; i < directorio.listFiles().length; i++) {

            if (directorio.listFiles()[i].isDirectory()) {

                System.out.println(directorio.listFiles()[i]);
                System.out.println(" <dir>");

            } else {
                System.out.println(directorio.listFiles()[i]);
                System.out.println("tamanio: "
                        + directorio.listFiles()[i].length());
            }
        }
        System.out.println("Renombrando fichero1vacio.txt a fich1...");
        
        File fich1 = new File("./src/NUEVODIR/fich1.txt");
        
        directorio.listFiles()[1].renameTo(fich1);
        
        System.out.println("Listando: ");
        
        for (int i = 0; i < directorio.listFiles().length; i++) {

            if (directorio.listFiles()[i].isDirectory()) {

                System.out.println(directorio.listFiles()[i]);
                System.out.println(" <dir>");

            } else {
                System.out.println(directorio.listFiles()[i]);
                System.out.println("tamanio: "
                        + directorio.listFiles()[i].length());
            }
        }
    }
}
