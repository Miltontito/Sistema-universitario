package Model;

import java.util.ArrayList;
import java.util.List;

public class ControladorUniversitario {

    // -------------------------------------------
    // ---------------| Atributos |---------------
    // -------------------------------------------
    private List<Carrera> carreras;
    private List<Materia> materias;
    private List<Alumno> alumnos;
    private List<PlanDeEstudio> planesDeEstudios;

    // -----------------------------------------------
    // ---------------| Constructores |---------------
    // -----------------------------------------------
    public ControladorUniversitario() {
        this.carreras = new ArrayList<>();
        this.materias = new ArrayList<>();
        this.alumnos = new ArrayList<>();
        this.planesDeEstudios = new ArrayList<>();
    }
    public ControladorUniversitario(List<Carrera> carreras, List<Materia> materias, List<Alumno> alumnos, List<PlanDeEstudio> planesDeEstudios) {
        this.carreras = carreras;
        this.materias = materias;
        this.alumnos = alumnos;
        this.planesDeEstudios = planesDeEstudios;
    }

    // -----------------------------------------
    // ---------------| Métodos |---------------
    // -----------------------------------------

    // Crear métodos
    public void crearCarrera(String nombre, Long codCarrera, Integer cantMateriasOptativas, PlanDeEstudio planDeEstudio, List<Cuatrimestre> cuatrimestres, List<Alumno> alumnos) {
        Carrera nuevaCarrera = new Carrera();
        nuevaCarrera.setNombre(nombre);
        nuevaCarrera.setCodigoCarrera(codCarrera);
        nuevaCarrera.setCantMateriasOptativasParaAprobar(cantMateriasOptativas);
        nuevaCarrera.setPlanDeEstudio(planDeEstudio);
        nuevaCarrera.setCuatrimestres(cuatrimestres != null ? cuatrimestres : new ArrayList<>());
        nuevaCarrera.setAlumnos(alumnos != null ? alumnos : new ArrayList<>());
        carreras.add(nuevaCarrera);
    }

    public void crearMateria(String codigoDeMateria, String nombre, Boolean promocionable, List<Materia> correlativas) {
        Materia nuevaMateria = new Materia(codigoDeMateria, nombre, promocionable, correlativas != null ? correlativas : new ArrayList<>());
        materias.add(nuevaMateria);
    }

    public void crearAlumno(String nombre, String apellido, Long legajo, Long dni, Carrera carrera) {
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombre(nombre);
        nuevoAlumno.setApellido(apellido);
        nuevoAlumno.setLegajo(legajo);
        nuevoAlumno.setDni(dni);
        nuevoAlumno.setCarrera(carrera);
        alumnos.add(nuevoAlumno);
    }


    // Obtener métodos
    public List<Carrera> obtenerCarreras() {
        return carreras;
    }

    public List<Materia> obtenerMaterias() {
        return materias;
    }

    public List<Alumno> obtenerAlumnos() {
        return alumnos;
    }

    public List<PlanDeEstudio> obtenerPlanesDeEstudios() {
        return planesDeEstudios;
    }

    // Actualizar métodos
    public void actualizarCarrera(Carrera carreraActualizada) {
        for (int i = 0; i < carreras.size(); i++) {
            if (carreras.get(i).getCarreraID().equals(carreraActualizada.getCarreraID())) {
                carreras.set(i, carreraActualizada);
                break;
            }
        }
    }

    public void actualizarMateria(Materia materiaActualizada) {
        for (int i = 0; i < materias.size(); i++) {
            if (materias.get(i).getMateriaID().equals(materiaActualizada.getMateriaID())) {
                materias.set(i, materiaActualizada);
                break;
            }
        }
    }

    public void actualizarAlumno(Alumno alumnoActualizado) {
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
}
