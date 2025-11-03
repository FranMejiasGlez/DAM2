
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class PruebaFichDirecto {

    public static void main(String[] args) {
        RandomAccessFile rFicheroDirecto;
        StringBuilder nombre, apellidos;
        String nombr, apellid;
        long longRegistro = 58;
        nombre = new StringBuilder("Francisco");
        nombre.setLength(10);
        nombr = nombre.toString();
        apellidos = new StringBuilder("Mejias Gonzalez");
        apellidos.setLength(15);
        apellid = apellidos.toString();

        try {
            rFicheroDirecto = new RandomAccessFile("prueba.dat", "rw");

            //Escribir registros

            rFicheroDirecto.writeInt(1);
            rFicheroDirecto.writeChars(nombr);
            rFicheroDirecto.writeChars(apellid);
            rFicheroDirecto.writeFloat(1300.50F);
            //Hueco vacio
            rFicheroDirecto.writeInt(0);
            rFicheroDirecto.writeChars("          ");
            rFicheroDirecto.writeChars("               ");
            rFicheroDirecto.writeFloat(0);
            //Escribir registros
            rFicheroDirecto.writeInt(3);
            rFicheroDirecto.writeChars(nombr);
            rFicheroDirecto.writeChars(apellid);
            rFicheroDirecto.writeFloat(1500.50F);

            //Leer
            rFicheroDirecto.seek(0);
            //  System.out.println(rFicheroDirecto.getFilePointer());
            //  System.out.println(rFicheroDirecto.length());
            while (true) {
                int numero;
                StringBuilder nom, apell;
                float sueldo;

                nom = new StringBuilder();
                apell = new StringBuilder();

                numero = rFicheroDirecto.readInt();
                for (int i = 0; i < 10; i++) {
                    nom = nom.append(rFicheroDirecto.readChar());
                }
                for (int i = 0; i < 15; i++) {
                    apell = apell.append(rFicheroDirecto.readChar());
                }
                sueldo = rFicheroDirecto.readFloat();
                System.out.println("Empleado: nº --> " + numero
                        + "\nNombre --> " + nom
                        + "\nApellidos--> " + apell + "\nSueldo -->" + sueldo + " €");
                System.out.println("");
            }


        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (EOFException eofe) {
            System.out.println("Fin de archivo.");
        } catch (IOException ex) {

            System.out.println("Error de E/S al leer o escribir en fichero");
        }
    }
}
