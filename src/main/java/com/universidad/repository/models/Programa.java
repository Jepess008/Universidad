package com.universidad.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Programa {
    private int id_programa;
    private String nombre_programa;
    private String nivel;
    private String codigo_programa;

    public Programa(String nombre_programa, String nivel, String codigo_programa){
        this.nombre_programa=nombre_programa;
        this.nivel=nivel;
        this.codigo_programa=codigo_programa;

    }

    public void imprimir(){

        System.out.println("Id del programa: "+this.id_programa );
        System.out.println("Nombre del Programa: " +this.nombre_programa );
        System.out.println("Nivel del Programa: "+this.nivel);
        System.out.println("Codigo del Programa: " +this.codigo_programa);
    }

    public void imprimirPrograma(){
        System.out.println("Id del programa: "+this.id_programa);
        System.out.println("Nombre del Programa: "+this.nombre_programa);
    }
}
