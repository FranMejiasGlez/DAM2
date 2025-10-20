/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_Fijo;

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
        String fichero = ("empleadosfijo.dat");
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
                        case 1: //ESCRIBIR EN FICHERO
                            StringBuilder nombreFijo,
                             apellidosFijos;
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
                                    System.out.println("Numero no valido,"
                                            + " teclee otro..");
                                    numeroCorrecto = false;
                                }
                            } while (numeroCorrecto == false || id < 1);
                            do {
                                System.out.println("Introduce Nombre"
                                        + ":(maximo 10 caracteres) ");
                                //Convierto en string fijo de 20 caracteres
                                nombre = teclado.readLine().trim();
                                nombreFijo = new StringBuilder(nombre);
                                nombreFijo.setLength(20);
                                nombre = nombreFijo.toString();
                            } while (nombre.length() > 20);
                            do {
                                System.out.println("Introduce Apellidos"
                                        + ":(maximo 30 caracteres)");
                                apellidos = teclado.readLine().trim();
                                apellidosFijos = new StringBuilder(apellidos);
                                apellidosFijos.setLength(30);
                                apellidos = apellidosFijos.toString();
                            } while (apellidos.length() > 60);
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
                            EmpleadosDAO.escribir(dataWrite, reg);
                            System.out.println("Registro guardado "
                                    + "correctamente.");
                            break;

                        case 2: //LEER FICHERO COMPLETO
                            System.out.println("Leyendo todo el fichero...");
                            DataInputStream dataRead = new DataInputStream(
                                    new FileInputStream(fichero));
                            Empleado empleado;
                            while ((empleado = EmpleadosDAO.leer(dataRead))
                                    != null) {
                                if (!EmpleadosDAO.ff) {
                                    System.out.println(empleado.toString());
                                }
                            }
                            dataRead.close();
                            EmpleadosDAO.ff = false; // Resetear flag
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
