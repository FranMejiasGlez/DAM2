
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class ClienteSocketUsuario {

    public static void main(String[] args) {
        Socket cliente = null;

        InetAddress ipLocal = null;
        ObjectOutputStream objetoSalida;
        ObjectInputStream objetoEntrada;
        Usuario user;
        String password, nombre;
        BufferedReader teclado;
        try {
            ipLocal = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println("Host desconocido");
        }
        try {
            cliente = new Socket(ipLocal, 5000);
        } catch (IOException ex) {
            System.out.println("Conexion rechazada.");
        }
        try {
            try {
                objetoEntrada = new ObjectInputStream(cliente.getInputStream());
                try {
                    user = (Usuario) objetoEntrada.readObject();
                    System.out.println("Password: " + user.getPassword());
                    user.setIp(ipLocal);

                    System.out.println("Introduzca un nombre de usuario: ");
                    teclado = new BufferedReader(new InputStreamReader(System.in));
                    nombre = teclado.readLine();
                    password = user.getPassword();
                    user.setNombre(nombre);
                    objetoSalida = new ObjectOutputStream(cliente.getOutputStream());
                    objetoSalida.writeObject(user);
                    objetoEntrada.close();//Cierro Stream de Entrada
                    objetoSalida.close();//Cierro Stream de Salida
                } catch (ClassNotFoundException ex) {
                    System.out.println("Clase no encontrada");
                }
            } catch (NullPointerException npe) {
                System.out.println("La conexion no ha podido establecerse");
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            System.out.println("Tipo de error: " + ex.getClass().getSimpleName());
        }
    }
}
