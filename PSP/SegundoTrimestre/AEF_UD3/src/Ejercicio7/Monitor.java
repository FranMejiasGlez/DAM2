/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio7;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Monitor {

    Ascensor ascensor;
    private Queue<Persona> cola;

    public Monitor() {
        this.ascensor = new Ascensor(this);
        this.cola = new LinkedList<>();
    }

    public synchronized void agregarPersona(Persona p) {
        cola.add(p);
    }

    public synchronized boolean hayPersonasEsperando() {
        return !cola.isEmpty();
    }

    public synchronized Persona get(Persona p) throws InterruptedException {
        //Consumidor
        agregarPersona(p);
        wait();
        //Recoge a una persona
        notifyAll();
        return null;
    }

    public synchronized Persona obtenerSiguientePersona() {
        return cola.poll();  // Saca y devuelve la primera
    }

    public synchronized void put() throws InterruptedException {
        //Productor
        //Baja a una persona
        notifyAll();
    }
}
