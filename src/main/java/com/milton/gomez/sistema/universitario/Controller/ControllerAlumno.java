package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Model.Alumno;
import com.milton.gomez.sistema.universitario.Model.Carrera;
import com.milton.gomez.sistema.universitario.Model.ControladorUniversitario;
import com.milton.gomez.sistema.universitario.Model.Cursada;
import com.milton.gomez.sistema.universitario.Model.Materia;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleAlumno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author milton
 */
public class ControllerAlumno {
    private static ControladorUniversitario cu = ControladorUniversitario.getInstance();
    
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
    
    public static List<TransferibleAlumno> listarTodosLosAlumnos1(){
        List<TransferibleAlumno> alumnos = new ArrayList<>();
        for(Alumno alumno : cu.getAlumnos()){
            TransferibleAlumno transferible = new TransferibleAlumno();
            transferible.setId(alumno.getAlumnoID());
            transferible.setLegajo(alumno.getLegajo());
            transferible.setDni(alumno.getDni());
            transferible.setNombre(alumno.getNombre());
            transferible.setApellido(alumno.getApellido());
            //transferible.setCarrera(alumno.getCarrera());
        }
        
        return alumnos;
    }
    
    
    public static TransferibleAlumno obtenerDatosDeAlumno(Integer id){
        TransferibleAlumno transferible = new TransferibleAlumno();
        try{
            Alumno a = getAlumnoPorID(id);
            transferible.setId(a.getAlumnoID());
            transferible.setLegajo(a.getLegajo());
            transferible.setDni(a.getDni());
            transferible.setApellido(a.getApellido());
            transferible.setNombre(a.getNombre());
            transferible.setCursadas(a.getCursadas());
            transferible.setCarrera(a.getCarrera());
            return transferible;
        }
        catch(NullPointerException e){
            System.out.println("No se encuentra el Alumno");
        }
        return transferible;
    }
    private static Alumno getAlumnoPorID(Integer alumnoID){
        return cu.getAlumnos().get(alumnoID);
    }
    
    
    public static DefaultTableModel obtenerAlumnoPorDNI(JTable Alumnos_Table, JTextField Alumno_TextField){
        
        DefaultTableModel model = (DefaultTableModel)Alumnos_Table.getModel();
        
        model.setRowCount(0);
        
        try{
            Alumno a = getAlumnoPorDNI(Long.valueOf(Alumno_TextField.getText()));
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
    private static Alumno getAlumnoPorDNI(Long alumnoDNI){
        for (Alumno alumno : cu.obtenerAlumnos()) {
            if (alumno.getDni().equals(alumnoDNI)) {
                return alumno;
            }
        }
        return null;
    }

    
    
    public static DefaultListModel obtenerMateriasCursando(Integer id, JList lista){
        // Obtenemos el modelo de la JList materias
        DefaultListModel model = (DefaultListModel) lista.getModel();
        Alumno a = getAlumnoPorID(id);
        
        model.addAll(a.obtenerMateriasQueCursa());
        
        return model;
    }
    public static DefaultListModel obtenerMateriasAprobadas(Integer id, JList lista){
        // Obtenemos el modelo de la JList materias
        DefaultListModel model = (DefaultListModel) lista.getModel();
        
        Alumno a = getAlumnoPorID(id);
        
        model.addAll(a.obtenerMateriasAprobadas());
        
        return model;
    }
    public static DefaultListModel obtenerMateriasQuePuedeCursar(Integer id, JList lista){
        // Obtenemos el modelo de la JList materias
        DefaultListModel model = (DefaultListModel) lista.getModel();
        
        Alumno a = getAlumnoPorID(id);
        
        model.addAll(a.obtenerMateriasQuePuedeCursar());
        
        return model;
    }
    
    public static List<Materia> listarMateriasQuePuedeCursar(Integer alumnoID){
        return cu.getAlumnos().get(alumnoID).obtenerMateriasQuePuedeCursar();
    }
    
    
    
    public static DefaultTableModel obtenerAlumnoPorLegajo(JTable Alumnos_Table, JTextField Alumno_TextField){
        DefaultTableModel model = (DefaultTableModel)Alumnos_Table.getModel();
        model.setRowCount(0);
        try{
            Alumno a = getAlumnoPorLegajo(Long.valueOf(Alumno_TextField.getText()));
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
    private static Alumno getAlumnoPorLegajo(Long alumnoLegajo){
        for (Alumno alumno : cu.obtenerAlumnos()) {
            if (alumno.getLegajo().equals(alumnoLegajo)) {
                return alumno;
            }
        }
        return null;
    }
    
    public static void asignarMaterias(Integer id, List<Materia> materias){
        Alumno a = getAlumnoPorID(id);
        a.setMaterias(materias);
    }
    
    public static void eliminarAlumno(Integer alumnoID){
        cu.eliminarAlumno(alumnoID);
    }
    public static void crearAlumno(JPanel panel,JTextField legajo_Text, JTextField dni_Text, JTextField nombre_Text, JTextField apellido_Text, JList carreras_List, JTable materias_Table){
        
        Long legajo = Long.valueOf(legajo_Text.getText());
        Long dni = Long.valueOf(dni_Text.getText());
        String nombre = nombre_Text.getText();
        String apellido = apellido_Text.getText();
        Carrera carrera = (Carrera) carreras_List.getSelectedValue();
        List<Materia> materias = new ArrayList<>();

        int[] filasSeleccionadas = materias_Table.getSelectedRows();
        for (int i = 0; i < filasSeleccionadas.length; i++) {
            int fila = filasSeleccionadas[i];
            materias.add((Materia) materias_Table.getValueAt(fila, 1));
        }

        cu.crearAlumno(nombre, apellido, legajo, dni, carrera, materias);
        javax.swing.JOptionPane.showMessageDialog(panel, "El alumno fue creado con éxito. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void actualizarAlumno(TransferibleAlumno alumno){
        Alumno alumnoFinal = new Alumno();
        alumnoFinal.setId(alumno.getId());
        alumnoFinal.setLegajo(alumno.getLegajo());
        alumnoFinal.setDni(alumno.getDni());
        alumnoFinal.setNombre(alumno.getNombre());
        alumnoFinal.setApellido(alumno.getApellido());
        alumnoFinal.setCarrera(alumno.getCarrera());
        alumnoFinal.setCursadas(alumno.getCursadas());
        
        cu.actualizarAlumno(alumnoFinal);
    }
    
    public static void inscribirAlumno(Integer id, List<Materia> materias){
        for(Materia m : materias){
            cu.getAlumnos().get(id).inscribirseAMateria(m);
        }
    }
}
