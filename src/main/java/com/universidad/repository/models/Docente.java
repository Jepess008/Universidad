package com.universidad.repository.models;

import java.time.LocalDate;

import lombok.NoArgsConstructor;
@NoArgsConstructor

public class Docente extends Persona {
    
    public Docente ( String tipo_documento, String documento, String nombre1, String nombre2, String apellido1, String apellidoo2, String telefono, LocalDate fecha_nacimiento, String genero, int direccion, int ciudad, String tipo) {
        super( tipo_documento, documento, nombre1, nombre2, apellido1, apellidoo2, telefono, fecha_nacimiento, genero, direccion, ciudad, tipo);
    
    }

    public void imprimirDocente(){
        System.out.println("Datos Docente: ");
        System.out.println("Id Docente: "+ getId_persona() );
        System.out.println("Nombre completo: " + getfullName());
       
    }

}
