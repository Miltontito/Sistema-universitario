package com.milton.gomez.sistema.universitario.Model;

import java.util.List;

public interface ModelPlanDeEstudio {
    List<ModelMateria> materiasQuePuedeCursar(ModelAlumno alumno, ModelCarrera carrera);
}

