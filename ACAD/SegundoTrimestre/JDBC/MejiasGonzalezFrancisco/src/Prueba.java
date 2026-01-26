
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Prueba {

    public static void main(String[] args) {

        Connection connection;
        String nombreDriver = "org.apache.derby.jdbc.ClientDriver";
        try {
            try {
                Class.forName(nombreDriver);
            } catch (ClassNotFoundException ex) {
                System.out.println("Clase no encontrada");
            }
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA", "DAM2", "DAM2");
            System.out.println("Conexion exitosa");
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la conexion");
        }
    }
}
