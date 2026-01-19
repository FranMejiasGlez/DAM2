/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio9;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Productor extends Thread {

    private Monitor monitor;

    public Productor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void producir() {
        Random r = new Random();
        int min, max;
        min = 1;
        max = 10;
        while (true) {
            int numeroAleatorio = min + r.nextInt(max - min + 1);
            monitor.put(numeroAleatorio);
            try {
                Thread.sleep(2000);
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
