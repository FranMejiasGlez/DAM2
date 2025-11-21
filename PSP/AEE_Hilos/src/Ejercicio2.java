
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        HiloIterador hilo1, hilo2;
        hilo1 = new HiloIterador("hilo1", 10);
        hilo2 = new HiloIterador("hilo2", 10);
        int contador = 0;
        System.out.println("Iniciando hilo1 e hilo2..");
        hilo1.start();
        hilo2.start();
        while (hilo1.isAlive() || hilo2.isAlive()) {
            contador++;
        }
        System.out.println("hilo1 e hilo2 finalizado..");
    }
}
