
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class PruebaFichData {

    public static void main(String[] args) {
        try {
            DataInputStream fichero = new DataInputStream(
                    new FileInputStream("./src/FichData.dat"));

            while (true) {
                String nombre = fichero.readUTF();  // Lee nombre
                int edad = fichero.readByte();       // Lee edad
                System.out.println("Nombre: " + nombre + ", Edad: " + edad);
            }

        } catch (EOFException e) {
            System.out.println("Fin del fichero");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
