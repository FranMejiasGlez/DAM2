
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
 * @author Administrador
 */
public class PruebaConsolaPBLinux {

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
                    ProcessBuilder pb;
                    pb = new ProcessBuilder("ls", "-la", ruta);
                    try {
                        p = pb.start();

                        // Leer salida
                        System.out.println("Es un directorio");
                        System.out.println("Comando a ejecutar: ");
                        System.out.println(pb.command(args));
                        System.out.println("");
                        System.out.println("=== SALIDA DEL DIR ===");


                        // Leer errores
                        System.out.println("=== ERRORES ===");
                        System.out.println(pb.redirectError());
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
                        BufferedReader contenido = new BufferedReader(
                                new InputStreamReader(new FileInputStream(ruta)));
                        System.out.println("Es un fichero");
                        System.out.println("Comando a ejecutar: ");
                        System.out.println("java PruebaConPB " + ruta);
                        System.out.println("");
                        System.out.println("=== SALIDA DEL FICHERO ===");
                        linea = contenido.readLine();
                        while (linea != null) {
                            System.out.println(linea);
                            linea = contenido.readLine();
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
