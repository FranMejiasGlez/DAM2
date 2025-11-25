/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Carrera {

    public static void main(String[] args) {

        boolean hayGanador = false;
        String quienGana = "Empate";
        Tortuga t;
        Liebre l;
        EstadoCarrera estado;

        estado = new EstadoCarrera();
        l = new Liebre(100, 1, estado);
        t = new Tortuga(100, 1, estado);

        t.start();

        l.start();

        try {
            t.join(); // Espera a que la tortuga termine (llegue a 70)
            l.join(); // Espera a que la liebre termine (llegue a 70)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long tiempoLlegadaTortuga = estado.getTiempoLlegadaTortuga();
        long tiempoLlegadaLiebre = estado.getTiempoLlegadaLiebre();
        // System.out.println("Liebre: " + tiempoLlegadaLiebre);
        // System.out.println("Tortuga: " + tiempoLlegadaTortuga);
        if (tiempoLlegadaLiebre == tiempoLlegadaTortuga) {
            System.out.println("Hay un empate");
        } else {
            if (tiempoLlegadaLiebre > tiempoLlegadaTortuga) {
                System.out.println("Ganador Tortuga");
            } else {
                System.out.println("Ganador Liebre");
            }
        }
    }
}
