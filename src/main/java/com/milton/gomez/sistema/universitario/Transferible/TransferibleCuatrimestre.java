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
public class TransferibleCuatrimestre {
    private List<Materia> materiasObligatorias;
    private List<Materia> materiasOptativas;

    public List<Materia> getMateriasObligatorias() {
        return materiasObligatorias;
    }

    public void setMateriasObligatorias(List<Materia> materiasObligatorias) {
        this.materiasObligatorias = materiasObligatorias;
    }

    public List<Materia> getMateriasOptativas() {
        return materiasOptativas;
    }

    public void setMateriasOptativas(List<Materia> materiasOptativas) {
        this.materiasOptativas = materiasOptativas;
    }
}
