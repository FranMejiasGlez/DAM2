
/**
 * Clase Departamento para representar un departamento en la base de datos
 * Contiene todos los atributos y métodos necesarios para trabajar con
 * departamentos
 *
 * @author Sistema de Gestión de Empleados
 */
public class Departamento {

    // ==================== ATRIBUTOS ====================
    private int idDepart;
    private String nombreDepart;

    // ==================== CONSTRUCTORES ====================
    /**
     * Constructor sin parámetros
     */
    public Departamento() {
    }

    /**
     * Constructor con parámetros
     */
    public Departamento(int idDepart, String nombreDepart) {
        this.idDepart = idDepart;
        this.nombreDepart = nombreDepart;
    }

    // ==================== GETTERS ====================
    /**
     * Obtiene el ID del departamento
     */
    public int getIdDepart() {
        return idDepart;
    }

    /**
     * Obtiene el nombre del departamento
     */
    public String getNombreDepart() {
        return nombreDepart;
    }

    // ==================== SETTERS ====================
    /**
     * Establece el ID del departamento
     */
    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    /**
     * Establece el nombre del departamento
     */
    public void setNombreDepart(String nombreDepart) {
        this.nombreDepart = nombreDepart;
    }

    // ==================== MÉTODOS ÚTILES ====================
    /**
     * Valida que los datos del departamento sean correctos
     *
     * @return true si todos los datos son válidos
     */
    public boolean esValido() {
        // Validar que el nombre no esté vacío
        if (nombreDepart == null || nombreDepart.isEmpty()) {
            System.out.println("Error: El nombre del departamento no puede estar vacío");
            return false;
        }

        // Validar ID
        if (idDepart <= 0) {
            System.out.println("Error: El ID del departamento debe ser mayor a 0");
            return false;
        }

        return true;
    }

    /**
     * Obtiene información del departamento en formato legible
     */
    @Override
    public String toString() {
        return String.format(
                "ID: %d | Nombre: %s",
                idDepart, nombreDepart);
    }

    /**
     * Obtiene información del departamento en formato tabla
     */
    public String toTabla() {
        return String.format(
                "│ %2d │ %-40s │",
                idDepart, nombreDepart);
    }

    /**
     * Compara si dos departamentos tienen el mismo ID
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Departamento) {
            Departamento otro = (Departamento) obj;
            return this.idDepart == otro.idDepart;
        }
        return false;
    }
}
