/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class MainCuenta {

    public static void main(String[] args) {
        HiloCuenta t = new HiloCuenta();
        t.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("Main:"+i);
        }
    }
}
