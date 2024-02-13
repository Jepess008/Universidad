package com.universidad.services;

import java.util.List;


import com.universidad.exceptions.docenteexceptions.DocenteNullException;
import com.universidad.repository.models.Docente;


public interface ServiceDocente {
    List<Docente>listarDocentes();
    List<Docente> listar();

    Docente porDocumento(String documento)throws DocenteNullException ;

    void crear(Docente docente);

    void editar(Docente docente);

    void eliminar(Docente docente);
}

