package Ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class PruebaConsolaRT {

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
                        p = rt.exec(new String[]{"cmd", "/c", "dir", ruta});

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
                        System.out.println("dir " + ruta);
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
                    Process p;
                    Runtime rt;
                    rt = Runtime.getRuntime();
                    String linea;
                    try {
                        p = rt.exec(new String[]{"cmd", "/c", "type", ruta});
                        BufferedReader contenido = new BufferedReader(
                                new InputStreamReader((p.getInputStream())));
                        System.out.println("Es un fichero");
                        System.out.println("Comando a ejecutar: ");
                        System.out.println("type " + ruta);
                        System.out.println("");
                        System.out.println("=== SALIDA DEL FICHERO ===");
                        linea = contenido.readLine();
                        while (linea != null) {
                            System.out.println(linea);
                            linea = contenido.readLine();
                        }
                        contenido.close();
                        p.waitFor();
                    } catch (FileNotFoundException ex) {
                        System.out.println("Archivo no encontrado");
                    } catch (IOException ex) {
                        System.out.println("Error de E/S leyendo fichero");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PruebaConsolaRT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                System.out.println("La ruta no existe - " + ruta);
            }
        }
    }
}
