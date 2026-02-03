/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class TextoModel {

    public synchronized String limpiarTexto(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.trim().replaceAll("\\s+", " ");
    }

    public synchronized int contar(String texto, Tipo tipo) {

        String textoLimpio = limpiarTexto(texto);

        if (textoLimpio.isEmpty()) {
            return 0;
        }


        int conteo = textoLimpio.length() - textoLimpio.replaceAll(tipo.getTipo(), "").length();


        if (tipo == Tipo.PALABRAS) {
            conteo++;
        }

        return conteo;
    }
}
