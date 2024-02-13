package com.universidad.services.impl;

import java.util.List;

import com.universidad.exceptions.docenteexceptions.DocenteNullException;

import com.universidad.repository.RepositoryDocente;

import com.universidad.repository.models.Docente;

import com.universidad.services.ServiceDocente;

public class ServiceDocenteImp implements ServiceDocente {

    private final RepositoryDocente crudRepositoryDocente;

    public ServiceDocenteImp(RepositoryDocente crudReposirotyDocente){
        this.crudRepositoryDocente=crudReposirotyDocente;
    }

    
    @Override
    public List<Docente> listar() {
        return this.crudRepositoryDocente.listar();
    }

    @Override
    public Docente porDocumento(String documento) throws DocenteNullException {
        Docente docente=this.crudRepositoryDocente.porDocumento(documento);
        if(docente!=null){
            return docente;
        }else{
            throw new DocenteNullException("No se encontro Estudiante por id");
        }  
    }

    @Override
    public void crear(Docente docente) {

        this.crudRepositoryDocente.crear(docente, 0, 0);
    }

    @Override
    public void editar(Docente docente) {
        this.crudRepositoryDocente.editar(docente);
    }

    @Override
    public void eliminar(Docente docente) {
        
        this.crudRepositoryDocente.eliminar(docente);
    }


    @Override
    public List<Docente> listarDocentes() {
      return this.crudRepositoryDocente.listarDocentes();
    }
    
}
