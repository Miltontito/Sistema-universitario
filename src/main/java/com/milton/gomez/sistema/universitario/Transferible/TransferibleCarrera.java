package com.milton.gomez.sistema.universitario.Transferible;

import com.milton.gomez.sistema.universitario.Model.PlanDeEstudio;
import java.util.List;

/**
 *
 * @author milton
 */
public class TransferibleCarrera {
    private Integer id;
    private String nombre;
    private Long codigoCarrera;
    private Integer cantMateriasOptativasParaAprobar;
    private List<TransferibleCuatrimestre> cuatrimestres;
    private PlanDeEstudio planDeEstudio;
    private List<TransferibleAlumno> alumnos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(Long codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public Integer getCantMateriasOptativasParaAprobar() {
        return cantMateriasOptativasParaAprobar;
    }

    public void setCantMateriasOptativasParaAprobar(Integer cantMateriasOptativasParaAprobar) {
        this.cantMateriasOptativasParaAprobar = cantMateriasOptativasParaAprobar;
    }

    public List<TransferibleCuatrimestre> getCuatrimestres() {
        return cuatrimestres;
    }

    public void setCuatrimestres(List<TransferibleCuatrimestre> cuatrimestres) {
        this.cuatrimestres = cuatrimestres;
    }

    public PlanDeEstudio getPlanDeEstudio() {
        return planDeEstudio;
    }

    public void setPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        this.planDeEstudio = planDeEstudio;
    }

    public List<TransferibleAlumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<TransferibleAlumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    
}
