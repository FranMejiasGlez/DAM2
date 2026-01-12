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

    private boolean ff;
    private String ruta;
    private DataInputStream fichero;

    public AgendaDAO() throws IOException {
        this.ruta = "Ficheros/Agenda.dat";
        this.fichero = null;
    }

    public PersonaAgenda leerRegistro() throws FileNotFoundException, IOException {
        PersonaAgenda persona = null;
        String nombre, direccion;
        byte edad;
        String telefono;


        if (this.fichero == null) {
            this.fichero = new DataInputStream(new FileInputStream(new File(ruta)));
        }

        setFf(false);

        try {
            nombre = this.fichero.readUTF();
            edad = this.fichero.readByte();
            direccion = this.fichero.readUTF();
            telefono = this.fichero.readUTF();
            persona = new PersonaAgenda(nombre, edad, direccion, telefono);

        } catch (EOFException eofe) {
            System.out.println("Fin de fichero Agenda.dat");
            setFf(true);
            fichero.close();
            fichero = null;
        }

        return persona;
    }

    public void escribirRegistro(PersonaAgenda persona) throws FileNotFoundException, IOException {
        DataOutputStream fichero = new DataOutputStream(
                new FileOutputStream(ruta, true));

        fichero.writeUTF(persona.getNombre());
        fichero.writeByte(persona.getEdad());
        fichero.writeUTF(persona.getDireccion());
        fichero.writeUTF(persona.getTelefono());

        fichero.close();
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
