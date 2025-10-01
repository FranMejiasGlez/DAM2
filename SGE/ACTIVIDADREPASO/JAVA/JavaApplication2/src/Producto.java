

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Producto {

    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Método para descontar del stock
    public boolean reducirStock(int cantidad) {
        boolean reducido = false;
        if (cantidad <= stock) {
            stock -= cantidad;
            reducido = true;
        } else {
            System.out.println("No hay suficiente stock de " + nombre);

        }
        return reducido;
    }

    @Override
    public String toString() {
        return nombre + " - Precio: " + precio + " - Stock: " + stock;
    }
}
