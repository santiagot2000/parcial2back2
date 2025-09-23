package com.example.parcial2.repositorios;

import com.example.parcial2.modelos.DetalleCine;
import com.example.parcial2.modelos.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDetalleCineRepositorio extends JpaRepository<DetalleCine, Long> {
    // Buscar detalle de cine por id
    Optional<DetalleCine> findById(Long id);
}
