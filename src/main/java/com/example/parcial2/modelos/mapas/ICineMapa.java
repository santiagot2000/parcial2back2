package com.example.parcial2.modelos.mapas;

import com.example.parcial2.modelos.Cine;
import com.example.parcial2.modelos.dtos.CineDTO;
import org.mapstruct.Mapping;

import java.util.List;

public interface ICineMapa {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "nit", target = "nit")
    CineDTO convertirADTO(Cine cine);

    //DTO para devolver a lista
    List<CineDTO> convertirAListaDTO(List<Cine> lista);

}
