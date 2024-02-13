package com.universidad.services.impl;

import java.util.List;

import com.universidad.exceptions.programaexceptions.ProgramaNullException;
import com.universidad.repository.RepositoryPrograma;
import com.universidad.repository.models.Programa;
import com.universidad.services.ServicePrograma;

public class ServiceProgramaImpl implements ServicePrograma {

    private final RepositoryPrograma crudRepositoryPrograma;

    public ServiceProgramaImpl(RepositoryPrograma crudRepositoryPrograma){
        this.crudRepositoryPrograma=crudRepositoryPrograma;
    }

    @Override
    public List<Programa> listar() {
    return this.crudRepositoryPrograma.listar();
    }

    @Override
    public Programa porCodigo(String codigo) throws ProgramaNullException {
        Programa programa=this.crudRepositoryPrograma.porCodigo(codigo);
        if(codigo!=null){
            return programa;
        }else{
            throw new ProgramaNullException("No se encontro Programa por codigo");
        }  
    }

    @Override
    public void crear(Programa programa) {
        this.crudRepositoryPrograma.crear(programa);
    }

    @Override
    public void editar(Programa programa) {
        this.crudRepositoryPrograma.editar(programa);
    }

    @Override
    public void eliminar(Programa programa) {
        this.crudRepositoryPrograma.eliminar(programa);
    }

    @Override
    public List<Programa> listaProgramas() {
        return this.crudRepositoryPrograma.listaProgramas();
    }
    
}
