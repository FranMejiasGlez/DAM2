
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        FileReader fichero1 = null, fichero2 = null;
        boolean esFichero = true;
        Process proceso;
        ProcessBuilder pb;
        FileWriter ficheroErrores = null;

        try {
            ficheroErrores = new FileWriter("Errores.txt");
            ficheroErrores.close();

            ficheroErrores = new FileWriter("Errores.txt", true);
            if (args.length < 1 || args.length > 2) {
                System.out.println("Error de formato, modo uso: ");
                System.out.println("Comparar ficheros: ");
                System.out.println("");
                System.out.println("java Utilidades [RutaFichero1] [RutaFichero2]");
                System.out.println("");
                System.out.println("Comprobar existencia de user en sistema operativo: ");
                System.out.println("");
                System.out.println("java Utilidades [NombreUsuario]");
            } else {
                //Si son 2 parametros --> Comparar ficheros
                if (args.length == 2) {
                    System.out.println("Modo: Comparacion de ficheros");
                    try {
                        fichero1 = new FileReader(args[0]);
                    } catch (FileNotFoundException fnfe) {
                        System.out.println("Fichero 1 no encontrado");
                        esFichero = false;
                        try {
                            ficheroErrores.write("Fichero 1 no encontrado\n");
                        } catch (IOException ex) {
                            System.out.println("Error al escribir en fichero de errores");
                        }
                    }

                    try {
                        fichero2 = new FileReader(args[1]);
                    } catch (FileNotFoundException fnfe) {
                        System.out.println("Fichero 2 no encontrado");
                        esFichero = false;
                        try {
                            ficheroErrores.write("Fichero 2 no encontrado\n");
                        } catch (IOException ex) {
                            System.out.println("Error al escribir en fichero de errores");
                        }
                    }

                    if (esFichero == false) {
                        System.out.println("Error de parametros,"
                                + " se esperaba encontrar: java Utilidades [Ruta Fichero1] [Ruta Fichero2]");
                    } else {//Si son ficheros
                        pb = new ProcessBuilder();
                        if (ES_WINDOWS) {
                            //Comparar ficheros con fc

                            pb.command().add("cmd");
                            pb.command().add("/c");
                            pb.command().add("fc");
                            pb.command().add(args[0]);  // Usa args[0] directamente
                            pb.command().add(args[1]);  // Usa args[1] directamente

                            System.out.println("Ejecutando comparacion");


                        } else {//ES_LINUX
                            pb.command().add("diff");
                            pb.command().add(args[0]);  // Usa args[0] directamente
                            pb.command().add(args[1]);  // Usa args[1] directamente
                        }
                        //COMPARAR FICHEROS
                        if (fichero1 != null && fichero2 != null) {
                            try {
                                File errores = new File("Errores.txt");
                                pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                                pb.redirectError(ProcessBuilder.Redirect.to(errores));
                                proceso = pb.start();
                                proceso.waitFor();  // Esperar a que termine
                            } catch (IOException ex) {
                                System.out.println("Error al arrancar proceso fc");
                            } catch (InterruptedException ex) {
                                System.out.println("Proceso fc interrumpido");
                            } finally {
                                fichero1.close();
                                fichero2.close();
                            }
                        }
                    }
                } else {// Es 1 parametro
                    pb = new ProcessBuilder();
                    //Si es 1 parametro - buscar usuario
                    if (ES_WINDOWS) {
                        if (args.length == 1) {
                            System.out.println("Comprobando usuario " + args[0]
                                    + " en sistema");

                            pb.command().add("cmd");
                            pb.command().add("/c");
                            pb.command().add("net");
                            pb.command().add("user");
                            pb.command().add(args[0]);
                            System.out.println("Ejecutando comando:"
                                    + pb.command().toString());


                        }
                    } else {//ES_LINUX

                        // Linux: id -u [args[0]]
                        // Si el usuario existe, retorna 0 (éxito). Si no existe, retorna >0 (error).
                        pb.command().add("id");
                        pb.command().add("-u");
                        pb.command().add(args[0]);// Usa args[0] directamente
                        System.out.println("Ejecutando comando:"
                                + pb.command().toString());

                    }
                    try {
                        String linea;
                        boolean existe = false;
                        pb.redirectOutput(ProcessBuilder.Redirect.PIPE);
                        pb.redirectError(ProcessBuilder.Redirect.PIPE);
                        proceso = pb.start();

                        BufferedReader lector = new BufferedReader(
                                new InputStreamReader(
                                proceso.getInputStream()));

                        // Lógica de lectura: solo relevante para Windows
                        while ((linea = lector.readLine()) != null) {
                            // Comprobación para Windows (español e inglés)
                            if (ES_WINDOWS && (linea.contains("Nombre de usuario")
                                    || linea.contains("User name"))) {
                                existe = true;
                            }
                        }
                        int exitCode = proceso.waitFor();

                        // LÓGICA DE CORRECCIÓN PARA LINUX/UNIX
                        // En sistemas Unix, id -u devuelve 0 si el usuario existe.
                        if (ES_UNIX && exitCode == 0) {
                            existe = true;
                        }

                        if (existe) {
                            System.out.println("El usuario " + args[0]
                                    + " EXISTE (código de salida: " + exitCode + ")");
                        } else {
                            System.out.println("El usuario " + args[0]
                                    + " NO EXISTE (código de salida: " + exitCode + ")");
                        }
                        proceso.waitFor();


                    } catch (IOException ioe) {
                        System.out.println("Error al arrancar proceso"
                                + pb.command());
                    } catch (InterruptedException ex) {
                        System.out.println("Proceso "
                                + pb.command());
                    }
                }
            }
        } catch (FileNotFoundException fnfErrores) {
            System.out.println("Error al crear o sobreescribir Fichero"
                    + " Errores.txt");
        } catch (IOException ex) {
            System.out.println("Error al escribir en fichero de errores");
        } finally {
            try {
                ficheroErrores.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar Fichero errores");
            }
        }
    }
}