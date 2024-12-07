package com.milton.gomez.sistema.universitario.Iniciador;

import com.milton.gomez.sistema.universitario.Model.Alumno;
import com.milton.gomez.sistema.universitario.Model.Carrera;
import com.milton.gomez.sistema.universitario.Model.ControladorUniversitario;
import com.milton.gomez.sistema.universitario.Model.Cuatrimestre;
import com.milton.gomez.sistema.universitario.Model.Materia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miltongomez
 */
public class IniciadorCompleto {
    
    public static ControladorUniversitario inicializarPlanesDeEstudio(){
        ControladorUniversitario controlador = ControladorUniversitario.getInstance();
        
        controlador.crearPlanesDeEstudio();
        
        return controlador;
    }
    
    public static ControladorUniversitario inicializarAlumnos(){
        ControladorUniversitario controlador = ControladorUniversitario.getInstance();
        
        controlador.crearAlumno("Milton", "Gómez", Long.valueOf("445760"), Long.valueOf("44576730"), new Carrera("Sistemas", "A1",0, controlador.obtenerPlanesDeEstudios().get(0)), new ArrayList<>());
        System.out.println("Se crean alumnos con carreras");

        //Almacena las carreras creadas por los usuarios
        controlador.obtenerAlumnos().forEach((a) -> controlador.agregarCarrera(a.getCarrera()));
        System.out.println("Se almacenan las carreras creadas por alumno.");

        //Inscribe a los alumnos a las carreras que crearon.
        controlador.obtenerAlumnos().forEach((a) -> a.getCarrera().inscribirAlumno(a));
        System.out.println("Se inscriben los alumnos correspondientes a sus carreras.");
        return controlador;
    }
    
    public static ControladorUniversitario inicializarMaterias(){
        ControladorUniversitario controlador = ControladorUniversitario.getInstance();
        System.out.println("Desde InciciadorCompleto/InicializarMaterias se crea o usa el ControladorUniversitario");
        
        controlador.obtenerCarreras().forEach((c) -> c.crearCuatrimestre());
        System.out.println("Por cada Carrera en el controlador se crean cuatrimestres.");
        
        //Creo un cuatrimestre extra para sistemas
        controlador.obtenerCarreras().get(0).crearCuatrimestre();
        
        controlador.obtenerCarreras().get(0).getCuatrimestres().get(0).addMateriaObligatoria(
                controlador.crearMateria("FEO1", "Algebra", Boolean.TRUE, null));
        
        controlador.obtenerCarreras().get(0).getCuatrimestres().get(0).addMateriaObligatoria(
                controlador.crearMateria("FEO2", "Expresión de problemas y algoritmos", Boolean.TRUE, null));
        
        controlador.obtenerCarreras().get(0).getCuatrimestres().get(0).addMateriaObligatoria(
                controlador.crearMateria("FEO3", "Elementos de Informatica", Boolean.TRUE, null));
        
        List<Materia> materia = new ArrayList<>();
        materia.add(controlador.obtenerCarreras().get(0).getCuatrimestres().get(0).getMateriasObligatorias().get(0));
        
        controlador.obtenerCarreras().get(0).getCuatrimestres().get(1).addMateriaObligatoria(
                controlador.crearMateria("FEO4", "Algoritmica y Programación I", Boolean.TRUE, materia));
        System.out.println("Se crean materias y se asignan al cuatrimestre respectivo de las carreras");
        return controlador;
        
    }
    
    public static ControladorUniversitario asignarMaterias(){
        
        ControladorUniversitario controlador = ControladorUniversitario.getInstance();
        
        //Obtiene el primer cuatrimestre de sistemas.
        Cuatrimestre cuatrimestre0_Sistemas = controlador.obtenerCarreras().get(0).getCuatrimestres().get(0);
        
        //Obtiene el primer alumno (el cual cursa sistemas)
        Alumno alumno = controlador.obtenerAlumno(0);
        
        //Agrega las materias del primer cuatrimestre en el alumno
        alumno.setMaterias(cuatrimestre0_Sistemas.listarTodasLasMaterias());
        
        //Apruebo al alumno en la primera materia
        alumno.getCursadas().get(0).aprobarMateria(Boolean.TRUE);
        
        return controlador;
    }
}
