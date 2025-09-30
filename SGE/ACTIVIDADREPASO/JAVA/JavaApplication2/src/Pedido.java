
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DAM2
 */
public class Pedido {

    private ArrayList<Producto> productos;
    private ArrayList<Integer> cantidades;
    // Añadir producto al pedido

    public void agregarProducto(Producto p, int cantidad) {
        if (p.reducirStock(cantidad)) { // Se descuenta del stock si hay suficiente
            productos.add(p);
            cantidades.add(cantidad);
            System.out.println(cantidad + " x " + p.getNombre() + " agregado al pedido.");
        }
    }

    // Calcular el total del pedido
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio() * cantidades.get(i);
        }
        return total;
    }

    // Mostrar pedido
    public void mostrarPedido() {
        System.out.println("=== Pedido ===");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(cantidades.get(i) + " x " + productos.get(i).getNombre()
                    + " = " + (productos.get(i).getPrecio() * cantidades.get(i)));
        }
        System.out.println("TOTAL: " + calcularTotal());
    }
}
