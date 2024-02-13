package com.universidad.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Periodo {
    private int id_periodo;
    private String codigo_periodo;

    public Periodo(String codigo_periodo){
        this.codigo_periodo=codigo_periodo;
    }


    public void imprimir(){
        System.out.println("ID DEL PERIODO: " +this.id_periodo);
        System.out.println("CODIGO DEL PERIODO: " +this.codigo_periodo);
    }
}
