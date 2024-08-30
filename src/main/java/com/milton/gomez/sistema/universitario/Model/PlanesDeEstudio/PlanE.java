package com.milton.gomez.sistema.universitario.Model.PlanesDeEstudio;


import com.milton.gomez.sistema.universitario.Model.*;

import java.util.ArrayList;
import java.util.List;

public class PlanE implements ModelPlanDeEstudio {
    @Override
    public List<ModelMateria> materiasQuePuedeCursar(ModelAlumno alumno, ModelCarrera carrera) {

        List<ModelMateria> materiasQuePuedeCursar = new ArrayList<>();


        // Plan C - Verificar correlativas (mismo que Plan A)
        List<ModelMateria> materiasAlumno = new ArrayList<>();
        for(ModelMateria materia : alumno.getMaterias()){
            if(materia.isMateriaAprobada()){
                materiasAlumno.add(materia);
            }
        }
        for (ModelMateria materia : carrera.obtenerMateriasDeLaCarrera()) {
            /* si no existen correlativas o las materias aprobadas contienen a todas las correlativas... */
            if (materia.getCorrelativas() == null || materiasAlumno.containsAll(materia.getCorrelativas())) {
                materiasQuePuedeCursar.add(materia);
            }
        }


        List<ModelCuatrimestre> cuatrimestres = carrera.getCuatrimestres();
        // Adicionalmente, verificar los últimos 5 cuatrimestres
        if (!aproboLosFinalesDeLosCuatrimestres(alumno, cuatrimestres)) {
            return new ArrayList<>(); // Retorna vacío si no se cumplen los requisitos
        }

        return materiasQuePuedeCursar;
    }

    private boolean aproboLosFinalesDeLosCuatrimestres(ModelAlumno alumno, List<ModelCuatrimestre> cuatrimestres) {
        // Validar si hay al menos 5 cuatrimestres
        if (cuatrimestres.size() < 3) {
            return false;
        }

        // Tomar los primeros 5 cuatrimestres
        List<ModelCuatrimestre> primerosCincoCuatrimestres = cuatrimestres.subList(cuatrimestres.size() - 3, cuatrimestres.size());

        // Verificar que todas las materias (obligatorias y optativas) de esos cuatrimestres tengan finales aprobados
        for (ModelCuatrimestre cuatrimestre : primerosCincoCuatrimestres) {
            for (ModelMateria materia : cuatrimestre.listarTodasLasMaterias()) {
                if (!alumno.getMaterias().contains(materia) || !materia.isMateriaAprobada()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public String toString(){
        return "Plan E";
    }
}
