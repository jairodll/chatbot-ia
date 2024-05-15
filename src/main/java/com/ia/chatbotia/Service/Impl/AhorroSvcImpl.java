/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Service.Impl;

import com.ia.chatbotia.Repository.AhorroRepository;
import com.ia.chatbotia.dto.AhorroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ia.chatbotia.Entity.Ahorros;
import com.ia.chatbotia.projection.ahorroProjection;
import com.ia.chatbotia.projection.mayorAhorroProjection;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jairo
 */
@Service
public class AhorroSvcImpl {

    @Autowired
    AhorroRepository ahorroRepository;

    public Ahorros guardarAhorro(AhorroDto ahorros) {
        Ahorros ahorro = null;
        Timestamp fechaAhora = Timestamp.valueOf(LocalDateTime.now());
        if (ahorro.getAhorroId() == 0) {
            ahorro = new Ahorros();
            ahorro.setFechaModificacion(fechaAhora);
            ahorro.setUsuarioAdicion(ahorro.getNitUsuario() + "");
        } else {
            Optional<Ahorros> ahorroDB = ahorroRepository.findById(ahorro.getAhorroId());
            ahorro = ahorroDB.get();
            ahorro.setFechaModificacion(fechaAhora);
            ahorro.setUsuarioModificacion(ahorro.getNitUsuario());
        }
        ahorro.setNitUsuario(ahorro.getNitUsuario());
        ahorro.setFechaAhorro(ahorro.getFechaAhorro());
        ahorro.setMontoAhorro(ahorro.getMontoAhorro());
        return ahorroRepository.save(ahorro);
    }

    public Integer sumAhorros(String nit) {
        return ahorroRepository.sumAhorros(nit);
    }
    
    public List<ahorroProjection> mayorGasto(String nit) {
        return ahorroRepository.mayorGasto(nit);   
    }
    
    public List<mayorAhorroProjection> mayorAhorro(String nit) {
        return ahorroRepository.mayorAhorro(nit);   
    }
    

}