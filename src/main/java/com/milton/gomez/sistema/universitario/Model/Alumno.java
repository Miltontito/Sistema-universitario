package com.milton.gomez.sistema.universitario.Model;


import java.util.ArrayList;
import java.util.List;

public class Alumno {
    // -------------------------------------------
    // ---------------| Atributos |---------------
    // -------------------------------------------

    private static Integer identificador_alumno = 0;
    private Integer alumnoID;
    private Long legajo;
    private Long dni;
    private String nombre;
    private String apellido;
    private Carrera carrera;
    private List<Materia> materiasQuePuedeCursar; //Cambia cada cuatrimestre
    private List<Cursada> cursadas;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public Alumno() {
        this.alumnoID = asignarID();
        this.materiasQuePuedeCursar = new ArrayList<>();
        this.cursadas = new ArrayList<>();
    }
    public Alumno(String nombre) {
        this();
        this.nombre = nombre;
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
     public Alumno(Long legajo, Long dni, String nombre, String apellido, Carrera carrera, List<Cursada> cursadas) {
        this(legajo, dni, nombre, apellido, carrera);
        this.cursadas = cursadas;
    }


    // -----------------------------------------
    // ---------------| Métodos |---------------
    // -----------------------------------------

    private Integer asignarID(){
        return identificador_alumno++;
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
            cursadas.add(new Cursada(materia));
            return true;
        }
        return false;
    }
    public List<Materia> obtenerMateriasQueCursa(){
        List<Materia> materias = new ArrayList<>();
        if(!this.cursadas.isEmpty()){
            for(Cursada cursada : this.cursadas){
                if(cursada.getCursando()){
                    materias.add(cursada.getMateria());
                }
            }
        }
        return materias;
    }
    public List<Materia> obtenerCursadasAprobadas(){
        List<Materia> aprobadas = new ArrayList<>();
        if(!this.cursadas.isEmpty()){
            for(Cursada cursada : this.cursadas){
                if(cursada.getCursadaAprobada()){
                    aprobadas.add(cursada.getMateria());
                }
            }
        }
        
        return aprobadas;
    }
    public List<Materia> obtenerMateriasAprobadas(){
        List<Materia> aprobadas = new ArrayList<>();
        if(!this.cursadas.isEmpty()){
            for(Cursada cursada : this.cursadas){
                if(cursada.getMateriaAprobada()){
                    aprobadas.add(cursada.getMateria());
                }
            }
        }
        
        return aprobadas;
    }
    public void setMateriaAprobada(Materia materia) {
        Cursada cursada = new Cursada(materia);
        cursada.setMateriaAprobada(Boolean.TRUE);
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
        List<Materia> materias = new ArrayList<>();
        this.cursadas.forEach((c) -> materias.add(c.getMateria()));
        return materias;
    }
    public List<Cursada> getCursadas() {
        return cursadas;
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
        List<Cursada> nuevaCursada = new ArrayList<>();
        materias.forEach((m) -> nuevaCursada.add(new Cursada(m)));
        this.cursadas = nuevaCursada;
    }
    public void setCarrera(Carrera carrera){
        this.carrera = carrera;
    }

    public void setCursadas(List<Cursada> cursadas) {
        this.cursadas = cursadas;
    }
    
    public void setId(Integer id){
        this.alumnoID = id;
    }
    
}
