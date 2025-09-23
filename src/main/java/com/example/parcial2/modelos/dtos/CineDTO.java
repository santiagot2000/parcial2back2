package com.example.parcial2.modelos.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CineDTO {

    @NotBlank(message = "El nombre no puede estar vacío")// Para campos de texto
    private String nombre; // MODELO cine

    @NotBlank(message = "El nit no puede estar vacío")// Para campos de texto
    private String nit; // MODELO cine

    public CineDTO() {
    }

    public CineDTO(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
