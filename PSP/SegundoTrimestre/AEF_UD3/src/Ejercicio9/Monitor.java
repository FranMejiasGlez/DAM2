/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Monitor {

    private Queue lista;
    private int max;
    //  private boolean vaciando=false;

    public Monitor(int max) {
        this.lista = new LinkedList();
        this.max = max;
    }

    public synchronized void put(int numero) {
        //Productor
        while (lista.size() == this.max) {// && this.vaciando) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.lista.add(numero);
        System.out.println("Productor agrega: " + numero + " - Cola: "
                + lista.size() + "/" + max);
        notifyAll();
    }

    public synchronized int get() {
        //Consumidor
        int num;

        while (this.lista.size() < this.max) {
            try {
                System.out.println("Consumidor esperando a que la cola este llena...");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        num = (int) this.lista.remove();
        System.out.println("  Número removido: " + num);
        System.out.println("Vaciando cola completa...");
        //this.vaciando = true;
        while (!this.lista.isEmpty()) {
            int n = (int) this.lista.remove();
            System.out.println("  Número removido: " + n);
        }
        // this.vaciando = false;
        System.out.println("Cola vacía. Notificando productores.");
        notifyAll();
        return num;
    }
}
