
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AtendedorCliente extends Thread {

    private Socket socketCliente;

    public AtendedorCliente(Socket socket) {
        this.socketCliente = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

            System.out.println("SERVIDOR: Cliente " + Thread.currentThread().getName() + " conectado");

            while (true) {
                String texto = entrada.readUTF();

                if (texto.equals("*")) {
                    salida.writeUTF("Conexion cerrada por servidor");
                    System.out.println("SERVIDOR: Cliente " + Thread.currentThread().getName() + " desconectado");
                    break;
                }

                String enMayusculas = texto.toUpperCase();
                salida.writeUTF(enMayusculas);
            }

            entrada.close();
            salida.close();
            socketCliente.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
