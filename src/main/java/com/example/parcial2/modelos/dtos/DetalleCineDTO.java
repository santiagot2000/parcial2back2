package com.example.parcial2.modelos.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DetalleCineDTO {

    @NotBlank(message = "El nit no puede estar vacío")// Para campos de texto
    private String cine; // MODELO cine

    @NotBlank(message = "La direccion no puede estar vacío")// Para campos de texto
    private String direccion;

    @NotBlank(message = "La ciudad no puede estar vacío")// Para campos de texto
    private String ciudad;

    @NotBlank(message = "El telefono no puede estar vacío")// Para campos de texto
    private String telefono;



    public DetalleCineDTO() {
    }

    public DetalleCineDTO(String cine, String direccion, String ciudad, String telefono) {
        this.cine = cine;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public String getCine() {
        return cine;
    }

    public void setCine(String cine) {
        this.cine = cine;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
