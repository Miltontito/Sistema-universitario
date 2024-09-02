/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Transferible;

/**
 *
 * @author milton
 */
public class TransferibleCursada {
    private TransferibleMateria materia;
    private Boolean cursadaAprobada;
    private Boolean materiaAprobada;
    private Boolean cursando;

    // Getters y setters
    public TransferibleMateria getMateria() {
        return materia;
    }

    public void setMateria(TransferibleMateria materia) {
        this.materia = materia;
    }

    public Boolean getCursadaAprobada() {
        return cursadaAprobada;
    }

    public void setCursadaAprobada(Boolean cursadaAprobada) {
        this.cursadaAprobada = cursadaAprobada;
    }

    public Boolean getMateriaAprobada() {
        return materiaAprobada;
    }

    public void setMateriaAprobada(Boolean materiaAprobada) {
        this.materiaAprobada = materiaAprobada;
    }

    public Boolean getCursando() {
        return cursando;
    }

    public void setCursando(Boolean cursando) {
        this.cursando = cursando;
    }
}
