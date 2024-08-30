/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Model.ModelControladorUniversitario;
import java.util.List;
import com.milton.gomez.sistema.universitario.Model.ModelPlanDeEstudio;

/**
 *
 * @author miltongomez
 */
public class ControllerPlanesDeEstudio {
    //Inicialización del controlador.
    private static ModelControladorUniversitario cu = ModelControladorUniversitario.getInstance();
    
    public static List<ModelPlanDeEstudio> listarTodosLosPlaneDeEstudio(){
        return cu.getPlanesDeEstudios();
    }
}
