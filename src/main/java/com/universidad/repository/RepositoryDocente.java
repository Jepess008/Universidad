package com.universidad.repository;

import java.util.List;

import com.universidad.repository.models.Docente;


public interface RepositoryDocente {
    List<Docente> listarDocentes();
    List<Docente> listar();

    Docente porDocumento(String documento);
    
    void crear(Docente docente,int id_direccion, int id_ciudad);

    void editar(Docente docente);

    void eliminar(Docente docente);
}
