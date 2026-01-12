
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
public class EstadoHilo extends Thread {

    Thread hiloAEsperar;

    public EstadoHilo(String nombre) {
        setName(nombre);
    }

    public EstadoHilo(String nombre, Thread hiloAEsperar) {
        setName(nombre);
        this.hiloAEsperar = hiloAEsperar;
    }

    @Override
    public void run() {
        if (this.hiloAEsperar != null) {
            try {
                EstadoHilo.sleep(1000);
                hiloAEsperar.join();
            } catch (InterruptedException ex) {
                System.out.println("Hilo2 interrumpido");
            }
        } else {
            for (int i = 0; i < 10; i++) {
                try {
                    EstadoHilo.sleep(500);
                } catch (InterruptedException ex) {
                    System.out.println("Hilo1 Interrumpido");
                }
            }

        }


    }
}
