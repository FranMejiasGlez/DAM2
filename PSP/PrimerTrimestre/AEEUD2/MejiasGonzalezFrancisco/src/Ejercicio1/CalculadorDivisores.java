package Ejercicio1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CalculadorDivisores extends Thread {

    private Map<Integer, Integer> sumas;
    private int numeroMin, numeroMax;
    private int suma, divisorComplementario;

    public CalculadorDivisores(int numeroMin, int numeroMax) {
        this.numeroMin = numeroMin;
        this.numeroMax = numeroMax;
    }

    @Override
    public void run() {
        sumas = new HashMap<>();

        for (int i = numeroMin; i < numeroMax; i++) {
            suma = 0;

            // Iterar solo hasta la raíz cuadrada
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    // j es divisor, lo sumamos (siempre que no sea el número mismo)
                    if (j != i) {
                        suma += j;
                    }
                    // i/j es el divisor complementario
                    divisorComplementario = i / j;
                    // Lo sumamos si es diferente de j y no es el numero mismo
                    if (divisorComplementario != j && divisorComplementario != i) {
                        suma += divisorComplementario;
                    }
                }
            }

            getSumas().put(i, suma);
        }
    }

    public Map<Integer, Integer> getSumas() {
        return sumas;
    }
}
