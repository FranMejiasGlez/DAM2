/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpleadosVariable;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class LeeEmpleados {

    public static void main(String[] args) {
        DataInputStream data = null;
        try {
            //try {
            data = new DataInputStream(
                    new FileInputStream("./src/EmpleadosVariable/Empleados.dat"));

            Empleado emple = EmpleadosDAO.leer(data);
            while (!EmpleadosDAO.isFf()) {
                System.out.println("Id: " + emple.getId());
                System.out.println("Nombre: " + emple.getNombre());
                System.out.println("Apellidos: " + emple.getApellidos());
                System.out.println("Sueldo: " + emple.getSueldo());
                emple = EmpleadosDAO.leer(data);
            }


        } catch (FileNotFoundException fnfe) {
            System.out.println("Archivo no encontrado");
            fnfe.printStackTrace();

        } catch (IOException ioe) {
            System.out.println("Error E/S al leer");
        } finally {
            try {
                data.close();
            } catch (IOException ex) {
                System.out.println("Error de E/S al cerrar");;
            }
        }
    }
}
