package com.milton.gomez.sistema.universitario.Model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Carrera {

    // -------------------------------------------
    // ---------------| Atributos |---------------
    // -------------------------------------------
    private static Integer identificador_carrera = 0;
    private final Integer carreraID;
    private String nombre;
    private String codigoCarrera;
    private Integer cantMateriasOptativasParaAprobar;
    private HashMap<Integer,Cuatrimestre> cuatrimestres;
    private PlanDeEstudio planDeEstudio;
    private HashMap<Integer,Alumno> alumnos;
    private Integer nroCuatrimestre = 0;
    
    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public Carrera() {
        this.carreraID = asignarID();
        this.cuatrimestres = new HashMap<>();
        this.alumnos = new HashMap<>();
    }
    
    public Carrera(String nombre) {
        this();
        this.nombre = nombre;
    }
    
    public Carrera(Integer cantMateriasOptativasParaAprobar) {
        this();
        this.cantMateriasOptativasParaAprobar = cantMateriasOptativasParaAprobar;
    }
    public Carrera(String nombre, String codigoCarrera) {
        this();
        this.nombre = nombre;
        this.codigoCarrera = codigoCarrera;
    }
    public Carrera(String nombre, String codigoCarrera, Integer cantMateriasOptativasParaAprobar) {
        this(nombre, codigoCarrera);
        this.cantMateriasOptativasParaAprobar = cantMateriasOptativasParaAprobar;
    }
    public Carrera(String nombre, String codigoCarrera, Integer cantMateriasOptativasParaAprobar, PlanDeEstudio planDeEstudio) {
        this(nombre, codigoCarrera, cantMateriasOptativasParaAprobar);
        this.planDeEstudio = planDeEstudio;
    }

    // -----------------------------------------
    // ---------------| Métodos |---------------
    // -----------------------------------------
    private Integer asignarID(){
        return identificador_carrera++;
    }

    public Cuatrimestre crearCuatrimestre(){
        Cuatrimestre cuatrimestreCreado = new Cuatrimestre(nroCuatrimestre);
        this.cuatrimestres.put(nroCuatrimestre,cuatrimestreCreado);
        nroCuatrimestre++;
        return cuatrimestreCreado;
    }
    public Cuatrimestre crearCuatrimestre(List<Materia> materiasObligatorias){
        Cuatrimestre cuatrimestreCreado = new Cuatrimestre(materiasObligatorias,nroCuatrimestre);
        this.cuatrimestres.put(nroCuatrimestre,cuatrimestreCreado);
        nroCuatrimestre++;
        return cuatrimestreCreado;
    }
    public Cuatrimestre crearCuatrimestre(List<Materia> materiasObligatorias, List<Materia> materiasOptativas){
        Cuatrimestre cuatrimestreCreado = new Cuatrimestre(materiasObligatorias, materiasOptativas, nroCuatrimestre);
        this.cuatrimestres.put(nroCuatrimestre,cuatrimestreCreado);
        nroCuatrimestre++;
        return cuatrimestreCreado;
    }
    
    public void borrarCuatrimestre(Integer nroCuatrimestre){
        this.cuatrimestres.remove(nroCuatrimestre);
    }
    public Carrera asignarCuatrimestre(Cuatrimestre cuatrimestre){
        this.cuatrimestres.put(cuatrimestre.getNumeroCuatrimestre(),cuatrimestre);
        return this;
    }
    public Carrera setPlanDeEstudio(PlanDeEstudio planDeEstudio){
        this.planDeEstudio = planDeEstudio;
        return this;
    }
    public List<Materia> materiasQuePuedeCursar(Alumno alumno){
        return planDeEstudio.materiasQuePuedeCursar(alumno, this);
    }
    
    public Boolean sePuedeGraduar(Alumno alumno) {
        // Lista de materias obligatorias del plan de estudios
        List<Materia> obligatorias = new ArrayList<>();
        List<Materia> optativas = new ArrayList<>();
        List<Materia> aprobadas = alumno.obtenerMateriasAprobadas();

        // Agregar todas las materias obligatorias desde los cuatrimestres
        this.cuatrimestres.forEach((k, v) -> {
            obligatorias.addAll(v.listarMateriasObligatorias());
            optativas.addAll(v.listarMateriasOptativas());
        });
        
        // Comprobar si el alumno aprobó todas las materias obligatorias
        if (!new HashSet<>(aprobadas).containsAll(obligatorias)) {
            return false;
        }

        // Contar las materias optativas aprobadas
        long optativasAprobadas = optativas.stream()
                .filter(aprobadas::contains)
                .count();
        
        return optativasAprobadas >= this.getCantMateriasOptativasParaAprobar();
    }

    
    public List<Materia> obtenerMateriasDeLaCarrera(){
        List<Materia> materias = new ArrayList<>();
        this.cuatrimestres.forEach((k,v) -> materias.addAll(v.listarTodasLasMaterias()));
        return materias;
    }

    public void inscribirAlumno(Alumno alumno){
        this.alumnos.put(alumno.getAlumnoID(),alumno);
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
    public String getCodigoCarrera() {
        return codigoCarrera;
    }
    public List<Alumno> getAlumnosList(){
        List<Alumno> alumnosList = new ArrayList<>();
        this.alumnos.forEach((k,v) -> alumnosList.add(v));
        return alumnosList;
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
    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }
    public void setAlumnos(List<Alumno> alumnos){
        HashMap<Integer, Alumno> alumnoHashMap = new HashMap<>();
        alumnos.forEach((a) -> this.alumnos.put(a.getAlumnoID(), a));
    }

    public HashMap<Integer, Cuatrimestre> getCuatrimestres() {
        return cuatrimestres;
    }

    public void setCuatrimestres(HashMap<Integer, Cuatrimestre> cuatrimestres) {
        this.cuatrimestres = cuatrimestres;
    }

}
