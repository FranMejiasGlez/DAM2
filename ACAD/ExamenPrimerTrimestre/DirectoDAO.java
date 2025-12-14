package ExamenPrimerTrimestre;

import java.io.IOException;
import java.io.RandomAccessFile;

public class DirectoDAO {
    /* ===== CONSTANTES ===== */

    public static final int TAM = 0; // Tamaño del registro en bytes
    private static final int TAM_NOMBRE = 0;

    /* ===== ATRIBUTOS ===== */

    private RandomAccessFile rndFichero;
    private boolean eof;
    private String modo;

    /* ===== CONSTRUCTOR ===== */

    public RNombreFicheroDAO(String fichero, String modoApertura) throws IOException {
        this.modo = modoApertura;
        //Control de modo apertura con throw IllegalArgumentsException?
        rndFichero = new RandomAccessFile(fichero, modoApertura);
        eof = false;
    }

    /* ===== MÉTODOS AUXILIARES ===== */

    private String cadenaFija(String str, int longitud) {
        StringBuilder sb = new StringBuilder(str);

        if (sb.length() > longitud) {
            sb.setLength(longitud);
        } else {
            while (sb.length() < longitud) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    private String leeCaracteres(int longitud) throws IOException {
        char[] buffer = new char[longitud];

        for (int i = 0; i < longitud; i++) {
            buffer[i] = rndFichero.readChar();
        }
        return new String(buffer).trim();
    }

    /* ===== NAVEGACIÓN ===== */

    public void irAlPrincipio() throws IOException {
        rndFichero.seek(0);
        eof = false;
    }

    /* ===== LECTURA ===== */

    // Lectura secuencial
    public NombreRegistro leer() throws IOException {

        if (rndFichero.getFilePointer() >= rndFichero.length()) {
            eof = true;
            return null;
        }

        int id = rndFichero.readInt();
        String nombre = leeCaracteres(TAM_NOMBRE);

        return new NombreRegistro(id, nombre);
    }

    // Lectura directa
    public NombreRegistro leer(long posicion) throws IOException {

        long offset = posicion * TAM;

        if (offset >= rndFichero.length()) {
            return null;
        }

        rndFichero.seek(offset);

        int id = rndFichero.readInt();
        String nombre = leeCaracteres(TAM_NOMBRE);

        return new NombreRegistro(id, nombre);
    }

    /* ===== ESCRITURA ===== */

    public void escribir(NombreRegistro reg, long posicion) throws IOException {

        long offset = posicion * TAM;
        rndFichero.seek(offset);

        rndFichero.writeInt(reg.getId());

        String nombreFijo = cadenaFija(reg.getNombre(), TAM_NOMBRE);
        for (int i = 0; i < TAM_NOMBRE; i++) {
            rndFichero.writeChar(nombreFijo.charAt(i));
        }
    }

    public void reescribir(NombreRegistro reg) throws IOException {

        long posicionActual = (rndFichero.getFilePointer() - TAM) / TAM;
        escribir(reg, posicionActual);
    }

    /* ===== UTILIDADES ===== */

    public boolean existe(long posicion) throws IOException {
        return (posicion * TAM) < rndFichero.length();
    }

    public boolean isEof() {
        return eof;
    }

    public void borrar() throws IOException {
        rndFichero.setLength(0);
        irAlPrincipio();
    }

    public void close() throws IOException {
        rndFichero.close();
    }
}
