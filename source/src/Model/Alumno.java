package Model;

import java.util.List;

public class Alumno {
    private static Integer identificador_alumno = 0;
    private final Integer alumnoID;
    private Long legajo;
    private Long dni;
    private String Nombre;
    private String apellido;
    private Carrera carrera;
    private List<Materia> materiasQuePuedeCursar; //Cambia cada cuatrimestre
    private List<Materia> materias; //Materias que cursa actualmente.
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
    public Alumno obtenerMateriasQuePuedeCursar(){
        materiasQuePuedeCursar = carrera.materiasQuePuedeCursar(this);
        return this;
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
        return this.materias;
    }
    public List<Materia> obtenerMateriasAprobadas(){
        return this.materiasAprobadas;
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
    /* Para asignar las materias del primer cuatrimestre */
    public Alumno setMaterias(List<Materia> materias) {
        this.materias = materias;
        return this;
    }
    public void setMateriasAprobadas(Materia materia) {
        this.materiasAprobadas.add(materia);
    }
}
