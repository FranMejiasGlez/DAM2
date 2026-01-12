/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpleadosVariable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class EmpleadosDAO {

    private static boolean ff = false;

    public static Empleado leer(DataInputStream data) throws IOException {
        try {
            emple.setId(data.readInt());
            emple.setNombre(data.readUTF());
            emple.setApellidos(data.readUTF());
            emple.setSueldo(data.readFloat());
        } catch (EOFException ioe) {
            System.out.println("Fin de fichero");
            ff = true;
        }


        return emple;
    }

    public static void escribir(DataOutputStream data, Empleado reg) throws IOException {

        data.writeInt(reg.getId());
        data.writeUTF(reg.getNombre());
        data.writeUTF(reg.getApellidos());
        data.writeFloat(reg.getSueldo());

    }

    /**
     * @return the ff
     */
    public static boolean isFf() {
        return ff;
    }
}
