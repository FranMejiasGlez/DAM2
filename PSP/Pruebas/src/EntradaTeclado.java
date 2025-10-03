
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class EntradaTeclado {

    public static void main(String[] args) {
        int datoInt;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        boolean datoInvalido;

        try {
            do {
                datoInvalido = false;
                try {
                    System.out.println("Ingresa un numero entero: ");
                    datoInt = Integer.parseInt(teclado.readLine());
                } catch (NumberFormatException nfe) {
                    System.out.println("Dato no válido, teclee otro.");
                    datoInvalido = true;
                }
            } while (datoInvalido);
        } catch (IOException ioe) {
            System.out.println("Error de E/S");
        }
    }
}
