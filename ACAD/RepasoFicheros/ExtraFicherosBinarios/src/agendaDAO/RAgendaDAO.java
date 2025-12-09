/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaDAO;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class RAgendaDAO {
//Nombre (String 15), Edad byte, Direccion (String 30), Telefono(String 9)

    private static final short TAM_REGISTRO = 109;
    private static final byte TAM_NOMBRE = 15;
    private static final byte TAM_DIRECCION = 30;
    private static final byte TAM_TELEFONO = 9;
    private boolean ff;
    private long ultimoRegistroLeido;
    private RandomAccessFile raf;
    private String ruta, modo;

    public RAgendaDAO(String ruta, String modo) throws FileNotFoundException {
        if (modo.matches("r|rw")) {
            this.ruta = ruta;
            this.raf = new RandomAccessFile(new File(ruta), modo);
        } else {
            throw new IllegalArgumentException("Modos: r|rw");
        }

    }

    private String cambiaAFija(String cadenaOriginal, byte tamanio) {
        StringBuilder cadFija;
        cadFija = new StringBuilder(cadenaOriginal);
        cadFija.setLength(tamanio);

        return cadFija.toString();
    }

    private String leeCaracteres(byte tamanio) throws IOException {
        char[] salida;
        salida = new char[tamanio];
        for (int i = 0; i < tamanio; i++) {
            salida[i] = raf.readChar();
        }
        return new String(salida);
    }

    public void escribir(PersonaAgenda persona) throws IOException {
        raf.writeChars(cambiaAFija(persona.getNombre(), TAM_NOMBRE));
        raf.writeByte(persona.getEdad());
        raf.writeChars(cambiaAFija(persona.getDireccion(), TAM_DIRECCION));
        raf.writeChars(cambiaAFija(persona.getTelefono(), TAM_TELEFONO));
    }

    public PersonaAgenda leer() throws IOException {
        setFf(false);
        PersonaAgenda registro = null;
        try {

            registro = new PersonaAgenda(leeCaracteres(TAM_NOMBRE), raf.readByte(),
                    leeCaracteres(TAM_DIRECCION),
                    leeCaracteres(TAM_TELEFONO));
            this.ultimoRegistroLeido = registroActual();
        } catch (EOFException eof) {
            System.out.println("Fin de archivo");
            setFf(true);
        }

        return registro;

    }

    public PersonaAgenda leer(long registro) throws IOException {
        setFf(false);
        String nombre, direccion, telefono;
        byte edad;
        PersonaAgenda persona = null;
        try {
            posicionar(registro);
            this.ultimoRegistroLeido = registro;
            nombre = leeCaracteres(TAM_NOMBRE);
            if (nombre.isEmpty() || nombre.trim().isEmpty()) {
                throw new EOFException("Registro vacio");
            } else {

                edad = raf.readByte();

                direccion = leeCaracteres(TAM_DIRECCION);

                telefono = leeCaracteres(TAM_TELEFONO);

                persona = new PersonaAgenda(nombre, edad, direccion, telefono);
            }
        } catch (EOFException eof) {
            System.out.println("Fin de archivo");
            setFf(true);
        }

        return persona;
    }

    public void cerrar() throws IOException {
        if (raf != null) {
            raf.close();
        }
    }

    public long registroActual() throws IOException {
        long numero;
        numero = raf.getFilePointer() / TAM_REGISTRO;
        return numero;
    }

    public long getTotalRegistros() throws IOException {
        long total;
        total = raf.length() / TAM_REGISTRO;
        return total;
    }

    public void borrar() throws IOException {
        posicionar(ultimoRegistroLeido);
        raf.writeChars(cambiaAFija("", TAM_NOMBRE));
        raf.writeByte(0);
        raf.writeChars(cambiaAFija("", TAM_DIRECCION));
        raf.writeChars(cambiaAFija("", TAM_TELEFONO));
    }

    public void reescribir(PersonaAgenda persona) throws IOException {
        posicionar(ultimoRegistroLeido);
        escribir(persona);
    }

    public void posicionar(long registro) throws IOException {
        long pos = registro * TAM_REGISTRO;
        raf.seek(pos);
    }

    public void irAlPrincipio() throws IOException {
        raf.seek(0);
    }

    public boolean existe(long registro) throws IOException {
        return registro * TAM_REGISTRO < raf.length();
    }

    public boolean isFf() {
        return ff;
    }

    public void setFf(boolean ff) {
        this.ff = ff;
    }
}
