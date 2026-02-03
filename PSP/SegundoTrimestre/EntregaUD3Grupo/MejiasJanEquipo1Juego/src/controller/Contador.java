package controller;
import model.Tipo;
public class Contador extends Thread {
    private JuegoLetrasController controller;
    private Tipo tipo;
    
    public Contador(JuegoLetrasController controller, Tipo tipo) {
        this.controller = controller;
        this.tipo = tipo;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                String texto = controller.getTexto();
                int conteo = controller.calcular(texto, tipo);
                controller.actualizarVista(conteo, tipo);
                
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.err.println("¡ERROR EN EL HILO!");
                ex.printStackTrace();
            }
        }
    }
}