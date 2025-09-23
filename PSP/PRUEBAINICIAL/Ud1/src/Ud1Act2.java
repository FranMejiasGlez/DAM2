
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*Mostrar la lista de los archivos contenidos en el directorio indicado por
 * teclado. (Esto segunda parte) Mostrando el nombre seguido del tamaño del archivo si
 * se trata de un fichero, o de la cadena “<dir>”, si se trata de un directorio.*/
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ud1Act2 {

    public static void main(String[] args) {
        File directorio;
        String dir;
        BufferedReader teclado;

        teclado = new BufferedReader(new InputStreamReader(System.in));
        try {

            System.out.println("Ingresa nombre de directorio: ");
            dir = teclado.readLine();
            directorio = new File("./src/" + dir);

            if (directorio.exists()) {

                System.out.println("Listar directorio: " + dir);

                for (int i = 0; i < directorio.listFiles().length; i++) {

                    if (directorio.listFiles()[i].isDirectory()) {

                        System.out.println(directorio.listFiles()[i]);
                        System.out.println(" <dir>");

                    } else {
                        System.out.println(directorio.listFiles()[i]);
                        System.out.println("tamanio: " + 
                                directorio.listFiles()[i].length());
                    }
                }

            } else {

                System.out.println("No existe el directorio.");

            }
        } catch (IOException ioe) {
        }

    }
}
