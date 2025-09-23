package com.example.parcial2.modelos.mapas;

import com.example.parcial2.modelos.Cine;
import com.example.parcial2.modelos.Sala;
import com.example.parcial2.modelos.dtos.CineDTO;
import com.example.parcial2.modelos.dtos.SalaDTO;
import org.mapstruct.Mapping;

import java.util.List;

public interface ISalaMapa {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "capacidad", target = "capasidad")
    @Mapping(source = "tipo", target = "tipo")
    SalaDTO convertirADTO(Sala sala);

    //DTO para devolver a lista
    List<SalaDTO> convertirAListaDTO(List<Sala> lista);
}
