
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class PruebaConsolaRTLinux {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Debe proporcionar 1 argumento");
        } else {
            String ruta;
            ruta = args[0];
            File archivo = new File(ruta);
            //Si existe y es un directorio
            if (archivo.exists()) {
                if (archivo.isDirectory()) {
                    Process p;
                    Runtime rt;
                    rt = Runtime.getRuntime();
                    try {
                        p = rt.exec(new String[]{"ls", "-la", ruta});

                        // Leer salida normal
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(p.getInputStream()));

                        //Leer errores
                        BufferedReader errorReader = new BufferedReader(
                                new InputStreamReader(p.getErrorStream()));

                        String linea;

                        // Leer salida
                        System.out.println("Es un directorio");
                        System.out.println("Comando a ejecutar: ");
                        System.out.println("ls -la " + ruta);
                        System.out.println("");
                        System.out.println("=== SALIDA DEL DIR ===");
                        while ((linea = reader.readLine()) != null) {
                            System.out.println(linea);
                        }

                        // Leer errores
                        System.out.println("=== ERRORES ===");
                        while ((linea = errorReader.readLine()) != null) {
                            System.out.println("ERROR: " + linea);
                        }

                        p.waitFor();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                //Si existe y es un fichero
                if (archivo.isFile()) {
                    String linea;
                    try {
                        Process p2;
                        Runtime rt = Runtime.getRuntime();
                        p2 = rt.exec(new String[]{"cat", ruta});
                        BufferedReader lector =
                                new BufferedReader(
                                new InputStreamReader(p2.getInputStream()));
                        System.out.println("Es un fichero");
                        System.out.println("Comando a ejecutar: ");
                        System.out.println("cat " + ruta);
                        System.out.println("");
                        System.out.println("=== SALIDA DEL FICHERO ===");
                        linea = lector.readLine();
                        while (linea != null) {
                            System.out.println(linea);
                            linea = lector.readLine();
                        }
                    } catch (FileNotFoundException ex) {
                        System.out.println("Archivo no encontrado");
                    } catch (IOException ex) {
                        System.out.println("Error de E/S leyendo fichero");
                    }
                }
            } else {
                System.out.println("La ruta no existe - " + ruta);
            }
        }
    }
}
