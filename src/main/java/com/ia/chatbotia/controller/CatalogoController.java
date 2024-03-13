/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.controller;

import com.ia.chatbotia.Entity.Usuarios;
import com.ia.chatbotia.Repository.CatalogoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Oscar
 */
@RestController
@Slf4j
@RequestMapping("/catalogos")
public class CatalogoController {

    @Autowired
    CatalogoRepository catalogoRepository;

    @GetMapping(value = "/findCatalogoGastos")
    public ResponseEntity<?> findUsuarioByusername() {
        return ResponseEntity.ok(catalogoRepository.findCatalogoGastos());
    }

    @GetMapping(value = "/findCatalogoTiposLimites")
    public ResponseEntity<?> findCatalogoTiposLimites() {
        return ResponseEntity.ok(catalogoRepository.findCatalogoTiposLimites());
    }
}
