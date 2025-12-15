/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipoPruebaDAO;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class LeerTipoPrueba {

    public static void main(String[] args) {
        String ruta = "Ficheros/obligatorio.dat";

        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r")) {
            System.out.println("Leyendo registros de " + ruta + "...\n");

            while (raf.getFilePointer() < raf.length()) {
                // 1. Lectura del byte
                byte b = raf.readByte();

                // 2. Lectura del String (asumiendo 30 caracteres fijos)
                String nombre = "";
                for (int i = 0; i < 15; i++) {
                    nombre += raf.readChar();
                }
                nombre = nombre.trim(); // Quitamos espacios sobrantes

                // 3. Lectura del short
                short s = raf.readShort();

                // Mostrar datos
                System.out.printf("Numero: %d | Nombre: %-15s | NumeroVeces: %d%n", b, nombre, s);
            }

            System.out.println("\nLectura finalizada.");

        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
