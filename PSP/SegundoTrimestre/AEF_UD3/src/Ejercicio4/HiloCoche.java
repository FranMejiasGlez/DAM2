/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class HiloCoche extends Thread {

    private byte tiempo = 1;//Segundos

    public HiloCoche(byte tiempo, String nombre) {
        this.tiempo = tiempo;//Segundos
        setName(nombre);
    }

    @Override
    public void run() {
        try {
            System.out.println("-> " + getName() + " intentando entrar.");

            Parking.semaforo.acquire();

            System.out.println("   [PARKING] " + getName() + " APARCO. "
                    + "(Tiempo: " + this.tiempo + "s). Plazas libres: "
                    + Parking.semaforo.availablePermits());
            
            Thread.sleep(this.tiempo * 1000);

            System.out.println("<- " + getName() + " saliendo...");

            Parking.semaforo.release();
        } catch (InterruptedException ex) {
            System.out.println(getName() + " Interrumpido");
        }



    }
}
