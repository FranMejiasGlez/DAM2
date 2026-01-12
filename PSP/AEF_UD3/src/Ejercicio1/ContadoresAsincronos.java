package Ejercicio1;


import java.util.logging.Level;
import java.util.logging.Logger;

public class ContadoresAsincronos {

    public static void main(String[] args) {
        HiloResta hiloResta = new HiloResta();
        HiloSuma hiloSuma = new HiloSuma();
        int contador = 0;
        // int numeroResta, numeroSuma;
        hiloResta.start();
        hiloSuma.start();


        while (hiloResta.isAlive() || hiloSuma.isAlive()) {
            contador++;
            //numeroResta = hiloResta.numero;
            // numeroSuma = hiloSuma.numero;
            //System.out.println("Contador:" + numeroResta + " | " + "Contador:" + numeroSuma);
        }

        if (!hiloResta.isAlive() && hiloSuma.isAlive()) {
            try {
                hiloSuma.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ContadoresAsincronos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!hiloSuma.isAlive() && hiloResta.isAlive()) {
            try {
                hiloResta.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ContadoresAsincronos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}