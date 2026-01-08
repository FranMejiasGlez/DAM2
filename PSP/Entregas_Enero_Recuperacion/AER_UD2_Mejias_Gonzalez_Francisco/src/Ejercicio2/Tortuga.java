package Ejercicio2;

import java.util.Random;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Tortuga extends Animal {

    @Override
    public void run() {
        Random r = new Random();
        do {
            int numeroAleatorio = super.getMin() + r.nextInt(super.getMax() - super.getMin() + 1);
            long sleepTime = 1000;

            if (numeroAleatorio <= 50) {
                // Avance rapido (50%)
                super.setCasilla((byte) (super.getCasilla() + 3));
            } else if (numeroAleatorio <= 70) {
                // Resbalo (20%)
                if (this.getCasilla() - 6 >= 1) {
                    super.setCasilla((byte) (super.getCasilla() - 6));
                } else {
                    super.setCasilla((byte) 1);
                }
            } else {
                // Avance lento (30%)
                super.setCasilla((byte) (super.getCasilla() + 1));
            }

            // Asegura que la casilla no suba de la META
            if (super.getCasilla() > super.getMETA()) {
                super.setCasilla((byte) super.getMETA());
            }

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ie) {
                 System.out.println("Hilo Tortuga interrumpido");
            }

            StringBuilder salida = new StringBuilder();
            for (int i = 1; i < super.getCasilla(); i++) {
                salida.append(" ");
            }
            System.out.println(salida + String.valueOf(getInicial()));

        } while (this.getCasilla() < super.getMETA());

        System.out.println("Tortuga llega a meta");
    }

    @Override
    public char getInicial() {
        return 'T';
    }
}
