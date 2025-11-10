
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
public class EscribePersona implements Serializable {

    public static void main(String[] args) {
        ObjectOutputStream oos;
        File fichero;
        FileOutputStream ficheroObjetos;
        Persona persona1, persona2, persona3;
        try {
            fichero = new File("Persona.dat");
            ficheroObjetos = new FileOutputStream(fichero, true);
            oos = new ObjectOutputStream(ficheroObjetos);
            persona1 = new Persona("Fran", "Mejias", 28, "12345678A", "Femenino");
            persona2 = new Persona("Andy", "Jan", 35, "87654321B", "Masculino");
            persona3 = new Persona("Pablo", "Fuentes", 16, "11223344C", "Femenino");

            oos.writeObject(persona1);
            oos.writeObject(persona2);
            oos.writeObject(persona3);
            oos.close();
            System.out.println("Fichero Persona.dat creado y se ha introducido 3 personas");
        } catch (FileNotFoundException fnfe) {
            System.out.println("fichero no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de E/S al escribir en fichero");
        }
    }
}
