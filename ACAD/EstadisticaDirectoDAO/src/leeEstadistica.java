
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class leeEstadistica {

    public static void main(String[] args) {
        REstadisticaDAO rE;
        try {
            rE = new REstadisticaDAO("Estadistica.dat", "r");
            rE.irAlPrincipio();
            Estadistica estadistica;
            while (rE.eof == false) {
                estadistica = rE.leer();
                if (estadistica != null && estadistica.getFrecuencia() > 0) {
                    System.out.println(estadistica.toString());
                }
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException ioe) {
            System.out.println("Error de E/S leyendo");
        }
    }
}
