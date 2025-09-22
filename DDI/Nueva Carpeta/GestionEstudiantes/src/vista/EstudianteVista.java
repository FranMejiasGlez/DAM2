/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author DAM2
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// TODO: Implementar la vista principal
public class EstudianteVista extends JFrame implements Observer {

    // Componentes de la interfaz
    private JTextField txtNombre, txtApellidos, txtEmail, txtCurso;
    private JButton btnAgregar, btnBuscar, btnActualizar, btnEliminar;
    private JList<Estudiante> listaEstudiantes;
    private DefaultListModel<Estudiante> modeloLista;
    private JTextField txtBuscar;

    // Constructor que inicializa la interfaz
    public EstudianteVista() {
        inicializarComponentes();
        configurarLayout();
        configurarVentana();
    }

    // TODO: Implementar estos métodos
    private void inicializarComponentes() {
        // Crear todos los componentes Swing
    }

    private void configurarLayout() {
        // Organizar componentes usando Layout Managers
        // Sugerencia: usar BorderLayout principal con paneles internos
    }

    private void configurarVentana() {
        // Configurar propiedades de la ventana
    }

    // Métodos para conectar con el controlador
    public void setAgregarListener(ActionListener listener) {
        btnAgregar.addActionListener(listener);
    }

    public void setBuscarListener(ActionListener listener) {
        btnBuscar.addActionListener(listener);
    }

    // TODO: Implementar más setters para otros listeners
    // Métodos para obtener datos del formulario
    public Estudiante obtenerDatosFormulario() {
        // Crear objeto Estudiante con datos del formulario
        return null; // TODO: implementar
    }

    public String obtenerTerminoBusqueda() {
        return txtBuscar.getText();
    }

    // Métodos para actualizar la vista
    public void actualizarListaEstudiantes(List<Estudiante> estudiantes) {
        modeloLista.clear();
        for (Estudiante e : estudiantes) {
            modeloLista.addElement(e);
        }
    }

    public void limpiarFormulario() {
        // Limpiar todos los campos del formulario
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @Override
    public void update() {
        // Este método se llama cuando el modelo cambia
        // TODO: implementar actualización automática de la vista
    }
}
