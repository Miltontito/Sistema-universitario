/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Transformador;

import com.milton.gomez.sistema.universitario.Model.Alumno;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleAlumno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class TransformadorAlumno {
    
    public static TransferibleAlumno toTransferible(Alumno alumno) {
        TransferibleAlumno transferible = new TransferibleAlumno();
        transferible.setId(alumno.getAlumnoID());
        transferible.setLegajo(alumno.getLegajo());
        transferible.setDni(alumno.getDni());
        transferible.setNombre(alumno.getNombre());
        transferible.setApellido(alumno.getApellido());
        transferible.setCarrera(TransformadorCarrera.toTransferible(alumno.getCarrera()));
        transferible.setCursadas(TransformadorCursada.toTransferibleList(alumno.getCursadas())); // Corrigiendo aquí
        return transferible;
    } 

    public static List<TransferibleAlumno> toTransferibleList(List<Alumno> alumnos) {
        List<TransferibleAlumno> transferibles = new ArrayList<>();
        for (Alumno alumno : alumnos) {
            transferibles.add(toTransferible(alumno));
        }
        return transferibles;
    }

    public static Alumno toModel(TransferibleAlumno transferible) {
        Alumno alumno = new Alumno();
        alumno.setLegajo(transferible.getLegajo());
        alumno.setDni(transferible.getDni());
        alumno.setNombre(transferible.getNombre());
        alumno.setApellido(transferible.getApellido());
        alumno.setCarrera(TransformadorCarrera.toModel(transferible.getCarrera()));
        alumno.setCursadas(TransformadorCursada.toModelList(transferible.getCursadas())); // Corrigiendo aquí
        return alumno;
    }

    public static List<Alumno> toModelList(List<TransferibleAlumno> transferibles) {
        List<Alumno> alumnos = new ArrayList<>();
        for (TransferibleAlumno transferible : transferibles) {
            alumnos.add(toModel(transferible));
        }
        return alumnos;
    }
}

