package Ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Utilidades {

    public static void main(String[] args) {
        FileReader fichero1 = null, fichero2 = null;
        boolean esFichero = true;
        Process procesoFC, procesoNetUser;
        ProcessBuilder pbFC, pbNetUser;
        List<String> comandos;

        try {
            FileWriter ficheroErrores = new FileWriter("Errores.txt");
            ficheroErrores.close();

            ficheroErrores = new FileWriter("Errores.txt", true);
            if (args.length < 1 || args.length > 2) {
                System.out.println("Error de formato, modo uso: ");
                System.out.println("Comparar ficheros: ");
                System.out.println("");
                System.out.println("java Utilidades [RutaFichero1] [RutaFichero2]");
                System.out.println("");
                System.out.println("Comprobar existencia de user en sistema operativo: ");
                System.out.println("");
                System.out.println("java Utilidades [NombreUsuario]");
            } else {
                //Si son 2 parametros
                if (args.length == 2) {
                    try {
                        fichero1 = new FileReader(args[0]);
                    } catch (FileNotFoundException fnfe) {
                        System.out.println("Fichero 1 no encontrado");
                        esFichero = false;
                        try {
                            ficheroErrores.write("Fichero 1 no encontrado\n");
                        } catch (IOException ex) {
                            System.out.println("Error al escribir en fichero de errores");
                        }
                    }

                    try {
                        fichero2 = new FileReader(args[1]);
                    } catch (FileNotFoundException fnfe) {
                        System.out.println("Fichero 2 no encontrado");
                        esFichero = false;
                        try {
                            ficheroErrores.write("Fichero 2 no encontradoçn");
                        } catch (IOException ex) {
                            System.out.println("Error al escribir en fichero de errores");
                        }
                    }

                    if (esFichero == false) {
                        System.out.println("Error de parametros,"
                                + " se esperaba encontrar: java Utilidades [Ruta Fichero1] [Ruta Fichero2]");
                    } else {
                        //Comparar ficheros con fc
                        comandos = new ArrayList<>();
                        comandos.add("cmd");
                        comandos.add("/c");
                        comandos.add("fc");
                        comandos.add(args[0]);  // Usa args[0] directamente
                        comandos.add(args[1]);  // Usa args[1] directamente
                        pbFC = new ProcessBuilder(comandos);
                        System.out.println("Ejecutando comparacion");

                        if (fichero1 != null && fichero2 != null) {
                            try {
                                File errores = new File("Errores.txt");
                                pbFC.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                                pbFC.redirectError(ProcessBuilder.Redirect.to(errores));
                                procesoFC = pbFC.start();
                                procesoFC.waitFor();  // Esperar a que termine
                            } catch (IOException ex) {
                                System.out.println("Error al arrancar proceso fc");
                            } catch (InterruptedException ex) {
                                System.out.println("Proceso fc interrumpido");
                            } finally {
                                fichero1.close();
                                fichero2.close();
                            }
                        }
                    }
                } else {
                    //Si es 1 parametro - buscar usuario
                    if (args.length == 1) {
                        System.out.println("Comprobando usuario " + args[0]
                                + " en sistema");
                        comandos = new ArrayList<>();
                        comandos.add("cmd");
                        comandos.add("/c");
                        comandos.add("net");
                        comandos.add("user");
                        comandos.add(args[0]);
                        pbNetUser = new ProcessBuilder(comandos);

                        try {
                            String linea;
                            boolean existe = false;
                            pbNetUser.redirectOutput(ProcessBuilder.Redirect.PIPE);
                            pbNetUser.redirectError(ProcessBuilder.Redirect.PIPE);
                            procesoNetUser = pbNetUser.start();

                            BufferedReader lector = new BufferedReader(
                                    new InputStreamReader(
                                    procesoNetUser.getInputStream()));

                            while ((linea = lector.readLine()) != null) {
                                if (linea.contains("Nombre de usuario")) {
                                    existe = true;
                                }
                            }

                            procesoNetUser.waitFor();

                            if (existe) {
                                System.out.println("El usuario " + args[0]
                                        + " EXISTE");
                            } else {
                                System.out.println("El usuario " + args[0]
                                        + " NO EXISTE");
                            }

                        } catch (IOException ioe) {
                            System.out.println("Error al arrancar proceso"
                                    + " net user");
                        } catch (InterruptedException ex) {
                            System.out.println("Proceso net "
                                    + "user interrumpido");
                        }
                    }
                }
            }
        } catch (FileNotFoundException fnfErrores) {
            System.out.println("Error al crear o sobreescribir Fichero"
                    + " Errores.txt");
        } catch (IOException ex) {
            System.out.println("Error al escribir en fichero de errores");
        }
    }
}