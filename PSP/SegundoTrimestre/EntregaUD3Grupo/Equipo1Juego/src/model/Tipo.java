package model;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public enum Tipo {
    
    VOCALES("(?i)[aeiouáéíóúü]"),
    LETRAS("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]"),
    MAYUSCULAS("[A-ZÑÁÉÍÓÚÜ]"),
    PALABRAS(" ");
    
    private final String regex;
    
    private Tipo(String regex){
        this.regex = regex;
    }
    
    public String getTipo(){
        return regex;
    }
}
