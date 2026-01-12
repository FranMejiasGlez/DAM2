/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO_Variable.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class EmpleadosDAO {

    public static boolean ff = false;

    public EmpleadosDAO() {
    }

    public static Empleado leer(DataInputStream data) throws FileNotFoundException, IOException {
        int id;
        String nombre, apellidos;
        float sueldo;
        Empleado emple = null;
        try {
            //Leer Datos de Registro Empleado (Objeto)
            EmpleadosDAO.ff = false;
            id = data.readInt();
            nombre = data.readUTF();
            apellidos = data.readUTF();
            sueldo = data.readFloat();
            emple = new Empleado(id, nombre, apellidos, sueldo);
        } catch (EOFException eofe) {
            ff = true;
            //System.out.println("Fin de fichero");
        }
        return emple;
    }

    public static void escribir(DataOutputStream data, Empleado reg) {


        try {

            //Escribir ,datos para Registro Empleado(Objeto)
            data.writeInt(reg.getId());
            data.writeUTF(reg.getNombre());
            data.writeUTF(reg.getApellidos());
            data.writeFloat(reg.getSueldo());

        } catch (IOException ioe) {
            System.out.println("Error de E/S");
        }


    }
}
