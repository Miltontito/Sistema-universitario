/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Transformador;

import com.milton.gomez.sistema.universitario.Model.Cursada;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleCursada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class TransformadorCursada {

    public static TransferibleCursada toTransferible(Cursada cursada) {
        TransferibleCursada transferible = new TransferibleCursada();
        transferible.setMateria(TransformadorMateria.toTransferible(cursada.getMateria()));
        transferible.setCursadaAprobada(cursada.getCursadaAprobada());
        transferible.setMateriaAprobada(cursada.getMateriaAprobada());
        transferible.setCursando(cursada.getCursando());
        return transferible;
    }

    public static List<TransferibleCursada> toTransferibleList(List<Cursada> cursadas) {
        List<TransferibleCursada> transferibles = new ArrayList<>();
        for (Cursada cursada : cursadas) {
            transferibles.add(toTransferible(cursada));
        }
        return transferibles;
    }

    public static Cursada toModel(TransferibleCursada transferible) {
        Cursada cursada = new Cursada();
        cursada.setMateria(TransformadorMateria.toModel(transferible.getMateria()));
        cursada.setCursadaAprobada(transferible.getCursadaAprobada());
        cursada.setMateriaAprobada(transferible.getMateriaAprobada());
        cursada.setCursando(transferible.getCursando());
        return cursada;
    }

    public static List<Cursada> toModelList(List<TransferibleCursada> transferibles) {
        List<Cursada> cursadas = new ArrayList<>();
        for (TransferibleCursada transferible : transferibles) {
            cursadas.add(toModel(transferible));
        }
        return cursadas;
    }
}
   

