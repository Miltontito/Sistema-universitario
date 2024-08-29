package com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio;


import com.milton.gomez.sistema.universitario.Model.*;

import java.util.ArrayList;
import java.util.List;

public class PlanD implements PlanDeEstudio {
    @Override
    public List<Materia> materiasQuePuedeCursar(Alumno alumno, Carrera carrera) {

        List<Materia> materiasQuePuedeCursar = new ArrayList<>();


        // Plan C - Verificar correlativas (mismo que Plan A)
        List<Materia> materiasAlumno = new ArrayList<>();
        for(Materia materia : alumno.getMaterias()){
            if(materia.isCursadaAprobada()){
                materiasAlumno.add(materia);
            }
        }
        for (Materia materia : carrera.obtenerMateriasDeLaCarrera()) {
            /* si no existen correlativas o las materias aprobadas contienen a todas las correlativas... */
            if (materia.getCorrelativas() == null || materiasAlumno.containsAll(materia.getCorrelativas())) {
                materiasQuePuedeCursar.add(materia);
            }
        }


        List<Cuatrimestre> cuatrimestres = carrera.getCuatrimestres();
        // Adicionalmente, verificar los últimos 5 cuatrimestres
        if (!aproboLosFinalesDeLosCuatrimestres(alumno, cuatrimestres)) {
            return new ArrayList<>(); // Retorna vacío si no se cumplen los requisitos
        }

        return materiasQuePuedeCursar;
    }

    private boolean aproboLosFinalesDeLosCuatrimestres(Alumno alumno, List<Cuatrimestre> cuatrimestres) {
        // Validar si hay al menos 5 cuatrimestres
        if (cuatrimestres.size() < 3) {
            return false;
        }

        // Tomar los primeros 5 cuatrimestres
        List<Cuatrimestre> primerosCincoCuatrimestres = cuatrimestres.subList(cuatrimestres.size() - 3, cuatrimestres.size());

        // Verificar que todas las materias (obligatorias y optativas) de esos cuatrimestres tengan finales aprobados
        for (Cuatrimestre cuatrimestre : primerosCincoCuatrimestres) {
            for (Materia materia : cuatrimestre.listarTodasLasMaterias()) {
                if (!alumno.getMaterias().contains(materia) || !materia.isMateriaAprobada()) {
                    return false;
                }
            }
        }
        return true;
    }
}