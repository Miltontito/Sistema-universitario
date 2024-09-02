/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Model.ControladorUniversitario;
import java.util.List;
import com.milton.gomez.sistema.universitario.Model.PlanDeEstudio;

/**
 *
 * @author miltongomez
 */
public class ControllerPlanDeEstudio {
    //Inicialización del controlador.
    private static ControladorUniversitario cu = ControladorUniversitario.getInstance();
    
    public static List<PlanDeEstudio> listarTodosLosPlaneDeEstudio(){
        return cu.getPlanesDeEstudios();
    }
}
