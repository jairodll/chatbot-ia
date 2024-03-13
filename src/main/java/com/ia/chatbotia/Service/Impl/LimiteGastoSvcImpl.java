/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.Service.Impl;

import com.ia.chatbotia.Entity.IngresoMensual;
import com.ia.chatbotia.Entity.LimiteGasto;
import com.ia.chatbotia.Repository.LimiteGastoRepository;
import com.ia.chatbotia.dto.IngresoDto;
import com.ia.chatbotia.dto.LimiteDto;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Oscar
 */
@Service
public class LimiteGastoSvcImpl {

    @Autowired
    LimiteGastoRepository limiteRepository;

    public LimiteGasto guardarLimiteGasto(LimiteDto datos) {
        LimiteGasto limite = null;
        Timestamp fechaAhora = Timestamp.valueOf(LocalDateTime.now());
        if (datos.getLimiteId()== 0) {
            limite = new LimiteGasto();
            limite.setFechaAdicion(fechaAhora);
            limite.setUsuarioAdicion(datos.getNitUsuario());
        } else {
            Optional<LimiteGasto> gastoDB = limiteRepository.findById(datos.getLimiteId());
            limite = gastoDB.get();
            limite.setFechaModificacion(fechaAhora);
            limite.setUsuarioModificacion(datos.getNitUsuario());
        }
        limite.setNitUsuario(datos.getNitUsuario());
        limite.setTipoLimiteId(datos.getTipoLimiteId());
        limite.setMontoLimite(datos.getMontoLimite());
        return limiteRepository.save(limite);
    }
}
