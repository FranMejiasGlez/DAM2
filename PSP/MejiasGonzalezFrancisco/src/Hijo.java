
 

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Hijo {

    public static void main(String[] args) {
        try {
            Thread.sleep(3000);
            System.out.println("Proceso Hijo terminado.");
            
            System.exit(2);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
    }
}
