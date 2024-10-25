package com.milton.gomez.sistema.universitario.Transferible;

import com.milton.gomez.sistema.universitario.Model.Alumno;
import com.milton.gomez.sistema.universitario.Model.Cuatrimestre;
import com.milton.gomez.sistema.universitario.Model.PlanDeEstudio;

import java.util.List;

public class TransferibleCarreraCrear {
    private String nombre;
    private String codigoCarrera;
    private Integer cantMateriasOptativasParaAprobar;
    private List<TransferibleCuatrimestre> cuatrimestres;
    private PlanDeEstudio planDeEstudio;

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

    public List<TransferibleCuatrimestre> getCuatrimestres() {
        return cuatrimestres;
    }

    public void setCuatrimestres(List<TransferibleCuatrimestre> cuatrimestres) {
        this.cuatrimestres = cuatrimestres;
    }
}
