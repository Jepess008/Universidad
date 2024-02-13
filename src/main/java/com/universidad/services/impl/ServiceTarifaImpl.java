package com.universidad.services.impl;

import java.util.List;

import com.universidad.exceptions.tarifaexceptions.TarifaNullException;
import com.universidad.repository.RepositoryTarifas;
import com.universidad.repository.models.Tarifas;
import com.universidad.services.ServiceTarifa;

public class ServiceTarifaImpl implements ServiceTarifa{


    private final RepositoryTarifas crudRepositoryTarifas;

    public ServiceTarifaImpl(RepositoryTarifas crudRepositoryTarifas){
        this.crudRepositoryTarifas=crudRepositoryTarifas;
    }

    @Override
    public List<Tarifas> listar() {
       return this.crudRepositoryTarifas.listar();
    }

    @Override
    public Tarifas porIdTarifas(int tarifa) throws TarifaNullException {
         Tarifas tarifas=this.crudRepositoryTarifas.porIdTarifas(tarifa);
        if(tarifas!=null){
            return tarifas;
        }else{
            throw new TarifaNullException("No se encontro la Tarifa por id");
        }  
    }

    @Override
    public void crear(Tarifas tarifas) {
       this.crudRepositoryTarifas.crear(tarifas, 0, 0);
    }

    @Override
    public void editar(Tarifas tarifas) {
        this.crudRepositoryTarifas.editar(tarifas);
    }

    @Override
    public void eliminar(Tarifas tarifas) {
        this.crudRepositoryTarifas.eliminar(tarifas);
    }
    
}
