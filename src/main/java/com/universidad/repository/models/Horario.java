package com.universidad.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Horario {
    private int id_horario;
    private String dia;
    private String inicio;
    private String fin;
    private int id_asignatura;
    private int id_salon;


    public Horario(String dia, String inicio, String fin, int id_asignatura, int id_salon){
        this.dia=dia;
        this.inicio=inicio;
        this.fin=fin;
        this.id_asignatura=id_asignatura;
        this.id_salon=id_salon;
    }

    public void imprimir(){
        System.out.println("día: "+this.dia);
        System.out.println("inicio: "+this.inicio);
        System.out.println("final: "+this.fin);
        System.out.println("asignatura: "+getId_asignatura());
        System.out.println("salon: "+this.id_salon);
    }
}
