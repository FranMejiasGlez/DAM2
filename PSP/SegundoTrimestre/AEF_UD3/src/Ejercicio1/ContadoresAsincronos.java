package Ejercicio1;

public class ContadoresAsincronos {

    public static void main(String[] args) {
        HiloResta hiloResta = new HiloResta();
        HiloSuma hiloSuma = new HiloSuma();


        hiloResta.start();
        hiloSuma.start();
    }
}