/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio9;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Consumidor extends Thread {

    private Monitor monitor;
   
    public Consumidor(Monitor monitor) {
        this.monitor = monitor;

    }

    public void consumir() {
        while (true) {
            int num = monitor.get();
            
            System.out.println("Numero recibido: " + num);
        }


    }

    @Override
    public void run() {

        consumir();

    }
}
