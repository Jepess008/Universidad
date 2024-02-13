package com.universidad.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Salon {
    private int id_salon;
    private int cupo;
    private int id_edificio;
    private int piso;
    private String serial_salon;

    public Salon(int cupo, int id_edificio, int piso, String serial_salon){
        this.cupo=cupo;
        this.id_edificio=id_edificio;
        this.piso=piso;
        this.serial_salon=serial_salon;

    }

    public void imprimir(){
        System.out.println("Id del Salon: "+this.id_salon);
        System.out.println("Cupo del Salon: " +this.cupo );
        System.out.println("Edificioo: "+ this.id_edificio);
        System.out.println("Piso al que pertenece: " +this.piso);
        System.out.println("Salon: " +this.serial_salon);
    }
}
