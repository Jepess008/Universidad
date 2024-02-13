package com.universidad.repository;

import java.util.List;

import com.universidad.repository.models.Matricula;

public interface RepositoryMatricula {
    List<Matricula> listar();
    void matricular(Matricula matricula);
}
