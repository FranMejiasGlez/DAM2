package Ejercicio1;

public class HiloSuma extends Thread {

    private int fin = 10000;

    @Override
    public void run() {
        for (int i = 1; i <= this.fin; i++) {

            System.out.println("\rContador +: " + i);
        }
    }
}