package Ejercicio6;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Aleatorios {

    public static Process exec(Class clase) throws IOException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator
                + "bin" + File.separator + "java";
        String classPath = System.getProperty("java.class.path");
        String className = clase.getCanonicalName();
        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classPath, className);
        return builder.start();
    }

    public static void main(String[] args) {
        boolean relanzar = true;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String linea;
        do {
            try {
                Process p;
                BufferedReader salidaNumero;
                p = Aleatorios.exec(GenerarAleatorios.class);
                salidaNumero = new BufferedReader(new InputStreamReader(p.getInputStream()));
                linea = salidaNumero.readLine();
                System.out.println(linea);
                String numeroStr = linea.replaceAll("[^0-9]", "");
                int numeroGenerado = Integer.parseInt(numeroStr);
                int salidaProceso = p.waitFor();
                System.out.println("Valor devuelto coincide con generado: "
                        + (salidaProceso == numeroGenerado ? "Si " : "No ") + numeroGenerado);
                System.out.println("Relanzar proceso? (s,n)");
                linea = teclado.readLine();
                relanzar = linea.equalsIgnoreCase("s");
            } catch (IOException ioe) {
                System.out.println("Error de E/S al leer por teclado");

            } catch (InterruptedException ex) {
                Logger.getLogger(Aleatorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (relanzar);
    }
}
