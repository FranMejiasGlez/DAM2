
public class Main {

    public static void main(String[] args) {

        ColaBuffer buffer = new ColaBuffer(5);

        Productor productor1 = new Productor(buffer);
        productor1.setName("Productor-1");
        productor1.start();

        Productor productor2 = new Productor(buffer);
        productor2.setName("Productor-2");
        productor2.start();

        Consumidor consumidor = new Consumidor(buffer);
        consumidor.setName("Consumidor-1");
        consumidor.start();
    }
}
