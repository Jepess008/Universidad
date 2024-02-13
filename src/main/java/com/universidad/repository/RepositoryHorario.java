package com.universidad.repository;

import java.util.List;

import com.universidad.repository.models.Horario;

public interface RepositoryHorario {
   List<Horario> listar();

   void crear(Horario horario, int id_asignatura, int id_salon);


  

}
