/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Model.ModelControladorUniversitario;
import com.milton.gomez.sistema.universitario.Model.ModelMateria;
import java.util.List;

/**
 *
 * @author milton
 */
public class ControllerMaterias {
    //Inicialización del controlador.
    private static ModelControladorUniversitario cu = ModelControladorUniversitario.getInstance();
    
    
    public static List<ModelMateria> listarTodasLasMaterias(){
        return cu.getMaterias();
    }
    
    public static List<ModelMateria> listarCorrelativas(Integer carreraID){
        return cu.getMaterias().get(carreraID).getCorrelativas();
    }
    
    public static void eliminarCarrera(Integer materiaID){
        cu.eliminarMateria(materiaID);
    }
}
