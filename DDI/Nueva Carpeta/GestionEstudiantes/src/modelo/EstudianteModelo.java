/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Francisco Mejias Gonzalez
 */
public class EstudianteModelo {

    private List<Estudiante> estudiantes;
    private List<Observer> observers;  // Para notificar cambios

    // Métodos CRUD:
    public EstudianteModelo() {
        estudiantes = new ArrayList();
    }

    // - agregarEstudiante(Estudiante estudiante)
    public boolean agregarEstudiante(Estudiante estu) {
        boolean aniadido = true;
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getId().equalsIgnoreCase(estu.getId())) {
                aniadido = false;
            }
        }
        estudiantes.add(estu);
        return aniadido;
    }

    // - obtenerEstudiantes()
    public List obtenerEstudiantes() {
        return this.estudiantes;
    }

    // - buscarPorNombre(String nombre)
    public String buscarPorNombre(String nombre) {
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return estudiante.toString();
            }
        }
        return null;
    }

    // - actualizarEstudiante(int id, Estudiante estudiante)
    public boolean actualizarEstudiante(int id, Estudiante estudiante) {
        for (Estudiante estu : this.estudiantes) {
            if (estu.getId().equalsIgnoreCase(estudiante.getId())) {
                estudiante.getNombre();
                estudiante.getApellidos();
                estudiante.getEmail();
                estudiante.getCurso();
            }
        }

    }
    // - eliminarEstudiante(int id)
    // Métodos Observer:
    // - addObserver(Observer observer)
    // - notifyObservers()
}
