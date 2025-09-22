/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Francisco Mejias Gonzalez
 */
public class EstudianteControlador {

    private EstudianteModelo modelo;
    private EstudianteVista vista;
//TODO: Implementar el controlador que coordina Modelo y Vista

    public EstudianteControlador(EstudianteModelo modelo, EstudianteVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    //Registrar la vista como observer del modelo
    modelo.addObserver (vista);

    // Configurar listeners de la vista
    configurarListeners();

    private void configurarListeners() {
        // TODO: Implementar listeners para cada acción

        vista.setAgregarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEstudiante();
            }
        });

        vista.setBuscarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEstudiante();
            }
        });

        // TODO: Implementar más listeners
    }

    private void agregarEstudiante() {
        try {
            // 1. Obtener datos de la vista
            Estudiante estudiante = vista.obtenerDatosFormulario();

            // 2. Validar datos (no vacíos, email válido, etc.)
            if (validarEstudiante(estudiante)) {
                // 3. Agregar al modelo
                modelo.agregarEstudiante(estudiante);

                // 4. Limpiar formulario
                vista.limpiarFormulario();

                // 5. Mostrar mensaje de éxito
                vista.mostrarMensaje("Estudiante agregado correctamente");
            }
        } catch (Exception ex) {
            vista.mostrarMensaje("Error: " + ex.getMessage());
        }
    }

    private void buscarEstudiante() {
        // TODO: Implementar búsqueda
        String termino = vista.obtenerTerminoBusqueda();
        List<Estudiante> resultados = modelo.buscarPorNombre(termino);
        vista.actualizarListaEstudiantes(resultados);
    }

    private boolean validarEstudiante(Estudiante estudiante) {
        // TODO: Implementar validaciones
        // - Campos no vacíos
        // - Email con formato correcto
        // - Curso válido
        
        return true; // Temporal
    }

    // TODO: Implementar métodos para actualizar y eliminar
}
