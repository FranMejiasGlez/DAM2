/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class Jaula {
    public static void main(String[] args) {
        Comedero comedero = new Comedero();
        Columpio columpio = new Columpio();
        int canarios = 10;
        
        for(int i = 0; i < canarios; i++){
            new Canario(i, comedero, columpio).start();
        }
        
    }
}
