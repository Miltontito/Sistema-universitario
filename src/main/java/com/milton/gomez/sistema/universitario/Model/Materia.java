package com.milton.gomez.sistema.universitario.Model;


import java.util.List;

public class Materia {
    // -------------------------------------------
    // ---------------| Atributos |---------------
    // -------------------------------------------

    private static Integer identificador_materia = 0;
    private final Integer materiaID;
    private String codigoDeMateria;
    private String nombre;
    private Boolean promocionable;
    private Boolean cursadaAprobada;
    private Boolean materiaAprobada;
    private List<Materia> correlativas;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public Materia() {
        this.materiaID = asignarID();
    }
    public Materia(String codigoDeMateria) {
        this();
        this.codigoDeMateria = codigoDeMateria;
    }
    public Materia(String codigoDeMateria, String nombre) {
        this(codigoDeMateria);
        this.nombre = nombre;
    }
    public Materia(String codigoDeMateria, String nombre, Boolean promocionable) {
        this(codigoDeMateria, nombre);
        this.promocionable = promocionable;
    }
    public Materia(String codigoDeMateria, String nombre, Boolean promocionable, List<Materia> correlativas) {
        this(codigoDeMateria, nombre, promocionable);
        this.correlativas = correlativas;
    }

    // -------------------------------------------
    // ----------------| Metodos |----------------
    // -------------------------------------------

    private Integer asignarID(){
        return identificador_materia++;
    }
    public void esPromocionable(Boolean promocionable){
        this.promocionable = promocionable;
    }
    public Boolean aprobarCursadaAlumno(Alumno alumno){
        if(this.promocionable){
            alumno.setMateriaAprobada(this);
            this.cursadaAprobada = true;
            /* El alumno fue aprobado con éxito */
            return true;
        }
        /*  la materia no es promocionable por lo que falta el final */
        this.cursadaAprobada = true;
        return false;

    }
    
    @Override
    public String toString(){
        return getCodigoDeMateria()+ ". " + getNombre();
    }

    // -------------------------------------------
    // ----------------| Getters |----------------
    // -------------------------------------------

    public Integer getMateriaID() {
        return materiaID;
    }
    public String getCodigoDeMateria() {
        return codigoDeMateria;
    }
    public String getNombre() {
        return nombre;
    }
    public Boolean isCursadaAprobada() {
        return cursadaAprobada;
    }
    public Boolean isMateriaAprobada() {
        return materiaAprobada;
    }
    public List<Materia> getCorrelativas() {
        if(correlativas.isEmpty() || correlativas == null){
            return null;
        }
        return correlativas;
    }

    // -------------------------------------------
    // ----------------| Setters |----------------
    // -------------------------------------------

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }
    public void setMateriaAprobada(Boolean materiaAprobada) {
        this.materiaAprobada = materiaAprobada;
    }
    public void setCursadaAprobada(Boolean cursadaAprobada) {
        this.cursadaAprobada = cursadaAprobada;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCodigoDeMateria(String codigoDeMateria) {
        this.codigoDeMateria = codigoDeMateria;
    }

}
