package com.universidad.repository;

import java.util.List;

import com.universidad.repository.models.Asignatura;

public interface RepositoryAsignatura {
    List<Asignatura> listar();

    Asignatura porIdAsignatura(int id_asignatura);
    
    void crear(Asignatura asignatura, int id_docente, int id_programa, int id_curso, int id_periodo);

    void editar(Asignatura asignatura);

    void eliminar(Asignatura asignatura);
}
