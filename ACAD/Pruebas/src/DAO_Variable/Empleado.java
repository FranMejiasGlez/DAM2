package DAO_Variable;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Empleado {

    private int id;
    private String nombre;
    private String apellidos;
    private float sueldo;

    public Empleado(int id, String nombre, String apellidos, float sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{"
                + "\nid=" + id
                + "\nnombre='" + nombre + '\''
                + "\napellidos='" + apellidos + '\''
                + "\nsueldo=" + sueldo + " €"
                + '}';
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
