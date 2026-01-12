
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejemplo3 {

    public static void main(String[] args) throws InterruptedException {
        Process cambiarFecha;
        String comando, linea, leerTeclado;
        comando = "cmd /c date";

        BufferedReader salidaProceso, teclado;
        BufferedWriter entradaProceso;
        try {
            // Ejecuto date
            cambiarFecha = Runtime.getRuntime().exec(comando);

            // Despues de ejecutar, ESCRIBIR la fecha
            System.out.println("Escribe la fecha nueva: ");
            teclado = new BufferedReader(new InputStreamReader(System.in));
            leerTeclado = teclado.readLine();

            entradaProceso = new BufferedWriter(
                    new OutputStreamWriter(cambiarFecha.getOutputStream()));
            entradaProceso.write(leerTeclado);
            entradaProceso.newLine();
            entradaProceso.flush();
            entradaProceso.close();

            // AHORA SÍ leer toda la salida
            salidaProceso = new BufferedReader(
                    new InputStreamReader(cambiarFecha.getInputStream()));
            linea = salidaProceso.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = salidaProceso.readLine();
            }

            cambiarFecha.waitFor();

            //Leer fecha actual sin cambiar para confirmar que se cambio antes
            cambiarFecha = Runtime.getRuntime().exec("cmd /c date /t");

            salidaProceso = new BufferedReader(
                    new InputStreamReader(cambiarFecha.getInputStream()));
            linea = salidaProceso.readLine();
            while (linea != null) {
                System.out.println("Fecha actual: " + linea);
                linea = salidaProceso.readLine();
            }
        } catch (IOException ioe) {
        }
    }
}
