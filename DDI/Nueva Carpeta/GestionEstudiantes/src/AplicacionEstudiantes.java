/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DAM2
 */
import javax.swing.SwingUtilities;

public class AplicacionEstudiantes {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // TODO: Crear instancias de Modelo, Vista y Controlador
                <         // TODO: Conectar los componentes
                // TODO: Mostrar la interfaz

                try {
                    // Aplicar Look and Feel del sistema
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
                } catch (Exception e) {
                    // Usar Look and Feel por defecto
                }

                // Crear componentes MVC
                EstudianteModelo modelo = new EstudianteModelo();
                EstudianteVista vista = new EstudianteVista();
                EstudianteControlador controlador = new EstudianteControlador(modelo, vista);

                // Mostrar ventana
                vista.setVisible(true);
            }
        });
    }
}
