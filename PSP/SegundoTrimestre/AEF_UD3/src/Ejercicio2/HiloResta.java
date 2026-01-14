package Ejercicio2;

public class HiloResta extends Thread {

    private int fin = 1;

    @Override
    public void run() {
        for (int i = 10000; i >= this.fin; i--) {
            try {
                ContadoresSemaforo.semaforo.acquire();
            } catch (InterruptedException ex) {
                System.out.println("HiloResta interrumpido");
            }
            ContadoresSemaforo.valorResta = i;
            ContadoresSemaforo.pintar();
            ContadoresSemaforo.semaforo.release();
        }
    }
}