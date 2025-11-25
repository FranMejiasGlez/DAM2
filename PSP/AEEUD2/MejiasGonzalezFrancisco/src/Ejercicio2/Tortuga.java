package Ejercicio2;

import java.util.Random;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Tortuga extends Thread {

    private byte casilla = 1;
    private int max, min;
    private EstadoCarrera estado;

    public Tortuga(int max, int min, EstadoCarrera estado) {
        this.max = max;
        this.min = min;
        this.estado = estado;
    }

    @Override
    public void run() {
        Random r = new Random();
        do {
            int numeroAleatorio = min + r.nextInt(this.max - this.min + 1);
            long sleepTime = 1000;

            if (numeroAleatorio <= 50) {
                casilla += 3;
                // System.out.println("Avanza 3 casillas");
            } else if (numeroAleatorio <= 80) {
                casilla += 1;
                //  System.out.println("Avanza 1 casilla");
            } else {
                if (this.getCasilla() - 6 >= 1) {
                    casilla -= 6;
                    //System.out.println("Retrocede 6 casillas");
                } else {
                    casilla = 1;
                }
            }
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ie) {
            }
            StringBuilder salida;
            salida = new StringBuilder();
            for (int i = 1; i < casilla; i++) {
                salida.append(" ");
            }
            System.out.println(salida + "T");
            // System.out.println(getCasilla());
        } while (this.getCasilla() < 70);
        estado.setTiempoLlegadaTortuga(System.currentTimeMillis());
        System.out.println("Tortuga llega a meta");
    }

    public byte getCasilla() {
        return casilla;
    }
}
