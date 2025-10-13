
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejemplo2 {

    public static void main(String[] args) {
        BufferedReader salidaProceso2;
        int salidaProceso1;
        String compilar, ejecutar, linea;
        
        compilar = "javac -d E:\\DAM2\\PSP\\Pruebas\\build\\classes "
                + "E:\\DAM2\\PSP\\Pruebas\\src\\AccesoAJVM.java"; //opcion -d para definir donde crear el class
        ejecutar = "java -cp E:\\DAM2\\PSP\\Pruebas\\build\\classes AccesoAJVM"; // opcion -cp para el classPath
        
        try {
            Process proceso1, proceso2;

            proceso1 = Runtime.getRuntime().exec(compilar);
            salidaProceso1 = proceso1.waitFor();
            
            if (salidaProceso1 != 0) {

                System.out.println("Error al compilar");

            } else {
                proceso2 = Runtime.getRuntime().exec(ejecutar);


                salidaProceso2 = new BufferedReader(
                        new InputStreamReader(proceso2.getInputStream()));
                linea = salidaProceso2.readLine();
                while (linea != null) {
                    System.out.println(linea);
                    linea = salidaProceso2.readLine();
                }
                proceso2.waitFor();
                salidaProceso2.close();
                System.out.println("");
                System.out.println("Compilacion exitosa");
            }
        } catch (Exception e) {
        }
    }
}
