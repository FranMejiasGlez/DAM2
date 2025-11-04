
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 *
 */
public class REstadisticaDAO {

    private static final int TAM = 7;
    public boolean eof = false;
    private RandomAccessFile rndEstadistica;
    private String modo;

    public REstadisticaDAO(String fichero, String modoApertura) throws FileNotFoundException {
        this.modo = modoApertura;
        this.rndEstadistica = new RandomAccessFile(fichero, modo);
    }

    /* private String leeCaracteres(int longitud) {
     * }
     * 
     * private String cadenaFija(String str, int Longitud) {
     * }*/
    public void irAlPrincipio() throws IOException {
        rndEstadistica.seek(0);
    }

    public Estadistica leer() throws IOException {
        byte num;
        short frec;
        float porcent;
        Estadistica es = null;
        try {
            this.eof = false;
            num = rndEstadistica.readByte();
            frec = rndEstadistica.readShort();
            porcent = rndEstadistica.readFloat();
            es = new Estadistica(num, frec, porcent);
        } catch (EOFException eofe) {
            System.out.println("Fin de archivo");
            this.eof = true;
        }
        return es;
    }

    public Estadistica leer(long posicion) throws IOException {
        byte num;
        short frec;
        float porcent;
//TODO: try catch fin archivo
        rndEstadistica.seek(posicion);
        num = rndEstadistica.readByte();
        frec = rndEstadistica.readShort();
        porcent = rndEstadistica.readFloat();
        return new Estadistica(num, frec, porcent);
    }

    public boolean existe(long posicion) throws IOException {
        boolean existe;

        rndEstadistica.seek(posicion);
        existe = leer(posicion).getNumero() > 0;
        return existe;
    }

    public void escribir(Estadistica reg, long posicion) throws IOException {
        rndEstadistica.seek((posicion - 1) * REstadisticaDAO.TAM);
        rndEstadistica.writeByte(reg.getNumero());
        rndEstadistica.writeShort(reg.getFrecuencia());
        rndEstadistica.writeFloat(reg.getPorcent());
    }

    public void reescribir(Estadistica reg) throws IOException {
        rndEstadistica.seek(rndEstadistica.getFilePointer() - TAM);
        escribir(reg, rndEstadistica.getFilePointer());
    }

    public void borrar() throws IOException {
        rndEstadistica.seek(rndEstadistica.getFilePointer() - TAM);
        escribir(null, rndEstadistica.getFilePointer());
    }

    public void close() throws IOException {
        rndEstadistica.close();
    }
}
