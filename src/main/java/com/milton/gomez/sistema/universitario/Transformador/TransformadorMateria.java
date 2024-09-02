/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Transformador;

import com.milton.gomez.sistema.universitario.Model.Materia;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleMateria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class TransformadorMateria {

    public static TransferibleMateria toTransferible(Materia materia) {
        TransferibleMateria transferible = new TransferibleMateria();
        transferible.setMateriaID(materia.getMateriaID());
        transferible.setCodigoDeMateria(materia.getCodigoDeMateria());
        transferible.setNombre(materia.getNombre());
        transferible.setPromocionable(materia.isPromocionable());
        transferible.setCorrelativas(toTransferibleList(materia.getCorrelativas()));
        return transferible;
    }

    public static List<TransferibleMateria> toTransferibleList(List<Materia> correlativas) {
        List<TransferibleMateria> transferibles = new ArrayList<>();
        for (Materia correlativa : correlativas) {
            transferibles.add(toTransferible(correlativa));
        }
        return transferibles;
    }

    public static Materia toModel(TransferibleMateria transferible) {
        Materia materia = new Materia();
        materia.setCodigoDeMateria(transferible.getCodigoDeMateria());
        materia.setNombre(transferible.getNombre());
        materia.esPromocionable(transferible.getPromocionable());
        materia.setCorrelativas(toModelList(transferible.getCorrelativas()));
        return materia;
    }

    public static List<Materia> toModelList(List<TransferibleMateria> transferibles) {
        List<Materia> correlativas = new ArrayList<>();
        for (TransferibleMateria transferible : transferibles) {
            correlativas.add(toModel(transferible));
        }
        return correlativas;
    }
}

