/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio7;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Persona extends Thread {

    private Monitor monitor;
    private int pisoActual;
    private int pisoDestino;

    public Persona(Monitor monitor, String nombre) {
        this.monitor = monitor;
        this.setName(nombre);
    }

    private int elegirPiso() {
        Random r = new Random();
        int min, max;
        min = 0;
        max = 3;
        int numeroAleatorio = min + r.nextInt(max - min + 1);
        return numeroAleatorio;
    }

    private int pisoActual() {
        Random r = new Random();
        int min, max;
        min = 0;
        max = 3;
        int numeroAleatorio = min + r.nextInt(max - min + 1);
        return numeroAleatorio;
    }

    public void llamarAscensor() throws InterruptedException {
        monitor.get(this);
    }

    @Override
    public void run() {
        this.pisoActual = pisoActual();
        this.pisoDestino = elegirPiso();
        while (this.getPisoActual() == this.getPisoDestino()) {
            this.pisoDestino = elegirPiso();
        }
        try {
            llamarAscensor();
            System.out.println("Recogida persona " + getName());
        } catch (InterruptedException ex) {
            System.out.println("Hilo interrumpido");
        }
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }
}
