package com.universidad.services;

import java.util.List;

import com.universidad.exceptions.asignaturaexceptions.AsignaturaNullException;
import com.universidad.repository.models.Asignatura;

public interface ServiceAsignatura {
    List<Asignatura> listar();

    Asignatura porIdAsignatura(int id_asignatura)throws AsignaturaNullException ;

    void crear(Asignatura asignatura);

    void editar(Asignatura asignatura);

    void eliminar(Asignatura asignatura);
}
