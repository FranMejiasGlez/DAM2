/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class Canario extends Thread {

    private int id;
    private Comedero comedero;
    private Columpio columpio;

    public Canario(int id, Comedero comedero, Columpio columpio) {
        this.id = id;
        this.comedero = comedero;
        this.columpio = columpio;
    }

    @Override
    public void run() {
        while (true) {
            comedero.empezarComer(id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } finally {
                comedero.terminarComer(id);
            }

            columpio.subir(id);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } finally {
                columpio.bajar(id);
            }
        }

    }
}
