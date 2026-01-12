/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.Random;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Liebre extends Animal {

    @Override
    public void run() {
        Random r = new Random();
        do {
            int numeroAleatorio = super.getMin() + r.nextInt(super.getMax() - super.getMin() + 1);
            long sleepTime = 1000; // Por defecto 1 segundo

            if (numeroAleatorio <= 20) {
                // Duerme (20%)
                // System.out.println("Duerme");
                sleepTime = 2000; // Espera 2 segundos
                // casilla no cambia
            } else if (numeroAleatorio <= 40) {
                // Gran Salto (20%)
                super.setCasilla((byte) (getCasilla() + 9));
                // System.out.println("Gran Salto: +9");
            } else if (numeroAleatorio <= 50) {
                // Resbalón grande (10%)
                super.setCasilla((byte) (getCasilla() - 12));
                // System.out.println("Resbalón grande: -12");
            } else if (numeroAleatorio <= 80) {
                // Pequeño Salto (30%)
                super.setCasilla((byte) (getCasilla() + 1));
                // System.out.println("Pequeño Salto: +1");
            } else { // numeroAleatorio <= 100
                // Resbalon pequeño (20%)
                super.setCasilla((byte) (getCasilla() - 2));
                // System.out.println("Resbalón pequeño: -2");
            }

            // Asegura que la casilla no baje de 1 (inicio) ni suba de super.getMETA() (fin)
            if (super.getCasilla() < 1) {
                super.setCasilla((byte) 1);
            }
            if (super.getCasilla() > super.getMETA()) {
                super.setCasilla((byte) super.getMETA());  // La meta
            }

            try {
                Thread.sleep(sleepTime); // Usa el tiempo de espera calculado
            } catch (InterruptedException ie) {
                System.out.println("Hilo Liebre interrumpido");
            }
            StringBuilder salida;
            salida = new StringBuilder();
            for (int i = 1; i < super.getCasilla(); i++) {
                salida.append(" ");
            }
            System.out.println(salida + String.valueOf(getInicial()));
            // System.out.println(getCasilla());
        } while (this.getCasilla() < super.getMETA());

        System.out.println("Liebre llega a meta");
    }

    @Override
    public char getInicial() {
        return 'L';
    }
}