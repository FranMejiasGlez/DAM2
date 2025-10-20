/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_Fijo;

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

    public static Empleado leer(DataInputStream data)
            throws FileNotFoundException, IOException {
        int id;
        String nombre, apellidos;
        char caracterNombre, caracterApellidos;
        float sueldo;
        Empleado emple = null;
        try {
            //Leer Datos de Registro Empleado (Objeto)
            nombre = "";
            apellidos = "";
            EmpleadosDAO.ff = false;
            id = data.readInt();
            //Construccion del nombre y apellidos caracter a caracter
            for (int i = 1; i <= 20; i++) {
                caracterNombre = data.readChar();
                nombre = nombre + caracterNombre;
            }
            nombre = nombre.trim();

            for (int i = 1; i <= 60; i++) {

                caracterApellidos = data.readChar();
                apellidos = apellidos + caracterApellidos;
            }
            apellidos = apellidos.trim();

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
            StringBuilder escribeNombre, escribeApellidos;
            //Escribir ,datos para Registro Empleado(Objeto)
            data.writeInt(reg.getId());

            escribeNombre = new StringBuilder(reg.getNombre().trim());
            escribeNombre.setLength(20);
            data.writeChars(escribeNombre.toString());

            escribeApellidos = new StringBuilder(reg.getApellidos().trim());
            escribeApellidos.setLength(60);
            data.writeChars(escribeApellidos.toString());
            
            data.writeFloat(reg.getSueldo());

        } catch (IOException ioe) {
            System.out.println("Error de E/S");
        }


    }
}
