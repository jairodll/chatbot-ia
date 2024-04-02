/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.controller;

import com.ia.chatbotia.Service.Impl.IngresoMensualSvcImpl;
import com.ia.chatbotia.components.Exceptiones;
import com.ia.chatbotia.dto.IngresoDto;
import com.ia.chatbotia.dto.ResponseDto;
import com.ia.chatbotia.projection.ingresoProjection;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping(path = "/showIngresosByNit/{nit}")
    @ApiOperation("Muestra los ingresos a partir del Nit")
    public ResponseEntity<List<ingresoProjection>> searchGestion(
            @PathVariable @ApiParam(value = "nit") String nit) {
        return ResponseEntity.ok(ingresoSvc.showIngreso(nit));
    }
}
