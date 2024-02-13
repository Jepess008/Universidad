package com.universidad.repository;

import java.util.List;

import com.universidad.repository.models.Programa;

public interface RepositoryPrograma {
    List<Programa> listaProgramas();
    List<Programa> listar();

    Programa porCodigo(String codigo);
    
    void crear(Programa programa);

    void editar(Programa programa);

    void eliminar(Programa programa);

}
