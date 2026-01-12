/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaDAO;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class LeerFichAgendaDat {

    public static void main(String[] args) {
        try {
            PersonaAgenda persona = null;
            String nombre, direccion, telefono, ruta;
            byte edad;

            DataInputStream fichero;
            boolean isFF;

            ruta = "Ficheros/Agenda.dat";
            fichero = new DataInputStream(new FileInputStream(ruta));

            isFF = true;
            try {
                while (isFF == true) {
                    nombre = fichero.readUTF();
                    edad = fichero.readByte();
                    direccion = fichero.readUTF();
                    telefono = fichero.readUTF();
                    persona = new PersonaAgenda(nombre, edad, direccion, telefono);
                    System.out.println("Contacto: ");
                    System.out.println(nombre + "\n" + edad
                            + "\n" + direccion + "\n" + telefono);
                    System.out.println("Fin Contacto.");
                    System.out.println("");
                }
            } catch (EOFException eofe) {
                System.out.println("Fin de fichero Agenda.dat");
                isFF = true;
            } catch (IOException ex) {
                System.out.println("Error de E/S leyendo del fichero Agenda.dat");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero Agenda.dat no encontrado");
        }
    }
}
