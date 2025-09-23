package com.example.parcial2.servicios;

import com.example.parcial2.modelos.Cine;
import com.example.parcial2.modelos.dtos.CineDTO;
import com.example.parcial2.modelos.mapas.ICineMapa;
import com.example.parcial2.repositorios.ICineRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CineServicio {

    //1. llamar al repositorio
    @Autowired
    ICineRepositorio repositorio;

    @Autowired
    ICineMapa mapa;

    //1 servicio para guardar un Cine
    public CineDTO guardaCine(Cine datosCine)throws Exception{
        try{
            return this.mapa.convertirADTO(this.repositorio.save(datosCine));
        }catch(Exception error){
            throw new Exception("Ups fallamos al guardar el cine: "+error.getMessage());
        }
    }

    //2 Servicio para buscar todos los Cines
    public List<CineDTO> buscarCine()throws Exception{ // cuando son todos los datos no se coloca nada en el parentesis
        try {
            List<Cine> cines = this.repositorio.findAll();
            if (cines.isEmpty()) {throw new Exception("Uos no hay cines registrados");}
            return this.mapa.convertirAListaDTO(cines);
        }catch(Exception error){
            throw new Exception("Ups fallamos al buscar los cines: "+error.getMessage());
        }
    }

    //2.1 servicio para buscar un cine si me dan su id
    public CineDTO buscarCineId(Long id)throws Exception{
        try {
            Optional<Cine> cineBuscado=(this.repositorio.findById(id));
            if (cineBuscado.isPresent()){ // SI SI ESTA
                return this.mapa.convertirADTO(cineBuscado.get());
            }else { // SI NO ESTAS
                throw  new Exception("Ups cine no encontrado");
            }
        }catch(Exception error){
            throw new Exception("Ups fallamos al buscar el cine: "+error.getMessage());
        }
    }
}
