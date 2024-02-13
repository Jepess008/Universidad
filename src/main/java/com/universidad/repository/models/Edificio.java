package com.universidad.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Edificio {
    private int id_edificio;
    private String nombre_edificio;


    public void imprimir(){
        System.out.println("Edificio: "+this.nombre_edificio);
    }
}
