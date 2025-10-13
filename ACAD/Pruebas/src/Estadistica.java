
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 *
 */
public class Estadistica {

    public static void main(String[] args) {
        DataOutputStream fichero;
        DataInputStream ficheroDatos;
        BufferedReader teclado;
        byte numero, total = 0;
        byte frecuencias[] = new byte[11];
        try {
            fichero = new DataOutputStream(
                    new FileOutputStream("./src/Frecuencia.dat"));
            do {

                System.out.println("Ingresa un numero entre 1 y 10: ");
                teclado = new BufferedReader(new InputStreamReader(System.in));
                numero = (byte) Integer.parseInt(teclado.readLine());


                if (numero != 0 && numero >= 1 && numero <= 10) {
                    fichero.writeByte(numero);
                    total++;
                }

            } while (numero != 0);

            System.out.println("");

            try {
                ficheroDatos = new DataInputStream(new FileInputStream("./src/Frecuencia.dat"));

                while (true) {
                    numero = (byte) ficheroDatos.readUnsignedByte();
                    System.out.println(numero);
                    frecuencias[numero]++;
                }

            } catch (EOFException eofe) {
            }
            for (int i = 1; i <= 10; i++) {
                if (frecuencias[i] > 0) {
                    System.out.println("Numero " + i + ": " + frecuencias[i]
                            + (frecuencias[i] == 1 ? " vez --> " : " veces --> ")
                            + (((float) frecuencias[i] / total) * 100) + " %");
                }
            }
        } catch (IOException e) {
        }
    }
}
