package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mejias Gonzalez Francisco
 */
public class CompruebaAmigos {

    public static void main(String[] args) {
        BufferedReader teclado;
        int numero = 0, totalHilos;
        boolean esValido ;
        CalculadorDivisores[] hilos;

        teclado = new BufferedReader(new InputStreamReader(System.in));

        // Calcular numero de nucleos disponibles
        int nucleos = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos disponibles: " + nucleos);

        // Pedir numero por teclado
        do {
            esValido = true;
            try {
                System.out.print("Introduce un número: ");
                numero = Integer.parseInt(teclado.readLine());
                if (numero > 0) {
                    esValido = true;
                } else {
                    System.out.println("El número debe ser positivo >0.");
                    esValido = false;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Dato inválido, teclea un número entero.");
                esValido = false;
            } catch (IOException ex) {
                System.out.println("Error de E/S teclado");
            }
        } while (!esValido);


        if (numero < 220) {
            System.out.println("\n--- Resultado ---");
            System.out.println("No existen numeros amigos menores que 220");
            System.out.println("Los primeros numeros amigos son 220 y 284");
            System.out.println("Introduce un numero >= 220 para buscar números amigos");

        } else {

            System.out.println("\n--- Calculando numeros amigos hasta " + numero + " ---\n");


            int numeroInicio = 220;
            int rango = numero - numeroInicio + 1;
            totalHilos = rango / nucleos;

            hilos = new CalculadorDivisores[nucleos];
            long tiempoInicio = System.currentTimeMillis();

            for (int i = 0; i < nucleos; i++) {
                int inicio = numeroInicio + i * totalHilos;
                int fin = (i == nucleos - 1) ? numero : numeroInicio + (i + 1) * totalHilos - 1;

                hilos[i] = new CalculadorDivisores(inicio, fin);
                hilos[i].start();
                System.out.println("Hilo " + i + " procesando números del " + inicio + " al " + fin);
            }

            // Esperar que terminen los hilos con join
            for (int i = 0; i < nucleos; i++) {
                try {
                    hilos[i].join();
                    System.out.println("Hilo " + i + " finalizado");
                } catch (InterruptedException e) {
                    System.out.println("Error esperando hilo " + i);
                }
            }

            long tiempoFin = System.currentTimeMillis();
            System.out.println("\nTiempo de calculo: " + (tiempoFin - tiempoInicio) + " ms\n");

            // Recopilar todas las sumas de todos los hilos
            Map<Integer, Integer> todasLasSumas = new HashMap<>();
            for (int i = 0; i < nucleos; i++) {
                todasLasSumas.putAll(hilos[i].getSumas());
            }

            // Buscar numeros amigos (solo desde 220 en adelante)
            System.out.println("--- Numeros amigos encontrados ---\n");
            boolean encontrado = false;

            for (int i = numeroInicio; i <= numero; i++) {
                Integer sumaI = todasLasSumas.get(i);

                if (sumaI != null && sumaI > i && sumaI <= numero) {
                    Integer sumaJ = todasLasSumas.get(sumaI);

                    if (sumaJ != null && sumaJ == i) {
                        System.out.println(i + " es amigo de " + sumaI);
                        System.out.println("  Suma de divisores de " + i + " = " + sumaI);
                        System.out.println("  Suma de divisores de " + sumaI + " = " + sumaJ);
                        System.out.println();
                        encontrado = true;
                    }
                }
            }

            if (!encontrado) {
                System.out.println("No se encontraron numeros amigos en el rango [" + numeroInicio + ", " + numero + "]");
            }
        }
        // Cerrar recursos
        try {
            teclado.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar teclado");
        }

    }
}