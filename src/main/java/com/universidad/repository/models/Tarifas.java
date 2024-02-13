package com.universidad.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tarifas {
    private int id_tarifas;
    private int id_periodo;
    private int id_programa;
    private int valor_credito;

    public Tarifas(int id_periodo, int id_programa, int valor_credito){
        this.id_periodo=id_periodo;
        this.id_programa=id_programa;
        this.valor_credito=valor_credito;
    }

    public void imprimir(){
        System.out.println("Id_tarifa: " +this.id_tarifas);
        System.out.println("Id_periodo: "+this.id_periodo);
        System.out.println("Id_programa: "+this.id_programa);
        System.out.println("Valor por cada credito: "+this.valor_credito);
    }
}
