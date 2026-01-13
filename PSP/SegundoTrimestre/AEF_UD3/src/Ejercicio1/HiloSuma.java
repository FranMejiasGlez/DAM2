package Ejercicio1;


public class HiloSuma extends Thread {

    private int fin = 10000;
    public volatile int numero;

    @Override
    public void run() {
        for (int i = 1; i <= this.fin; i++) {
            numero = i;
           System.out.println("Contador: " + i);
        }
    }
}