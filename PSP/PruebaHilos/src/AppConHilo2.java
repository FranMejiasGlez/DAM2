/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class AppConHilo2 {

    public static void main(String[] args) {

        Thread t = new Thread(new Mi2oThread());
        t.start();
    }
}
