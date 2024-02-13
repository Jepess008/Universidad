package com.universidad.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Asignatura {
    private int id_asignatura;
    private String nombre_asignatura;
    private int creditos;
    private int id_docente;
    private int id_programa;
    private int id_curso;
    private int id_periodo;


    public Asignatura(String nombre_asignatura, int creditos, int id_docente, int id_programa, int id_curso, int id_periodo){
        this.nombre_asignatura=nombre_asignatura;
        this.creditos = creditos;
        this.id_docente=id_docente;
        this.id_programa=id_programa;
        this.id_curso=id_curso;
        this.id_periodo=id_periodo;

    }

    public void imprimir(){
        System.out.println("Id de la asignatura: "+this.id_asignatura);
        System.out.println("Nombre de la asignatura: "+this.nombre_asignatura);
        System.out.println("Creditos de la asignatura: "+this.creditos);
        System.out.println("Docente de la Asignatura: " +this.id_docente);
        System.out.println("Programa al que pertenece la asignatura: "+this.id_programa);
        System.out.println("Curso al que pertenece la asignatura: "+this.id_curso);
        System.out.println("Periodo al que pertenece la Asignatura: "+this.id_periodo);

    }   

    public void imprimirAsignaturas(){
        System.out.println("Id de la Asignatura: "+this.id_asignatura);
        System.out.println("Nombre de la Asignatura: "+this.nombre_asignatura);
    }
}
