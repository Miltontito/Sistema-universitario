package com.milton.gomez.sistema.universitario.Iniciador;

import com.milton.gomez.sistema.universitario.Model.Carrera;
import com.milton.gomez.sistema.universitario.Model.ControladorUniversitario;
import com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio.PlanA;

/**
 *
 * @author miltongomez
 */
public class IniciadorCompleto {
    
    public static ControladorUniversitario inicializarAlumnos(){
        ControladorUniversitario controlador = ControladorUniversitario.getInstance();
        
        controlador.crearAlumno("Milton", "Gómez", Long.valueOf("445760"), Long.valueOf("44576730"), new Carrera("Sistemas", Long.parseLong("123"),0,new PlanA()));
        controlador.crearAlumno("Laura", "Pérez", Long.valueOf("445770"), Long.valueOf("44576731"), new Carrera("Medios"));
        controlador.crearAlumno("Carlos", "Rodríguez", Long.valueOf("445780"), Long.valueOf("44576732"), new Carrera("Sociologia"));
        controlador.crearAlumno("Ana", "Martínez", Long.valueOf("445790"), Long.valueOf("44576733"), new Carrera("Ciencia politica"));
        controlador.crearAlumno("Juan", "Fernández", Long.valueOf("445800"), Long.valueOf("44576734"), new Carrera("Gestion"));
        controlador.crearAlumno("María", "López", Long.valueOf("445810"), Long.valueOf("44576735"), new Carrera("Geologia"));
        controlador.crearAlumno("Jorge", "Sánchez", Long.valueOf("445820"), Long.valueOf("44576736"), new Carrera("Abogacia"));
        controlador.crearAlumno("Patricia", "Romero", Long.valueOf("445830"), Long.valueOf("44576737"), new Carrera("Criminologia"));
        controlador.crearAlumno("Luis", "Díaz", Long.valueOf("445840"), Long.valueOf("44576738"), new Carrera("Psicologia"));
        controlador.crearAlumno("Sofía", "Gutiérrez", Long.valueOf("445850"), Long.valueOf("44576739"), new Carrera("Bromatologia"));
        System.out.println("Se crean alumnos con carreras");
        //Almacena las carreras creadas por los usuarios
        controlador.obtenerAlumnos().forEach((a) -> controlador.agregarCarrera(a.getCarrera()));
        System.out.println("Se almacenan las carreras creadas por alumno.");
        return controlador;
    }
    
    public static ControladorUniversitario inicializarMaterias(){
        ControladorUniversitario controlador = ControladorUniversitario.getInstance();
        System.out.println("Desde InciciadorCompleto/InicializarMaterias se crea o usa el ControladorUniversitario");
        
        controlador.obtenerCarreras().forEach((c) -> c.crearCuatrimestre());
        System.out.println("Por cada Carrera en el controlador se crean cuatrimestres.");
        
        controlador.obtenerCarreras().get(0).getCuatrimestres().get(0).addMateriaObligatoria(
                controlador.crearMateria("FEO1", "Algebra", Boolean.TRUE, null));
        
        controlador.obtenerCarreras().get(0).getCuatrimestres().get(0).addMateriaObligatoria(
                controlador.crearMateria("FEO2", "Expresión de problemas y algoritmos", Boolean.TRUE, null));
        
        controlador.obtenerCarreras().get(0).getCuatrimestres().get(0).addMateriaObligatoria(
                controlador.crearMateria("FEO3", "Elementos de Informatica", Boolean.TRUE, null));
        System.out.println("Se crean materias y se asignan al cuatrimestre respectivo de las carreras");
        return controlador;
        
    }
    
    public static ControladorUniversitario inicializarPlanesDeEstudio(){
        ControladorUniversitario controlador = ControladorUniversitario.getInstance();
        
        controlador.crearPlanesDeEstudio();
        
        return controlador;
    }
}
