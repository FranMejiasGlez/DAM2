
public class Ejercicio1 extends Thread {

    private String nombre;
    private Thread t;
    // Objeto compartido para provocar el bloqueo (la llave)
    private static final Object CANDADO = new Object();

    public Ejercicio1(String nombre, Thread t) {
        super(nombre);
        this.nombre = nombre;
        this.t = t;
    }

    public Ejercicio1(String nombre) {
        super(nombre);
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            // --- LOGICA DEL HILO SECUNDARIO ---
            // Su trabajo es bloquear al otro hilo
            if (t == null) {
                synchronized (CANDADO) { // Toma la llave
                    // Se duerme CON la llave en el bolsillo para bloquear al otro
                    Thread.sleep(2000);
                }
                // Se queda vivo un poco mas para que le de tiempo al otro a hacer join()
                Thread.sleep(3000);
            } // --- LOGICA DEL HILO PRUEBA (El que monitoreamos) ---
            else {
                // 1. TIMED_WAITING: Dormimos un poco
                Thread.sleep(200);

                // 2. BLOCKED: Intentamos entrar donde esta el secundario
                // Como el secundario esta durmiendo 2 seg con la llave, 
                // aqui nos quedaremos BLOQUEADOS esperando.
                synchronized (CANDADO) {
                    // Al fin entramos (no hacemos nada, solo queriamos bloquearnos fuera)
                }

                // 3. WAITING: Esperamos a que el secundario muera
                t.join();
            }

        } catch (InterruptedException ex) {
            System.out.println("Hilo " + getName() + " interrumpido...");
        }
    }

    public static void main(String[] args) {
        try {
            Ejercicio1 hiloSecundario = new Ejercicio1("Hilo Secundario");
            // Pasamos el secundario al constructor para poder hacer join luego
            Ejercicio1 hiloPrueba = new Ejercicio1("Hilo Prueba", hiloSecundario);

            System.out.println("Estado inicial: " + hiloPrueba.getState()); // NEW

            // Arrancamos primero el secundario para que le de tiempo a coger la llave
            hiloSecundario.start();
            Thread.sleep(100); // Pequeña pausa para asegurar que Secundario coge el candado
            hiloPrueba.start();

            Thread.State estadoActual;
            Thread.State estadoAnterior = hiloPrueba.getState();
            System.out.println("Estado: " + estadoAnterior);

            while (hiloPrueba.isAlive()) {
                estadoActual = hiloPrueba.getState();

                // Solo imprimimos si el estado ha cambiado
                if (estadoActual != estadoAnterior) {
                    System.out.println("Estado: " + estadoActual);
                    estadoAnterior = estadoActual;
                }

            }

            System.out.println("Estado final: " + hiloPrueba.getState()); // TERMINATED

        } catch (InterruptedException ex) {
        }
    }
}