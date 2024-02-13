package com.universidad.services.impl;

import java.util.List;

import com.universidad.repository.RepositoryHorario;
import com.universidad.repository.models.Horario;
import com.universidad.services.ServiceHorario;

public class ServiceHorarioImpl implements ServiceHorario {

    private final RepositoryHorario crudRepositoryHorario;

    public ServiceHorarioImpl(RepositoryHorario crudRepositoryHorario){
        this.crudRepositoryHorario=crudRepositoryHorario;
    }

    @Override
    public List<Horario> listar() {
        return this.crudRepositoryHorario.listar();
    }

    @Override
    public void crear(Horario horario, int id_salon, int id_asignatura) {
        this.crudRepositoryHorario.crear(horario, 0,0);
    }
    
}
