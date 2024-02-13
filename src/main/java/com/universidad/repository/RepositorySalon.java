package com.universidad.repository;

import java.util.List;

import com.universidad.repository.models.Salon;

public interface RepositorySalon {
    List<Salon> listar();
    List<Salon> listarHorarios();
    Salon porSalon(String serial_salon);
    void crear(Salon salon, int id_edificio);
    void editar(Salon salon);
    void eliminar(Salon salon);

}
