package com.universidad.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Curso {
    private int id_curso;
    private String nombre_curso;
    private String guia_catedra;
    private String codigo_curso;
    
    public Curso(String nombre_curso, String guia_catedra, String codigo_curso){
        this.nombre_curso= nombre_curso;
        this.guia_catedra= guia_catedra;
        this.codigo_curso= codigo_curso;
    }

    public void imprimir(){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("ID DEL CURSO: " +this.id_curso);
        System.out.println("NOMBRE DEL CURSO: " +this.nombre_curso);
        System.out.println("GUIA CATEDRA: " +this.guia_catedra);
        System.out.println("CODIGO DEL CURSO: " +this.codigo_curso);
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public void imprimirCurso(){
        System.out.println("Id del curso: "+this.id_curso);
        System.out.println("Nombre del curso: "+this.nombre_curso);
    }
}
