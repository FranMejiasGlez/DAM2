/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadisticaConDAO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class LeeEstadistica {

    public static void main(String[] args) {
        DataInputStream data = null;
        Estadistica reg;
        try {
            try {

                data = new DataInputStream(new FileInputStream(
                        "./src/EstadisticaConDAO/Estadistica.dat"));
            } catch (FileNotFoundException fnfe) {
                System.out.println("Archivo no encontrado");
            }

            //Leer mientras no sea FF

            while (!EstadisticaDAO.esFf()) {
                reg = EstadisticaDAO.leer(data);

                // Verificar si es null (fin de archivo)
                if (reg != null) {
                    // Mostrar solo registros con frecuencia > 0 (opcional)
                    if (reg.getFrecuencia() > 0) {
                        System.out.println(reg.toString());
                    }
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
