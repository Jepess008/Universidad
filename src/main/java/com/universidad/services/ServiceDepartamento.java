package com.universidad.services;

import java.util.List;

import com.universidad.exceptions.departamentoexceptions.DepartamentoNullException;
import com.universidad.repository.models.Departamento;


public interface ServiceDepartamento {
    List<Departamento> listar();

    Departamento porNombre(String nombre)throws DepartamentoNullException ;

    void crear(Departamento departamento);

    void editar(Departamento departamento);

    void eliminar(Departamento departamento);
}
