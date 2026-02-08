
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread {

    private Socket cliente = null;
    private InetAddress ipLocal = null;
    private DataInputStream entrada;
    private DataOutputStream salida;

    @Override
    public void run() {
        try {
            try {
                ipLocal = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                System.out.println("Host desconocido");
                return;
            }
            try {
                cliente = new Socket(ipLocal, 5000);
                System.out.println("Cliente " + Thread.currentThread().getName() + ": Conectado");
            } catch (IOException ex) {
                System.out.println("Cliente " + Thread.currentThread().getName() + ": Conexion rechazada");
                return;
            }
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            // Envia 3 mensajes
            String[] mensajes = {
                "mensaje uno",
                "mensaje dos",
                "*"
            };
            for (String mensaje : mensajes) {
                salida.writeUTF(mensaje);

                if (!mensaje.equals("*")) {
                    String respuesta = entrada.readUTF();
                    System.out.println("Cliente " + Thread.currentThread().getName() + ": " + respuesta);
                } else {
                    String respuesta = entrada.readUTF();
                    System.out.println("Cliente " + Thread.currentThread().getName() + ": " + respuesta);
                    break;
                }
            }
            entrada.close();
            salida.close();
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
