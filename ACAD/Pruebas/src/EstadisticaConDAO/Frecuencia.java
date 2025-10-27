/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadisticaConDAO;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Frecuencia {

    private byte numero;
    private short frecuencia;
    private float porcentaje;

    public Frecuencia(byte numero, short frecuencia, float porcentaje) {
        this.numero = numero;
        this.frecuencia = frecuencia;
        this.porcentaje = porcentaje;
    }
}
