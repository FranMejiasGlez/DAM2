/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipoPruebaDAO;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Prueba {

    private String nombre;
    private byte numeroPrueba;
    private short nVeces;

    public Prueba(byte numeroPrueba, String nombre, short nVeces) {
        this.nombre = nombre;
        this.numeroPrueba = numeroPrueba;
        this.nVeces = nVeces;
    }

    public String getNombre() {
        return nombre;
    }

    public byte getNumeroPrueba() {
        return numeroPrueba;
    }

    public short getnVeces() {
        return nVeces;
    }

    @Override
    public String toString() {

        return String.format("Prueba %d;%s;%d",
                numeroPrueba,
                nombre.trim(),
                nVeces);
    }
}
