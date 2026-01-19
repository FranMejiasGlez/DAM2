/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio8;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Monitor {

    private Queue valor;

    public Monitor() {
        this.valor = new LinkedList();
    }

    public synchronized int get() {
        //consumidor
        while (this.valor.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Hilo interrumpido");
            }
        }
        int numero = (int)this.valor.remove();
        notifyAll();
        return numero;
    }

    public synchronized void put(int numero) throws InterruptedException {
        //productor
        while (!this.valor.isEmpty()) {
            wait();
        }
        this.valor.add(numero);
        notifyAll();
    }
}
