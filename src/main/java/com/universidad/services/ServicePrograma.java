package com.universidad.services;

import java.util.List;
import com.universidad.exceptions.programaexceptions.ProgramaNullException;
import com.universidad.repository.models.Programa;

public interface ServicePrograma {
    List<Programa> listaProgramas();
    List<Programa> listar();

    Programa porCodigo(String codigo)throws ProgramaNullException ;

    void crear(Programa programa);

    void editar(Programa programa);

    void eliminar(Programa programa);
}
