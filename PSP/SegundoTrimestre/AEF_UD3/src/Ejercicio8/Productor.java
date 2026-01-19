/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Productor extends Thread {

    private Monitor monitor;
    private int cantidad;

    public Productor(Monitor monitor, int cantidad) {
        this.monitor = monitor;
        this.cantidad = cantidad;

    }

    public void producir() {
        for (int i = 1; i <= cantidad; i++) {
            try {
                monitor.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void run() {
        producir();

    }
}
