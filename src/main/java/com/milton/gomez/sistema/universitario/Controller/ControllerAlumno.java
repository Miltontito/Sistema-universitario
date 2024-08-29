package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Iniciador.IniciadorAlumno;
import com.milton.gomez.sistema.universitario.Model.Alumno;
import com.milton.gomez.sistema.universitario.Model.ControladorUniversitario;
import java.util.List;

/**
 *
 * @author milton
 */
public class ControllerAlumno {
    private static ControladorUniversitario cu = IniciadorAlumno.inicializarAlumnos();
    
    public static List<Alumno> listarTodosLosAlumnos(){
        return cu.obtenerAlumnos();
    }
    
}
