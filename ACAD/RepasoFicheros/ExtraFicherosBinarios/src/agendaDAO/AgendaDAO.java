/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class AgendaDAO {

    private File agenda;
    private boolean ff;

    public AgendaDAO(File ruta) {
        this.agenda = ruta;
    }

    public PersonaAgenda leerRegistro() throws FileNotFoundException, IOException {
        PersonaAgenda persona = null;
        String nombre, direccion;
        byte edad;
        short telefono;
        DataInputStream fichero;

        fichero = new DataInputStream(new FileInputStream(agenda));
        setFf(false);
        try {
            nombre = fichero.readUTF();
            edad = fichero.readByte();
            direccion = fichero.readUTF();
            telefono = fichero.readShort();
            persona = new PersonaAgenda(nombre, edad, direccion, telefono);

        } catch (EOFException eofe) {
            System.out.println("Fin de fichero Agenda.dat");
            setFf(true);
        }
        return persona;
    }

    public void escribirRegistro(PersonaAgenda persona) throws FileNotFoundException, IOException {
        DataOutputStream fichero;
        fichero = new DataOutputStream(new FileOutputStream(agenda));

        fichero.writeUTF(persona.getNombre());
        fichero.writeByte(persona.getEdad());
        fichero.writeUTF(persona.getDireccion());
        fichero.writeShort(persona.getTelefono());
    }

    /**
     * @return the ff
     */
    public boolean isFf() {
        return ff;
    }

    /**
     * @param ff the ff to set
     */
    public void setFf(boolean ff) {
        this.ff = ff;
    }
}
