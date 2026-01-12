/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadisticaConDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class EstadisticaDAO {

    private static boolean ff = false;

    public static void setFf() {
        ff = !ff;
    }

    public EstadisticaDAO() {
    }

    public static boolean esFf() {
        return ff;
    }

    public static Estadistica leer(DataInputStream data)
            throws FileNotFoundException, IOException {
        Estadistica reg = null;
        byte num;
        short frecuencia;
        float porcentaje;
        String salida;

        try {
            num = data.readByte();
            frecuencia = data.readShort();
            porcentaje = data.readFloat();
            reg = new Estadistica(num, frecuencia, porcentaje);
        } catch (EOFException eofe) {
            System.out.println("Fin del archivo");
            EstadisticaDAO.setFf();
            return null;
        }

        return reg;
    }

    public static void escribir(DataOutputStream data, Estadistica reg) throws IOException {
        data.writeByte(reg.getNumero());
        data.writeShort(reg.getFrecuencia());
        data.writeFloat(reg.getPorcentaje());
    }
}
