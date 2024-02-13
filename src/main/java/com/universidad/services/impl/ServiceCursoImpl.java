package com.universidad.services.impl;

import java.util.List;

import com.universidad.exceptions.cursoexceptions.CursoNullException;
import com.universidad.repository.RepositoryCurso;
import com.universidad.repository.models.Curso;
import com.universidad.services.ServiceCurso;

public class ServiceCursoImpl implements ServiceCurso {

    private final RepositoryCurso crudRepositoryCurso;

    public ServiceCursoImpl(RepositoryCurso crudRepositoryCurso){
        this.crudRepositoryCurso=crudRepositoryCurso;
    }

    @Override
    public List<Curso> listar() {
        return this.crudRepositoryCurso.listar();
    }

    @Override
    public Curso porCodigo(String codigo) throws CursoNullException {
        Curso curso=this.crudRepositoryCurso.porCodigo(codigo);
        if(codigo!=null){
            return curso;
        }else{
            throw new CursoNullException("No se encontro Curso por Codigo");
        } 
    }

    @Override
    public void crear(Curso curso) {
       this.crudRepositoryCurso.crear(curso);
    }

    @Override
    public void editar(Curso curso) {
        this.crudRepositoryCurso.editar(curso);
    }

    @Override
    public void eliminar(Curso curso) {
        this.crudRepositoryCurso.eliminar(curso);
    }

    @Override
    public List<Curso> listaCursos() {
        return this.crudRepositoryCurso.listaCursos();
    }
    
}
