/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public abstract class Animal extends Thread {

    private static final int META = 70;
    private byte casilla = 1;
    private static final int min = 1, max = 100;

    @Override
    public abstract void run();

    public byte getCasilla() {
        return casilla;
    }

    public void setCasilla(byte casilla) {
        this.casilla = casilla;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public abstract char getInicial();

    public int getMETA() {
        return META;
    }
}
