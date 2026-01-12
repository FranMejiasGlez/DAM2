/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class PruebaHijo {

    public static void main(String[] args) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ie) {
        }
        System.out.println("El proceso hijo termina.");
    }
}
