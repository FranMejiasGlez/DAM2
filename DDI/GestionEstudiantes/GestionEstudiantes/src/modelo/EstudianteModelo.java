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

    private List<Estudiante> estudiantes, nuevaLista;
    private List<Observer> observers;  // Para notificar cambios

    // Métodos CRUD:
    public EstudianteModelo() {
        estudiantes = new ArrayList();
    }

    // - agregarEstudiante(Estudiante estudiante)
    public boolean agregarEstudiante(Estudiante estu) {
        boolean aniadido = true;
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getId() == estu.getId()) {
                aniadido = false;
            }
        }
        if (aniadido == true) {
            estudiantes.add(estu);
        }
        return aniadido;
    }

    // - obtenerEstudiantes()
    public List obtenerEstudiantes() {
        return this.estudiantes;
    }

    // - buscarPorNombre(String nombre)
    public List buscarPorNombre(String nombre) {
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                nuevaLista = new ArrayList();
                nuevaLista.add(estudiante);
            }
        }
        return nuevaLista;
    }

    // - actualizarEstudiante(int id, Estudiante estudiante)
    public boolean actualizarEstudiante(int id, Estudiante estudiante) {
        boolean actualizado = false;
        for (Estudiante estu : this.estudiantes) {
            if (estu.getId() == estudiante.getId()) {
                estu.setNombre(estudiante.getNombre());
                estu.setApellidos(estudiante.getApellidos());
                estu.setEmail(estudiante.getApellidos());
                estu.setCurso(estudiante.getCurso());
                actualizado = true;
            }
        }
        return actualizado;
    }

    // - eliminarEstudiante(int id)
    public boolean eliminarEstudiante(int id) {
        boolean eliminado = false;
        for (Estudiante estu : this.estudiantes) {
            if (estu.getId() == id) {
                this.estudiantes.remove(estu);
                eliminado = true;
            }
        }
        return eliminado;
    }
    // Métodos Observer:
    // - addObserver(Observer observer)
    // - notifyObservers()
}
