package com.universidad.repository;

import java.util.List;

import com.universidad.repository.models.Departamento;


public interface RepositoryDepartamento {
    List<Departamento> listar();

    Departamento porNombre(String nombre);
    
    void crear(Departamento departamento);

    void editar(Departamento departamento);

    void eliminar(Departamento departamento);

}
