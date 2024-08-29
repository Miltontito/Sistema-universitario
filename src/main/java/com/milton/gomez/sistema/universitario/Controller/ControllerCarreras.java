/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Model.Carrera;
import com.milton.gomez.sistema.universitario.Model.ControladorUniversitario;
import com.milton.gomez.sistema.universitario.Model.Cuatrimestre;
import java.util.List;

/**
 *
 * @author milton
 */
public class ControllerCarreras {
    private static ControladorUniversitario cu = ControladorUniversitario.getInstance();
    
    public static List<Carrera> listarTodasLasCarreras(){
        return cu.getCarreras();
    }
    
    public static Cuatrimestre retornarCuatrimestre(Integer carreraID,Integer cuatrimestreID){
        return cu.getCarreras().get(carreraID).getCuatrimestres().get(cuatrimestreID);
    }
}
