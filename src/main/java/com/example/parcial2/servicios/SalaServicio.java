package com.example.parcial2.servicios;

import com.example.parcial2.modelos.Sala;
import com.example.parcial2.modelos.dtos.SalaDTO;
import com.example.parcial2.modelos.mapas.ISalaMapa;
import com.example.parcial2.repositorios.ISalaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaServicio {


    //1. llamar al repositorio
    @Autowired
    ISalaRepositorio repositorio;

    @Autowired
    ISalaMapa mapa;

    //1 servicio para guardar una sala
    public SalaDTO guardaSala(Sala datosSala)throws Exception{
        try{
            return this.mapa.convertirADTO(this.repositorio.save(datosSala));
        }catch(Exception error){
            throw new Exception("Ups fallamos al guardar la sala: "+error.getMessage());
        }
    }

    //2 Servicio para buscar todos las salas
    public List<SalaDTO> buscarSala()throws Exception{ // cuando son todos los datos no se coloca nada en el parentesis
        try {
            List<Sala> salas = this.repositorio.findAll();
            if (salas.isEmpty()) {throw new Exception("Ups no hay salas registrados");}
            return this.mapa.convertirAListaDTO(salas);
        }catch(Exception error){
            throw new Exception("Ups fallamos al buscar las salas: "+error.getMessage());
        }
    }

    //2.1 servicio para buscar una sala si me dan su id
    public SalaDTO buscarSalaId(Long id)throws Exception{
        try {
            Optional<Sala> salaBuscada=(this.repositorio.findById(id));
            if (salaBuscada.isPresent()){ // SI SI ESTA
                return this.mapa.convertirADTO(salaBuscada.get());
            }else { // SI NO ESTAS
                throw  new Exception("Ups sala no encontrado");
            }
        }catch(Exception error){
            throw new Exception("Ups fallamos al buscar la sala: "+error.getMessage());
        }
    }
}
