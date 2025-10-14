
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class PruebaFichDataFija {

    public static void main(String[] args) {
        try {
            DataInputStream fichero = new DataInputStream(
                    new FileInputStream("./src/FichData.dat"));

            DataOutputStream fichero2 = new DataOutputStream(
                    new FileOutputStream("./src/FichDataFija.dat"));

            //Leer Fichero
            while (true) {
                String nombre = fichero.readUTF();  // Lee nombre en UTF_16
                fichero2.                      // Escribe nombre en char
                int edad = fichero.readByte();      // Lee edad en byte
                // Escribe edad
                System.out.println("Nombre: " + nombre + ", Edad: " + edad);
            }

        } catch (EOFException e) {
            System.out.println("Fin del fichero");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
