import java.io.IOException;
import java.io.RandomAccessFile;

public class Remple {

    public static void main(String[] args) {
        // Tamaño fijo de cada registro en bytes
        // int id: 4 bytes + apellidos: 30 bytes (15 chars * 2) + 
        // departamento: 20 bytes (10 chars * 2) + salario: 4 bytes = 58 bytes
        final int LONG_REGISTRO = 58;
        
        // Tamaño fijo en caracteres de cada campo
        final int TAM_APELLIDOS = 15;
        final int TAM_DEPARTAMENTO = 20;
        
        // Arrays con datos de ejemplo para 10 empleados
        String[] apellidos = {"Garcia", "Rodriguez", "Lopez", "Martinez",
            "Sanchez", "Perez", "Gonzalez", "Fernandez",
            "Diaz", "Ruiz"};
            
        String[] departamentos = {"I+D", "Desarrollo", "Marketing", "RRHH", "Integracion",
            "Electricidad", "Mantenimiento", "DataScientist", "Seguridad", "Cocinero"};

        float[] salarios = {1500.50f, 1800.75f, 2100.00f, 1650.25f, 1900.50f,
            1750.00f, 2200.75f, 1950.25f, 2300.00f, 1600.50f};

        try (RandomAccessFile rFichero = new RandomAccessFile("REmple.dat", "rw")) {

            System.out.println("Creando fichero REmple.dat con 10 empleados...");

            // Crear 10 empleados consecutivos
            for (int i = 0; i < 10; i++) {
                // Preparar los datos para el empleado i
                int id = i + 1; // Los IDs empiezan en 1
                String apellido = formatearCampo(apellidos[i], TAM_APELLIDOS);
                String departamento = formatearCampo(departamentos[i], TAM_DEPARTAMENTO);
                float salario = salarios[i];

                // Escribir registro en el fichero
                // No necesitamos seek porque se escribe secuencialmente
                rFichero.writeInt(id);                    // 4 bytes
                rFichero.writeChars(apellido);            // 30 bytes
                rFichero.writeChars(departamento);        // 40 bytes
                rFichero.writeFloat(salario);             // 4 bytes

                System.out.println("Empleado " + id + " creado.");
            }

            System.out.println("\nFichero creado exitosamente.");
            System.out.println("Total registros: 10");
            System.out.println("Tamaño total: " + rFichero.length() + " bytes");
            System.out.println("Tamaño por registro: " + LONG_REGISTRO + " bytes");

            // Mostrar contenido del fichero para verificación
            mostrarContenidoFichero(rFichero, LONG_REGISTRO, TAM_APELLIDOS, TAM_DEPARTAMENTO);

        } catch (IOException ex) {
            System.err.println("Error al crear el fichero: " + ex.getMessage());
        }
    }

    // Método para formatear un campo de texto con longitud fija
    private static String formatearCampo(String texto, int longitud) {
        StringBuilder sb = new StringBuilder(texto);
        // Asegurar que el texto tenga la longitud exacta
        if (sb.length() > longitud) {
            sb.setLength(longitud); // Cortar si es más largo
        } else {
            // Rellenar con espacios si es más corto
            while (sb.length() < longitud) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // Método para mostrar el contenido del fichero
    private static void mostrarContenidoFichero(RandomAccessFile raf, 
                                                int longRegistro,
                                                int tamApellidos, 
                                                int tamDepartamento) throws IOException {
        System.out.println("\n=== CONTENIDO DEL FICHERO ===");

        // Ir al inicio del fichero
        raf.seek(0);

        int registroActual = 1;

        try {
            while (true) {
                System.out.println("\n--- Empleado " + registroActual + " ---");

                // Leer ID
                int id = raf.readInt();

                // Leer apellidos
                StringBuilder apellidosBuilder = new StringBuilder();
                for (int i = 0; i < tamApellidos; i++) {
                    apellidosBuilder.append(raf.readChar());
                }
                String apellidos = apellidosBuilder.toString().trim();

                // Leer departamento
                StringBuilder deptoBuilder = new StringBuilder();
                for (int i = 0; i < tamDepartamento; i++) {
                    deptoBuilder.append(raf.readChar());
                }
                String departamento = deptoBuilder.toString().trim();

                // Leer salario
                float salario = raf.readFloat();

                // Mostrar datos
                System.out.println("ID: " + id);
                System.out.println("Apellidos: " + apellidos);
                System.out.println("Departamento: " + departamento);
                System.out.println("Salario: " + String.format("%.2f", salario) + " €");
                System.out.println("Posición en fichero: " + ((registroActual - 1) * longRegistro));

                registroActual++;
            }
        } catch (IOException e) {
            // Fin del fichero alcanzado
            System.out.println("\n=== FIN DEL FICHERO ===");
        }
    }
}