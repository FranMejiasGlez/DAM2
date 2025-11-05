package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Traductor {

    public static void main(String[] args) {
        String engEs, esEng, http, frase;
        engEs = "en-es";
        esEng = "es-en";
        Process p;
        ProcessBuilder pb;
        BufferedReader teclado;

        pb = new ProcessBuilder();
        frase = "";
        http = "";
        teclado = new BufferedReader(new InputStreamReader(System.in));

        try {
            if (args.length < 2) {
                System.out.println("Numero de parametros incorrecto");
                System.out.println("Uso: java Traductor <segundos> <en-es|es-en>");

            } else {

                //Si el primer parametro es incorrecto
                if (Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[0]) > 10) {
                    System.out.println("El primer parametro de tiempo de ejecucion debe estar entre 1 y 10 segundos");

                } else {
                    //Si el segundo parametro es incorrecto
                    if (!args[1].matches(engEs) && !args[1].matches(esEng)) {
                        System.out.println("El segundo parametro no es valido, Introduzca: en-es|es-en");

                    } else {
                        //Si el segundo parametro es valido
                        System.out.println("Que quieres traducir?: ");
                        frase = teclado.readLine();
                        //Verificar Sistema Operativo
                        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                            pb.command().add("cmd");
                            pb.command().add("/c");
                            pb.command().add("start");
                        } else {
                            //Si es linux
                            if (System.getProperty("os.name").toLowerCase().contains("linux")) {
                                pb.command().add("xdg-open");
                            }
                        }
                        System.out.println("Construccion de comando hasta aqui: " + pb.command());
                        //Crear la URL con el primer y segundo idioma del parametro args[1]
                        http = "http://translate.google.es/?hl="
                                + args[1].substring(0, args[1].indexOf("-"))
                                + "#auto/"
                                + args[1].substring(args[1].indexOf("-") + 1, args[1].length());
                        //Terminar de crear la URL con la frase a traducir
                        http = http + "/" + frase.replace(" ", "%20"); // Codificar espacios;

                        //Agregar el comando a proceso
                        pb.command().add(http);
                        //Redireccionar salida del procesoe
                        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

                        //Arrancar proceso
                        System.out.println("Comando a ejecutar: " + pb.command());
                        System.out.println("URL: " + http);
                        p = pb.start();
                        //TODO: gestionar tiempo maximo de ejecucion

                    }
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Dato de tiempo no valido, teclee un numero");
        } catch (IOException ex) {
            System.out.println("Error al iniciar proceso");
        }
    }
}
