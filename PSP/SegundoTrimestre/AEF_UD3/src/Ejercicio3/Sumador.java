package Ejercicio3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Sumador extends Thread {

    private int valorFinal;
    private int id;
    private Semaphore s;

    public Sumador(int hasta, int id, Semaphore s) {
        this.valorFinal = hasta;
        this.s = s;
        this.id = id;
    }

    public void acumula() {
        Acumulador.acumulador += this.id;
    }

    @Override
    public void run() {
        for (int i = 0; i < valorFinal; i++) {
            try {
                s.acquire();
            } catch (InterruptedException ex) {
            }
            acumula();
            s.release();
        }
    }
}
