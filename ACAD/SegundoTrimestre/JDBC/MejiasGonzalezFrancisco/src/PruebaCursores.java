
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class PruebaCursores {

    public static void main(String[] args) {
        Properties propiedades = new Properties();
        GestionConCursores gcc;

        try {
            propiedades.load(new FileInputStream("src/Oracle.properties"));
        } catch (IOException e) {
            System.out.println("Error al cargar archivo de propiedades: " + e.getMessage());
            return;
        }
        String driver = propiedades.getProperty("driver");
        String urlConexion = propiedades.getProperty("url");
        String usuario = propiedades.getProperty("usuario");
        String contra = propiedades.getProperty("password");
        gcc = new GestionConCursores(driver, urlConexion, usuario, contra);
        System.out.println(gcc.obtenerTotalEmpleados());
    }
}
