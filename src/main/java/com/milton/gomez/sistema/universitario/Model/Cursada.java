package com.milton.gomez.sistema.universitario.Model;

/**
 *
 * @author milton
 */
public class Cursada {
    private Materia materia;
    private Boolean cursadaAprobada;
    private Boolean materiaAprobada;
    private Boolean cursando;
    
    public Cursada() {
    }
    
    public Cursada(Materia materia) {
        this.materia = materia;
        this.cursadaAprobada = Boolean.FALSE;
        this.materiaAprobada = Boolean.FALSE;
        this.cursando = Boolean.TRUE;
    }

    
    
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
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
        if (materiaAprobada){
            this.materiaAprobada = materiaAprobada;
            this.cursando = Boolean.FALSE;
            this.cursadaAprobada = Boolean.TRUE;
        }
    }

    public Boolean getCursando() {
        return cursando;
    }

    public void setCursando(Boolean cursando) {
        this.cursando = cursando;
    }
    
    
}
