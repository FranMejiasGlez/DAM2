/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class ContadoresSemaforo {

    public static int valorSuma = 1;
    public static int valorResta = 10000;
    public static Semaphore semaforo = new Semaphore(1, true);

    public static void pintar() {
        System.out.print("\rContador +:" + valorSuma + "\t\tContador -:" + valorResta);
    }

    public static void main(String[] args) {


        HiloSuma hiloSuma;
        HiloResta hiloResta;

        hiloSuma = new HiloSuma();
        hiloResta = new HiloResta();
        hiloSuma.start();
        hiloResta.start();

    }
}
