
import agendaDAO.AgendaDAO;
import agendaDAO.PersonaAgenda;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CrearFicheAgenda {

    public static String pedirNombre() {
        String telefono = "";
        BufferedReader teclado;
        teclado = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Introduce un nombre: ");
            telefono = teclado.readLine();
        } catch (IOException ex) {
            System.out.println("Error de E/S Leyendo telefono de teclado");
        }
        return telefono;
    }

    public static byte pedirEdad() {
        byte edad = 0;
        BufferedReader teclado;
        boolean esValido;

        teclado = new BufferedReader(new InputStreamReader(System.in));
        do {
            esValido = true;
            try {

                System.out.println("Introduce edad: ");
                edad = Byte.parseByte(teclado.readLine());


            } catch (NumberFormatException nfe) {
                System.out.println("dato invalido, teclee otro.");
                esValido = false;
            } catch (IOException ex) {
                Logger.getLogger(CrearFicheAgenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (esValido == false);

        return edad;
    }

    public static String pedirDireccion() {
        String telefono = "";
        BufferedReader teclado;
        teclado = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Introduce una direccion: ");
            telefono = teclado.readLine();
        } catch (IOException ex) {
            System.out.println("Error de E/S Leyendo telefono de teclado");
        }
        return telefono;
    }

    public static String pedirTelefono() {
        String telefono = "";
        BufferedReader teclado;
        teclado = new BufferedReader(new InputStreamReader(System.in));
        //Validar telefono do-while
        try {
            System.out.println("Introduce un telefono: ");
            telefono = teclado.readLine();
        } catch (IOException ex) {
            System.out.println("Error de E/S Leyendo telefono de teclado");
        }
        return telefono;
    }

    public static void main(String[] args) {
        AgendaDAO dao;
        PersonaAgenda persona;
        try {
            dao = new AgendaDAO();
            for (int i = 0; i <= 2; i++) {
                persona = new PersonaAgenda(pedirNombre(),
                        pedirEdad(), pedirDireccion(), pedirTelefono());
                dao.escribirRegistro(persona);
            }

        } catch (IOException ex) {
            System.out.println("Error de E/S en fichero Agenda.dat");
        }
    }
}
