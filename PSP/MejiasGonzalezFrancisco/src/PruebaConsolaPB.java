
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

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
                        System.out.println("dir " + ruta);
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
                    String linea;
                    try {
                        BufferedReader contenido = new BufferedReader(
                                new InputStreamReader(new FileInputStream(ruta)));
                        System.out.println("Es un fichero");
                        System.out.println("Comando a ejecutar: ");
                        System.out.println("java PruebaConsolaPB " + ruta);
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
