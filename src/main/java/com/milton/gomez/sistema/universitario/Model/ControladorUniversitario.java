package com.milton.gomez.sistema.universitario.Model;


import com.milton.gomez.sistema.universitario.Iniciador.IniciadorCompleto;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanA;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanB;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanC;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanD;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControladorUniversitario {

    // -------------------------------------------
    // ---------------| Atributos |---------------
    // -------------------------------------------
    private static ControladorUniversitario instance;
    private HashMap<Integer, Carrera> carreras;
    private HashMap<Integer, Materia> materias;
    private HashMap<Integer, Alumno> alumnos;
    private List<PlanDeEstudio> planesDeEstudios;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    private ControladorUniversitario() {
        this.carreras = new HashMap<>();
        this.materias = new HashMap<>();
        this.alumnos = new HashMap<>();
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
    public Carrera crearCarrera(String nombre, String codCarrera, Integer cantMateriasOptativas, PlanDeEstudio planDeEstudio, HashMap<Integer,Cuatrimestre> cuatrimestres, List<Alumno> alumnos) {
        Carrera nuevaCarrera = new Carrera();
        nuevaCarrera.setNombre(nombre);
        nuevaCarrera.setCodigoCarrera(codCarrera);
        nuevaCarrera.setCantMateriasOptativasParaAprobar(cantMateriasOptativas);
        nuevaCarrera.setPlanDeEstudio(planDeEstudio);
        nuevaCarrera.setCuatrimestres(cuatrimestres != null ? cuatrimestres : new HashMap<>());
        nuevaCarrera.setAlumnos(alumnos != null ? alumnos : new ArrayList<>());
        this.carreras.put(nuevaCarrera.getCarreraID(), nuevaCarrera);
        return nuevaCarrera;
    }

    public Materia crearMateria(String codigoDeMateria, String nombre, Boolean promocionable, List<Materia> correlativas) {
        Materia nuevaMateria = new Materia(codigoDeMateria, nombre, promocionable, correlativas != null ? correlativas : new ArrayList<>());
        this.materias.put(nuevaMateria.getMateriaID(), nuevaMateria);
        return nuevaMateria;
    }

    public Alumno crearAlumno(String nombre, String apellido, Long legajo, Long dni, Carrera carrera, List<Materia> materias) {
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombre(nombre);
        nuevoAlumno.setApellido(apellido);
        nuevoAlumno.setLegajo(legajo);
        nuevoAlumno.setDni(dni);
        nuevoAlumno.inscribirACarrera(carrera);
        nuevoAlumno.setMaterias(materias);
        this.alumnos.put(nuevoAlumno.getAlumnoID(), nuevoAlumno);
        return nuevoAlumno;
    }
    
    public void crearPlanesDeEstudio(){
        this.planesDeEstudios.add(new PlanA());
        this.planesDeEstudios.add(new PlanB());
        this.planesDeEstudios.add(new PlanC());
        this.planesDeEstudios.add(new PlanD());
        this.planesDeEstudios.add(new PlanE());
    }

    /* Métodos para Obtener TODOS */
    public List<Carrera> obtenerCarreras() {
        List<Carrera> listaCarreras = new ArrayList<>();
        this.carreras.forEach((k,v) -> listaCarreras.add(v));
        return listaCarreras;
    }

    public List<Materia> obtenerMaterias() {
        List<Materia> listaMaterias = new ArrayList<>();
        this.materias.forEach((k,v) -> listaMaterias.add(v));
        return listaMaterias;
    }

    public List<Alumno> obtenerAlumnos() {
        List<Alumno> listaAlumos = new ArrayList<>();
        this.alumnos.forEach((k,v) -> listaAlumos.add(v));
        return listaAlumos;
    }

    public List<PlanDeEstudio> obtenerPlanesDeEstudios() {
        return this.planesDeEstudios;
    }

    /* Métodos para Obtener uno */
    public Carrera obtenerCarrera(Integer carreraId){
        return this.carreras.get(carreraId);
    }

    public Materia obtenerMateria(Integer materiaId){
        return this.materias.get(materiaId);
    }

    public Alumno obtenerAlumno(Integer alumnoId){
        return this.alumnos.get(alumnoId);
    }

    // Eliminar métodos
    public void eliminarCarrera(Integer carreraID) {
        this.carreras.remove(carreraID);
    }
    public void eliminarMateria(Integer materiaID) {
        this.materias.remove(materiaID);
    }
    public void eliminarAlumno(Integer alumnoID) {
        this.alumnos.remove(alumnoID);
    }

    public void agregarCarrera(Carrera carrera){
        this.carreras.put(carrera.getCarreraID(), carrera);
    }
}
