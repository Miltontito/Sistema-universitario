package Model;

import java.util.List;

public class Carrera {
    private static Integer identificador_carrera;
    private final Integer carreraID;
    private String nombre;
    private Long codigoCarrera;
    private Integer cantMateriasOptativasParaAprobar;
    private List<Cuatrimestre> cuatrimestres;
    private PlanDeEstudio planDeEstudio;
    private List<Alumno> alumnos;

    // ---------------| Constructores |---------------
    public Carrera(){
        this.carreraID = asignarID();
    }
    public Carrera(Integer cantMateriasOptativasParaAprobar){
        this();
        this.cantMateriasOptativasParaAprobar = cantMateriasOptativasParaAprobar;
    }

    // ---------------| Métodos |---------------
    protected Integer asignarID(){
        return identificador_carrera++;
    }
    public boolean crearCuatrimestre(){
        cuatrimestres.add(new Cuatrimestre());
        return true;
    }
    public Carrera asignarCuatrimestre(Cuatrimestre cuatrimestre){
        this.cuatrimestres.add(cuatrimestre);
        return this;
    }
    public Carrera setPlanDeEstudio(PlanDeEstudio planDeEstudio){
        this.planDeEstudio = planDeEstudio;
        return this;
    }
    public List<Materia> materiasQuePuedeCursar(Alumno alumno){
        return null;
    }
    public Boolean sePuedeGraduar(Alumno alumno){
        return null;
    }

    // ---------------| Getters |---------------
    public Integer getCarreraID() {
        return carreraID;
    }
    public Integer getCantMateriasOptativasParaAprobar() {
        return cantMateriasOptativasParaAprobar;
    }
    public String getNombre() {
        return nombre;
    }
    public Long getCodigoCarrera() {
        return codigoCarrera;
    }
    public List<Cuatrimestre> getCuatrimestres(){
        return this.cuatrimestres;
    }
    public List<Alumno> getAlumnos(){
        return this.alumnos;
    }
    // ---------------| Setters |---------------
    public void setCantMateriasOptativasParaAprobar(Integer cantMateriasOptativasParaAprobar) {
        this.cantMateriasOptativasParaAprobar = cantMateriasOptativasParaAprobar;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCodigoCarrera(Long codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }
}
