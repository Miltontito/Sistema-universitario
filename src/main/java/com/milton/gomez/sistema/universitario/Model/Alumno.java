package com.milton.gomez.sistema.universitario.Model;


import java.util.ArrayList;
import java.util.List;

public class Alumno {
    // -------------------------------------------
    // ---------------| Atributos |---------------
    // -------------------------------------------

    private static Integer identificador_alumno = 0;
    private final Integer alumnoID;
    private Long legajo;
    private Long dni;
    private String nombre;
    private String apellido;
    private Carrera carrera;
    private List<Materia> materiasQuePuedeCursar; //Cambia cada cuatrimestre
    private List<Materia> materias; //todas las materias, aprobadas y cursando

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public Alumno() {
        this.alumnoID = asignarID();
    }
    public Alumno(Long legajo, Long dni, String nombre, String apellido) {
        this();
        this.legajo = legajo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Alumno(Long legajo, Long dni, String nombre, String apellido, Carrera carrera) {
        this(legajo, dni, nombre, apellido);
        this.carrera = carrera;
    }
    public Alumno(Long legajo, Long dni, String nombre, String apellido, Carrera carrera, List<Materia> materiasQuePuedeCursar, List<Materia> materias) {
        this(legajo, dni, nombre, apellido, carrera);
        this.materiasQuePuedeCursar = materiasQuePuedeCursar;
        this.materias = materias;
    }


    // -----------------------------------------
    // ---------------| Métodos |---------------
    // -----------------------------------------

    protected Integer asignarID(){
        return ++identificador_alumno;
    }
    public Boolean inscribirseACarrera(Carrera carrera){
        if (this.carrera != null){
            this.carrera = carrera;
            return true;
        }
        return false;
    }
    public List<Materia> obtenerMateriasQuePuedeCursar(){
        materiasQuePuedeCursar = carrera.materiasQuePuedeCursar(this);
        return materiasQuePuedeCursar;
    }
    public Boolean inscribirseAMateria(Materia materia){
        /* si la materia se encuentra en la lista de materias que puede cursar entonces... */
        if(materiasQuePuedeCursar.contains(materia)){
            materias.add(materia);
            return true;
        }
        return false;
    }
    public List<Materia> obtenerMateriasQueCursa(){
        List<Materia> cursadas = new ArrayList<>();
        for(Materia materia : this.materias){
            if(!materia.isMateriaAprobada()){
                cursadas.add(materia);
            }
        }
        if(cursadas.isEmpty()){
            return null;
        }
        return cursadas;
    }
    public List<Materia> obtenerMateriasAprobadas(){
        List<Materia> aprobadas = new ArrayList<>();
        for(Materia materia : this.materias){
            if(materia.isMateriaAprobada()){
                aprobadas.add(materia);
            }
        }
        if(aprobadas.isEmpty()){
            return null;
        }
        return aprobadas;
    }
    public void setMateriaAprobada(Materia materia) {
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
    public Carrera getCarrera() {
        return carrera;
    }
    public Integer getAlumnoID() {
        return alumnoID;
    }
    public List<Materia> getMaterias(){
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
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    public void setCarrera(Carrera carrera){
        this.carrera = carrera;
    }
}
