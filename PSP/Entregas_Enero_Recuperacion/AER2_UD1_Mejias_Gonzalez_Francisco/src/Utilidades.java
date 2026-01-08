import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Utilidades {

    private static final String OS = System.getProperty("os.name").toLowerCase();
    private static final boolean ES_WINDOWS = OS.contains("win");
    private static final boolean ES_UNIX = (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));

    public static void main(String[] args) {
        if (!ES_WINDOWS && !ES_UNIX) {
            System.out.println("Sistema operativo no soportado: " + OS);
            return;
        }

        Process proceso;
        boolean parametrosValidos = true;

        try {
            // Crear archivo de errores (se sobrescribe en cada ejecución)
            File archivoErrores = new File("Errores.DAT");

            if (args.length < 1 || args.length > 2) {
                System.out.println("Error de formato, modo uso: ");
                System.out.println("Comparar ficheros: ");
                System.out.println("");
                System.out.println("java Utilidades [RutaFichero1] [RutaFichero2]");
                System.out.println("");
                System.out.println("Comprobar existencia de user en sistema operativo: ");
                System.out.println("");
                System.out.println("java Utilidades [NombreUsuario]");
                parametrosValidos = false;
            }

            if (parametrosValidos) {
                ProcessBuilder pb;

                // Si son 2 parametros --> Comparar ficheros
                if (args.length == 2) {
                    System.out.println("Modo: Comparacion de ficheros");

                    if (ES_WINDOWS) {
                        // fc es comando EXTERNO en Windows (ubicado en System32)
                        pb = new ProcessBuilder("fc", args[0], args[1]);
                        System.out.println("Ejecutando comparacion en Windows");
                    } else {
                        // diff es comando EXTERNO en Unix
                        pb = new ProcessBuilder("diff", args[0], args[1]);
                        System.out.println("Ejecutando comparacion en Unix/Linux");
                    }

                    // Redirigir errores al archivo (se sobrescribe)
                    pb.redirectError(ProcessBuilder.Redirect.to(archivoErrores));
                    
                    proceso = pb.start();

                    // Leer y mostrar la salida estandar
                    BufferedReader lector = new BufferedReader(
                            new InputStreamReader(proceso.getInputStream()));
                    String linea;
                    while ((linea = lector.readLine()) != null) {
                        System.out.println(linea);
                    }

                    proceso.waitFor();
                    System.out.println("Comparacion finalizada. Errores guardados en Errores.DAT");

                } else {
                    // Es 1 parametro - buscar usuario
                    System.out.println("Comprobando usuario " + args[0] + " en sistema");

                    if (ES_WINDOWS) {
                        // net user es comando EXTERNO en Windows (ubicado en System32)
                        pb = new ProcessBuilder("net", "user", args[0]);
                    } else {
                        // id es comando EXTERNO en Unix
                        pb = new ProcessBuilder("id", "-u", args[0]);
                    }

                    // Redirigir errores al archivo (se sobrescribe)
                    pb.redirectError(ProcessBuilder.Redirect.to(archivoErrores));
                    
                    proceso = pb.start();

                    // Leer la salida sin mostrarla
                    BufferedReader lector = new BufferedReader(
                            new InputStreamReader(proceso.getInputStream()));
                    String linea;
                    boolean existe = false;

                    while ((linea = lector.readLine()) != null) {
                        // Comprobacion para Windows (español e ingles)
                        if (ES_WINDOWS && (linea.contains("Nombre de usuario")
                                || linea.contains("User name"))) {
                            existe = true;
                        }
                    }

                    int exitCode = proceso.waitFor();

                    // En sistemas Unix, id -u devuelve 0 si el usuario existe
                    if (ES_UNIX && exitCode == 0) {
                        existe = true;
                    }

                    // Mostrar solo el resultado final
                    if (existe) {
                        System.out.println("EXISTE");
                    } else {
                        System.out.println("NO EXISTE");
                    }
                }
            }

        } catch (IOException ex) {
            System.out.println("Error al ejecutar proceso: " + ex.getMessage());
        } catch (InterruptedException ex) {
            System.out.println("Proceso interrumpido: " + ex.getMessage());
        }
    }
}