
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class GestionConCursores {

    Connection conexion;
    String driver, urlConexion, contra, username;

    public GestionConCursores(String driver, String urlConexion, String username, String contra) {
        this.driver = driver;
        this.username = username;
        this.contra = contra;
        this.urlConexion = urlConexion;
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
        }
        try {
            conexion = DriverManager.getConnection(urlConexion, username, contra);
            System.out.println("Conectado.");
        } catch (SQLException ex) {
            System.out.println("No se pudo conectar.");
        }
    }

    public int obtenerTotalEmpleados() {
        try {
            String sql = "SELECT id_emple,nombre FROM empleado";
            PreparedStatement pstmt = conexion.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = pstmt.executeQuery();

            rs.last();

            int total = rs.getRow();
            System.out.println("Total empleados: ");

            rs.close();
            pstmt.close();
            return total;
        } catch (SQLException ex) {
            System.out.println("Error Ejecutando Query");
            return 0;
        }

    }
}
