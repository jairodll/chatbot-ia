/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.Service.Impl;

import com.ia.chatbotia.Repository.GastoRepository;
import com.ia.chatbotia.dto.GastoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ia.chatbotia.Entity.Gasto;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 *
 * @author Oscar
 */
@Service
public class GastoSvcImpl {

    @Autowired
    GastoRepository gastoRepository;

    public Gasto guardarGasto(GastoDto datos) {
        Gasto gasto = null;
        Timestamp fechaAhora = Timestamp.valueOf(LocalDateTime.now());
        if (datos.getGastoId() ==0) {
            gasto = new Gasto();
            gasto.setFechaAdicion(fechaAhora);
            gasto.setUsuarioAdicion(datos.getNitUsuario()+"");
        } else {
            Optional<Gasto> gastoDB = gastoRepository.findById(datos.getGastoId());
            gasto = gastoDB.get();
            gasto.setFechaModificacion(fechaAhora);
            gasto.setUsuarioModificacion(datos.getNitUsuario());
        }
        gasto.setNitUsuario(datos.getNitUsuario());
        gasto.setFechaGasto(datos.getFechaGasto());
        gasto.setTipoGasto(datos.getTipoGasto() + "");
        gasto.setMontoGasto(datos.getMontoGasto());
        return gastoRepository.save(gasto);
    }

}
