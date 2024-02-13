package com.universidad.services;

import java.util.List;

import com.universidad.exceptions.cursoexceptions.CursoNullException;
import com.universidad.repository.models.Curso;

public interface ServiceCurso {
    List<Curso>listaCursos();
    List<Curso> listar();

    Curso porCodigo(String codigo)throws CursoNullException ;

    void crear(Curso curso);

    void editar(Curso curso);

    void eliminar(Curso curso);
}
