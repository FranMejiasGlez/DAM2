
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Estadistica {

    public byte numero;
    public short frecuencia;
    public float porcent;

    public Estadistica() {
    }

    public Estadistica(byte numero, short frecuencia, float porcent) {
        this.numero = numero;
        this.frecuencia = frecuencia;
        this.porcent = porcent;
    }

    /**
     * @return the numero
     */
    public byte getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(byte numero) {
        this.numero = numero;
    }

    /**
     * @return the frecuencia
     */
    public short getFrecuencia() {
        return frecuencia;
    }

    /**
     * @param frecuencia the frecuencia to set
     */
    public void aumentaFrecuencia() {
        this.frecuencia++;
    }

    /**
     * @return the porcent
     */
    public float getPorcent() {
        return porcent;
    }

    /**
     * @param porcent the porcent to set
     */
    public void setPorcent(float porcent) {
        this.porcent = porcent;
    }

    @Override
    public String toString() {
        return "" + this.getNumero() + " | " + this.getFrecuencia() + " | " + this.getPorcent();
    }
}
