package com.universidad.repository;

import java.util.List;

import com.universidad.repository.models.Edificio;

public interface ReposirotyEdificio {
    List<Edificio> listar();

    Edificio porNombre(String nombre);
    
    void crear(Edificio edificio);

    void editar(Edificio edificio);

    void eliminar(Edificio edificio);
}
