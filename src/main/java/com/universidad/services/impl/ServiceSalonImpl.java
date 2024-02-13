package com.universidad.services.impl;

import java.util.List;

import com.universidad.exceptions.salonexceptions.SalonNullException;
import com.universidad.repository.RepositorySalon;
import com.universidad.repository.models.Salon;
import com.universidad.services.ServiceSalon;

public class ServiceSalonImpl implements ServiceSalon {

    private final RepositorySalon crudRepositorySalon;

    public ServiceSalonImpl(RepositorySalon cuRepositorySalon){
        this.crudRepositorySalon=cuRepositorySalon;
    }
    
    @Override
    public List<Salon> listar() {
       return this.crudRepositorySalon.listar();
    }

    @Override
    public Salon porSalon(String salon_serial) throws SalonNullException {
         Salon salon=this.crudRepositorySalon.porSalon(salon_serial);
        if(salon!=null){
            return salon;
        }else{
            throw new SalonNullException("No se encontro el Salon por Serial");
        }  
    }

    @Override
    public void crear(Salon salon, int id_edificio) {
        this.crudRepositorySalon.crear(salon,0);
    }

    @Override
    public void editar(Salon salon) {
        this.crudRepositorySalon.editar(salon);
    }

    @Override
    public void eliminar(Salon salon) {
      this.crudRepositorySalon.eliminar(salon);
    }

    @Override
    public List<Salon> listarSalones() {
        return this.crudRepositorySalon.listarHorarios();
    }
    
}
