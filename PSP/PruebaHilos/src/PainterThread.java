
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class PainterThread extends Thread {

    private String mensaje;

    public PainterThread(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 2; j++) {
                System.out.println(this.mensaje);
            }
            Thread.yield();
        }

    }

    public static void main(String[] args) {
        PainterThread si, no;
        si = new PainterThread("SI");
        no = new PainterThread("NO");
        si.start();
        no.start();
    }
}
