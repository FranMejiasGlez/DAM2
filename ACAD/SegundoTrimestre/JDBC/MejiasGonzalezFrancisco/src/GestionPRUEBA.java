
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class GestionPRUEBA {

    //  private
    private String nombreDriver;
    Connection conexion;
    private String urlConexion;
    private String usuario;
    private String contra;

    public GestionPRUEBA(String nombreDriver, String urlConexion, String usuario, String contraseña) {
        this.nombreDriver = nombreDriver;
        this.urlConexion = urlConexion;
        this.usuario = usuario;
        this.contra = contraseña;
        try {
            try {
                Class.forName(nombreDriver);
            } catch (ClassNotFoundException ex) {
                System.out.println("Clase no encontrada");
            }
            conexion = DriverManager.getConnection(urlConexion, usuario, contra);
            System.out.println("Conexion exitosa");
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la conexion: " + ex.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void insertarDepartamento(int idDepart, String nombreDepart) {
        try {
            String sql = "INSERT INTO departamento (id_depart, nombre_depart) VALUES (?, ?)";

            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idDepart);
            pstmt.setString(2, nombreDepart);

            int filasInsertadas = pstmt.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Departamento insertado: " + nombreDepart);
            }

            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar departamento: " + e.getMessage());
        }
    }

    public void insertarEmpleado(int idEmple, String nombre, String apellido,
            int idDepart, Integer idJefe, String puesto) {
        try {
            String sql = "INSERT INTO empleado "
                    + "(id_emple, nombre, apellido, id_depart, id_jefe, puesto) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idEmple);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setInt(4, idDepart);

            // Manejo de NULL
            if (idJefe != null) {
                pstmt.setInt(5, idJefe);
            } else {
                pstmt.setNull(5, java.sql.Types.INTEGER);
            }

            pstmt.setString(6, puesto);

            int filasInsertadas = pstmt.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Empleado insertado: " + nombre + " " + apellido);
            }

            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.getMessage());
        }
    }

    public void actualizarEmpleado(int idEmple, String nuevoNombre,
            String nuevoApellido, String nuevoPuesto,
            Integer nuevoIdJefe) {
        try {
            String sql = "UPDATE empleado "
                    + "SET nombre = ?, apellido = ?, puesto = ?, id_jefe = ? "
                    + "WHERE id_emple = ?";

            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevoApellido);
            pstmt.setString(3, nuevoPuesto);

            if (nuevoIdJefe != null) {
                pstmt.setInt(4, nuevoIdJefe);
            } else {
                pstmt.setNull(4, java.sql.Types.INTEGER);
            }

            pstmt.setInt(5, idEmple);

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Empleado actualizado: " + nuevoNombre);
            } else {
                System.out.println("No se encontró empleado con ID: " + idEmple);
            }

            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void actualizarDepartamento(int idDepart, String nuevoNombre) {
        try {
            String sql = "UPDATE departamento SET nombre_depart = ? WHERE id_depart = ?";

            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, nuevoNombre);   // Nuevo nombre
            pstmt.setInt(2, idDepart);         // WHERE id_depart = ?

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("✓ Departamento actualizado: " + nuevoNombre);
            } else {
                System.out.println("⚠ No se encontró departamento con ID: " + idDepart);
            }

            pstmt.close();

        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void eliminarDepartamento(int idDepart) {
        try {
            // PRIMERO: Verificar si hay empleados en este departamento
            String sqlVerificar = "SELECT COUNT(*) as cantidad FROM empleado "
                    + "WHERE id_depart = ?";
            PreparedStatement pstmtVer = conexion.prepareStatement(sqlVerificar);
            pstmtVer.setInt(1, idDepart);
            ResultSet rs = pstmtVer.executeQuery();

            rs.next();
            int cantidad = rs.getInt("cantidad");

            if (cantidad > 0) {
                System.out.println("⚠ No se puede eliminar: hay " + cantidad
                        + " empleados en este departamento");
                rs.close();
                pstmtVer.close();
                return;
            }

            // SEGUNDO: Eliminar el departamento
            String sql = "DELETE FROM departamento WHERE id_depart = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idDepart);

            int filasEliminadas = pstmt.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Departamento eliminado");
            } else {
                System.out.println("No se encontró departamento con ID: " + idDepart);
            }

            rs.close();
            pstmtVer.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public void eliminarEmpleado(int idEmple) {
        try {
            // PRIMERO: Verificar si tiene subordinados
            String sqlVerificar = "SELECT COUNT(*) as cantidad FROM empleado "
                    + "WHERE id_jefe = ?";
            PreparedStatement pstmtVer = conexion.prepareStatement(sqlVerificar);
            pstmtVer.setInt(1, idEmple);
            ResultSet rs = pstmtVer.executeQuery();

            rs.next();
            int cantidad = rs.getInt("cantidad");

            if (cantidad > 0) {
                System.out.println("⚠ No se puede eliminar: tiene " + cantidad
                        + " subordinados");
                rs.close();
                pstmtVer.close();
                return;
            }

            // SEGUNDO: Obtener datos antes de eliminar (para log)
            String sqlObtener = "SELECT nombre, apellido FROM empleado WHERE id_emple = ?";
            PreparedStatement pstmtObt = conexion.prepareStatement(sqlObtener);
            pstmtObt.setInt(1, idEmple);
            ResultSet rsObt = pstmtObt.executeQuery();

            String nombreEmpleado = "";
            if (rsObt.next()) {
                nombreEmpleado = rsObt.getString("nombre") + " " + rsObt.getString("apellido");
            }

            // TERCERO: Eliminar el empleado
            String sql = "DELETE FROM empleado WHERE id_emple = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idEmple);

            int filasEliminadas = pstmt.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Empleado eliminado: " + nombreEmpleado);
            } else {
                System.out.println("No se encontró empleado con ID: " + idEmple);
            }

            rs.close();
            pstmtVer.close();
            rsObt.close();
            pstmtObt.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public boolean existeEmpleado(int idEmple) {
        try {
            String sql = "SELECT COUNT(*) as cantidad FROM empleado WHERE id_emple = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idEmple);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int cantidad = rs.getInt("cantidad");

            rs.close();
            pstmt.close();

            return cantidad > 0;

        } catch (SQLException e) {
            System.out.println("Error al validar empleado: " + e.getMessage());
            return false;
        }
    }

    public boolean existeDepartamento(int idDepart) {
        try {
            String sql = "SELECT COUNT(*) as cantidad FROM departamento WHERE id_depart = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idDepart);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int cantidad = rs.getInt("cantidad");

            rs.close();
            pstmt.close();

            return cantidad > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al validar departamento: " + e.getMessage());
            return false;
        }
    }

    public String obtenerNombreDepartamento(int idDepart) {
        try {
            String sql = "SELECT nombre_depart FROM departamento WHERE id_depart = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idDepart);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre_depart");
                rs.close();
                pstmt.close();
                return nombre;
            }

            rs.close();
            pstmt.close();
            return null;

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener nombre de departamento: " + e.getMessage());
            return null;
        }
    }

    public String obtenerNombreEmpleado(int idEmple) {
        try {
            String sql = "SELECT nombre, apellido FROM empleado WHERE id_emple = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idEmple);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                rs.close();
                pstmt.close();
                return nombre + " " + apellido;
            }

            rs.close();
            pstmt.close();
            return null;

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener nombre de empleado: " + e.getMessage());
            return null;
        }
    }

    public void cerrar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("\nConexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
