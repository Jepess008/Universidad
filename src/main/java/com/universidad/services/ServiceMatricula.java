package com.universidad.services;

import java.util.List;

import com.universidad.repository.models.Matricula;

public interface ServiceMatricula {
    List<Matricula> listar();
    void matricular(Matricula matricula);
    
}
