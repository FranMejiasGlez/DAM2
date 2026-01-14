package Ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Contador {

    private int valorSuma = 0;
    private int valorResta = 10000;
    private boolean turnoSuma = true;

    public Contador() {
    }

    public synchronized void suma() {
        while (!turnoSuma) {
            try {
                wait();//Soltar la llave
            } catch (InterruptedException ex) {
                Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        valorSuma++;
        System.out.print("\rContador +: " + valorSuma + "   Contador -: " + valorResta);
        turnoSuma = false;
        notifyAll();//Notifica que ha abierto el cerrojo
    }

    public synchronized void resta() {
        while (turnoSuma) {
            try {
                wait();//Soltar la llave
            } catch (InterruptedException ex) {
                Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        valorResta--;
        turnoSuma = true;
        System.out.print("\rContador +: " + valorSuma + "   Contador -: " + valorResta);
        notifyAll();//Notifica que ha abierto el cerrojo
    }
}
