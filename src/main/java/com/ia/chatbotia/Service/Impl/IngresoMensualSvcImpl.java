/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.Service.Impl;

import com.ia.chatbotia.Entity.IngresoMensual;
import com.ia.chatbotia.Repository.IngresoMensualRepository;
import com.ia.chatbotia.dto.IngresoDto;
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
public class IngresoMensualSvcImpl {

    @Autowired
    IngresoMensualRepository ingresoRepository;

    public IngresoMensual guardarIngresoMensual(IngresoDto datos) {
        IngresoMensual ingreso = null;
        Timestamp fechaAhora = Timestamp.valueOf(LocalDateTime.now());
        if (datos.getIngresoId() == 0) {
            ingreso = new IngresoMensual();
            ingreso.setFechaAdicion(fechaAhora);
            ingreso.setUsuarioAdicion(datos.getNitUsuario());
        } else {
            Optional<IngresoMensual> gastoDB = ingresoRepository.findById(datos.getIngresoId());
            ingreso = gastoDB.get();
            ingreso.setFechaModificacion(fechaAhora);
            ingreso.setUsuarioModificacion(datos.getNitUsuario());
        }
        ingreso.setNitUsuario(datos.getNitUsuario());
        ingreso.setMesIngreso(datos.getMesIngreso());
        ingreso.setMontoIngreso(datos.getMontoIngreso());
        return ingresoRepository.save(ingreso);
    }
}
