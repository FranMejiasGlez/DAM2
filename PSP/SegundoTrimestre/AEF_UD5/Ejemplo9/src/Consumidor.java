
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
public class Consumidor extends Thread {

    private ColaBuffer cola;

    public Consumidor(ColaBuffer cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        while (true) {
            while (!cola.estaLlena()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                }
            }

            System.out.println("\n>>> COLA LLENA, COMENZANDO A VACIAR <<<");

            while (!cola.estaVacia()) {
                try {
                    int numero = cola.get();
                    System.out.println("Consumidor saca: " + numero);
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                }
            }

            System.out.println(">>> COLA VACÍA, ESPERANDO NUEVA LLENADA <<<\n");
        }
    }
}
