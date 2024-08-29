package com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio;


import com.milton.gomez.sistema.universitario.Model.*;

import java.util.ArrayList;
import java.util.List;

public class PlanB implements PlanDeEstudio {
    /***
     *
     * @param alumno recibe el alumno del que se requiere recibir las materias que puede cursar.
     * @param carrera recibe la carrera del alumno para extraer las materias.
     * @return devuelve la lista de materias que pueden cursar los alumnos.
     */
    @Override
    public List<Materia> materiasQuePuedeCursar(Alumno alumno, Carrera carrera) {
        List<Materia> materiasQuePuedeCursar = new ArrayList<>();

        // Obtiene todas las materias de la carrera
        List<Materia> todasLasMaterias = carrera.obtenerMateriasDeLaCarrera();

        // Verifica si el alumno puede cursar cada materia bajo el Plan A
        for (Materia materia : todasLasMaterias) {

            // Si la materia se encuentra en alumno --> está aprobada o la está cursando.
            boolean tieneLaMateria = alumno.getMaterias().contains(materia);

            // si puede cursar la materia y NO está en alumno...
            if (puedeCursarMateria(materia) & !tieneLaMateria) {
                materiasQuePuedeCursar.add(materia);
            }
        }

        return materiasQuePuedeCursar;
    }

    /***
     *
     * @param materia recibe una materia para evaluar si aprobo los finales de las correlativas o no.
     * @return retorna si puede cursar la materia o no.
     */

    private Boolean puedeCursarMateria(Materia materia) {
        // Si la materia no tiene correlativas, puede cursarla
        if (materia.getCorrelativas() == null || materia.getCorrelativas().isEmpty()) {
            return true;
        }
        // Verifica que las correlativas tengan la cursada aprobada
        for (Materia correlativa : materia.getCorrelativas()) {
            if (!correlativa.isMateriaAprobada()) {
                return false;
            }
        }
        return true; // Todas las correlativas tienen la cursada aprobada
    }
    
    @Override
    public String toString(){
        return "Plan B: Un alumno puede cursar una materia si aprobó los finales de las correlativas";
    }
}
