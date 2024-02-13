package com.universidad.services;

import java.util.List;

import com.universidad.exceptions.estudianteexceptions.EstudianteNullException;
import com.universidad.repository.models.Estudiante;

public interface ServiceEstudiante {
    List<Estudiante> listar();

    Estudiante porDocumento(String documento)throws EstudianteNullException ;

    void crear(Estudiante estudiante);

    void editar(Estudiante estudiante);

    void eliminar(Estudiante estudiante);
}
