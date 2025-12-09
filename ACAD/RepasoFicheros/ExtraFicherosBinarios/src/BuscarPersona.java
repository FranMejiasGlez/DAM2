
import agendaDAO.AgendaDAO;
import agendaDAO.PersonaAgenda;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class BuscarPersona {

    public static void main(String[] args) {
        BufferedReader teclado;
        String nombre, salir;
        AgendaDAO dao;
        PersonaAgenda persona;
        Boolean encontrado = false;

        teclado = new BufferedReader(new InputStreamReader(System.in));

        try {
            do {
                dao = new AgendaDAO();
                System.out.println("Buscar por nombre de contacto: ");
                do {

                    System.out.println("Introduzca un nombre: ");
                    nombre = teclado.readLine();
                } while (nombre.isEmpty());

                persona = dao.leerRegistro();
                while (!dao.isFf()) {
                    if (persona != null && persona.getNombre().equalsIgnoreCase(nombre)) {
                        System.out.println("");
                        System.out.println("Contacto: ");
                        System.out.println(persona.getNombre()
                                + "\n" + persona.getEdad()
                                + "\n" + persona.getTelefono());
                        System.out.println("Fin Contacto.");
                        System.out.println("");
                        encontrado = true;

                    }
                    persona = dao.leerRegistro();
                }
                if (!encontrado) {
                    System.out.println("Contacto no encontrado");
                }
                do {
                    System.out.println("¿Buscar otro? (s/n): ");
                    salir = teclado.readLine();
                } while (!salir.matches("s|S|n|N"));
            } while (salir.equalsIgnoreCase("s"));
        } catch (IOException ex) {
            System.out.println("Error de E/S en fichero");
        }

    }
}
