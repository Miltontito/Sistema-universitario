package com.milton.gomez.sistema.universitario.Transferible;

import com.milton.gomez.sistema.universitario.Model.Alumno;
import com.milton.gomez.sistema.universitario.Model.Cuatrimestre;
import com.milton.gomez.sistema.universitario.Model.PlanDeEstudio;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author milton
 */
public class TransferibleCarrera {
    private Integer id;
    private String nombre;
    private String codigoCarrera;
    private Integer cantMateriasOptativasParaAprobar;
    private HashMap<Integer,Cuatrimestre> cuatrimestres;
    private PlanDeEstudio planDeEstudio;
    private List<Alumno> alumnos;

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

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public Integer getCantMateriasOptativasParaAprobar() {
        return cantMateriasOptativasParaAprobar;
    }

    public void setCantMateriasOptativasParaAprobar(Integer cantMateriasOptativasParaAprobar) {
        this.cantMateriasOptativasParaAprobar = cantMateriasOptativasParaAprobar;
    }

    public PlanDeEstudio getPlanDeEstudio() {
        return planDeEstudio;
    }

    public void setPlanDeEstudio(PlanDeEstudio planDeEstudio) {
        this.planDeEstudio = planDeEstudio;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public HashMap<Integer, Cuatrimestre> getCuatrimestres() {
        return cuatrimestres;
    }

    public void setCuatrimestres(HashMap<Integer, Cuatrimestre> cuatrimestres) {
        this.cuatrimestres = cuatrimestres;
    }

    
    
    
}
