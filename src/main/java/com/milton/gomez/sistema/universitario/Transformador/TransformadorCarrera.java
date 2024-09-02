package com.milton.gomez.sistema.universitario.Transformador;

import com.milton.gomez.sistema.universitario.Model.Carrera;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleCarrera;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class TransformadorCarrera {
    
    public static TransferibleCarrera toTransferible(Carrera carrera){
        TransferibleCarrera transferible = new TransferibleCarrera();
        transferible.setId(carrera.getCarreraID());
        transferible.setCodigoCarrera(carrera.getCodigoCarrera());
        transferible.setCantMateriasOptativasParaAprobar(carrera.getCantMateriasOptativasParaAprobar());
        transferible.setNombre(carrera.getNombre());
        transferible.setPlanDeEstudio(carrera.getPlanDeEstudio());
        transferible.setAlumnos(TransformadorAlumno.toTransferibleList(carrera.getAlumnos()));
        transferible.setCuatrimestres(TransformadorCuatrimestre.toTransferibleList(carrera.getCuatrimestres()));
        return transferible;
    }
    
    public static List<TransferibleCarrera> toTransferibleList(List<Carrera> carreras) {
        List<TransferibleCarrera> transferibles = new ArrayList<>();
        for (Carrera carrera : carreras) {
            transferibles.add(toTransferible(carrera));
        }
        return transferibles;
    }
    
    public static Carrera toModel(TransferibleCarrera transferible) {
        Carrera carrera = new Carrera();
        carrera.setCodigoCarrera(transferible.getCodigoCarrera());
        carrera.setCantMateriasOptativasParaAprobar(transferible.getCantMateriasOptativasParaAprobar());
        carrera.setNombre(transferible.getNombre());
        carrera.setPlanDeEstudio(transferible.getPlanDeEstudio());
        carrera.setAlumnos(TransformadorAlumno.toModelList(transferible.getAlumnos()));
        carrera.setCuatrimestres(TransformadorCuatrimestre.toModelList(transferible.getCuatrimestres()));
        return carrera;
    }

    public static List<Carrera> toModelList(List<TransferibleCarrera> transferibles) {
        List<Carrera> carreras = new ArrayList<>();
        for (TransferibleCarrera transferible : transferibles) {
            carreras.add(toModel(transferible));
        }
        return carreras;
    }
}
