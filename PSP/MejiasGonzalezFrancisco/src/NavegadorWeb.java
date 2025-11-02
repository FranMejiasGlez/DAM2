
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class NavegadorWeb {

    public static void main(String[] args) {
        Process internet;
        ProcessBuilder pb;
        String linea = "";
        BufferedReader teclado;
        try {
            teclado = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                try {
                    System.out.println("Esperando 10 segundos...");
                    Thread.sleep(10000);
                    System.out.println("Que direccion web desea consultar?: ");
                    System.out.println("Utilize www.[dominio].[topDomain] : ");
                    linea = teclado.readLine();
                    pb = new ProcessBuilder("cmd", "/c", "start", "http://" + linea);
                    internet = pb.start();

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
