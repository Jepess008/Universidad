package com.universidad.repository.models;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Persona {
    
    private int id_persona;
    private String tipo_documento;
    protected String documento;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private LocalDate fecha_nacimiento;
    private String genero;
    private int direccion;
    private int ciudad;
    private String tipo;

    public Persona ( String tipo_documento, String documento, String nombre1, String nombre2, String apellido1, String apellidoo2, String telefono, LocalDate fecha_nacimiento, String genero, int direccion, int ciudad, String tipo) {
        this.tipo_documento=tipo_documento;
        this.documento=documento;
        this.nombre1=nombre1;
        this.nombre2=nombre2;
        this.apellido1=apellido1;
        this.apellido2=apellidoo2;
        this.telefono=telefono;
        this.fecha_nacimiento=fecha_nacimiento;
        this.genero=genero;
        this.direccion=direccion;
        this.ciudad=ciudad;
        this.tipo=tipo;
    }
    public String getfullName(){
        return this.nombre1+" "+ this.nombre2+ " "+this.apellido1 + " " + this.apellido2;
    }
    
    
    public void imprimir(){
        System.out.println("Datos Persona: ");
        System.out.println("Tipo de Documento: " +this.tipo_documento);
        System.out.println("Documento: " +this.documento);
        System.out.println("Nombre completo: " + getfullName());
        System.out.println("Telefono: " + this.telefono);
        System.err.println("Fecha de Nacimiento: "+ this.fecha_nacimiento);
        System.out.println("Genero: "+ this.genero);
        System.out.println("Direccion: " +this.direccion);
        System.out.println("Ciudad: "+ this.ciudad);
        

    }
}
