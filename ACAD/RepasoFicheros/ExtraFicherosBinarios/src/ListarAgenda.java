
import agendaDAO.AgendaDAO;
import agendaDAO.PersonaAgenda;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class ListarAgenda {

    public static void main(String[] args) {
        try {
            AgendaDAO dao;
            PersonaAgenda persona;
            dao = new AgendaDAO();
            persona = dao.leerRegistro();
            while (!dao.isFf()) {
                System.out.println("Contacto: ");
                System.out.println(persona.getNombre()
                        + "\n" + persona.getEdad()
                        + "\n" + persona.getDireccion()
                        + "\n" + persona.getTelefono());
                System.out.println("Fin Contacto.");
                System.out.println("");
                persona = dao.leerRegistro();
            }
        } catch (IOException ex) {
            System.out.println("Error de E/S leyendo fichero");
        }








    }
}
