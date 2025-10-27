/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadisticaConDAO;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Estadistica {

    private byte numero;
    private short frecuencia;
    private float porcentaje;

    public Estadistica(byte numero, short frecuencia, float porcentaje) {
        this.numero = numero;
        this.frecuencia = frecuencia;
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return String.format("Número: %2d | Frecuencia: %3d | Porcentaje: %6.2f%%",
                numero, frecuencia, porcentaje);
    }

    public byte getNumero() {
        return numero;
    }

    public void setNumero(byte numero) {
        this.numero = numero;
    }

    public short getFrecuencia() {
        return frecuencia;
    }

    public void aumentaFrecuencia() {
        this.frecuencia++;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }
}
