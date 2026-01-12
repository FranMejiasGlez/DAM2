
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
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
public class Ej1 {

    public static void main(String[] args) {
        int numero = -1;
        String salida = "";
        BufferedReader teclado;
        boolean valido;
        teclado = new BufferedReader(new InputStreamReader(System.in));
        try {
            //Entrada de datos
            do {
                valido = true;
                System.out.println("Introduce un numero entre 2 y 50: ");
                try {
                    numero = Integer.parseInt(teclado.readLine());
                    if (numero < 2 || numero > 50) {
                        valido = false;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Dato inválido, teclee otro...");
                    valido = false;
                }
            } while (!valido);
            //System.out.println(numero);
            //Crear fichero en src

            File archivoTexto, carpeta;
            FileWriter escritura;
            try {

                carpeta = new File("./src/Ficheros");
                carpeta.mkdir();
                archivoTexto = new File("./src/Ficheros/muestra.txt");
                archivoTexto.createNewFile();
                escritura = new FileWriter(archivoTexto, false);

                //Logica

                for (char c = 'A'; c <= 'Z'; c++) { // De la A a la Z


                    for (int j = 1; j <= numero; j++) { //Escribir el numero de veces el caracter

                        escritura.append(c);
                    }

                    escritura.append("\n");

                }
                for (char c = 'a'; c <= 'z'; c++) { // De la A a la Z

                    for (int j = 1; j <= numero; j++) { //Escribir el numero de veces el caracter

                        escritura.append(c);
                    }

                    escritura.append("\n");

                }

                escritura.close();

            } catch (Exception e) {
            }
        } catch (IOException ioe) {
            System.out.println("Error de E/S");
        }

    }
}
