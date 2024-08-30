package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Model.ModelAlumno;
import com.milton.gomez.sistema.universitario.Model.ModelControladorUniversitario;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author milton
 */
public class ControllerAlumnos {
    private static ModelControladorUniversitario cu = ModelControladorUniversitario.getInstance();
    
    public static DefaultTableModel listarTodosLosAlumnos(JTable Alumnos_Table){
        
        // "ID", "Legajo", "DNI", "Nombre", "Apellido", "Carrera"
        DefaultTableModel model = (DefaultTableModel)Alumnos_Table.getModel();
        model.setRowCount(0);
        
        cu.obtenerAlumnos()
                .forEach((u) -> model
                        .addRow(new Object[]{
                            u.getAlumnoID(),
                            u.getLegajo(), 
                            u.getDni(), 
                            u.getNombre(), 
                            u.getApellido(), 
                            u.getCarrera().getNombre()}));
        
        return model;
    }
    
    public static ModelAlumno obtenerAlumnoPorID(Integer alumnoID){
        return cu.getAlumnos().get(alumnoID);
    }
    
    public static DefaultTableModel obtenerAlumnoPorDNI(JTable Alumnos_Table, JTextField Alumno_TextField){
        
        DefaultTableModel model = (DefaultTableModel)Alumnos_Table.getModel();
        
        model.setRowCount(0);
        
        try{
            ModelAlumno a = getAlumnoPorDNI(Long.valueOf(Alumno_TextField.getText()));
            model.addRow(new Object[]{
            a.getAlumnoID(),
            a.getLegajo(), 
            a.getDni(), 
            a.getNombre(), 
            a.getApellido(), 
            a.getCarrera().getNombre()
        });
        }
        catch(NumberFormatException e){
            System.out.println("El dato introducido no es un numero");
        }
        catch(NullPointerException e){
            System.out.println("No se encuentra el Alumno");
        }
        
        return model;
    }
    
    public static ModelAlumno getAlumnoPorDNI(Long alumnoDNI){
        for (ModelAlumno alumno : cu.obtenerAlumnos()) {
            if (alumno.getDni().equals(alumnoDNI)) {
                return alumno;
            }
        }
        return null;
    }
    
    public static ModelAlumno obtenerAlumnoPorLegajo(Long alumnoLegajo){
        for (ModelAlumno alumno : cu.obtenerAlumnos()) {
            if (alumno.getLegajo().equals(alumnoLegajo)) {
                return alumno;
            }
        }
        return null;
    }
    
    public static void eliminarAlumno(Integer alumnoID){
        cu.eliminarAlumno(alumnoID);
    }
}
