/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Transformador;

import com.milton.gomez.sistema.universitario.Model.Cuatrimestre;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleCuatrimestre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class TransformadorCuatrimestre {

    public static TransferibleCuatrimestre toTransferible(Cuatrimestre cuatrimestre) {
        TransferibleCuatrimestre transferible = new TransferibleCuatrimestre();
        transferible.setId(cuatrimestre.getCuatrimestreID());
        transferible.setMateriasObligatorias(TransformadorMateria.toTransferibleList(cuatrimestre.listarMateriasObligatorias()));
        transferible.setMateriasOptativas(TransformadorMateria.toTransferibleList(cuatrimestre.listarMateriasObligatorias()));
        return transferible;
    }

    public static List<TransferibleCuatrimestre> toTransferibleList(List<Cuatrimestre> cuatrimestres) {
        List<TransferibleCuatrimestre> transferibles = new ArrayList<>();
        for (Cuatrimestre cuatrimestre : cuatrimestres) {
            transferibles.add(toTransferible(cuatrimestre));
        }
        return transferibles;
    }

    public static Cuatrimestre toModel(TransferibleCuatrimestre transferible) {
        Cuatrimestre cuatrimestre = new Cuatrimestre();
        cuatrimestre.setMateriasObligatorias(TransformadorMateria.toModelList(transferible.getMateriasObligatorias()));
        cuatrimestre.setMateriasOptativas(TransformadorMateria.toModelList(transferible.getMateriasOptativas()));
        return cuatrimestre;
    }

    public static List<Cuatrimestre> toModelList(List<TransferibleCuatrimestre> transferibles) {
        List<Cuatrimestre> cuatrimestres = new ArrayList<>();
        for (TransferibleCuatrimestre transferible : transferibles) {
            cuatrimestres.add(toModel(transferible));
        }
        return cuatrimestres;
    }
}

