/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Iniciador;

import com.milton.gomez.sistema.universitario.Model.ControladorUniversitario;

/**
 *
 * @author milton
 */
public class IniciadorMaterias {
    public static void inicializarMaterias(){
        ControladorUniversitario controlador = ControladorUniversitario.getInstance();
        
        
        //Crea el primer cuatrimestre de la carrera Sistemas.
        controlador.obtenerCarreras().get(0).crearCuatrimestre();
        
        controlador.obtenerCarreras().get(0).getCuatrimestres().get(0).addMateriaObligatoria(
                controlador.crearMateria("FEO1", "Algebra", Boolean.TRUE, null));
        
        controlador.obtenerCarreras().get(0).getCuatrimestres().get(0).addMateriaObligatoria(
                controlador.crearMateria("FEO2", "Programacion 0", Boolean.TRUE, null));
        
        controlador.obtenerCarreras().get(0).getCuatrimestres().get(0).addMateriaObligatoria(
                controlador.crearMateria("FEO3", "Elementos de Info.", Boolean.TRUE, null));
        
    }
    
    
}
