package com.milton.gomez.sistema.universitario.Model;

/**
 *
 * @author milton
 */
public class Cursada {
    private Materia materia;
    private Boolean vaAFinal;
    private Boolean materiaAprobada;
    private Boolean cursando;
    
    public Cursada() {
        this.materia = null;
        this.vaAFinal = Boolean.FALSE;
        this.materiaAprobada = Boolean.FALSE;
        this.cursando = Boolean.FALSE;
    }
    
    public Cursada(Materia materia) {
        this();
        this.materia = materia;
        this.vaAFinal = Boolean.FALSE;
        this.materiaAprobada = Boolean.FALSE;
        this.cursando = Boolean.TRUE;
    }
    
    public Cursada(Materia materia, Boolean aprobada){
        this(materia);
        this.aprobarMateria(aprobada);
    }

    
    
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Boolean getVaAFinal() {
        return vaAFinal;
    }

    public void setCursadaAprobada(Boolean cursadaAprobada) {
        this.vaAFinal = cursadaAprobada;
    }

    public Boolean getMateriaAprobada() {
        return materiaAprobada;
    }

    public void aprobarMateria(Boolean materiaAprobada) {
        
        if(this.materia.isPromocionable()){
            if (materiaAprobada){
                this.materiaAprobada = materiaAprobada;
                this.cursando = Boolean.FALSE;
                this.vaAFinal = Boolean.FALSE;
            }
            else{
                this.materiaAprobada = materiaAprobada;
            }
        }
        else{
            if (materiaAprobada && this.cursando){
                this.cursando = Boolean.FALSE;
                this.vaAFinal = Boolean.TRUE;
            }
            else if(materiaAprobada && this.vaAFinal){
                this.vaAFinal = Boolean.FALSE;
                this.materiaAprobada = Boolean.TRUE;
            }
            else{
                this.materiaAprobada = materiaAprobada;
            }
        }
    }

    public Boolean getCursando() {
        return cursando;
    }

    public void setCursando(Boolean cursando) {
        this.cursando = cursando;
    }
    
    
}
