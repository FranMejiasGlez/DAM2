package Ejercicio1;


public class HiloResta extends Thread {

    private int fin = 1;
    public volatile int numero;

    @Override
    public void run() {
        for (int i = 10000; i >= this.fin; i--) {
            numero = i;
            System.out.println("Contador: " + i);
        }
    }
}