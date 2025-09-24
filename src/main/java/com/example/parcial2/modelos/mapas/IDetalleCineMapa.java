package com.example.parcial2.modelos.mapas;

import com.example.parcial2.modelos.Cine;
import com.example.parcial2.modelos.DetalleCine;
import com.example.parcial2.modelos.dtos.CineDTO;
import com.example.parcial2.modelos.dtos.DetalleCineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDetalleCineMapa {

    @Mapping(source = "cine.nombre", target = "cine")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "ciudad", target = "ciudad")
    @Mapping(source = "telefono", target = "telefono")
    DetalleCineDTO convertirADTO(DetalleCine detalleCines);

    //DTO para devolver a lista
    List<DetalleCineDTO> convertirAListaDTO(List<DetalleCine>lista);
}
