
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy
 */
public class Comedero {

    private Semaphore semaforo;

    public Comedero() {
        this.semaforo = new Semaphore(3);
    }

    public void empezarComer(int id) {
        try {
            semaforo.acquire();
            System.out.println("Canario " + id + " empieza a comer");
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void terminarComer(int id) {
        System.out.println("Canario " + id + " termina de comer.");
        semaforo.release();
    }
}
