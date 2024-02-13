package com.universidad.services.impl;

import java.util.List;

import com.universidad.exceptions.estudianteexceptions.EstudianteNullException;
import com.universidad.repository.RepositoryEstudiante;
import com.universidad.repository.models.Estudiante;
import com.universidad.services.ServiceEstudiante;

public class ServiceEstudianteImpl implements ServiceEstudiante {


    private final RepositoryEstudiante crudRepositoryEstudiante;

    public ServiceEstudianteImpl(RepositoryEstudiante crudReposirotyEstudiante){
        this.crudRepositoryEstudiante=crudReposirotyEstudiante;
    }


    @Override
    public List<Estudiante> listar() {
        return this.crudRepositoryEstudiante.listar();
    }

    @Override
    public Estudiante porDocumento(String documento) throws EstudianteNullException {
        Estudiante estudiante=this.crudRepositoryEstudiante.porDocumento(documento);
        if(estudiante!=null){
            return estudiante;
        }else{
            throw new EstudianteNullException("No se encontro Estudiante por id");
        }  
    }

    @Override
    public void crear(Estudiante estudiante) {
      this.crudRepositoryEstudiante.crear(estudiante, 0, 0);
    }

    @Override
    public void editar(Estudiante estudiante) {
        this.crudRepositoryEstudiante.editar(estudiante);
    }   

    @Override
    public void eliminar(Estudiante estudiante) {
        this.crudRepositoryEstudiante.eliminar(estudiante);
    }
    
}
