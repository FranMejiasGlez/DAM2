
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class HiloIterador extends Thread {

    private String nombre;
    private int tMax;

    public HiloIterador(String nombre, int tMax) {
        this.setName(nombre);
        this.tMax = tMax;
    }

    @Override
    public void run() {
        for (int i = 1; i <= this.tMax; i++) {
            try {
                sleep(1000);//Espera de 1 segundo
            } catch (InterruptedException ex) {
                System.out.println("Hilo: " + this.getName() + " interrumpido");
            }
            System.out.println(this.getName() + "#" + i);
        }
    }
}
