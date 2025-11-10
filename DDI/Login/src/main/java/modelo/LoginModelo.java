package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author MEjias Gonzalez Francisco
 */
public class LoginModelo {

    File ficheroUsers;
    FileOutputStream fos;

    public LoginModelo() throws FileNotFoundException {
        ficheroUsers = new File("users.txt");
        // Crear el archivo si no existe
        if (!ficheroUsers.exists()) {
            try {
                ficheroUsers.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear archivo users.txt");
            }
        }
    }

    public static boolean esValido(User usuario) throws FileNotFoundException, IOException {
        FileReader fr = null;
        BufferedReader lector = null;

        try {
            fr = new FileReader("users.txt");
            lector = new BufferedReader(fr);
            String linea = lector.readLine();

            while (linea != null) {
                String[] partes = linea.split(",");
                // Verificar si es el usuario correcto Y la contraseña coincide
                if (partes.length == 2
                        && partes[0].equals(usuario.getNombre())
                        && partes[1].equals(usuario.getContrasenia())) {
                    System.out.println(partes[0] + " " + partes[1]);
                    return true; // Usuario y contraseña correctos
                }
                linea = lector.readLine();
            }

        } finally {
            if (lector != null) {
                lector.close();
            }
            if (fr != null) {
                fr.close();
            }
        }

        return false; // No se encontró la combinación usuario-contraseña
    }

    public void registrarUser(User nuevoUser) throws IOException {
        FileWriter fr = null;
        PrintWriter pw = null;

        try {
            fr = new FileWriter("users.txt", true);
            pw = new PrintWriter(fr);
            pw.println(nuevoUser.getNombre() + "," + nuevoUser.getContrasenia());
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }

    public User buscarUser(User us) throws FileNotFoundException, IOException {
        BufferedReader br = null;
        User user = null;

        try {
            br = new BufferedReader(new FileReader("users.txt"));
            String linea = br.readLine();

            while (linea != null) {
                String[] partes = linea.split(",");

                if (partes.length == 2 && partes[0].equals(us.getNombre())) {

                    user = new User(partes[0], partes[1]);
                    break; // Usuario encontrado, salir del bucle
                }

                linea = br.readLine();
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }

        return user; // Retorna null si no se encuentra
    }
}
