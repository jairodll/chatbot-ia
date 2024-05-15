/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.controller;

import com.ia.chatbotia.Repository.AhorroRepository;
import com.ia.chatbotia.Service.Impl.AhorroSvcImpl;
import com.ia.chatbotia.components.Exceptiones;
import com.ia.chatbotia.dto.AhorroDto;
import com.ia.chatbotia.dto.ResponseDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
 * @author jairo
 */
@RestController
@Slf4j
@RequestMapping("/ahorro")
public class AhorroController {

    @Autowired
    AhorroSvcImpl ahorroSvcImpl;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveUsuario(@RequestBody AhorroDto dato) {
        try {
            return ResponseEntity.ok(ahorroSvcImpl.guardarAhorro(dato));
        } catch (Exceptiones ex) {
            ResponseDto response = new ResponseDto("Ocurrio un error al ingresar el ahorro");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/getTotalAhorros/{nit}")
    @ApiOperation("Que puedo comprar con mi ahorro del mes")
    public ResponseEntity<?> getTotalAhorros(@PathVariable @ApiParam(value = "nit") String nit) {
        Integer totalAhorros = ahorroSvcImpl.sumAhorros(nit);
        if (totalAhorros == null) {
            totalAhorros = 0;
        }
        return ResponseEntity.ok(totalAhorros);
    }
    
    @GetMapping("/getMayorGastoByNit/{nit}")
    @ApiOperation("Cual fué el mayor gasto del mes")
    public ResponseEntity<?> listarGastos(@PathVariable @ApiParam(value = "nit") String nit) {
        return ResponseEntity.ok(ahorroSvcImpl.mayorGasto(nit));
    }
    
    @GetMapping("/getMayorAhorroByNit/{nit}")
    @ApiOperation("Qué mes obtuve mas ahorros")
    public ResponseEntity<?> listarAorro(@PathVariable @ApiParam(value = "nit") String nit) {
        return ResponseEntity.ok(ahorroSvcImpl.mayorAhorro(nit));
    }

}
