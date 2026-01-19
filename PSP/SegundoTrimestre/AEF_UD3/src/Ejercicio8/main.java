/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejercicio8;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class main {
    public static void main(String[] args) {
        Monitor monitor;
        Consumidor con;
        Productor pro;
        
        monitor= new Monitor();
        con= new Consumidor(monitor,40);
        pro= new Productor(monitor,40);
        
        con.start();
        pro.start();
    }
}
