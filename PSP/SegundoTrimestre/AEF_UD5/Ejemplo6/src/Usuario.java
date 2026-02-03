
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Random;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Usuario implements Serializable{

    private String password, nombre, ip;

    public Usuario() {
        this.nombre = "";
        this.password = generarPassword();
        this.ip = "";
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip.getHostAddress();
    }

    private String generarPassword() {
        String caracteresValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 10; i++) {

            int indiceAleatorio = random.nextInt(caracteresValidos.length());

            char caracterAleatorio = caracteresValidos.charAt(indiceAleatorio);

            password.append(caracterAleatorio);
        }

        String passwordFinal = password.toString();
        return passwordFinal;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
