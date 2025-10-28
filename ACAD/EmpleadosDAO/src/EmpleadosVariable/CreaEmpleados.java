/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpleadosVariable;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CreaEmpleados {

    public static int leerDatoId() {
        int numeroId = -1;
        boolean datoInvalido;
        try {
            BufferedReader teclado =
                    new BufferedReader(new InputStreamReader(System.in));
            do {
                try {
                    datoInvalido = false;
                    System.out.println("Id: ");
                    numeroId = Integer.parseInt(teclado.readLine());
                } catch (NumberFormatException nfe) {
                    System.out.println("dato no válido, teclee otro..");
                    datoInvalido = true;
                }
            } while (datoInvalido == true || numeroId < 0);
        } catch (IOException ioe) {
            System.out.println("");
        }
        return numeroId;
    }

    public static String leerDatoNombre() {
        String linea = "";

        try {
            BufferedReader teclado =
                    new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println("Nombre: ");
                linea = teclado.readLine();
            } while (!linea.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+$"));
        } catch (IOException ioe) {
            System.out.println("");
        }
        return linea;
    }

    public static String leerDatoApellidos() {
        String linea = "";

        try {
            BufferedReader teclado =
                    new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println("Apellidos: ");
                linea = teclado.readLine();
            } while (!linea.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)+$"));
        } catch (IOException ioe) {
            System.out.println("");
        }
        return linea;
    }

    public static float leerDatoSueldo() {
        float sueldo = -1;
        boolean datoInvalido;
        try {
            BufferedReader teclado =
                    new BufferedReader(new InputStreamReader(System.in));
            do {
                try {
                    datoInvalido = false;
                    System.out.println("Sueldo: ");
                    sueldo = Float.parseFloat(teclado.readLine());
                } catch (NumberFormatException nfe) {
                    System.out.println("dato no válido, teclee otro..");
                    datoInvalido = true;
                }
            } while (datoInvalido == true || sueldo < 0);
        } catch (IOException ioe) {
            System.out.println("");
        }
        return sueldo;
    }

    public static void main(String[] args) {
        DataOutputStream data = null;
        try {
            data = new DataOutputStream(
                    new FileOutputStream("./src/EmpleadosVariable/Empleados.dat"));
            System.out.println("Escribe los datos de un empleado: ");


            EmpleadosDAO.escribir(data, new Empleado(leerDatoId(), leerDatoNombre(), leerDatoApellidos(), leerDatoSueldo()));
        } catch (IOException ioe) {
            System.out.println("");
        } finally {
            try {
                data.close();
            } catch (IOException ex) {
                System.out.println("Error de E/S al cerrar");
            }
        }
    }
}
