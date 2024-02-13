package com.universidad.services.impl;

import java.util.List;

import com.universidad.exceptions.asignaturaexceptions.AsignaturaNullException;
import com.universidad.repository.RepositoryAsignatura;
import com.universidad.repository.models.Asignatura;
import com.universidad.services.ServiceAsignatura;

public class ServiceAsignaturaImpl implements ServiceAsignatura {

    private final RepositoryAsignatura crudRepositoryAsignatura;

    public ServiceAsignaturaImpl(RepositoryAsignatura crudRepositoryAsignatura){
        this.crudRepositoryAsignatura=crudRepositoryAsignatura;
    }

    @Override
    public List<Asignatura> listar() {
        return this.crudRepositoryAsignatura.listar();
    }

    @Override
    public Asignatura porIdAsignatura(int id_asignatura) throws AsignaturaNullException {
         Asignatura asignatura=this.crudRepositoryAsignatura.porIdAsignatura(id_asignatura);
        if(asignatura!=null){
            return asignatura;
        }else{
            throw new AsignaturaNullException("No se encontro la Tarifa por id");
        } 
    }

    @Override
    public void crear(Asignatura asignatura) {
       this.crudRepositoryAsignatura.crear(asignatura, 0, 0, 0, 0);
    }

    @Override
    public void editar(Asignatura asignatura) {
       this.crudRepositoryAsignatura.editar(asignatura);
    }

    @Override
    public void eliminar(Asignatura asignatura) {
        this.crudRepositoryAsignatura.eliminar(asignatura);
    }
    
}
