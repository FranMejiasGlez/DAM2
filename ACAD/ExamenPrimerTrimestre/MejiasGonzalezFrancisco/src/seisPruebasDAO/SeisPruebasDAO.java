/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seisPruebasDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import tipoPruebaDAO.Prueba;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class SeisPruebasDAO {

    public static boolean ff;

    public SeisPruebasDAO() {
        ff = false;
    }

    public static Prueba leer(DataInputStream data) throws IOException {
        ff = false;
        Prueba prueba = null;
        try {

            prueba = new Prueba(data.readByte(), data.readUTF(), data.readShort());
            return prueba;
        } catch (EOFException eof) {
            System.out.println("Fin fichero");
            ff = true;
        }
        return prueba;
    }

    public static void escribir(DataOutputStream data, Prueba prueba) throws IOException {
        data.writeByte(prueba.getNumeroPrueba());
        data.writeUTF(prueba.getNombre());
        data.writeShort(prueba.getnVeces());
    }
}
