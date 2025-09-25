
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*Hacer una aplicación Java que al escribir java copia fic1.txt fic2.txt realice
 * una copia de fic1 en fic2 carácter a carácter.*/
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ud1Act6 {

    public static void main(String[] args) {
        BufferedReader teclado;
        teclado = new BufferedReader(new InputStreamReader(System.in));
        String linea;
        try {
            System.out.println("Para copiar introduzca: java copia \"fichero_origen\" \"fichero_destino\"");
            linea = teclado.readLine();
            if (linea.substring(0, 9).equalsIgnoreCase("java copia")) {
            } else {
                System.out.println("No se conoce como comando copia.");
            }
        } catch (IOException ioe) {
            System.out.println("Error E/S");
        }
    }
}
