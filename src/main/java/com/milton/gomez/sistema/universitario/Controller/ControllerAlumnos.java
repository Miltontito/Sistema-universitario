package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Model.Alumno;
import com.milton.gomez.sistema.universitario.Model.ControladorUniversitario;
import java.util.List;

/**
 *
 * @author milton
 */
public class ControllerAlumnos {
    private static ControladorUniversitario cu = ControladorUniversitario.getInstance();
    
    public static List<Alumno> listarTodosLosAlumnos(){
        return cu.obtenerAlumnos();
    }
    
    public static Alumno obtenerAlumnoPorID(Integer alumnoID){
        return cu.getAlumnos().get(alumnoID);
    }
    
    public static Alumno obtenerAlumnoPorDNI(Long alumnoDNI){
        for (Alumno alumno : cu.obtenerAlumnos()) {
            if (alumno.getDni().equals(alumnoDNI)) {
                return alumno;
            }
        }
        return null;
    }
    
    public static Alumno obtenerAlumnoPorLegajo(Long alumnoLegajo){
        for (Alumno alumno : cu.obtenerAlumnos()) {
            if (alumno.getLegajo().equals(alumnoLegajo)) {
                return alumno;
            }
        }
        return null;
    }
    
}
