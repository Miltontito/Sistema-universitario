package Model;

import java.util.List;

public class Alumno {
    private static Integer identificador_alumno = 0;
    private Integer alumnoID;
    private Long legajo;
    private Long dni;
    private String Nombre;
    private String apellido;
    private Carrera carrera;
    private List<Materia> materias; //Cambian constantemente.
    private List<Materia> materiasAprobadas; //Se guardan a lo largo del tiempo.


    // ---------------| Constructores |---------------
    /* sin parámetros */
    public Alumno(){
        this.alumnoID = asignarID();
    }
    
    // ---------------| Métodos |---------------
    protected Integer asignarID(){
        return identificador_alumno++;
    }

    public Boolean inscribirseACarrera(Carrera carrera){
        if (this.carrera != null){
            this.carrera = carrera;
            return true;
        }
        return false;
    }

    public Boolean inscribirseAMateria(){
        return null;
    }



    // ---------------| Getters |---------------
    public Long getLegajo() {
        return legajo;
    }
    public Long getDni() {
        return dni;
    }
    public String getNombre() {
        return Nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public Carrera getCarrera() {
        return carrera;
    }
    public List<Materia> getMaterias() {
        return materias;
    }
    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }
    public Integer getAlumnoID() {
        return alumnoID;
    }

    // ---------------| Setters |---------------
    /* Se elige retornar al alumno por buenas prácticas */
    public Alumno setLegajo(Long legajo) {
        this.legajo = legajo;
        return this;
    }
    public Alumno setDni(Long dni) {
        this.dni = dni;
        return this;
    }
    public Alumno setNombre(String nombre) {
        Nombre = nombre;
        return this;
    }
    public Alumno setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }
    public Alumno setMaterias(List<Materia> materias) {
        this.materias = materias;
        return this;
    }
    public Alumno setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
        return this;
    }
    public Alumno setAlumnoID(Integer alumnoID) {
        this.alumnoID = alumnoID;
        return this;
    }
}
