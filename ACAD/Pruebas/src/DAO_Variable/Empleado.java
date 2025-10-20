/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_Variable;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Empleado {

    public int id;
    public String nombre;
    public String apellidos;
    public float sueldo;

    public Empleado(int id, String nombre, String apellidos, float sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the sueldo
     */
    public float getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
}
