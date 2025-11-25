/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CompruebaAmigos {

    public static void main(String[] args) {
        BufferedReader teclado;
        int numero = 0, totalHilos;
        boolean esValido = true;
        CalculadorDivisores[] hilos;

        teclado = new BufferedReader(new InputStreamReader(System.in));
        //Calcular numero de nucleos disponibles para luego calcular hilos
        int nucleos = 14;// Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos disponibles: " + nucleos);
        //Pedir numero por teclado
        do {
            try {
                System.out.print("Introduce un número: ");
                numero = Integer.parseInt(teclado.readLine());
                if (numero > 0) {
                    esValido = true;
                } else {
                    System.out.println("El número debe ser positivo >0.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Dato inválido, teclea un número entero.");
            } catch (IOException ex) {
                System.out.println("Error de E/S teclado");
            }
        } while (!esValido);
        System.out.println("\n--- Calculando numeros amigos hasta "
                + numero + " ---\n");
        //Calcular hilos necesarios
        totalHilos = numero / nucleos;
        hilos = new CalculadorDivisores[nucleos];
        long tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < nucleos; i++) {
            int inicio = i * totalHilos + 1;
            int fin = (i == nucleos - 1) ? numero : (i + 1) * totalHilos;

            hilos[i] = new CalculadorDivisores(inicio, fin);
            hilos[i].start();
            System.out.println("Hilo " + i + " procesando números del " + inicio + " al " + fin);
        }
        //Esperar que terminen los hilos con join
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
        //Recopilar todas las sumas de todos los hilos
        Map<Integer, Integer> todasLasSumas = new HashMap<>();
        for (int i = 0; i < nucleos; i++) {
            todasLasSumas.putAll(hilos[i].getSumas());
        }
        //Buscar numeros amigos
        System.out.println("--- Numeros amigos encontrados ---\n");
        boolean encontrado = false;

        for (int i = 1; i <= numero; i++) {
            Integer sumaI = todasLasSumas.get(i);

            // Verificar si sumaI está en el rango y si es amigo de i
            if (sumaI != null && sumaI > i && sumaI <= numero) {
                Integer sumaJ = todasLasSumas.get(sumaI);

                // Dos números son amigos si la suma de divisores de uno es el otro y viceversa
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
            System.out.println("No se encontraron numeros amigos en el rango [1, " + numero + "]");
        }
    }
}
