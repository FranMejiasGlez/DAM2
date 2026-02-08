
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class ColaBuffer {

    private Queue<Integer> cola;
    private final int TAMANIO;

    public ColaBuffer(int TAMANIO) {
        this.cola = new LinkedList<>();
        this.TAMANIO = TAMANIO;
    }

    public synchronized int get() throws InterruptedException {
        while (this.cola.isEmpty()) {
            wait();
        }
        int numero = cola.poll();
        notifyAll();

        return numero;

    }

    public synchronized void put(int numero) throws InterruptedException {
        while (cola.size() >= this.TAMANIO) {
            wait();
        }
        cola.add(numero);
        notifyAll();
    }

    public synchronized boolean estaLlena() {
        return this.cola.size() >= this.TAMANIO;
    }

    public synchronized boolean estaVacia() {
        return cola.isEmpty();
    }
}
