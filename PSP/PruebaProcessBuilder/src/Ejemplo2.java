
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;

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
        BufferedReader teclado = new BufferedReader(
                new InputStreamReader(System.in));
        String saludo, ejecutar, compilar, argumentoCompilar, ruta, programaCompilar, programaEjecutar, argumentoEjecutar;
        ProcessBuilder compilarUnSaludo, ejecutarUnSaludo;
        Process procesoSaludoCompilar, procesoSaludoEjecutar;
        BufferedReader salidaSaludo;
        Map<String, String> env;

        //Comandos para compilar
        compilar = "javac";
        argumentoCompilar = "-d";
        ruta = "E:\\DAM2\\PSP\\PruebaProcessBuilder\\build\\classes";
        programaCompilar = "E:\\DAM2\\PSP\\PruebaProcessBuilder\\src\\UnSaludo.java";

        //Comandos para ejecutar
        ejecutar = "java";
        argumentoEjecutar = "-cp";
        ruta = "E:\\DAM2\\PSP\\PruebaProcessBuilder\\build\\classes";
        programaEjecutar = "UnSaludo";

        System.out.println("Introduce un saludo: ");
        try {
            saludo = teclado.readLine();
            System.out.println("");
            compilarUnSaludo = new ProcessBuilder(compilar, argumentoCompilar, ruta, programaCompilar);
            System.out.println("Compilando UnSaludo.java con parametro: " + saludo);
            System.out.println("");

            ejecutarUnSaludo = new ProcessBuilder(ejecutar, argumentoEjecutar, ruta, programaEjecutar, saludo);
            System.out.println("Ejecutando UnSaludo");
            System.out.println("");

            //Asignar el start con el process para poder gestionar salidas
            procesoSaludoCompilar = compilarUnSaludo.start();
            //Asignar el start con el process para poder gestionar salidas
            procesoSaludoEjecutar = ejecutarUnSaludo.start();
            System.out.println("Salida de UnSaludo: ");
            System.out.println("");
            salidaSaludo = new BufferedReader(
                    new InputStreamReader(procesoSaludoEjecutar.getInputStream()));
            saludo = salidaSaludo.readLine();

            System.out.println(saludo);

            System.out.println("Variables de entorno");
            System.out.println("");

            System.out.println("Propiedad: NOMBRE => VALOR");
            env = compilarUnSaludo.environment();

            for (Map.Entry<String, String> entry : env.entrySet()) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }

            System.out.println("Comando para compilar: ");
            System.out.println("");
            for (String comando : compilarUnSaludo.command()) {
                System.out.println(comando);
            }

            System.out.println("");

            System.out.println("Comando para ejecutar: ");
            System.out.println("");
            for (String comando : ejecutarUnSaludo.command()) {
                System.out.println(comando);
            }
        } catch (IOException ioe) {
        }

    }
}
