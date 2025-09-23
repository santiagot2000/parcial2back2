package com.example.parcial2.servicios;

import com.example.parcial2.modelos.DetalleCine;
import com.example.parcial2.modelos.dtos.DetalleCineDTO;
import com.example.parcial2.modelos.mapas.IDetalleCineMapa;
import com.example.parcial2.repositorios.IDetalleCineRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCineServicio {

    //1. llamar al repositorio
    @Autowired
    IDetalleCineRepositorio repositorio;

    @Autowired
    IDetalleCineMapa mapa;

    //1 servicio para guardar un detalle del Cine
    public DetalleCineDTO guarDetallesCine(DetalleCine datosDetalleCine)throws Exception{
        try{
            return this.mapa.convertirADTO(this.repositorio.save(datosDetalleCine));
        }catch(Exception error){
            throw new Exception("Ups fallamos al guardar los detalles del cine: "+error.getMessage());
        }
    }

    //2 Servicio para buscar todos los detalles del Cines
    public List<DetalleCineDTO> buscarDetallesCine()throws Exception{ // cuando son todos los datos no se coloca nada en el parentesis
        try {
            List<DetalleCine> detalleCine = this.repositorio.findAll();
            if (detalleCine.isEmpty()) {throw new Exception("Ups no hay detalles del cine registrados");}
            return this.mapa.convertirAListaDTO(detalleCine);
        }catch(Exception error){
            throw new Exception("Ups fallamos al buscar los detalles del cine: "+error.getMessage());
        }
    }

    //2.1 servicio para buscar un etalle del cine si me dan su id
    public DetalleCineDTO buscarDetalleCineId(Long id)throws Exception{
        try {
            Optional<DetalleCine> detalleCineBuscado=(this.repositorio.findById(id));
            if (detalleCineBuscado.isPresent()){ // SI SI ESTA
                return this.mapa.convertirADTO(detalleCineBuscado.get());
            }else { // SI NO ESTAS
                throw  new Exception("Ups detalles del cine no encontrado");
            }
        }catch(Exception error){
            throw new Exception("Ups fallamos al buscar el detalle del cine: "+error.getMessage());
        }
    }
}
