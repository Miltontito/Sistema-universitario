package com.milton.gomez.sistema.universitario.Model;


import com.milton.gomez.sistema.universitario.Iniciador.IniciadorCompleto;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanA;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanB;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanC;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanD;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanE;
import java.util.ArrayList;
import java.util.List;

public class ModelControladorUniversitario {

    // -------------------------------------------
    // ---------------| Atributos |---------------
    // -------------------------------------------
    private static ModelControladorUniversitario instance;
    private List<ModelCarrera> carreras;
    private List<ModelMateria> materias;
    private List<ModelAlumno> alumnos;
    private List<ModelPlanDeEstudio> planesDeEstudios;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    private ModelControladorUniversitario() {
        this.carreras = new ArrayList<>();
        this.materias = new ArrayList<>();
        this.alumnos = new ArrayList<>();
        this.planesDeEstudios = new ArrayList<>();
    }
    
    public static ModelControladorUniversitario getInstance(){
        if(instance == null){
            instance = new ModelControladorUniversitario();
            
            IniciadorCompleto.inicializarPlanesDeEstudio();
            IniciadorCompleto.inicializarAlumnos();
            IniciadorCompleto.inicializarMaterias();
        }
        return instance;
        
    }
    // -----------------------------------------
    // ---------------| Métodos |---------------
    // -----------------------------------------
    
    // Crear métodos
    public ModelCarrera crearCarrera(String nombre, Long codCarrera, Integer cantMateriasOptativas, ModelPlanDeEstudio planDeEstudio, List<ModelCuatrimestre> cuatrimestres, List<ModelAlumno> alumnos) {
        ModelCarrera nuevaCarrera = new ModelCarrera();
        nuevaCarrera.setNombre(nombre);
        nuevaCarrera.setCodigoCarrera(codCarrera);
        nuevaCarrera.setCantMateriasOptativasParaAprobar(cantMateriasOptativas);
        nuevaCarrera.setPlanDeEstudio(planDeEstudio);
        nuevaCarrera.setCuatrimestres(cuatrimestres != null ? cuatrimestres : new ArrayList<>());
        nuevaCarrera.setAlumnos(alumnos != null ? alumnos : new ArrayList<>());
        this.carreras.add(nuevaCarrera);
        return nuevaCarrera;
    }

    public ModelMateria crearMateria(String codigoDeMateria, String nombre, Boolean promocionable, List<ModelMateria> correlativas) {
        ModelMateria nuevaMateria = new ModelMateria(codigoDeMateria, nombre, promocionable, correlativas != null ? correlativas : new ArrayList<>());
        this.materias.add(nuevaMateria);
        return nuevaMateria;
    }

    public ModelAlumno crearAlumno(String nombre, String apellido, Long legajo, Long dni, ModelCarrera carrera) {
        ModelAlumno nuevoAlumno = new ModelAlumno();
        nuevoAlumno.setNombre(nombre);
        nuevoAlumno.setApellido(apellido);
        nuevoAlumno.setLegajo(legajo);
        nuevoAlumno.setDni(dni);
        nuevoAlumno.setCarrera(carrera);
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
    public List<ModelCarrera> obtenerCarreras() {
        return this.carreras;
    }

    public List<ModelMateria> obtenerMaterias() {
        return this.materias;
    }

    public List<ModelAlumno> obtenerAlumnos() {
        return this.alumnos;
    }

    public List<ModelPlanDeEstudio> obtenerPlanesDeEstudios() {
        return this.planesDeEstudios;
    }

    // Actualizar métodos
    public void actualizarCarrera(ModelCarrera carreraActualizada) {
        for (int i = 0; i < carreras.size(); i++) {
            if (carreras.get(i).getCarreraID().equals(carreraActualizada.getCarreraID())) {
                carreras.set(i, carreraActualizada);
                break;
            }
        }
    }

    public void actualizarMateria(ModelMateria materiaActualizada) {
        for (int i = 0; i < materias.size(); i++) {
            if (materias.get(i).getMateriaID().equals(materiaActualizada.getMateriaID())) {
                materias.set(i, materiaActualizada);
                break;
            }
        }
    }

    public void actualizarAlumno(ModelAlumno alumnoActualizado) {
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getAlumnoID().equals(alumnoActualizado.getAlumnoID())) {
                alumnos.set(i, alumnoActualizado);
                break;
            }
        }
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
    public List<ModelCarrera> getCarreras() {
        return this.carreras;
    }
    public List<ModelMateria> getMaterias() {
        return this.materias;
    }
    public List<ModelAlumno> getAlumnos() {
        return this.alumnos;
    }
    public List<ModelPlanDeEstudio> getPlanesDeEstudios() {
        return this.planesDeEstudios;
    }

    // Setters
    public void setCarreras(List<ModelCarrera> carreras) {
        this.carreras = carreras;
    }
    public void setMaterias(List<ModelMateria> materias) {
        this.materias = materias;
    }
    public void setAlumnos(List<ModelAlumno> alumnos) {
        this.alumnos = alumnos;
    }
    public void setPlanesDeEstudios(List<ModelPlanDeEstudio> planesDeEstudios) {
        this.planesDeEstudios = planesDeEstudios;
    }
    public void agregarCarrera(ModelCarrera carrera){
        this.carreras.add(carrera);
    }
}
