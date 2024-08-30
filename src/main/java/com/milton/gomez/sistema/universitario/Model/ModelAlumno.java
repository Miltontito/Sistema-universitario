package com.milton.gomez.sistema.universitario.Model;


import java.util.ArrayList;
import java.util.List;

public class ModelAlumno {
    // -------------------------------------------
    // ---------------| Atributos |---------------
    // -------------------------------------------

    private static Integer identificador_alumno = 0;
    private final Integer alumnoID;
    private Long legajo;
    private Long dni;
    private String nombre;
    private String apellido;
    private ModelCarrera carrera;
    private List<ModelMateria> materiasQuePuedeCursar; //Cambia cada cuatrimestre
    private List<ModelMateria> materias; //todas las materias, aprobadas y cursando

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public ModelAlumno() {
        this.alumnoID = asignarID();
        this.materiasQuePuedeCursar = new ArrayList<>();
        this.materias = new ArrayList<>();
    }
    public ModelAlumno(String nombre) {
        this();
        this.nombre = nombre;
    }
    public ModelAlumno(Long legajo, Long dni, String nombre, String apellido) {
        this();
        this.legajo = legajo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public ModelAlumno(Long legajo, Long dni, String nombre, String apellido, ModelCarrera carrera) {
        this(legajo, dni, nombre, apellido);
        this.carrera = carrera;
    }
    public ModelAlumno(Long legajo, Long dni, String nombre, String apellido, ModelCarrera carrera, List<ModelMateria> materiasQuePuedeCursar, List<ModelMateria> materias) {
        this(legajo, dni, nombre, apellido, carrera);
        this.materiasQuePuedeCursar = materiasQuePuedeCursar;
        this.materias = materias;
    }


    // -----------------------------------------
    // ---------------| Métodos |---------------
    // -----------------------------------------

    protected Integer asignarID(){
        return identificador_alumno++;
    }
    public Boolean inscribirseACarrera(ModelCarrera carrera){
        if (this.carrera != null){
            this.carrera = carrera;
            return true;
        }
        return false;
    }
    public List<ModelMateria> obtenerMateriasQuePuedeCursar(){
        materiasQuePuedeCursar = carrera.materiasQuePuedeCursar(this);
        return materiasQuePuedeCursar;
    }
    public Boolean inscribirseAMateria(ModelMateria materia){
        /* si la materia se encuentra en la lista de materias que puede cursar entonces... */
        if(materiasQuePuedeCursar.contains(materia)){
            materias.add(materia);
            return true;
        }
        return false;
    }
    public List<ModelMateria> obtenerMateriasQueCursa(){
        List<ModelMateria> cursadas = new ArrayList<>();
        for(ModelMateria materia : this.materias){
            if(!materia.isMateriaAprobada()){
                cursadas.add(materia);
            }
        }
        if(cursadas.isEmpty()){
            return null;
        }
        return cursadas;
    }
    public List<ModelMateria> obtenerMateriasAprobadas(){
        List<ModelMateria> aprobadas = new ArrayList<>();
        for(ModelMateria materia : this.materias){
            if(materia.isMateriaAprobada()){
                aprobadas.add(materia);
            }
        }
        if(aprobadas.isEmpty()){
            return null;
        }
        return aprobadas;
    }
    public void setMateriaAprobada(ModelMateria materia) {
        this.materias.add(materia);
    }

    // -----------------------------------------
    // ---------------| Getters |---------------
    // -----------------------------------------

    public Long getLegajo() {
        return legajo;
    }
    public Long getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public ModelCarrera getCarrera() {
        return carrera;
    }
    public Integer getAlumnoID() {
        return alumnoID;
    }
    public List<ModelMateria> getMaterias(){
        return materias;
    }

    // -----------------------------------------
    // ---------------| Setters |---------------
    // -----------------------------------------
    /* Se elige retornar al alumno por buenas prácticas */

    public void setLegajo(Long legajo) {
        this.legajo = legajo;}
    public void setDni(Long dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setMaterias(List<ModelMateria> materias) {
        this.materias = materias;
    }
    public void setCarrera(ModelCarrera carrera){
        this.carrera = carrera;
    }
}
