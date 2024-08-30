package com.milton.gomez.sistema.universitario.Model;


import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanA;
import java.util.ArrayList;
import java.util.List;

public class ModelCarrera {

    // -------------------------------------------
    // ---------------| Atributos |---------------
    // -------------------------------------------
    private static Integer identificador_carrera = 0;
    private final Integer carreraID;
    private String nombre;
    private Long codigoCarrera;
    private Integer cantMateriasOptativasParaAprobar;
    private List<ModelCuatrimestre> cuatrimestres;
    private ModelPlanDeEstudio planDeEstudio;
    private List<ModelAlumno> alumnos;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public ModelCarrera() {
        this.carreraID = asignarID();
        this.cuatrimestres = new ArrayList<>();
    }
    
    public ModelCarrera(String nombre) {
        this();
        this.nombre = nombre;
    }
    
    public ModelCarrera(Integer cantMateriasOptativasParaAprobar) {
        this();
        this.cantMateriasOptativasParaAprobar = cantMateriasOptativasParaAprobar;
    }
    public ModelCarrera(String nombre, Long codigoCarrera) {
        this();
        this.nombre = nombre;
        this.codigoCarrera = codigoCarrera;
    }
    public ModelCarrera(String nombre, Long codigoCarrera, Integer cantMateriasOptativasParaAprobar) {
        this(nombre, codigoCarrera);
        this.cantMateriasOptativasParaAprobar = cantMateriasOptativasParaAprobar;
    }
    public ModelCarrera(String nombre, Long codigoCarrera, Integer cantMateriasOptativasParaAprobar, ModelPlanDeEstudio planDeEstudio) {
        this(nombre, codigoCarrera, cantMateriasOptativasParaAprobar);
        this.planDeEstudio = planDeEstudio;
    }

    // -----------------------------------------
    // ---------------| Métodos |---------------
    // -----------------------------------------
    private Integer asignarID(){
        return identificador_carrera++;
    }
    public boolean crearCuatrimestre(){
        this.cuatrimestres.add(new ModelCuatrimestre());
        return true;
    }
    public boolean crearCuatrimestre(List<ModelMateria> materias){
        cuatrimestres.add(new ModelCuatrimestre(materias));
        return true;
    }
    public ModelCarrera asignarCuatrimestre(ModelCuatrimestre cuatrimestre){
        this.cuatrimestres.add(cuatrimestre);
        return this;
    }
    public ModelCarrera setPlanDeEstudio(ModelPlanDeEstudio planDeEstudio){
        this.planDeEstudio = planDeEstudio;
        return this;
    }
    public List<ModelMateria> materiasQuePuedeCursar(ModelAlumno alumno){
        return planDeEstudio.materiasQuePuedeCursar(alumno, this);
    }
    public Boolean sePuedeGraduar(ModelAlumno alumno){

        boolean cumpleLosRequisitos = true;
        List<ModelMateria> obligatorias = new ArrayList<>();
        List<ModelMateria> aprobadas = alumno.getMaterias();

        //Por cada cuatrimestre retira las materias obligatorias.
        for(ModelCuatrimestre cuatrimestre : this.cuatrimestres){
            obligatorias.addAll(cuatrimestre.listarMateriasObligatorias());
        }
        //No es eficiente.
        cumpleLosRequisitos = aprobadas.containsAll(obligatorias);

        /* Si eliminamos todas las obligatorias nos quedan las optativas */
        aprobadas.removeAll(obligatorias);
        if(cumpleLosRequisitos){
            return aprobadas.size() >= this.getCantMateriasOptativasParaAprobar();
        }

        //Retorna false
        return cumpleLosRequisitos;
    }
    public List<ModelMateria> obtenerMateriasDeLaCarrera(){
        List<ModelMateria> materias = new ArrayList<>();
        for(ModelCuatrimestre cuatrimestre : this.cuatrimestres){
            materias.addAll(cuatrimestre.listarTodasLasMaterias());
        }
        return materias;
    }
    @Override
    public String toString(){
        return this.getNombre();
    }
    // -----------------------------------------
    // ---------------| Getters |---------------
    // -----------------------------------------
    public Integer getCarreraID() {
        return carreraID;
    }
    public Integer getCantMateriasOptativasParaAprobar() {
        return cantMateriasOptativasParaAprobar;
    }
    public String getNombre() {
        return nombre;
    }
    public Long getCodigoCarrera() {
        return codigoCarrera;
    }
    public List<ModelCuatrimestre> getCuatrimestres(){
        return this.cuatrimestres;
    }
    public List<ModelAlumno> getAlumnos(){
        return this.alumnos;
    }
    public ModelPlanDeEstudio getPlanDeEstudio() {
        return planDeEstudio;
    }

    // -----------------------------------------
    // ---------------| Setters |---------------
    // -----------------------------------------
    public void setCantMateriasOptativasParaAprobar(Integer cantMateriasOptativasParaAprobar) {
        this.cantMateriasOptativasParaAprobar = cantMateriasOptativasParaAprobar;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCodigoCarrera(Long codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }
    public void setCuatrimestres(List<ModelCuatrimestre> cuatrimestres){
        this.cuatrimestres = cuatrimestres;
    }
    public void setAlumnos(List<ModelAlumno> alumnos){
        this.alumnos = alumnos;
    }
}
