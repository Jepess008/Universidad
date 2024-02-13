package com.universidad.services;

import java.util.List;

import com.universidad.exceptions.tarifaexceptions.TarifaNullException;
import com.universidad.repository.models.Tarifas;

public interface ServiceTarifa {
    List<Tarifas> listar();

    Tarifas porIdTarifas(int tarifa)throws TarifaNullException ;

    void crear(Tarifas tarifas);

    void editar(Tarifas tarifas);

    void eliminar(Tarifas tarifas);
}
