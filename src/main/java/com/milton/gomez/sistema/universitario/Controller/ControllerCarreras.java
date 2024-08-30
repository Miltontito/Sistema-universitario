/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Iniciador.IniciadorCompleto;
import com.milton.gomez.sistema.universitario.Model.ModelCarrera;
import com.milton.gomez.sistema.universitario.Model.ModelControladorUniversitario;
import com.milton.gomez.sistema.universitario.Model.ModelCuatrimestre;
import com.milton.gomez.sistema.universitario.Model.ModelMateria;
import java.util.List;

/**
 *
 * @author milton
 */
public class ControllerCarreras {
    
    //Inicialización del controlador.
    private static ModelControladorUniversitario cu = ModelControladorUniversitario.getInstance();
    
    
    public static List<ModelCarrera> listarTodasLasCarreras(){
        return cu.getCarreras();
    }
    
    public static List<ModelCuatrimestre> listarTodosLosCuatrimestres(Integer carreraID){
        return cu.getCarreras().get(carreraID).getCuatrimestres();
    }
    
    public static ModelCuatrimestre listarCuatrimestre(Integer carreraID, Integer cuatrimestreID){
        return cu.getCarreras().get(carreraID).getCuatrimestres().get(cuatrimestreID);
    }
    
    public static List<ModelMateria> listarMateriasDeLaCarrera(Integer carreraID){
        cu.getCarreras().get(carreraID).getCuatrimestres().forEach((c) -> System.out.print(c.getCuatrimestreID()));
        return cu.getCarreras().get(carreraID).obtenerMateriasDeLaCarrera();
    }
    
    public static void eliminarCarrera(Integer carreraID){
        cu.eliminarCarrera(carreraID);
    }
}
