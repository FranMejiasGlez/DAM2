
/**
 * Clase Departamento para representar un departamento en la base de datos
 * Contiene todos los atributos y métodos necesarios para trabajar con
 * departamentos
 *
 * @author Sistema de Gestión de Empleados
 */
public class Departamento {

    
    private int idDepart;
    private String nombreDepart;

   
    public Departamento() {
    }

    /**
     * Constructor con parámetros
     */
    public Departamento(int idDepart, String nombreDepart) {
        this.idDepart = idDepart;
        this.nombreDepart = nombreDepart;
    }

  
    public int getIdDepart() {
        return idDepart;
    }

   
    public String getNombreDepart() {
        return nombreDepart;
    }

    
    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

   
    public void setNombreDepart(String nombreDepart) {
        this.nombreDepart = nombreDepart;
    }

    
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

   
    @Override
    public String toString() {
        return String.format(
                "ID: %d | Nombre: %s",
                idDepart, nombreDepart);
    }

    
    public String toTabla() {
        return String.format(
                "│ %2d │ %-40s │",
                idDepart, nombreDepart);
    }

   
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Departamento) {
            Departamento otro = (Departamento) obj;
            return this.idDepart == otro.idDepart;
        }
        return false;
    }
}
