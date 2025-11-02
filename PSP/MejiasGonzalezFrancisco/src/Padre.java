
import java.io.BufferedReader;
import java.io.File;
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
public class Padre {

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
        do {
            try {
                String linea;
                int codigoSalida;
                BufferedReader salidaHijo, teclado;
                Process p = Padre.exec(Hijo.class);
                salidaHijo = new BufferedReader(new InputStreamReader(p.getInputStream()));
                linea = salidaHijo.readLine();
                while (linea != null) {
                    System.out.println(linea);
                    linea = salidaHijo.readLine();
                }
                codigoSalida = p.waitFor();
                System.out.println("Codigo Salida: " + codigoSalida);
                teclado = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("¿Relanzar hijo? (s/n): ");
                linea = teclado.readLine();
                relanzar = linea.equalsIgnoreCase("s");
            } catch (IOException ioe) {
                System.out.println("Error de E/S al ejecutar proceso");;

            } catch (InterruptedException ine) {
                System.out.println("Proceso interrumpido");;
            }
        } while (relanzar);
    }
}