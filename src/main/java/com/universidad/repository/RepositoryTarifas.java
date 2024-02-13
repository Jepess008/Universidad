package com.universidad.repository;

import java.util.List;

import com.universidad.repository.models.Tarifas;

public interface RepositoryTarifas {
    List<Tarifas> listar();
    Tarifas porIdTarifas(int id_tarifas);
    void crear(Tarifas tarifa, int id_periodo, int id_programa);
    void editar(Tarifas tarifa);
    void eliminar(Tarifas tarifa);
}
