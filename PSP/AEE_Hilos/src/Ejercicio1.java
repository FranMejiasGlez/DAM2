/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejercicio1 extends Thread {

    private String nombre;

    public Ejercicio1(String nombre) {
        this.nombre = nombre;
        setName(nombre);
    }

    @Override
    public void run() {
        try {
            System.out.println("Hilo:" + getName());
            System.out.println("");
            System.out.println("Contando hasta 1000");
            System.out.println("");
            for (int i = 0; i < 1000; i++) {
            }
            System.out.println("Hilo:" + getName());
            System.out.println("");
            System.out.println("Durmiendo 5 segundos");
            System.out.println("");
            Thread.sleep(5000);

            System.out.println("Hilo " + getName() + " finalizando...");
        } catch (InterruptedException ex) {
            System.out.println("Hilo " + getName() + " interrumpido...");
        }
    }

    public static void main(String[] args) {
        Ejercicio1 hiloPrueba;

        hiloPrueba = new Ejercicio1("HiloEstado");

        Thread.State estado = hiloPrueba.getState();
        System.out.println("Estado 1: " + estado);//Estado NEW

        System.out.println("");

        hiloPrueba.start();
        estado = hiloPrueba.getState();
        System.out.println("Estado 2: " + estado);//Estado RUNNABLE
        Thread.State estadoAnterior = estado;
        int contador = 3;

        while (hiloPrueba.isAlive()) {
            estado = hiloPrueba.getState();
            if (!estado.equals(estadoAnterior)) {
                System.out.println("Estado: " + contador + " - "
                        + estado + ": " + estado);
                estadoAnterior = estado;
                contador++;
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Hilo main interrumpido");
        }
        estado = hiloPrueba.getState();
        System.out.println("Estado final - TERMINATED: " + estado);
        System.out.println("\nHilo completamente terminado");


    }
}
