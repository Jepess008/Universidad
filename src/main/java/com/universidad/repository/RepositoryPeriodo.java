package com.universidad.repository;

import java.util.List;


import com.universidad.repository.models.Periodo;

public interface RepositoryPeriodo {
    List<Periodo> listar();

    Periodo porSemestre(String codigo );
    
    void crear(Periodo periodo);

    void editar(Periodo periodo);

    
}
