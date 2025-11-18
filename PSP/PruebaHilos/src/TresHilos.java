
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class TresHilos extends Thread {

    public static void main(String[] args) {
        Random rd;
        int min = 1;
        int max = 2000;
        rd = new Random();
        int generado = min + rd.nextInt(max - min + 1);
        RetardoThread t1 = new RetardoThread("Thread 1", generado);
        generado = min + rd.nextInt(max - min + 1);
        RetardoThread t2 = new RetardoThread("Thread 2", generado);
        generado = min + rd.nextInt(max - min + 1);
        RetardoThread t3 = new RetardoThread("Thread 3", generado);

        t1.start();

        t2.start();

        t3.start();

    }
}
