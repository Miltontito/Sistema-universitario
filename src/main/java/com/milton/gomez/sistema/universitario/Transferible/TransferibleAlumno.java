package com.milton.gomez.sistema.universitario.Transferible;

import java.util.List;

/**
 *
 * @author milton
 */
public class TransferibleAlumno {
    private Integer id;
    private Long legajo;
    private Long dni;
    private String nombre;
    private String apellido;
    private TransferibleCarrera carrera;
    private List<TransferibleCursada> cursadas;

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getLegajo() {
        return legajo;
    }

    public void setLegajo(Long legajo) {
        this.legajo = legajo;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TransferibleCarrera getCarrera() {
        return carrera;
    }

    public void setCarrera(TransferibleCarrera carrera) {
        this.carrera = carrera;
    }

    public List<TransferibleCursada> getCursadas() {
        return cursadas;
    }

    public void setCursadas(List<TransferibleCursada> cursadas) {
        this.cursadas = cursadas;
    }
}