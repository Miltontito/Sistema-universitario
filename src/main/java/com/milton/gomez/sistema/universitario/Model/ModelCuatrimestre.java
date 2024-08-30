package com.milton.gomez.sistema.universitario.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelCuatrimestre {
    // -----------------------------------------------
    // ---------------|   Atributos   |---------------
    // -----------------------------------------------
    private static Integer identificador_cuatrimestre = 0;
    private final Integer cuatrimestreID;
    private List<ModelMateria> materiasObligatorias;
    private List<ModelMateria> materiasOptativas;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public ModelCuatrimestre() {
        this.cuatrimestreID = asignarID();
        this.materiasObligatorias = new ArrayList<>();
        this.materiasOptativas = new ArrayList<>();
    }
    public ModelCuatrimestre(List<ModelMateria> materiasObligatorias) {
        this();
        this.materiasObligatorias = materiasObligatorias;
    }
    public ModelCuatrimestre(List<ModelMateria> materiasObligatorias, List<ModelMateria> materiasOptativas) {
        this(materiasObligatorias);
        this.materiasOptativas = materiasOptativas;
    }

    // -----------------------------------------------
    // ---------------|    Metodos    |---------------
    // -----------------------------------------------
    private Integer asignarID(){
        return identificador_cuatrimestre++;
    }
    public List<ModelMateria> listarMateriasObligatorias(){
        return materiasObligatorias;
    }
    public List<ModelMateria> litarMateriasOptativas(){
        return materiasOptativas;
    }
    public List<ModelMateria> listarTodasLasMaterias(){
        List<ModelMateria> materias = new ArrayList<>();
        materias.addAll(materiasObligatorias);
        materias.addAll(materiasOptativas);
        return materias;
    }
    public Boolean addMateriaObligatoria(ModelMateria materia){
        if (materia != null){
            this.materiasObligatorias.add(materia);
        }
        return false;
    }
    public Boolean addMateriaOptativa(ModelMateria materia){
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

}
