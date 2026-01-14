package Ejercicio5;

public class HiloResta extends Thread {

    private int fin = 1;
    private Contador contador;

    public HiloResta(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 10000; i >= this.fin; i--) {
            contador.resta();
        }
    }
}