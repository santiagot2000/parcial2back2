package com.example.parcial2.modelos;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "cines")
public class Cine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")// Para campos de texto
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @NotBlank(message = "El nit no puede estar vacío")// Para campos de texto
    @Size(min = 8, max = 11, message = "El nit debe tener entre 8 y 11 caracteres")
    @Column(name = "nit", length = 11, nullable = false, unique = true)
    private String nit;

    // Relacion con detalle cine
    @OneToOne(mappedBy = "cine", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "relaciondetalleCinecine")
    private DetalleCine detalle;

    // Relaciones con salas
    @OneToMany(mappedBy = "cine", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "relacionsalacine")
    private List<Sala> salas;

    public Cine() {
    }

    public Cine(Long id, String nombre, String nit) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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