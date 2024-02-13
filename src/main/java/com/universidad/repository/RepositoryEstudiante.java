package com.universidad.repository;

import java.util.List;

import com.universidad.repository.models.Estudiante;

public interface RepositoryEstudiante {
    
    List<Estudiante> listar();

    Estudiante porDocumento(String documento);
    
    void crear(Estudiante estudiante,int id_direccion, int id_ciudad);

    void editar(Estudiante estudiante);

    void eliminar(Estudiante estudiante);



}
