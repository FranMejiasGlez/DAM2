
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class EscribeEstadistica {

    public static void main(String[] args) {
        List<Estadistica> lista;
        REstadisticaDAO rE;
        BufferedReader teclado;
        byte numero = -1;
        // byte contador = 0;
        boolean invalido;

        lista = new LinkedList();
        for (int i = 1; i <= 10; i++) {
            lista.add(new Estadistica((byte) i, (short) 0, 0F));
        }
        try {
            rE = new REstadisticaDAO("Estadistica.dat", "rw");
            teclado = new BufferedReader(new InputStreamReader(System.in));
            do {
                try {
                    invalido = false;
                    System.out.println("Ingresa un numero entre 1 y 10 "
                            + "| 0 para salir:");
                    System.out.println("");
                    numero = Byte.parseByte(teclado.readLine());
                    for (Estadistica e : lista) {
                        //contador++;
                        if (e.getNumero() == numero) {
                            e.aumentaFrecuencia();
                            rE.escribir(e, numero);
                        }
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Dato Invalido, teclee otro..");
                    invalido = true;
                }

            } while (invalido || numero != 0);
        } catch (IOException ioe) {
            System.out.println("Error de E/S Al leer o escribir");
        }

    }
}
