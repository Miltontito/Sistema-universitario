package Model.PlanesDeEstudio;

import Model.Alumno;
import Model.Carrera;
import Model.Materia;
import Model.PlanDeEstudio;

import java.util.List;

public class PlanE implements PlanDeEstudio {
    @Override
    public List<Materia> materiasQuePuedeCursar(Alumno alumno, Carrera carrera) {
        return List.of();
    }
}
