/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class HiloCuenta extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            System.out.println("Hilo:" + i);
        }
    }
}
