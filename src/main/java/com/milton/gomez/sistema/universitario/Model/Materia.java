package com.milton.gomez.sistema.universitario.Model;


import java.util.ArrayList;
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
    private List<Materia> correlativas;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public Materia() {
        this.materiaID = asignarID();
        this.correlativas = new ArrayList<>();
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
    public List<Materia> getCorrelativas() {
        return correlativas;
    }
    public Boolean isPromocionable(){
        return this.promocionable;
    }

    // -------------------------------------------
    // ----------------| Setters |----------------
    // -------------------------------------------

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCodigoDeMateria(String codigoDeMateria) {
        this.codigoDeMateria = codigoDeMateria;
    }

}
