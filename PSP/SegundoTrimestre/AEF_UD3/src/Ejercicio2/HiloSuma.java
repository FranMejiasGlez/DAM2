package Ejercicio2;

public class HiloSuma extends Thread {

    private int fin = 10000;

    @Override
    public void run() {
        for (int i = 1; i <= this.fin; i++) {
            try {
                ContadoresSemaforo.semaforo.acquire();
            } catch (InterruptedException ex) {
                System.out.println("HiloSuma interrumpido");
            }
            ContadoresSemaforo.valorSuma = i;
            ContadoresSemaforo.pintar();
            ContadoresSemaforo.semaforo.release();
        }
    }
}