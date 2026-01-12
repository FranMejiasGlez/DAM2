
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import tipoPruebaDAO.TipoPruebaDAO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        FileWriter pruebas = null;
        TipoPruebaDAO opcional = null, obligatorio = null;
        try {
            pruebas = new FileWriter(new File("Ficheros/pruebas.txt"));

            opcional = new TipoPruebaDAO("Ficheros/opcional.dat", "r");
            obligatorio = new TipoPruebaDAO("Ficheros/obligatorio.dat", "r");

            while (!opcional.isFf()) {
                tipoPruebaDAO.Prueba p = opcional.leer();
                if (p != null && p.getNumeroPrueba() != 0) {
                    pruebas.write("opcional;" + p.toString());
                    pruebas.write("\n");
                }
            }
            while (!obligatorio.isFf()) {
                tipoPruebaDAO.Prueba p = obligatorio.leer();
                if (p != null && p.getNumeroPrueba() != 0) {
                    pruebas.write("obligatorio;" + p.toString());
                    pruebas.write("\n");
                }
            }
            System.out.println("Fichero generado: ../Ficheros/pruebas.txt");
        } catch (IOException ex) {
            System.out.println("Error de E/S");
        } finally {
            try {
                if (pruebas != null) {
                    pruebas.close();
                }
                if (opcional != null) {
                    opcional.cerrar();
                }
                if (obligatorio != null) {
                    obligatorio.cerrar();
                }
            } catch (IOException ex) {
                System.out.println("Error al cerrar ficheros");
            }
        }
    }
}