package Ejercicio6;

import java.util.Random;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
class GenerarAleatorios {

    public static void main(String[] args) {
        Random r = new Random();
        int min = 0;
        int max = 10;

        int numeroAleatorio = min + r.nextInt(max - min + 1);

        System.out.println("Numero generado: " + numeroAleatorio );
        System.exit(numeroAleatorio);
    }
}
