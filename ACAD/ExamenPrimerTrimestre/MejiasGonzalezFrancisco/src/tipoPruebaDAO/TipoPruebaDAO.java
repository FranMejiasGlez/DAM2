/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipoPruebaDAO;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class TipoPruebaDAO {

    private final byte TAM_NOMBREPRUEBA = 15;
    private RandomAccessFile raf;
    private boolean ff;
    private static final long TAM_REGISTRO = 33;
    private String modo;

    public TipoPruebaDAO(String ruta, String modo) throws FileNotFoundException {
        if (modo.equalsIgnoreCase("w")) {
            File f = new File(ruta);
            f.delete();

            this.raf = new RandomAccessFile(ruta, "rw");
        } else {
            this.raf = new RandomAccessFile(ruta, modo);
        }
        this.modo = modo;
    }

    private String cambiaAFija(String cadenaOriginal, byte tamanio) {
        String resultado;
        if (cadenaOriginal == null) {
            cadenaOriginal = "";
        }

        if (cadenaOriginal.length() > tamanio) {
            throw new IllegalArgumentException(
                    String.format("Cadena demasiado larga: %d caracteres (maximo: %d)",
                    cadenaOriginal.length(), tamanio));
        }

        StringBuilder cadFija;
        cadFija = new StringBuilder(cadenaOriginal);
        cadFija.setLength(tamanio);
        resultado = cadFija.toString();
        return resultado;
    }

    private String leeCaracteres(byte tamanio) throws IOException {
        char[] salida;
        salida = new char[tamanio];
        for (int i = 0; i < tamanio; i++) {
            salida[i] = raf.readChar();
        }
        return new String(salida);
    }

    public void escribir(Prueba prueba, long posicion) throws IOException, Exception {
        raf.seek(posicion * TAM_REGISTRO);
        raf.writeByte(prueba.getNumeroPrueba());
        raf.writeChars(cambiaAFija(prueba.getNombre(), TAM_NOMBREPRUEBA));
        raf.writeShort(prueba.getnVeces());
    }

    public Prueba leer() throws IOException {
        ff = false;
        Prueba registro = null;
        try {

            registro = new Prueba(raf.readByte(), leeCaracteres(TAM_NOMBREPRUEBA), raf.readShort());


        } catch (EOFException eof) {
            System.out.println("Fin de archivo");
            ff = true;
        }

        return registro;

    }

    public Prueba leer(long registro) throws IOException {
        ff = false;
        String nombre;
        byte numeroPrueba;
        short nVec;
        Prueba prueba = null;
        try {
            raf.seek(registro);


            numeroPrueba = raf.readByte();
            nombre = leeCaracteres(TAM_NOMBREPRUEBA);
            nVec = raf.readShort();
            prueba = new Prueba(numeroPrueba, nombre, nVec);
        } catch (EOFException eof) {
            System.out.println("Fin de archivo");
            ff = true;
        }
        return prueba;
    }

    public void cerrar() throws IOException {
        if (raf != null) {
            raf.close();
        }
    }

    public long getTotalRegistros() throws IOException {
        long total;
        total = raf.length() / TAM_REGISTRO;
        return total;
    }

    public void borrar() throws IOException, Exception {

        raf.writeByte(0);
        raf.writeChars(cambiaAFija("", TAM_NOMBREPRUEBA));
        raf.writeByte(0);
    }

    public void reescribir(Prueba prueba) throws IOException, Exception {
        this.raf.seek(this.raf.getFilePointer() - TAM_REGISTRO);
        this.escribir(prueba, this.raf.getFilePointer() / TAM_REGISTRO);
    }

    public void irAlPrincipio() throws IOException {
        raf.seek(0);
    }

    public boolean existe(long registro) throws IOException {
        boolean existe;
        raf.seek(registro * TAM_REGISTRO);
        existe = this.raf.readByte() != 0;
        return existe;
    }

    public boolean isFf() {
        return ff;
    }
}
