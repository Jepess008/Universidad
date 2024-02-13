package com.universidad.services;

import java.util.List;

import com.universidad.repository.models.Horario;

public interface ServiceHorario {
    
    List<Horario> listar();
    void crear(Horario horario, int id_salon, int id_asignatura);
    
}
