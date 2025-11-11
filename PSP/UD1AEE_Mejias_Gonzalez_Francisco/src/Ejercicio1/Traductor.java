package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Traductor {

    public static void main(String[] args) {
        String engEs = "en-es";
        String esEng = "es-en";
        Process p;
        ProcessBuilder pb;
        BufferedReader teclado;
        int timeout = 10;
        String seguir;
        String idiomaBase; // URL base que se reutilizará

        teclado = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Configuración inicial
            if (args.length != 2) {
                System.out.println("Numero de parametros incorrecto");
                System.out.println("Uso: java Traductor <segundos> <en-es|es-en>");
                System.out.println("Ejecutando con parametros por defecto:");
                System.out.println("Tiempo de ejecucion: " + timeout + " segundos");
                System.out.println("Idioma: " + esEng);
                idiomaBase = "http://translate.google.es/?hl=es#auto/en";
            } else {
                // Crear la URL base con el primer y segundo idioma del parametro args[1]
                idiomaBase = "http://translate.google.es/?hl="
                        + args[1].substring(0, args[1].indexOf("-"))
                        + "#auto/"
                        + args[1].substring(args[1].indexOf("-") + 1, args[1].length());
                timeout = Integer.parseInt(args[0]);
                System.out.println("Tiempo de ejecucion: " + timeout + " segundos");
                System.out.println("Idioma: " + args[1]);
            }

            do {
                System.out.println("Que quieres traducir?: ");
                String frase = teclado.readLine();

                // Crear la URL completa con la frase a traducir
                String http = idiomaBase + "/" + frase.replace(" ", "%20");

                // Crear un NUEVO ProcessBuilder en cada iteración
                pb = new ProcessBuilder();

                // Verificar Sistema Operativo y configurar comando
                if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                    pb.command("C:\\Archivos de programa\\Internet Explorer", http);
                } else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
                    pb.command("xdg-open", http);
                } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                    pb.command("open", http);
                }

                // Arrancar proceso
                System.out.println("Abriendo navegador con URL: " + http);
                p = pb.start();

                // Gestionar tiempo máximo de ejecución
                Thread.sleep(timeout * 1000);
                p.destroy();

                System.out.println("Ejecutar de nuevo? (s|n)");
                seguir = teclado.readLine();

            } while (seguir.equalsIgnoreCase("s"));

            System.out.println("Programa finalizado.");

        } catch (NumberFormatException nfe) {
            System.out.println("Dato de tiempo no valido, teclee un numero");
        } catch (IOException ex) {
            System.out.println("Error al iniciar proceso: " + ex.getMessage());
        } catch (InterruptedException ex) {
            System.out.println("Proceso interrumpido");
        }
    }
}
