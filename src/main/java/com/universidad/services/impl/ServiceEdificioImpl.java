package com.universidad.services.impl;

import java.util.List;

import com.universidad.exceptions.edificioexceptions.EdificioNullException;
import com.universidad.repository.ReposirotyEdificio;
import com.universidad.repository.models.Edificio;
import com.universidad.services.ServiceEdificio;

public class ServiceEdificioImpl implements ServiceEdificio {


    private final ReposirotyEdificio cruudRepositoryEdificio;

    public ServiceEdificioImpl(ReposirotyEdificio crudRepositoryEdificio){
        this.cruudRepositoryEdificio=crudRepositoryEdificio;
    }


    @Override
    public List<Edificio> listar() {
        return this.cruudRepositoryEdificio.listar();
    }

    @Override
    public Edificio porNombre(String nombre) throws EdificioNullException {
        Edificio edificio=this.cruudRepositoryEdificio.porNombre(nombre);
        if(nombre!=null){
            return edificio;
        }else{
            throw new EdificioNullException("No se encontro Edificio por nombre");
        } 
    }

    @Override
    public void crear(Edificio edificio) {
        this.cruudRepositoryEdificio.crear(edificio);
       
    }

    @Override
    public void editar(Edificio edificio) {
        this.cruudRepositoryEdificio.editar(edificio);
        
    }

    @Override
    public void eliminar(Edificio edificio) {
        this.cruudRepositoryEdificio.eliminar(edificio);
    }
    
}
