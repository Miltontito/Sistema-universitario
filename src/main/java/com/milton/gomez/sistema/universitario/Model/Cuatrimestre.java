package com.milton.gomez.sistema.universitario.Model;

import java.util.ArrayList;
import java.util.List;

public class Cuatrimestre {
    // -----------------------------------------------
    // ---------------|   Atributos   |---------------
    // -----------------------------------------------
    private List<Materia> materiasObligatorias;
    private List<Materia> materiasOptativas;
    private Integer numeroCuatrimestre;
    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    
    public Cuatrimestre(){
        this.materiasObligatorias = new ArrayList<>();
        this.materiasOptativas = new ArrayList<>();
        this.numeroCuatrimestre = -1;
    }
    
    public Cuatrimestre(Integer numeroCuatrimestre) {
        this();
        this.numeroCuatrimestre = numeroCuatrimestre;
    }
    public Cuatrimestre(List<Materia> materiasObligatorias, Integer numeroCuatrimestre) {
        this();
        this.materiasObligatorias = materiasObligatorias;
        this.numeroCuatrimestre = numeroCuatrimestre;
    }
    
    public Cuatrimestre(List<Materia> materiasObligatorias, List<Materia> materiasOptativas, Integer numeroCuatrimestre) {
        this();
        this.materiasObligatorias = materiasObligatorias;
        this.materiasOptativas = materiasOptativas;
        this.numeroCuatrimestre = numeroCuatrimestre;
    }

    // -----------------------------------------------
    // ---------------|    Metodos    |---------------
    // -----------------------------------------------
    public List<Materia> listarMateriasObligatorias(){
        return materiasObligatorias;
    }
    public List<Materia> listarMateriasOptativas(){
        return materiasOptativas;
    }
    public List<Materia> listarTodasLasMaterias(){
        List<Materia> materias = new ArrayList<>();
        materias.addAll(materiasObligatorias);
        materias.addAll(materiasOptativas);
        return materias;
    }
    public Boolean addMateriaObligatoria(Materia materia){
        if (materia != null){
            this.materiasObligatorias.add(materia);
        }
        return false;
    }
    public Boolean addMateriaOptativa(Materia materia){
        if (materia != null){
            this.materiasOptativas.add(materia);
        }
        return false;
    }
    
    @Override
    public String toString(){
        Integer numero = numeroCuatrimestre;
        numero++;
        return numero.toString();
    }

    public List<Materia> getMateriasObligatorias() {
        return materiasObligatorias;
    }

    public void setMateriasObligatorias(List<Materia> materiasObligatorias) {
        this.materiasObligatorias = materiasObligatorias;
    }

    public List<Materia> getMateriasOptativas() {
        return materiasOptativas;
    }

    public void setMateriasOptativas(List<Materia> materiasOptativas) {
        this.materiasOptativas = materiasOptativas;
    }

    public Integer getNumeroCuatrimestre() {
        return numeroCuatrimestre;
    }

    public void setNumeroCuatrimestre(Integer numeroCuatrimestre) {
        this.numeroCuatrimestre = numeroCuatrimestre;
    }

    
    
}
