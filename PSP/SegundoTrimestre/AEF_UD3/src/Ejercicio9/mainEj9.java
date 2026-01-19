/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio9;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class mainEj9 {

    public static void main(String[] args) {
        Monitor mon;
        Productor pro, pro2;
        Consumidor con;
        mon = new Monitor(10);
        pro = new Productor(mon);
        pro2 = new Productor(mon);
        con = new Consumidor(mon);
        pro.start();
        pro2.start();
        con.start();
    }
}
