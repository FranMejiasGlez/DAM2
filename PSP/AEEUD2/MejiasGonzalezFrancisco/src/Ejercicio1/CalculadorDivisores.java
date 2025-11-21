/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CalculadorDivisores extends Thread {

    private int numeroMin, numeroMax;
    private List divisores;

    public CalculadorDivisores(int numeroMin, int numeroMax) {
        this.numeroMin = numeroMin;
        this.numeroMax = numeroMax;
    }

    @Override
    public void run() {
        divisores = new LinkedList();
        for (int i = numeroMin; numeroMin * numeroMin <= numeroMax; i++) {
        }


    }
}


