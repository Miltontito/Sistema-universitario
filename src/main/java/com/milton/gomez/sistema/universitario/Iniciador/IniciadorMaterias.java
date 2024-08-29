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
        controlador.crearMateria("FEO12", "Algebra", Boolean.TRUE, null);
    }
    
    
}
