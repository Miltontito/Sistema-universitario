package Model;

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
    public Cuatrimestre(){}
    public Cuatrimestre(List<Materia> materiasObligatorias){
        this.materiasObligatorias = materiasObligatorias;
    }
    public Cuatrimestre(List<Materia> materiasObligatorias, List<Materia> materiasOptativas){
        this(materiasObligatorias);
        this.materiasOptativas = materiasOptativas;
    }

    // -----------------------------------------------
    // ---------------|    Metodos    |---------------
    // -----------------------------------------------
    public List<Materia> listarMateriasObligatorias(){
        return null;
    }
    public List<Materia> listarTodasLasMaterias(){
        return null;
    }

    // -----------------------------------------------
    // ---------------|    Getters    |---------------
    // -----------------------------------------------

    // -----------------------------------------------
    // ---------------|    Setters    |---------------
    // -----------------------------------------------

}
