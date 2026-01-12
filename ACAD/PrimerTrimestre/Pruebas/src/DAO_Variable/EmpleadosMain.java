/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_Variable;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class EmpleadosMain {

    public static void main(String[] args) {
        byte opcion, id = 0;
        opcion = -1;
        String fichero = ("empleados.dat");
        String nombre, apellidos;
        float sueldo = 0;
        boolean numeroCorrecto;
        do {
            try {
                BufferedReader teclado = new BufferedReader(
                        new InputStreamReader(System.in));


                try {

                    System.out.println("1.- Escribir..");
                    System.out.println("2.- Leer todos registros..");
                    System.out.println("3.- Salir..");
                    opcion = Byte.parseByte(teclado.readLine());

                } catch (NumberFormatException nfe) {
                    System.out.println("Dato no válido, teclee otro.");
                }

                try {

                    switch (opcion) {
                        case 1:
                            File fich = new File(fichero);
                            if (fich.exists()) {

                                System.out.println("Existe el archivo");
                            } else {
                                FileOutputStream salida = new FileOutputStream(
                                        fichero, true);
                            }
                            //Pedir los datos para rellenar los campos del 
                            //Empleado
                            DataOutputStream dataWrite = new DataOutputStream(
                                    new FileOutputStream(fichero, true));
                            do {
                                try {
                                    numeroCorrecto = true;
                                    System.out.println("Introduce id: ");
                                    id = Byte.parseByte(teclado.readLine());
                                } catch (NumberFormatException nfe1) {
                                    System.out.println("Numero no valido, teclee otro..");
                                    numeroCorrecto = false;
                                }
                            } while (numeroCorrecto == false || id < 1);

                            System.out.println("Introduce Nombre: ");
                            nombre = teclado.readLine().trim();
                            System.out.println("Introduce Apellidos: ");
                            apellidos = teclado.readLine().trim();
                            do {
                                try {
                                    numeroCorrecto = true;
                                    System.out.println("Introduce sueldo: ");
                                    sueldo = Float.parseFloat(teclado.readLine());
                                } catch (NumberFormatException nfe2) {
                                    System.out.println("Numero no valido, teclee otro..");
                                    numeroCorrecto = false;
                                }
                            } while (numeroCorrecto == false);
                            //Crear objeto Empleado con los registros
                            Empleado reg = new Empleado(
                                    id, nombre, apellidos, sueldo);

                            //Escribir en el registro
                            EmpleadosDAOFichVar.escribir(dataWrite, reg);
                            System.out.println("Registro guardado "
                                    + "correctamente.");
                            break;

                        case 2:
                            System.out.println("Leyendo todo el fichero...");
                            DataInputStream dataReadAll = new DataInputStream(
                                    new FileInputStream(fichero));
                            Empleado empleado;
                            while ((empleado = EmpleadosDAOFichVar.leer(dataReadAll))
                                    != null) {
                                if (!EmpleadosDAOFichVar.ff) {
                                    System.out.println(empleado.toString());
                                }
                            }
                            dataReadAll.close();
                            EmpleadosDAOFichVar.ff = false; // Resetear flag
                            break;

                        case 3:
                            System.out.println("Saliendo del programa...");
                            break;

                        default:
                            System.out.println("Opción no válida. Intente "
                                    + "de nuevo.");
                    }
                } catch (FileNotFoundException fnfe) {
                    System.out.println("Archivo no encontrado");

                }

            } catch (IOException ioe) {
                System.out.println("Error de E/S");
            }
        } while (opcion != 3);
    }
}
