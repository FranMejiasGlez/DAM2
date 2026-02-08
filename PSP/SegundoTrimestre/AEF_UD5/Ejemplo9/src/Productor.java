
import java.util.Random;
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
public class Productor extends Thread {

    private ColaBuffer cola;
    private Random random;

    public Productor(ColaBuffer cola) {
        this.cola = cola;
        this.random = new Random();
    }

    public void run() {
        int numero;
        while (true) {
            try {
                numero = random.nextInt(1, 11);
                System.out.println("Productor "
                        + Thread.currentThread().getName()
                        + " agrega: " + numero);
                cola.put(numero);
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("Hilo productor interrumpido");
            }

        }
    }
}
