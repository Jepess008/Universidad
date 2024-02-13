package com.universidad.services;

import java.util.List;

import com.universidad.exceptions.salonexceptions.SalonNullException;
import com.universidad.repository.models.Salon;

public interface ServiceSalon {
    List<Salon> listar();
    List<Salon> listarSalones();
    Salon porSalon(String salon_serial) throws SalonNullException;
    void crear(Salon salon, int id_edificio);
    void editar(Salon salon);
    void eliminar(Salon salon);
}
