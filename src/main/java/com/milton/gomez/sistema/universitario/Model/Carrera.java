package com.milton.gomez.sistema.universitario.Model;


import java.awt.PopupMenu;
import java.util.ArrayList;
import java.util.List;

public class Carrera {

    // -------------------------------------------
    // ---------------| Atributos |---------------
    // -------------------------------------------
    private static Integer identificador_carrera = 0;
    private final Integer carreraID;
    private String nombre;
    private Long codigoCarrera;
    private Integer cantMateriasOptativasParaAprobar;
    private List<Cuatrimestre> cuatrimestres;
    private PlanDeEstudio planDeEstudio;
    private List<Alumno> alumnos;
    public PopupMenu getNombre;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public Carrera() {
        this.carreraID = asignarID();
    }
    
    public Carrera(String nombre) {
        this();
        this.nombre = nombre;
    }
    
    public Carrera(Integer cantMateriasOptativasParaAprobar) {
        this();
        this.cantMateriasOptativasParaAprobar = cantMateriasOptativasParaAprobar;
    }
    public Carrera(String nombre, Long codigoCarrera) {
        this();
        this.nombre = nombre;
        this.codigoCarrera = codigoCarrera;
    }
    public Carrera(String nombre, Long codigoCarrera, Integer cantMateriasOptativasParaAprobar, List<Cuatrimestre> cuatrimestres) {
        this(nombre, codigoCarrera);
        this.cantMateriasOptativasParaAprobar = cantMateriasOptativasParaAprobar;
        this.cuatrimestres = cuatrimestres;
    }
    public Carrera(String nombre, Long codigoCarrera, Integer cantMateriasOptativasParaAprobar, List<Cuatrimestre> cuatrimestres, PlanDeEstudio planDeEstudio, List<Alumno> alumnos) {
        this(nombre, codigoCarrera, cantMateriasOptativasParaAprobar, cuatrimestres);
        this.planDeEstudio = planDeEstudio;
        this.alumnos = alumnos;
    }

    // -----------------------------------------
    // ---------------| Métodos |---------------
    // -----------------------------------------
    protected Integer asignarID(){
        return ++identificador_carrera;
    }
    public boolean crearCuatrimestre(List<Materia> materias){
        cuatrimestres.add(new Cuatrimestre(materias));
        return true;
    }
    public Carrera asignarCuatrimestre(Cuatrimestre cuatrimestre){
        this.cuatrimestres.add(cuatrimestre);
        return this;
    }
    public Carrera setPlanDeEstudio(PlanDeEstudio planDeEstudio){
        this.planDeEstudio = planDeEstudio;
        return this;
    }
    public List<Materia> materiasQuePuedeCursar(Alumno alumno){
        return planDeEstudio.materiasQuePuedeCursar(alumno, this);
    }
    public Boolean sePuedeGraduar(Alumno alumno){

        boolean cumpleLosRequisitos = true;
        List<Materia> obligatorias = new ArrayList<>();
        List<Materia> aprobadas = alumno.getMaterias();

        //Por cada cuatrimestre retira las materias obligatorias.
        for(Cuatrimestre cuatrimestre : this.cuatrimestres){
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
    public List<Materia> obtenerMateriasDeLaCarrera(){
        List<Materia> materias = new ArrayList<>();
        for(Cuatrimestre cuatrimestre : this.cuatrimestres){
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
    public List<Cuatrimestre> getCuatrimestres(){
        return this.cuatrimestres;
    }
    public List<Alumno> getAlumnos(){
        return this.alumnos;
    }
    public PlanDeEstudio getPlanDeEstudio() {
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
    public void setCuatrimestres(List<Cuatrimestre> cuatrimestres){
        this.cuatrimestres = cuatrimestres;
    }
    public void setAlumnos(List<Alumno> alumnos){
        this.alumnos = alumnos;
    }
}
