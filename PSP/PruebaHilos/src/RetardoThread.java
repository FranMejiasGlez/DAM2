
import java.util.Random;
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
public class RetardoThread extends Thread {

    private String nombre;
    private int numero;

    public RetardoThread(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(numero);
        } catch (InterruptedException ex) {
            Logger.getLogger(RetardoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hola mundo,Hilo: " + this.getName() + " Retardo:" + numero);

    }
}
