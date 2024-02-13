package com.universidad.services;

import java.util.List;

import com.universidad.exceptions.periodoexceptions.PeriodoNullException;
import com.universidad.repository.models.Periodo;

public interface ServicePeriodo {
    List<Periodo> listar();

    Periodo porSemestre(String codigo)throws PeriodoNullException ;

    void crear(Periodo periodo);

    void editar(Periodo periodo);

}
