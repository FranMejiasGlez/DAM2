/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NATURAL;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Naturales {

    public static void main(String[] args) {
        String nombreArchivo = "./src/naturales.dat";

        try {
            FileOutputStream archivo = new FileOutputStream(nombreArchivo);
            DataOutputStream numerosNaturales = new DataOutputStream(archivo);

            for (int i = 0; i < 500; i++) {
                numerosNaturales.writeShort(i);
            }
            System.out.println("Total escrito: " + numerosNaturales.size() + " bytes");
            archivo.close();
            numerosNaturales.close();

        } catch (IOException ioe) {
            System.out.println("Error al abrir archivo");
        }
    }
}
