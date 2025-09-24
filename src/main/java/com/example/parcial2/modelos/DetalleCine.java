package com.example.parcial2.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "detalles_cine")
public class DetalleCine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotBlank(message = "La direccion no puede estar vacío")// Para campos de texto
    @Size(min = 3, max = 50, message = "La direccion debe tener entre 3 y 50 caracteres")
    @Column(name = "direccion", length = 50, nullable = false)
    private String direccion;

    @NotBlank(message = "La ciudad no puede estar vacío")// Para campos de texto
    @Size(min = 3, max = 20, message = "La ciudad debe tener entre 3 y 20 caracteres")
    @Column(name = "ciudad", length = 20, nullable = false)
    private String ciudad;

    @NotBlank(message = "El telefono no puede estar vacío")// Para campos de texto
    @Size(min = 7, max = 15, message = "El telefono debe tener entre 7 y 15 caracteres")
    @Column(name = "telefono", length = 15, nullable = false, unique = true)
    private String telefono;

    // Relacion con cine
    @OneToOne
    @JoinColumn(name = "cine",referencedColumnName = "id", nullable = false, unique = true)
    @JsonBackReference(value = "relaciondetalleCinecine")
    private Cine cine;

    public DetalleCine() {
    }

    public DetalleCine(Long id, String direccion, String ciudad, String telefono) {
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }
}
