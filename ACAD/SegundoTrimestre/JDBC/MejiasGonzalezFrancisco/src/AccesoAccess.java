
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * *
 * @author Mejias Gonzalez Francisco
 */
public class AccesoAccess {

    private static GestionPRUEBA gestion;
    private static BufferedReader teclado;

    public static void main(String[] args) {
        // Inicializar
        Properties propiedades = new Properties();
        try {
            propiedades.load(new FileInputStream("src/Access.properties"));
        } catch (IOException e) {
            System.out.println("Error al cargar archivo de propiedades: " + e.getMessage());
            return;
        }
        /*String nombreDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
         * String urlConexion = "jdbc:odbc:PRUEBAACCESS";
         * String usuario = "Admin";
         * String contra = "DAM2";*/
        // Inicializar con valores del archivo properties
        String nombreDriver = propiedades.getProperty("driver");
        String urlConexion = propiedades.getProperty("url");
        String usuario = propiedades.getProperty("usuario");
        String contra = propiedades.getProperty("password");

        gestion = new GestionPRUEBA(nombreDriver, urlConexion, usuario, contra);
        teclado = new BufferedReader(new InputStreamReader(System.in));

        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();

            try {
                byte opcion = Byte.parseByte(obtenerEntrada("Selecciona una opcion: "));

                switch (opcion) {
                    case 1:
                        menuDepartamentos();
                        break;
                    case 2:
                        menuEmpleados();
                        break;
                    case 3:
                        salir = true;
                        System.out.println("\n¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opcion no valida\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero valido\n");
            }
        }

        gestion.cerrar();
        try {
            teclado.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar teclado");
        }
    }

    // ==================== MENUS ====================
    /**
     * Muestra el menu principal
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║           GESTION DE BASE DE DATOS PRUEBA                     ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. Gestionar Departamentos                                   ║");
        System.out.println("║  2. Gestionar Empleados                                       ║");
        System.out.println("║  3. Salir                                                     ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    /**
     * Menu de departamentos
     */
    private static void menuDepartamentos() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
            System.out.println("║                   GESTION DE DEPARTAMENTOS                      ║");
            System.out.println("╠════════════════════════════════════════════════════════════════╣");
            System.out.println("║  1. Insertar Departamento                                       ║");
            System.out.println("║  2. Actualizar Departamento                                     ║");
            System.out.println("║  3. Eliminar Departamento                                       ║");
            System.out.println("║  4. Volver al menu principal                                    ║");
            System.out.println("╚════════════════════════════════════════════════════════════════╝");

