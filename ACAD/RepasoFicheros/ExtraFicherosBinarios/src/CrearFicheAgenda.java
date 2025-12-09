
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CrearFicheAgenda {
    public static void main(String[] args) {
        try {
            FileWriter fichero;
            fichero= new FileWriter(new File("/Ficheros/Agenda.dat"));
            
            
            
            
            
            
            
            
            
        } catch (IOException ex) {
            System.out.println("Error de E/S en fichero Agenda.dat");
        }
    }
}
