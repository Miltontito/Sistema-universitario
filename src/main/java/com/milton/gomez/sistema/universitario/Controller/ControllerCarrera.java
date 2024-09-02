/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Iniciador.IniciadorCompleto;
import com.milton.gomez.sistema.universitario.Model.Carrera;
import com.milton.gomez.sistema.universitario.Model.ControladorUniversitario;
import com.milton.gomez.sistema.universitario.Model.Cuatrimestre;
import com.milton.gomez.sistema.universitario.Model.Materia;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleCarrera;
import com.milton.gomez.sistema.universitario.Transformador.TransformadorCarrera;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class ControllerCarrera {
    
    //Inicialización del controlador.
    private static ControladorUniversitario cu = ControladorUniversitario.getInstance();
    
    public static List<TransferibleCarrera> listarTodasLasCarreras(){
        List<TransferibleCarrera> carreras = TransformadorCarrera.toTransferibleList(cu.getCarreras());
        return carreras;
    }
    
    public static TransferibleCarrera obtenerCarreraPorId(Integer id){
        return TransformadorCarrera.toTransferible(cu.getCarreras().get(id));
    }
    
    public static List<Cuatrimestre> listarTodosLosCuatrimestres(Integer carreraID){
        return cu.getCarreras().get(carreraID).getCuatrimestres();
    }
    
    public static Cuatrimestre listarCuatrimestre(Integer carreraID, Integer cuatrimestreID){
        return cu.getCarreras().get(carreraID).getCuatrimestres().get(cuatrimestreID);
    }
    
    public static List<Materia> listarMateriasDeLaCarrera(Integer carreraID){
        cu.getCarreras().get(carreraID).getCuatrimestres().forEach((c) -> System.out.print(c.getCuatrimestreID()));
        return cu.getCarreras().get(carreraID).obtenerMateriasDeLaCarrera();
    }
    
    public static void eliminarCarrera(Integer carreraID){
        cu.eliminarCarrera(carreraID);
    }
}