package com.universidad.services.impl;

import java.util.List;

import com.universidad.repository.RepositoryMatricula;
import com.universidad.repository.models.Matricula;
import com.universidad.services.ServiceMatricula;

public class ServiceMatriculaImpl implements ServiceMatricula {

    private final RepositoryMatricula crudRepositoryMatricula;

    public ServiceMatriculaImpl(RepositoryMatricula crudRepositoryMatricula){
        this.crudRepositoryMatricula=crudRepositoryMatricula;
    }

    @Override
    public List<Matricula> listar() {
        return this.crudRepositoryMatricula.listar();
    }

    @Override
    public void matricular(Matricula matricula) {
        this.crudRepositoryMatricula.matricular(matricula);
    }
    
}
