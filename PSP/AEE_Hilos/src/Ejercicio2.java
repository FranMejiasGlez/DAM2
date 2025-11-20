
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        HiloIterador hilo1, hilo2;
        hilo1 = new HiloIterador("hilo1", 10);
        hilo2 = new HiloIterador("hilo2", 10);
        System.out.println("Iniciando hilo1 e hilo2..");

        hilo1.start();
        hilo2.start();
        while (hilo1.isAlive() || hilo2.isAlive()) {
            try {
                Thread.sleep(10); //Dormir para aliviar la CPU
            } catch (InterruptedException ex) {
                System.out.println("Hilo main interrumpido");
            }
        }
        System.out.println("hilo1 e hilo2 finalizado..");
    }
}
