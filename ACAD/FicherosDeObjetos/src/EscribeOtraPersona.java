
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class EscribeOtraPersona {

    public static void main(String[] args) {
        ObjectOutputStream oos;
        File fichero;
        FileOutputStream ficheroObjetos;
        Persona persona1, persona2, persona3;
        try {
            fichero = new File("Persona.dat");
            ficheroObjetos = new FileOutputStream(fichero, true);
            oos = new ObjectOutputStream(ficheroObjetos);
            persona1 = new Persona("Anabel", "Mejias", 28, "12345678A", "Femenino");
          

            oos.writeObject(persona1);
           
            oos.close();
            System.out.println("Fichero Persona.dat creado y se ha introducido 1 personas");
        } catch (FileNotFoundException fnfe) {
            System.out.println("fichero no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de E/S al escribir en fichero");
        }
    }
}
