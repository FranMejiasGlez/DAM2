/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadisticaConDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class EscribeEstadistica {

    public static void main(String[] args) {
        byte numero;
        short frecuencia, contador;
        float porcentaje;
        Estadistica estadisticaNumeros[] = new Estadistica[10];
        String linea, caracter;
        boolean seguirEscribiendo, datoInvalido = false;
        BufferedReader teclado = new BufferedReader(
                new InputStreamReader(System.in));
        Estadistica reg;

        for (int i = 0; i < estadisticaNumeros.length; i++) {
            estadisticaNumeros[i] = new Estadistica(
                    (byte) (i + 1), (short) 0, 0.0f);
        }
        contador = 0;
        try {
            seguirEscribiendo = true;
            do {
                datoInvalido = false;

                try {
                    do {

                        frecuencia = 0;
                        porcentaje = 0;
                        System.out.println("Escribe un numero entre 1 y 10: ");
                        linea = teclado.readLine();
                        numero = Byte.parseByte(linea);

                    } while (Byte.parseByte(linea) > 10
                            || Byte.parseByte(linea) < 1);
                    contador++;
                    //Buscar coincidencia, incrementar frecuencia
                    for (Estadistica estadist : estadisticaNumeros) {
                        if (estadist.getNumero() == numero) {
                            estadist.aumentaFrecuencia();
                            break;
                        }
                    }

                } catch (NumberFormatException nfe) {
                    System.out.println("Dato invalido, teclee otro..");
                    datoInvalido = true;
                }

                do {
                    System.out.println("¿Seguir escribiendo? (s/n)");
                    caracter = teclado.readLine();
                } while (!caracter.matches("[sSnN]"));

                seguirEscribiendo = caracter.equalsIgnoreCase("s");

            } while (seguirEscribiendo || datoInvalido);

            for (Estadistica estadist : estadisticaNumeros) {
                if (contador > 0) {
                    float porcen = (estadist.getFrecuencia() / (float) contador) * 100;
                    estadist.setPorcentaje(porcen);
                }
            }
            DataOutputStream escritor = new DataOutputStream(
                    new FileOutputStream("./src/EstadisticaConDAO/Estadistica.dat"));
            System.out.println("Escribiendo archivo Estadistica.dat...");

            //Escribir en el fichero al final del todo
            for (Estadistica estadist : estadisticaNumeros) {
                if (estadist != null) {
                    EstadisticaDAO.escribir(escritor, estadist);
                }
            }
            System.out.println("Completado.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
