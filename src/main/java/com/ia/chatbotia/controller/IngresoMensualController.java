/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.controller;

import com.ia.chatbotia.Service.Impl.IngresoMensualSvcImpl;
import com.ia.chatbotia.components.Exceptiones;
import com.ia.chatbotia.dto.IngresoDto;
import com.ia.chatbotia.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Oscar
 */
@RestController
@Slf4j
@RequestMapping("/ingreso")
public class IngresoMensualController {

    @Autowired
    IngresoMensualSvcImpl ingresoSvc;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveUsuario(@RequestBody IngresoDto dato) {
        try {
            return ResponseEntity.ok(ingresoSvc.guardarIngresoMensual(dato));
        } catch (Exceptiones ex) {
            ResponseDto response = new ResponseDto("Ocurrio un error al ingresar el ingreso");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
