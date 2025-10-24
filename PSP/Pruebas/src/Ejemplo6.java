
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejemplo6 {

    public static void main(String[] args) {
        String compilar, ejecutar;
        Process procesoHijoCompilar, procesoHijoEjecutar;
        compilar = "javac -d PruebaHijo E:\\DAM2\\PSP\\Pruebas\\build\\classes"
                + " E:\\DAM2\\PSP\\Pruebas\\src\\PruebaHijo.java";
        ejecutar = "java -cp E:\\DAM2\\PSP\\Pruebas\\build\\classes PruebaHijo";
        try {
            procesoHijoCompilar = Runtime.getRuntime().exec(compilar);
            procesoHijoEjecutar = Runtime.getRuntime().exec(ejecutar);
        } catch (IOException ioe) {
            System.out.println("Error de E/S");
        }
    }
}
