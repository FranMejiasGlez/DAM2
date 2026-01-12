package Ejercicio2;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class P2 {

    public static void main(String[] args) {
        Process p;
        ProcessBuilder pb;
        pb = new ProcessBuilder("notepad.exe");
        try {
            p = pb.start();
        } catch (IOException ex) {
            Logger.getLogger(P1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
