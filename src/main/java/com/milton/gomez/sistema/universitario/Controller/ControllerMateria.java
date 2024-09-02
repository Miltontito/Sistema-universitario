/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Model.ControladorUniversitario;
import com.milton.gomez.sistema.universitario.Model.Materia;
import java.util.List;

/**
 *
 * @author milton
 */
public class ControllerMateria {
    //Inicialización del controlador.
    private static ControladorUniversitario cu = ControladorUniversitario.getInstance();
    
    
    public static List<Materia> listarTodasLasMaterias(){
        return cu.getMaterias();
    }
    
    public static List<Materia> listarCorrelativas(Integer carreraID){
        return cu.getMaterias().get(carreraID).getCorrelativas();
    }
    
    public static void eliminarCarrera(Integer materiaID){
        cu.eliminarMateria(materiaID);
    }
}
