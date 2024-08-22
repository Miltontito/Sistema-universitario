package Model;

import java.util.List;

public interface PlanDeEstudio {
    List<Materia> materiasQuePuedeCursar(Alumno alumno, Carrera carrera);
}
