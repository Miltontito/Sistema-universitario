package com.milton.gomez.sistema.universitario.Model;

import java.util.ArrayList;
import java.util.List;

public class Cuatrimestre {
    // -----------------------------------------------
    // ---------------|   Atributos   |---------------
    // -----------------------------------------------
    private static Integer identificador_cuatrimestre = 0;
    private final Integer cuatrimestreID;
    private List<Materia> materiasObligatorias;
    private List<Materia> materiasOptativas;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public Cuatrimestre() {
        this.cuatrimestreID = asignarID();
        this.materiasObligatorias = new ArrayList<>();
        this.materiasOptativas = new ArrayList<>();
    }
    public Cuatrimestre(List<Materia> materiasObligatorias) {
        this();
        this.materiasObligatorias = materiasObligatorias;
    }
    public Cuatrimestre(List<Materia> materiasObligatorias, List<Materia> materiasOptativas) {
        this(materiasObligatorias);
        this.materiasOptativas = materiasOptativas;
    }

    // -----------------------------------------------
    // ---------------|    Metodos    |---------------
    // -----------------------------------------------
    private Integer asignarID(){
        return identificador_cuatrimestre++;
    }
    public List<Materia> listarMateriasObligatorias(){
        return materiasObligatorias;
    }
    public List<Materia> litarMateriasOptativas(){
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
    
    public Integer getCuatrimestreID(){
        return this.cuatrimestreID;
    }
    
    @Override
    public String toString(){
        return getCuatrimestreID().toString();
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

    
    
}
