/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Cliente cliente;
            cliente = new Cliente();
            cliente.setName(Integer.toString(i));
            cliente.start();
        }
    }
}
