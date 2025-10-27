
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    public static void main(String[] args) throws FileNotFoundException, IOException {
        byte tamanioNombre = 30;
        char caracterNombre;


        try {
            DataInputStream fichero = new DataInputStream(
                    new FileInputStream("./src/FichData.dat"));

            DataOutputStream fichero2 = new DataOutputStream(
                    new FileOutputStream("./src/FichDataFija.dat"));

            //Leer Fichero Variable y escribir en Fichero Fijo
            System.out.println("Leyendo Fichero Variable y escribiendo en Fichero Fijo...");
            while (true) {
                String nombre = fichero.readUTF();  // Lee nombre en UTF_16
                StringBuilder nombreFijo;

                nombreFijo = new StringBuilder(nombre);
                nombreFijo.setLength(30); //Tamaño fijo de 30
                nombre = nombreFijo.toString(); //Transformar para escribir
                // System.out.println(nombre);
                fichero2.writeChars(nombre);// Escribe nombre en char
                int edad = fichero.readByte();      // Lee edad en byte
                fichero2.writeByte(edad);// Escribe edad
                // System.out.println("Nombre: " + nombre + ", Edad: " + edad);
            }

        } catch (EOFException e) {
            System.out.println("Fin del Fichero Variable...");
            try {
                //Leer fichero fijo
                System.out.println("Leyendo Fichero Fijo...");
                DataInputStream ficheroFijo = new DataInputStream(
                        new FileInputStream("./src/FichDataFija.dat"));
                while (true) {
                    String nombreCompleto = "";
                    for (int i = 1; i <= tamanioNombre; i++) {
                        caracterNombre = ficheroFijo.readChar();
                        nombreCompleto = nombreCompleto + caracterNombre;
                    }
                 //  nombreCompleto = nombreCompleto.trim();
                    int edadFijo = ficheroFijo.readByte();
                    System.out.println("Nombre: " + nombreCompleto
                            + ", Edad: " + edadFijo);
                }

            } catch (EOFException ioe) {
                System.out.println("Fin Fichero Fijo...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
