package com.universidad.repository;

import java.util.List;

import com.universidad.repository.models.Curso;

public interface RepositoryCurso {
    List<Curso>listaCursos();
    List<Curso> listar();

    Curso porCodigo(String codigo);
    
    void crear(Curso curso);

    void editar(Curso curso);

    void eliminar(Curso curso);
}
