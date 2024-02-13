package com.universidad.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Direccion {
    private int id_direccion;
    private String via;
    private String numero;
    private String tipo;
}
