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

    private String nombre, direccion, telefono;
    private byte edad;

    public PersonaAgenda(String nombre, byte edad, String direccion, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "\nnombre: " + nombre + '\n'
                + "direccion: " + direccion + '\n'
                + "telefono=: " + telefono + '\n'
                + "edad: " + edad;
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
    public String getTelefono() {
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
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
