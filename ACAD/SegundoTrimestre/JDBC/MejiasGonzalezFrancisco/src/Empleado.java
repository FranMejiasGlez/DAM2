
/**
 * Clase Empleado para representar un empleado en la base de datos Contiene
 * todos los atributos y métodos necesarios para trabajar con empleados
 *
 * @author Mejias Gonzalez Francisco
 */
public class Empleado {

  
    private int idEmple;
    private String nombre;
    private String apellido;
    private int idDepart;
    private Integer idJefe;      // Puede ser NULL si es jefe supremo
    private String puesto;

    
    public Empleado() {
    }

   
    public Empleado(int idEmple, String nombre, String apellido,
            int idDepart, Integer idJefe, String puesto) {
        this.idEmple = idEmple;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idDepart = idDepart;
        this.idJefe = idJefe;
        this.puesto = puesto;
    }

  
    public Empleado(String nombre, String apellido, int idDepart,
            Integer idJefe, String puesto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idDepart = idDepart;
        this.idJefe = idJefe;
        this.puesto = puesto;
    }

   
  
    public int getIdEmple() {
        return idEmple;
    }

    
    public String getNombre() {
        return nombre;
    }

   
    public String getApellido() {
        return apellido;
    }

    public int getIdDepart() {
        return idDepart;
    }

   
    public Integer getIdJefe() {
        return idJefe;
    }

  
    public String getPuesto() {
        return puesto;
    }

  
    
    public void setIdEmple(int idEmple) {
        this.idEmple = idEmple;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

   
    public void setIdJefe(Integer idJefe) {
        this.idJefe = idJefe;
    }

    
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    
    public boolean esJefeSupremo() {
        return idJefe == null;
    }

  
    public boolean tieneJefe() {
        return idJefe != null;
    }

   
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
            System.out.println(" Error: El puesto no puede estar vacío");
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

    
    @Override
    public String toString() {
        String jefe = (idJefe == null) ? "SUPREMO" : idJefe.toString();
        return String.format(
                "ID: %d | Nombre: %s %s | Puesto: %s | Depart: %d | Jefe: %s",
                idEmple, nombre, apellido, puesto, idDepart, jefe);
    }

    public String toTabla() {
        String jefe = (idJefe == null) ? "SUPREMO" : idJefe.toString();
        return String.format(
                "│ %2d │ %-20s │ %-15s │ %2d │ %7s │",
                idEmple, getNombreCompleto(), puesto, idDepart, jefe);
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Empleado) {
            Empleado otro = (Empleado) obj;
            return this.idEmple == otro.idEmple;
        }
        return false;
    }
}
