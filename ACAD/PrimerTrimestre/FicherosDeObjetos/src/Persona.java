
import java.io.Serializable;

public class Persona implements Serializable {
    // Atributos básicos

    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private String genero;

    // Constructor por defecto
    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.dni = "";
        this.genero = "";
    }

    // Constructor con parámetros
    public Persona(String nombre, String apellido, int edad, String dni, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.genero = genero;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Método para obtener el nombre completo
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    // Método para verificar si es mayor de edad
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    // Método toString para mostrar la información de la persona
    @Override
    public String toString() {
        return "Persona{"
                + "nombre='" + nombre + '\''
                + ", apellido='" + apellido + '\''
                + ", edad=" + edad
                + ", dni='" + dni + '\''
                + ", genero='" + genero + '\''
                + '}';
    }

    // Método para mostrar información formateada
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombreCompleto());
        System.out.println("Edad: " + edad + " años");
        System.out.println("DNI: " + dni);
        System.out.println("Género: " + genero);
        System.out.println("Mayor de edad: " + (esMayorDeEdad() ? "Sí" : "No"));
    }
}