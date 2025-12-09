/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaDAO;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class PersonaAgenda {

    private String nombre, direccion;
    private byte edad;
    private short telefono;

    public PersonaAgenda(String nombre, byte edad, String direccion, short telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @return the edad
     */
    public byte getEdad() {
        return edad;
    }

    /**
     * @return the telefono
     */
    public short getTelefono() {
        return telefono;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(byte edad) {
        this.edad = edad;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(short telefono) {
        this.telefono = telefono;
    }
    
}
