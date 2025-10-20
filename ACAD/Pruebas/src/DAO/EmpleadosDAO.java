/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class EmpleadosDAO {

    public static boolean ff;

    public EmpleadosDAO() {
    }

    public static Empleado leer(DataInputStream data) throws FileNotFoundException {
        int id;
        String nombre, apellidos;
        float sueldo;
        String fichero = ("./src/DAO/empleados.dat");
        DataInputStream datos = new DataInputStream(new FileInputStream(fichero));
        
        return new Empleado(id, nombre, apellidos, sueldo);
    }

    public static void escribir(DataOutputStream data, Empleado reg) {
    }
}
