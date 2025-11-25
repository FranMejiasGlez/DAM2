
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Traductor {

    private static String getIEPath() {
        final String IE_EXECUTABLE = "\\Internet Explorer\\iexplore.exe";

        // 1. %ProgramFiles(x86)% (Sistemas 64-bit)
        String pfX86 = System.getenv("ProgramFiles(x86)");
        if (pfX86 != null) {
            String pathX86 = pfX86 + IE_EXECUTABLE;
            if (new File(pathX86).exists()) {
                return pathX86;
            }
        }

        // 2. %ProgramFiles% (Sistemas 32-bit)
        String pf = System.getenv("ProgramFiles");
        if (pf != null) {
            String pathStandard = pf + IE_EXECUTABLE;
            if (new File(pathStandard).exists()) {
                return pathStandard;
            }
        }

        // 3.Defecto
        System.out.println("ADVERTENCIA: No se encontró la ruta de IE mediante variables de entorno. Usando ruta ingles");
        return "C:\\Program Files\\Internet Explorer\\iexplore.exe";
    }

    public static void main(String[] args) {
        String engEs = "en-es";
        String esEng = "es-en";
        Process p;
        ProcessBuilder pb;
        BufferedReader teclado;
        int timeout = 10;
        String idiomaBase, argumentoIdioma, frase, seguir; // URL base que se reutilizará
        String[] idiomas;
        final String RUTA_IE = getIEPath();

        teclado = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Configuración inicial
            if (args.length != 2) {
                System.out.println("Numero de parametros incorrecto");
                System.out.println("Uso: java Traductor [segundos] [en-es|es-en]");
                System.out.println("Ejecutando con parametros por defecto:");
                System.out.println("Tiempo de ejecucion: " + timeout + " segundos");
                System.out.println("Idioma: " + esEng);
                idiomaBase = "http://translate.google.es/?hl=es#auto/en";
            } else {
                argumentoIdioma = args[1];
                idiomas = argumentoIdioma.split("-");
                // Crear la URL base con el primer y segundo idioma del parametro args[1]
                idiomaBase = "http://translate.google.es/?hl="
                        + idiomas[0]
                        + "#auto/"
                        + idiomas[1];
                timeout = Integer.parseInt(args[0]);
                System.out.println("Tiempo de ejecucion: " + timeout + " segundos");
                System.out.println("Idioma: " + args[1]);
            }

            do {

                do {
                    System.out.println("Que quieres traducir?: ");
                    frase = teclado.readLine();
                } while (frase.isEmpty());
                // Crear la URL completa con la frase a traducir
                String http = idiomaBase + "/" + frase.replace(" ", "%20");

                // Crear un NUEVO ProcessBuilder en cada iteración
                pb = new ProcessBuilder();

                // Verificar Sistema Operativo y configurar comando

                pb.command(RUTA_IE, http);


                // Arrancar proceso
                System.out.println("Abriendo navegador con URL: " + http);
                p = pb.start();

                // Gestionar tiempo máximo de ejecución
                Thread.sleep(timeout * 1000);
                // Intentar destruir el proceso (el navegador)

                p.destroy();
                System.out.println("Tiempo de ejecución de "
                        + timeout + " segundos terminado. Cerrando navegador.");


                System.out.println("Ejecutar de nuevo? (s|n)");
                seguir = teclado.readLine();

            } while (seguir.equalsIgnoreCase("s"));

            System.out.println("Programa finalizado.");

        } catch (NumberFormatException nfe) {
            System.out.println("Dato de tiempo no valido, teclee un numero");
            System.out.println("Uso: java Traductor [segundos] [en-es|es-en]");
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            System.out.println("Parametro de lenguaje erroneo");
            System.out.println("Uso: java Traductor [segundos] [en-es|es-en]");
        } catch (IOException ex) {
            System.out.println("Error al iniciar proceso: " + ex.getMessage());
        } catch (InterruptedException ex) {
            System.out.println("Proceso interrumpido");
        }
    }
}
