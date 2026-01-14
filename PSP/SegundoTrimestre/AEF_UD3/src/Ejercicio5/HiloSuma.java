package Ejercicio5;

public class HiloSuma extends Thread {

    private int fin = 10000;
    private Contador contador;

    public HiloSuma(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {

        for (int i = 1; i <= this.fin; i++) {
            contador.suma();
        }
    }
}