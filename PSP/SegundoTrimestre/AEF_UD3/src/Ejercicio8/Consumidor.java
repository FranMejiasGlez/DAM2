/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio8;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Consumidor extends Thread {

    private Monitor monitor;
    private int numeros;

    public Consumidor(Monitor monitor, int cantidad) {
        this.monitor = monitor;
        this.numeros = cantidad;
    }

    public void consumir() {
        for (int i = 0; i < numeros; i++) {
            int num = monitor.get();
            System.out.println("Numero recibido: " + num);
        }


    }

    public void run() {
        consumir();
    }
}
