package com.milton.gomez.sistema.universitario.Model;

import java.util.ArrayList;
import java.util.List;

public class Cuatrimestre {
    // -----------------------------------------------
    // ---------------|   Atributos   |---------------
    // -----------------------------------------------
    private List<Materia> materiasObligatorias;
    private List<Materia> materiasOptativas;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public Cuatrimestre() {}
    public Cuatrimestre(List<Materia> materiasObligatorias) {
        this.materiasObligatorias = materiasObligatorias;
    }
    public Cuatrimestre(List<Materia> materiasObligatorias, List<Materia> materiasOptativas) {
        this(materiasObligatorias);
        this.materiasOptativas = materiasOptativas;
    }

    // -----------------------------------------------
    // ---------------|    Metodos    |---------------
    // -----------------------------------------------
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
            materiasObligatorias.add(materia);
        }
        return false;
    }
    public Boolean addMateriaOptativa(Materia materia){
        if (materia != null){
            materiasOptativas.add(materia);
        }
        return false;
    }

}
