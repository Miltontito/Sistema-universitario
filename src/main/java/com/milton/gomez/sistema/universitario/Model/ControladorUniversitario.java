package com.milton.gomez.sistema.universitario.Model;


import com.milton.gomez.sistema.universitario.Iniciador.IniciadorCompleto;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanA;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanB;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanC;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanD;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanE;
import java.util.ArrayList;
import java.util.List;

public class ControladorUniversitario {

    // -------------------------------------------
    // ---------------| Atributos |---------------
    // -------------------------------------------
    private static ControladorUniversitario instance;
    private List<Carrera> carreras;
    private List<Materia> materias;
    private List<Alumno> alumnos;
    private List<PlanDeEstudio> planesDeEstudios;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    private ControladorUniversitario() {
        this.carreras = new ArrayList<>();
        this.materias = new ArrayList<>();
        this.alumnos = new ArrayList<>();
        this.planesDeEstudios = new ArrayList<>();
    }
    
    public static ControladorUniversitario getInstance(){
        if(instance == null){
            instance = new ControladorUniversitario();
            
            IniciadorCompleto.inicializarPlanesDeEstudio();
            IniciadorCompleto.inicializarAlumnos();
            IniciadorCompleto.inicializarMaterias();
            IniciadorCompleto.asignarMaterias();
        }
        return instance;
        
    }
    // -----------------------------------------
    // ---------------| Métodos |---------------
    // -----------------------------------------
    
    // Crear métodos
    public Carrera crearCarrera(String nombre, String codCarrera, Integer cantMateriasOptativas, PlanDeEstudio planDeEstudio, List<Cuatrimestre> cuatrimestres, List<Alumno> alumnos) {
        Carrera nuevaCarrera = new Carrera();
        nuevaCarrera.setNombre(nombre);
        nuevaCarrera.setCodigoCarrera(codCarrera);
        nuevaCarrera.setCantMateriasOptativasParaAprobar(cantMateriasOptativas);
        nuevaCarrera.setPlanDeEstudio(planDeEstudio);
        nuevaCarrera.setCuatrimestres(cuatrimestres != null ? cuatrimestres : new ArrayList<>());
        nuevaCarrera.setAlumnos(alumnos != null ? alumnos : new ArrayList<>());
        this.carreras.add(nuevaCarrera);
        return nuevaCarrera;
    }

    public Materia crearMateria(String codigoDeMateria, String nombre, Boolean promocionable, List<Materia> correlativas) {
        Materia nuevaMateria = new Materia(codigoDeMateria, nombre, promocionable, correlativas != null ? correlativas : new ArrayList<>());
        this.materias.add(nuevaMateria);
        return nuevaMateria;
    }

    public Alumno crearAlumno(String nombre, String apellido, Long legajo, Long dni, Carrera carrera, List<Materia> materias) {
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombre(nombre);
        nuevoAlumno.setApellido(apellido);
        nuevoAlumno.setLegajo(legajo);
        nuevoAlumno.setDni(dni);
        nuevoAlumno.setCarrera(carrera);
        nuevoAlumno.setMaterias(materias);
        this.alumnos.add(nuevoAlumno);
        return nuevoAlumno;
    }
    
    public void crearPlanesDeEstudio(){
        this.planesDeEstudios.add(new PlanA());
        this.planesDeEstudios.add(new PlanB());
        this.planesDeEstudios.add(new PlanC());
        this.planesDeEstudios.add(new PlanD());
        this.planesDeEstudios.add(new PlanE());
    }

    // Obtener métodos
    public List<Carrera> obtenerCarreras() {
        return this.carreras;
    }

    public List<Materia> obtenerMaterias() {
        return this.materias;
    }

    public List<Alumno> obtenerAlumnos() {
        return this.alumnos;
    }

    public List<PlanDeEstudio> obtenerPlanesDeEstudios() {
        return this.planesDeEstudios;
    }


    // Eliminar métodos
    public void eliminarCarrera(Integer carreraID) {
        carreras.removeIf(carrera -> carrera.getCarreraID().equals(carreraID));
    }
    public void eliminarMateria(Integer materiaID) {
        materias.removeIf(materia -> materia.getMateriaID().equals(materiaID));
    }
    public void eliminarAlumno(Integer alumnoID) {
        alumnos.removeIf(alumno -> alumno.getAlumnoID().equals(alumnoID));
    }
    
    // Getters
    public List<Carrera> getCarreras() {
        return this.carreras;
    }
    public List<Materia> getMaterias() {
        return this.materias;
    }
    public List<Alumno> getAlumnos() {
        return this.alumnos;
    }
    public List<PlanDeEstudio> getPlanesDeEstudios() {
        return this.planesDeEstudios;
    }

    // Setters
    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    public void setPlanesDeEstudios(List<PlanDeEstudio> planesDeEstudios) {
        this.planesDeEstudios = planesDeEstudios;
    }
    public void agregarCarrera(Carrera carrera){
        this.carreras.add(carrera);
    }
}
