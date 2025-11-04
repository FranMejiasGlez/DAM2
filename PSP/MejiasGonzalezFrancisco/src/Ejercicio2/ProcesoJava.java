package Ejercicio2;


import java.io.File;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public final class ProcesoJava {

    public static Process exec(Class clase) throws IOException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator
                + "bin" + File.separator + "java";
        String classPath = System.getProperty("java.class.path");
        String className = clase.getCanonicalName();
        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classPath, className);
        return builder.start();
    }

    public static void main(String[] args) throws IOException {
        ProcesoJava.exec(P1.class);
        ProcesoJava.exec(P1.class);
        ProcesoJava.exec(P2.class);

    }
}

