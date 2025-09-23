package com.example.parcial2.modelos.dtos;

import com.example.parcial2.ayudas.Sala.Tipo;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SalaDTO {

    @NotBlank(message = "El nombre no puede estar vacío")// Para campos de texto
    private String nombre;

    @NotNull(message = "La capacidad es obligatorio")// Para campos que no son de texto
    private Integer capacidad;

    @NotNull(message = "El tipo es obligatorio")// Para campos que no son de texto
    private Tipo tipo;

    public SalaDTO() {
    }

    public SalaDTO(String nombre, Integer capacidad, Tipo tipo) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
