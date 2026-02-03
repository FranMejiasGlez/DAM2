/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class Columpio {
    private boolean ocupado = false;
    
    public synchronized void subir(int id){
        while(ocupado){
            try{
                wait();
            } catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        ocupado = true;
        System.out.println("Canario " + id + " se SUBE al columpio.");
    }
    
    public synchronized void bajar(int id){
        ocupado = false;
        System.out.println("Canario " + id + " se BAJA del columpio.");
        notifyAll();
    }
}
