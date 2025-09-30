/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DAM2
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class StockProducto {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Pedir datos al usuario
        System.out.print("Ingrese el stock inicial del producto: ");
        int stockInicial = Integer.parseInt(br.readLine());

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = br.readLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(br.readLine());

        // Crear producto con stock inicial
        Producto p1 = new Producto(nombre, precio, stockInicial);

        // Pedir unidades a vender
        System.out.print("Ingrese cuántas unidades desea vender: ");
        int venta = Integer.parseInt(br.readLine());
        // Usar el método reducirStock()
        if (p1.reducirStock(venta)) {
            System.out.println("Venta realizada correctamente.");
            System.out.println("Stock actualizado de " + p1.getNombre() + ": " + p1.getStock());
        } else {
            System.out.println("Error: no hay suficiente stock disponible.");
        }
    }
}
