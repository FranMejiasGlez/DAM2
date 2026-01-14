/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Parking {

    public static final byte PLAZAS = 5;
    public static Semaphore semaforo = new Semaphore(PLAZAS, true);

    public static void main(String[] args) {
        
        byte[] tablaTiempos = {1, 3, 5, 2, 4, 1, 6, 3, 2, 4, 5, 2, 1, 3, 2};
        
        HiloCoche[] coches = new HiloCoche[15];
        
        System.out.println("--- APERTURA DEL PARKING (5 PLAZAS) ---");
        
        for (int i = 0; i < 15; i++) {
            coches[i] = new HiloCoche(tablaTiempos[i], "Coche " + (i + 1));
            coches[i].start();
        }
        try {
            for (HiloCoche coche : coches) {
                coche.join(); 
            }
        } catch (InterruptedException ex) {
            System.out.println("El hilo principal fue interrumpido.");
        }
        
        System.out.println("--- NO QUEDAN COCHES. CIERRA EL PARKING ---");
    }
}
