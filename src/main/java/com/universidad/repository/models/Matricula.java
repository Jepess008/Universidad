package com.universidad.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Matricula {
    private int id_matricula;
    private int id_estudiante;
    private int id_asignatura;
    private int id_periodo;

    public Matricula(int id_estudiante, int id_asignatura, int id_periodo){
        this.id_estudiante=id_estudiante;
        this.id_asignatura=id_asignatura;
        this.id_periodo=id_periodo;
    }

    public void imprimir(){
        System.out.println("Id Estudiante: "+this.id_estudiante);
        System.out.println("Asignatura: "+this.id_asignatura);
        System.out.println("Periodo: "+this.id_periodo);
    }
}
