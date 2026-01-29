
/**
 * Clase Empleado para representar un empleado en la base de datos Contiene
 * todos los atributos y métodos necesarios para trabajar con empleados
 *
 * @author Mejias Gonzalez Francisco
 */
public class Empleado {

    // ==================== ATRIBUTOS ====================
    private int idEmple;
    private String nombre;
    private String apellido;
    private int idDepart;
    private Integer idJefe;      // Puede ser NULL si es jefe supremo
    private String puesto;

    // ==================== CONSTRUCTORES ====================
    /**
     * Constructor sin parámetros
     */
    public Empleado() {
    }

    /**
     * Constructor con todos los parámetros
     */
    public Empleado(int idEmple, String nombre, String apellido,
            int idDepart, Integer idJefe, String puesto) {
        this.idEmple = idEmple;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idDepart = idDepart;
        this.idJefe = idJefe;
        this.puesto = puesto;
    }

    /**
     * Constructor sin ID (útil para insertar nuevos)
     */
    public Empleado(String nombre, String apellido, int idDepart,
            Integer idJefe, String puesto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idDepart = idDepart;
        this.idJefe = idJefe;
        this.puesto = puesto;
    }

    // ==================== GETTERS ====================
    /**
     * Obtiene el ID del empleado
     */
    public int getIdEmple() {
        return idEmple;
    }

    /**
     * Obtiene el nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del empleado
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el ID del departamento
     */
    public int getIdDepart() {
        return idDepart;
    }

    /**
     * Obtiene el ID del jefe
     *
     * @return ID del jefe o null si no tiene jefe
     */
    public Integer getIdJefe() {
        return idJefe;
    }

    /**
     * Obtiene el puesto del empleado
     */
    public String getPuesto() {
        return puesto;
    }

    // ==================== SETTERS ====================
    /**
     * Establece el ID del empleado
     */
    public void setIdEmple(int idEmple) {
        this.idEmple = idEmple;
    }

    /**
     * Establece el nombre del empleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el apellido del empleado
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Establece el ID del departamento
     */
    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    /**
     * Establece el ID del jefe
     */
    public void setIdJefe(Integer idJefe) {
        this.idJefe = idJefe;
    }

    /**
     * Establece el puesto del empleado
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    // ==================== MÉTODOS ÚTILES ====================
    /**
     * Obtiene el nombre completo del empleado
     *
     * @return "Nombre Apellido"
     */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    /**
     * Verifica si el empleado es jefe supremo (no tiene jefe)
     *
     * @return true si es jefe supremo, false si tiene jefe
     */
    public boolean esJefeSupremo() {
        return idJefe == null;
    }

    /**
     * Verifica si el empleado tiene jefe
     *
     * @return true si tiene jefe, false si es jefe supremo
     */
    public boolean tieneJefe() {
        return idJefe != null;
    }

    /**
     * Valida que los datos del empleado sean correctos
     *
     * @return true si todos los datos son válidos
     */
    public boolean esValido() {
        // Validar que no estén vacíos
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío");
            return false;
        }

        if (apellido == null || apellido.isEmpty()) {
            System.out.println("Error: El apellido no puede estar vacío");
            return false;
        }

        if (puesto == null || puesto.isEmpty()) {
            System.out.println("❌ Error: El puesto no puede estar vacío");
            return false;
        }

        // Validar IDs
        if (idEmple <= 0) {
            System.out.println("Error: El ID debe ser mayor a 0");
            return false;
        }

        if (idDepart <= 0) {
            System.out.println("Error: El ID del departamento debe ser mayor a 0");
            return false;
        }

        if (idJefe != null && idJefe <= 0) {
            System.out.println("Error: El ID del jefe debe ser mayor a 0");
            return false;
        }

        return true;
    }

    /**
     * Obtiene información del empleado en formato legible
     */
    @Override
    public String toString() {
        String jefe = (idJefe == null) ? "SUPREMO" : idJefe.toString();
        return String.format(
                "ID: %d | Nombre: %s %s | Puesto: %s | Depart: %d | Jefe: %s",
                idEmple, nombre, apellido, puesto, idDepart, jefe);
    }

    /**
     * Obtiene información del empleado en formato tabla
     */
    public String toTabla() {
        String jefe = (idJefe == null) ? "SUPREMO" : idJefe.toString();
        return String.format(
                "│ %2d │ %-20s │ %-15s │ %2d │ %7s │",
                idEmple, getNombreCompleto(), puesto, idDepart, jefe);
    }

    /**
     * Compara si dos empleados tienen el mismo ID
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Empleado) {
            Empleado otro = (Empleado) obj;
            return this.idEmple == otro.idEmple;
        }
        return false;
    }
}
