package com.universidad.services.impl;

import java.util.List;

import com.universidad.exceptions.periodoexceptions.PeriodoNullException;
import com.universidad.repository.RepositoryPeriodo;
import com.universidad.repository.models.Periodo;
import com.universidad.services.ServicePeriodo;

public class ServicePeriodoImpl implements ServicePeriodo {

    private final RepositoryPeriodo crudRepositoryPeriodo;
    
    public ServicePeriodoImpl(RepositoryPeriodo crudRepositoryPeriodo){
        this.crudRepositoryPeriodo=crudRepositoryPeriodo;
    }

    @Override
    public List<Periodo> listar() {
        return this.crudRepositoryPeriodo.listar();
    }

    @Override
    public Periodo porSemestre(String codigo) throws PeriodoNullException {
       Periodo periodo=this.crudRepositoryPeriodo.porSemestre(codigo);
        if(codigo!=null){
            return periodo;
        }else{
            throw new PeriodoNullException("No se encontro Periodo por codigo");
        }  
    }

    @Override
    public void crear(Periodo periodo) {
        this.crudRepositoryPeriodo.crear(periodo);
    }

    @Override
    public void editar(Periodo periodo) {
        this.crudRepositoryPeriodo.editar(periodo);
    }

    
}