            try {
                byte opcion = Byte.parseByte(obtenerEntrada("Selecciona una opcion: "));

                switch (opcion) {
                    case 1:
                        insertarDepartamento();
                        break;
                    case 2:
                        actualizarDepartamento();
                        break;
                    case 3:
                        eliminarDepartamento();
                        break;
                    case 4:
                        volver = true;
                        break;
                    default:
                        System.out.println("Opcion no valida\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero valido\n");
            }
        }
    }

    /**
     * Menu de empleados
     */
    private static void menuEmpleados() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
            System.out.println("║                    GESTION DE EMPLEADOS                        ║");
            System.out.println("╠════════════════════════════════════════════════════════════════╣");
            System.out.println("║  1. Insertar Empleado                                           ║");
            System.out.println("║  2. Actualizar Empleado                                         ║");
            System.out.println("║  3. Eliminar Empleado                                           ║");
            System.out.println("║  4. Volver al menu principal                                    ║");
            System.out.println("╚════════════════════════════════════════════════════════════════╝");

            try {
                byte opcion = Byte.parseByte(obtenerEntrada("Selecciona una opcion: "));

                switch (opcion) {
                    case 1:
                        insertarEmpleado();
                        break;
                    case 2:
                        actualizarEmpleado();
                        break;
                    case 3:
                        eliminarEmpleado();
                        break;
                    case 4:
                        volver = true;
                        break;
                    default:
                        System.out.println("Opcion no valida\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero valido\n");
            }
        }
    }

    // ==================== OPERACIONES DEPARTAMENTO ====================
    /**
     * Insertar departamento
     */
    private static void insertarDepartamento() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║                  INSERTAR DEPARTAMENTO                           ║");
        System.out.println("╚═════════════════════════════════════════╝\n");

        try {
            int idDepart = obtenerNumero("ID del departamento (1-100): ", 1, 100);
            String nombreDepart = obtenerTexto("Nombre del departamento: ");

            gestion.insertarDepartamento(idDepart, nombreDepart);

        } catch (IOException e) {
            System.out.println("Error de entrada");
        }
    }

    /**
     * Actualizar departamento
     */
    private static void actualizarDepartamento() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║                  ACTUALIZAR DEPARTAMENTO                         ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        try {
            int idDepart = obtenerNumero("ID del departamento a actualizar (1-100): ", 1, 100);

            if (gestion.existeDepartamento(idDepart)) {
                String nombreActual = gestion.obtenerNombreDepartamento(idDepart);
                System.out.println("Nombre actual: " + nombreActual);

                String nuevoNombre = obtenerTexto("Nuevo nombre: ");
                gestion.actualizarDepartamento(idDepart, nuevoNombre);
            } else {
                System.out.println("No existe departamento con ID: " + idDepart);
            }

        } catch (IOException e) {
            System.out.println("Error de entrada");
        }
    }

    /**
     * Eliminar departamento
     */
    private static void eliminarDepartamento() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║                  ELIMINAR DEPARTAMENTO                           ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        try {
            int idDepart = obtenerNumero("ID del departamento a eliminar (1-100): ", 1, 100);
            gestion.eliminarDepartamento(idDepart);

        } catch (IOException e) {
            System.out.println("Error de entrada");
        }
    }

    // ==================== OPERACIONES EMPLEADO ====================
    /**
     * Insertar empleado
     */
    private static void insertarEmpleado() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║                    INSERTAR EMPLEADO                            ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        try {
            int idEmple = obtenerNumero("ID del empleado (1-100): ", 1, 100);
            String nombre = obtenerTexto("Nombre: ");
            String apellido = obtenerTexto("Apellido: ");
            int idDepart = obtenerNumero("ID del departamento (1-100): ", 1, 100);

            // Validar departamento
            if (!gestion.existeDepartamento(idDepart)) {
                System.out.println("El departamento no existe");
                return;
            }

            // Preguntar por jefe
            Integer idJefe = null;
            System.out.print("\n¿Tiene jefe? (s/n): ");
            String respuesta = obtenerEntrada("").trim().toLowerCase();

            if (respuesta.equals("s") || respuesta.equals("si")) {
                // Validar que el jefe existe
                boolean jefeValido = false;
                do {
                    idJefe = obtenerNumero("ID del jefe (1-100): ", 1, 100);

                    if (gestion.existeEmpleado(idJefe)) {
                        System.out.println("Jefe: " + gestion.obtenerNombreEmpleado(idJefe));
                        jefeValido = true;
                    } else {
                        System.out.println("El jefe no existe. Intenta de nuevo");
                    }
                } while (!jefeValido);
            }

            String puesto = obtenerTexto("Puesto: ");

            gestion.insertarEmpleado(idEmple, nombre, apellido, idDepart, idJefe, puesto);

        } catch (IOException e) {
            System.out.println("Error de entrada");
        }
    }

    /**
     * Actualizar empleado
     */
    private static void actualizarEmpleado() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║                    ACTUALIZAR EMPLEADO                          ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        try {
            int idEmple = obtenerNumero("ID del empleado (1-100): ", 1, 100);

            if (gestion.existeEmpleado(idEmple)) {
                System.out.println("Empleado encontrado");

                String nombre = obtenerTexto("Nuevo nombre: ");
                String apellido = obtenerTexto("Nuevo apellido: ");
                String puesto = obtenerTexto("Nuevo puesto: ");

                Integer idJefe = null;
                System.out.print("\n¿Cambiar jefe? (s/n): ");
                String respuesta = obtenerEntrada("").trim().toLowerCase();

                if (respuesta.equals("s") || respuesta.equals("si")) {
                    boolean jefeValido = false;
                    do {
                        idJefe = obtenerNumero("ID del nuevo jefe (1-100): ", 1, 100);

                        if (gestion.existeEmpleado(idJefe)) {
                            System.out.println("Jefe: " + gestion.obtenerNombreEmpleado(idJefe));
                            jefeValido = true;
                        } else {
                            System.out.println("El jefe no existe. Intenta de nuevo");
                        }
                    } while (!jefeValido);
                }

                gestion.actualizarEmpleado(idEmple, nombre, apellido, puesto, idJefe);
            } else {
                System.out.println("No existe empleado con ID: " + idEmple);
            }

        } catch (IOException e) {
            System.out.println("Error de entrada");
        }
    }

    /**
     * Eliminar empleado
     */
    private static void eliminarEmpleado() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║                   ELIMINAR EMPLEADO                             ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        try {
            int idEmple = obtenerNumero("ID del empleado a eliminar (1-100): ", 1, 100);
            gestion.eliminarEmpleado(idEmple);

        } catch (IOException e) {
            System.out.println("Error de entrada");
        }
    }

    // ==================== METODOS AUXILIARES ====================
    /**
     * Obtiene entrada del teclado
     */
    private static String obtenerEntrada(String mensaje) {
        try {
            System.out.print(mensaje);
            return teclado.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * Obtiene un numero valido dentro de un rango
     */
    private static int obtenerNumero(String mensaje, int minimo, int maximo)
            throws IOException {
        int numero;
        boolean valido = false;

        do {
            try {
                numero = Integer.parseInt(obtenerEntrada(mensaje).trim());

                if (numero >= minimo && numero <= maximo) {
                    valido = true;
                    return numero;
                } else {
                    System.out.println("Debe estar entre " + minimo + " y " + maximo);
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero valido");
            }
        } while (!valido);

        return -1;
    }

    /**
     * Obtiene un texto valido (no vacío)
     */
    private static String obtenerTexto(String mensaje) throws IOException {
        String texto;

        do {
            texto = obtenerEntrada(mensaje).trim();

            if (texto.isEmpty()) {
                System.out.println("El campo no puede estar vacío");
            } else {
                return texto;
            }
        } while (true);
    }
}
