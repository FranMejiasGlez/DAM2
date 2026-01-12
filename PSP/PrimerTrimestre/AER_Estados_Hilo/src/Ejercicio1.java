/*
 * No se me ocurre como sacar BLOCKED, la IA me dice que necesito sincronizacion.
 * 
 */

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        EstadoHilo hilo1, hilo2, hilo3;
        
        hilo1 = new EstadoHilo("hilo1");
        hilo2 = new EstadoHilo("hilo2", hilo1);
        hilo3 = new EstadoHilo("hilo3", hilo2);
        
        System.out.println(hilo1.getName() + ": " + hilo1.getState());
        System.out.println(hilo2.getName() + ": " + hilo2.getState());
        System.out.println(hilo3.getName() + ": " + hilo3.getState());
        
        hilo1.start();
        hilo3.start();
        hilo2.start();

        Thread.State estadoAnterior1 = null;
        Thread.State estadoAnterior2 = null;
        Thread.State estadoAnterior3 = null;

        while (hilo1.isAlive() || hilo2.isAlive()) {
            Thread.State estadoActual1 = hilo1.getState();
            Thread.State estadoActual2 = hilo2.getState();
            Thread.State estadoActual3 = hilo3.getState();
            
            if (estadoActual1 != estadoAnterior1) {
                System.out.println(hilo1.getName() + ": " + estadoActual1);
                estadoAnterior1 = estadoActual1;
            }

            if (estadoActual2 != estadoAnterior2) {
                System.out.println(hilo2.getName() + ": " + estadoActual2);
                estadoAnterior2 = estadoActual2;
            }
            if (estadoActual3 != estadoAnterior3) {
                System.out.println(hilo3.getName() + ": " + estadoActual3);
                estadoAnterior3 = estadoActual3;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Main interrumpido");
            }

        }
        System.out.println(hilo1.getName() + ": " + hilo1.getState());
        System.out.println(hilo2.getName() + ": " + hilo2.getState());
        System.out.println(hilo3.getName() + ": " + hilo3.getState());
    }
}
