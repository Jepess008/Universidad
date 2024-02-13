package com.universidad.services;

import java.util.List;

import com.universidad.exceptions.edificioexceptions.EdificioNullException;
import com.universidad.repository.models.Edificio;

public interface ServiceEdificio {
    List<Edificio> listar();

    Edificio porNombre(String nombre)throws EdificioNullException ;

    void crear(Edificio edificio);

    void editar(Edificio edificio);

    void eliminar(Edificio edificio);
}
