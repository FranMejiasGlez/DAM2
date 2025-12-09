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

    private byte casilla = 1;
    private int max, min;
    private Animal estado;

    public Liebre(int max, int min, Animal estado) {
        this.max = max;
        this.min = min;
        this.estado = estado;
    }

    @Override
    public void run() {
        Random r = new Random();
        do {
            int numeroAleatorio = min + r.nextInt(this.max - this.min + 1);
            long sleepTime = 1000; // Por defecto 1 segundo

            if (numeroAleatorio <= 20) {
                // Duerme (20%)
                // System.out.println("Duerme");
                sleepTime = 2000; // Espera 2 segundos
                // casilla no cambia
            } else if (numeroAleatorio <= 40) {
                // Gran Salto (20%)
                casilla += 9;
                // System.out.println("Gran Salto: +9");
            } else if (numeroAleatorio <= 50) {
                // Resbalón grande (10%)
                casilla -= 12;
                // System.out.println("Resbalón grande: -12");
            } else if (numeroAleatorio <= 80) {
                // Pequeño Salto (30%)
                casilla += 1;
                // System.out.println("Pequeño Salto: +1");
            } else { // numeroAleatorio <= 100
                // Resbalón pequeño (20%)
                casilla -= 2;
                // System.out.println("Resbalón pequeño: -2");
            }

            // Asegura que la casilla no baje de 1 (inicio) ni suba de 70 (fin)
            if (casilla < 1) {
                casilla = 1;
            }
            if (casilla > 70) {
                casilla = 70; // La meta
            }

            try {
                Thread.sleep(sleepTime); // Usa el tiempo de espera calculado
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            StringBuilder salida;
            salida = new StringBuilder();
            for (int i = 1; i < casilla; i++) {
                salida.append(" ");
            }
            System.out.println(salida + "L");
            // System.out.println(getCasilla());
        } while (this.getCasilla() < 70);
        
        System.out.println("Liebre llega a meta");
    }

    public byte getCasilla() {
        return casilla;
    }
}
