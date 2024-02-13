package com.universidad.services.impl;

import java.util.List;

import com.universidad.exceptions.departamentoexceptions.DepartamentoNullException;
import com.universidad.repository.RepositoryDepartamento;
import com.universidad.repository.models.Departamento;
import com.universidad.services.ServiceDepartamento;

public class ServiceDepartamentoImpl implements ServiceDepartamento {


    private final RepositoryDepartamento crudRepositoryDepartamento;

    public ServiceDepartamentoImpl(RepositoryDepartamento crudRepositoryDepartamento){
        this.crudRepositoryDepartamento=crudRepositoryDepartamento;
    }


    @Override
    public List<Departamento> listar() {
        return this.crudRepositoryDepartamento.listar();
    }

    @Override
    public Departamento porNombre(String nombre) throws DepartamentoNullException {
        Departamento departamento=this.crudRepositoryDepartamento.porNombre(nombre);
        if(nombre!=null){
            return departamento;
        }else{
            throw new DepartamentoNullException("No se encontro Departamento por nombre");
        }  
    }

    @Override
    public void crear(Departamento departamento) {
        this.crudRepositoryDepartamento.crear(departamento);
    }

    @Override
    public void editar(Departamento departamento) {
      this.crudRepositoryDepartamento.editar(departamento);
    }

    @Override
    public void eliminar(Departamento departamento) {
        this.crudRepositoryDepartamento.eliminar(departamento);
    }
    
}
