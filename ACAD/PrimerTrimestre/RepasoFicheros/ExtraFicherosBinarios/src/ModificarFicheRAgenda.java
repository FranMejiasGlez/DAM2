
import agendaDAO.PersonaAgenda;
import agendaDAO.RAgendaDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class ModificarFicheRAgenda {

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
        try {
            RAgendaDAO rADao;
            PersonaAgenda persona;
            rADao = new RAgendaDAO("Ficheros/RAgenda.dat", "rw");
            System.out.println("Leyendo contactos: ");
            System.out.println("");
            String nombre, direccion, telefono;
            byte edad;
            int registroAModificar = -1;

            while (!rADao.isFf()) {
                persona = rADao.leer();
                if (persona != null) {
                     registroAModificar = (int) rADao.registroActual() - 1;
                    System.out.println("Contacto " + rADao.registroActual());
                    System.out.println(persona.toString());
                    System.out.println("");
                }
            }
            if (registroAModificar >= 0) {
                System.out.println("");
                System.out.println("Modificar contacto " + registroAModificar);
                nombre = pedirNombre();
                edad = pedirEdad();
                direccion = pedirDireccion();
                telefono = pedirTelefono();
                persona = new PersonaAgenda(nombre, edad, direccion, telefono);

                rADao.reescribir(persona);
            } else {
                System.out.println("No hay contactos para modificar");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            Logger.getLogger(ModificarFicheRAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
