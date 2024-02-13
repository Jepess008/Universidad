package com.universidad.repository.models;

import java.time.LocalDate;

import lombok.NoArgsConstructor;
@NoArgsConstructor



public class Estudiante extends Persona{

    public Estudiante ( String tipo_documento, String documento, String nombre1, String nombre2, String apellido1, String apellidoo2, String telefono, LocalDate fecha_nacimiento, String genero, int direccion, int ciudad, String tipo) {
        super( tipo_documento, documento, nombre1, nombre2, apellido1, apellidoo2, telefono, fecha_nacimiento, genero, direccion, ciudad, tipo);
    
    }

    public void imprimirEstudiante(){
        System.out.println("Id Estudiante: "+this.getId_persona());
        System.out.println("Nombre del Estudiante: "+this.getfullName());
        
    }
}


