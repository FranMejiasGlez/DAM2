package Ejercicio3;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaConsolaPB {

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
                    pb = new ProcessBuilder("cmd", "/c", "dir", ruta);
                    pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                    pb.redirectError(ProcessBuilder.Redirect.INHERIT);
                    try {
                        p = pb.start();

                        // Leer salida
                        System.out.println("Es un directorio");
                        System.out.println("Comando a ejecutar: ");
                        System.out.println(pb.command());
                        System.out.println("");
                        System.out.println("=== SALIDA ===");
                        p.waitFor();
                        System.out.println("=== FIN SALIDA ===");

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                //Si existe y es un fichero
                if (archivo.isFile()) {

                    try {
                        Process p2;
                        ProcessBuilder pb2;
                        pb2 = new ProcessBuilder("cmd", "/c", "type", ruta);
                        pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);

                        p2 = pb2.start();

                        System.out.println("Es un fichero");
                        System.out.println("Comando a ejecutar: ");
                        System.out.println(pb2.command());
                        System.out.println("");
                        System.out.println("=== SALIDA DEL FICHERO ===");
                        p2.waitFor();
                        System.out.println("\n=== FIN FICHERO ===");
                    } catch (FileNotFoundException fnfe) {
                        System.out.println("Archivo no encontrado");
                    } catch (IOException ioe) {
                        //System.out.println("Error de E/S leyendo fichero");
                        ioe.printStackTrace();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PruebaConsolaPB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                System.out.println("La ruta no existe - " + ruta);
            }
        }
    }
}
