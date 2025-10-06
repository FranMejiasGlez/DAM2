package NATURAL;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author frans
 */
public class LeerNaturales {

    public static void main(String[] args) {
        DataInputStream naturales;
        String nombreArchivo = "./src/naturales.dat";
        boolean finArchivo = false;
        try {
            naturales = new DataInputStream(new FileInputStream(nombreArchivo));

            try {

                int contadorByt, byteLeido;
                contadorByt = 0;
                byteLeido = naturales.readInt();

                while (!finArchivo) {
                    try {
                        System.out.print(byteLeido + " ");
                        contadorByt++;
                        byteLeido = naturales.readInt();
                        if (contadorByt % 10 == 0) {
                            System.out.println();
                        }
                    } catch (EOFException eof) {
                        System.out.println("\nFin de archivo");
                        finArchivo = !finArchivo;
                    }
                }

                System.out.println("\nTotal de bytes leídos: " + contadorByt);

            } catch (IOException ioe) {
                System.out.println("Error al leer el archivo");

            } finally {
                try {
                    naturales.close();
                } catch (IOException ioe) {
                    System.out.println("Error al cerrar archivo");
                }
            }

        } catch (IOException ioe) {
            System.out.println("Error de E/S al abrir el archivo");
        }
    }
}
