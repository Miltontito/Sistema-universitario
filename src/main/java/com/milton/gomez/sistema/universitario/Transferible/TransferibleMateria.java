/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Transferible;

import com.milton.gomez.sistema.universitario.Model.Materia;

import java.util.List;

/**
 *
 * @author milton
 */
public class TransferibleMateria {
    private Integer materiaID;
    private String codigoDeMateria;
    private String nombre;
    private Boolean promocionable;
    private List<Materia> correlativas;

    // Getters y setters
    public Integer getMateriaID() {
        return materiaID;
    }

    public void setMateriaID(Integer materiaID) {
        this.materiaID = materiaID;
    }

    public String getCodigoDeMateria() {
        return codigoDeMateria;
    }

    public void setCodigoDeMateria(String codigoDeMateria) {
        this.codigoDeMateria = codigoDeMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getPromocionable() {
        return promocionable;
    }

    public void setPromocionable(Boolean promocionable) {
        this.promocionable = promocionable;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }
}
