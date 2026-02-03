package controller;
import model.TextoModel;
import model.Tipo;
import view.JuegoLetrasView;
public class JuegoLetrasController {
    private JuegoLetrasView view;
    private TextoModel model;
    
    public JuegoLetrasController() {
        this.view = new JuegoLetrasView();
        this.model = new TextoModel();
    }
    
    public void iniciar() {
        // Crear y arrancar 4 hilos Contador
        new Contador(this, Tipo.VOCALES).start();
        new Contador(this, Tipo.LETRAS).start();
        new Contador(this, Tipo.MAYUSCULAS).start();
        new Contador(this, Tipo.PALABRAS).start();
        
        view.setVisible(true);
    }
    
     
    public synchronized String getTexto() {
        return view.getTexto();
    }
    
    
    public int calcular(String texto, Tipo tipo) {
        return model.contar(texto, tipo);
    }
    
    
    public synchronized void  actualizarVista(int conteo, Tipo tipo) {
        switch (tipo) {
            case VOCALES: view.setVocales(String.valueOf(conteo)); break;
            case LETRAS: view.setLetras(String.valueOf(conteo)); break;
            case MAYUSCULAS: view.setMayusculas(String.valueOf(conteo)); break;
            case PALABRAS: view.setPalabras(String.valueOf(conteo)); break;
        }
    }
}