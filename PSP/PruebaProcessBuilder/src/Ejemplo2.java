
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 *
 */
public class Ejemplo2 {

    public static void main(String[] args) {
        BufferedReader salidaSaludo, teclado = new BufferedReader(
                new InputStreamReader(System.in));
        String saludo, ejecutar, compilar, argumentoCompilar, ruta, programaCompilar, programaEjecutar, argumentoEjecutar;
        ProcessBuilder compilarUnSaludo, ejecutarUnSaludo;
        Process procesoSaludo;


        compilar = "javac";
        argumentoCompilar = "-d";
        ruta = "E:\\DAM2\\PSP\\PruebaProcessBuilder\\build\\classes";
        programaCompilar = "E:\\DAM2\\PSP\\PruebaProcessBuilder\\src\\UnSaludo.java";

        ejecutar = "java";
        argumentoEjecutar = "-cp";
        ruta = "E:\\DAM2\\PSP\\PruebaProcessBuilder\\build\\classes";
        programaEjecutar = "UnSaludo";

        System.out.println("Introduce un saludo: ");
        try {
            saludo = teclado.readLine();
            compilarUnSaludo = new ProcessBuilder(
                    compilar, argumentoCompilar, ruta, programaCompilar);
            ejecutarUnSaludo = new ProcessBuilder(
                    ejecutar, argumentoEjecutar, ruta, programaEjecutar, saludo);

            compilarUnSaludo.start();
            procesoSaludo = ejecutarUnSaludo.start();

            salidaSaludo = new BufferedReader(
                    new InputStreamReader(procesoSaludo.getInputStream()));
        } catch (IOException ioe) {
        }

    }
}
