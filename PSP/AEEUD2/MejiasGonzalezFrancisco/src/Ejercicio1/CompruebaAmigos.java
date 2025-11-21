/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CompruebaAmigos {

    public static void main(String[] args) {
        BufferedReader teclado;
        int numero;
        boolean esValido = true;

        teclado = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                numero = Integer.parseInt(teclado.readLine());
            } catch (NumberFormatException nfe) {
                esValido = false;
                System.out.println("Dato invalido, teclee otro.");
            } catch (IOException ex) {
                System.out.println("Error de E/S teclado");
            }
        } while (!esValido);
        
        
    }
}
