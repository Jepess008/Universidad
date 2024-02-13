package com.universidad.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Departamento {
    private int id_departamento;
    private String nombre_departamento;

    public Departamento(String nombre_departamento){
        this.nombre_departamento=nombre_departamento;
    }

    public void imprimir(){

        System.out.println("Id del Departamento: " + this.id_departamento);
        System.out.println("Nombre del Departamento: " +this.nombre_departamento); 
    }
}
