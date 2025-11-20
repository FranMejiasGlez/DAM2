
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejercicio1 extends Thread {

    private String nombre;
    private Thread t;

    public Ejercicio1(String nombre, Thread t) {
        this.nombre = nombre;
        setName(nombre);
        this.t = t;
    }

    public Ejercicio1(String nombre) {
        this.nombre = nombre;
        setName(nombre);
    }

    @Override
    public void run() {
        try {



            for (int i = 0; i < 1000; i++) {
            }

            Thread.sleep(5000);

            if (t != null) {

                t.join();
            }
            if (t == null) { // t es null solo en hiloSecundario

                Thread.sleep(5000); // 5 segundos
            }


        } catch (InterruptedException ex) {
            System.out.println("Hilo " + getName() + " interrumpido...");
        }
    }

    public static void main(String[] args) {

        Ejercicio1 hiloPrueba, hiloSecundario;
        hiloSecundario = new Ejercicio1("Hilo Secundario");
        hiloPrueba = new Ejercicio1("Hilo Prueba", hiloSecundario);


        Thread.State estado = hiloPrueba.getState();
        System.out.println("Estado: 1 - " + estado);//Estado NEW
        System.out.println("");

        hiloPrueba.start();
        hiloSecundario.start();



        Thread.State estadoAnterior = estado; // Comienza en NEW
        int contador = 2; // Empezamos a contar desde el estado tras start()



        // Monitoreamos continuamente el estado del hiloPrueba

        while (hiloPrueba.isAlive()) {
            estado = hiloPrueba.getState();

            if (!estado.equals(estadoAnterior)) {


                System.out.println("Estado: " + contador + " - "
                        + estado);
                System.out.println("");
                estadoAnterior = estado;
                contador++;
            }
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Hilo main interrumpido");
        }
        estado = hiloPrueba.getState();
        System.out.println("Estado final - TERMINATED: " + estado);
        System.out.println("\nHilo: " + hiloPrueba.getName() + " completamente terminado");
        System.out.println("\nHilo: " + hiloSecundario.getName() + " completamente terminado");
    }
}
