/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Carrera {

    public static void main(String[] args) {
        Liebre liebre;
        Tortuga tortuga;
        String ganador;

        liebre = new Liebre();
        tortuga = new Tortuga();

        liebre.start();
        tortuga.start();
        ganador = "";

        while (liebre.isAlive() && tortuga.isAlive()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (!liebre.isAlive() && !tortuga.isAlive()) {
            ganador = "¡EMPATE!";
        } else if (!liebre.isAlive()) {
            ganador = "¡Gana la Liebre!";
        } else {
            ganador = "¡Gana la Tortuga!";
        }

        try {
            liebre.join();
            tortuga.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }

        System.out.println("\n" + ganador);

    }
}
