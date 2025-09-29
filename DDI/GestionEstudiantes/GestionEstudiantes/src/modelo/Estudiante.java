/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;
import vista.EstudianteVista;

/**
 *
 * @author Francisco Mejias Gonzalez
 */
// TODO: Implementar la clase Estudiante
public class Estudiante {

    // Atributos necesarios: id, nombre, apellidos, email, curso
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private byte curso;
    private static int contadorId = 0;

    // Constructor completo
    public Estudiante(int id, String nombre, String apellidos, String email,
             byte curso) {

        contadorId++;

        this.id = contadorId;

        this.nombre = nombre;

        this.apellidos = apellidos;

        this.email = email;

        this.curso = curso;

    }
    // Getters y setters

    /**
     * @return the id
     */
    public int getId() {
        return id;
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
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the curso
     */
    public byte getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(byte curso) {
        this.curso = curso;
    }

    // toString() para mostrar información
    @Override
    public String toString() {
        String salida;
        salida = this.getId() + "| "
                + this.getNombre() + "| " + this.getApellidos()
                + "| " + this.getEmail() + "| " + this.getCurso();

        return salida;
    }

    // equals() y hashCode() para comparaciones
    public boolean equals(Estudiante estu) {
        boolean esIgual;
        esIgual = this.id == estu.getId();
        return esIgual;
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}
