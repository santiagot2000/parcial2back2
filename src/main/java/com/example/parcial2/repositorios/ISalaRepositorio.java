package com.example.parcial2.repositorios;

import com.example.parcial2.ayudas.Sala.Tipo;
import com.example.parcial2.modelos.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISalaRepositorio extends JpaRepository<Sala, Long> {

    // Buscar por tipo se dala
    Optional<Sala> findByNombre(String nombre);

    // Buscar por tipo
    List<Sala> findByTipo(Tipo tipo);

    // Buscar por capacidad
    List<Sala> findByCapacidad(Integer capacidad);
}
