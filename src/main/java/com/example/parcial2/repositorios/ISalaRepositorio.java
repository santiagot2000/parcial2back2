package com.example.parcial2.repositorios;

import com.example.parcial2.modelos.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISalaRepositorio extends JpaRepository<Sala, Long> {
    // Buscar sala por id
    Optional<Sala> findById(Long id);

    // Buscar por tipo se dala
    Optional<Sala> findBySala(String sala);
}
