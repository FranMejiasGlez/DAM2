
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class LeePersona {

    public static void main(String[] args) {
        FileInputStream ficheroObjetos;
        File fichero;
        ObjectInputStream ois;
        Object obj;
        try {
            fichero = new File("Persona.dat");
            ficheroObjetos = new FileInputStream(fichero);
            ois = new ObjectInputStream(ficheroObjetos);
            obj = ois.readObject();
            while (true) {
                System.out.println(((Persona) obj).getNombre());
                obj = ois.readObject();
            }
     //       ois.close();
        } catch (IOException ioe) {
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Fin archivo");
        }
    }
}
