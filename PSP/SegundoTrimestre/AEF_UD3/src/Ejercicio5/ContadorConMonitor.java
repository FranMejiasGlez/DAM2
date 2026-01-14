/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class ContadorConMonitor {

    public static void main(String[] args) {
        HiloSuma hiloSuma;
        HiloResta hiloResta;
        Contador contador = new Contador();

        hiloResta = new HiloResta(contador);
        hiloSuma = new HiloSuma(contador);
        hiloResta.start();
        hiloSuma.start();
    }
}
