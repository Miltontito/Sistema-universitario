/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Transferible;

import java.util.List;

/**
 *
 * @author milton
 */
public class TransferibleCuatrimestre {
    private Integer id;
    private List<TransferibleMateria> materiasObligatorias;
    private List<TransferibleMateria> materiasOptativas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TransferibleMateria> getMateriasObligatorias() {
        return materiasObligatorias;
    }

    public void setMateriasObligatorias(List<TransferibleMateria> materiasObligatorias) {
        this.materiasObligatorias = materiasObligatorias;
    }

    public List<TransferibleMateria> getMateriasOptativas() {
        return materiasOptativas;
    }

    public void setMateriasOptativas(List<TransferibleMateria> materiasOptativas) {
        this.materiasOptativas = materiasOptativas;
    }
    
    
}
