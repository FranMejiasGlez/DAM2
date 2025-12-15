/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seisPruebasDAO;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class LeerSeisPruebas {

    public static void main(String[] args) {
        String ruta = "Ficheros/seisPruebas.dat";

        try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))) {
            System.out.println(
                    "Leyendo registros de " + ruta + "...\n");
            try {
                while (true) {
                    // 1. Lectura del byte
                    byte b = dis.readByte();

                    String nombre = dis.readUTF().trim();

                    // 3. Lectura del short
                    short s = dis.readShort();

                    // Mostrar datos
                    System.out.printf("Numero: %d | Nombre: %-15s | NumeroVeces: %d%n", b, nombre, s);
                }
            } catch (EOFException eofe) {
                System.out.println("Fin Fichero");
            }
            System.out.println(
                    "\nLectura finalizada.");

        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
