package com.milton.gomez.sistema.universitario.Model;

import java.util.List;

public interface PlanDeEstudio {
    List<Materia> materiasQuePuedeCursar(Alumno alumno, Carrera carrera);
}

