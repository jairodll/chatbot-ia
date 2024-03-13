/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.controller;

import com.ia.chatbotia.Entity.Usuarios;
import com.ia.chatbotia.Repository.UsuarioRepository;
import com.ia.chatbotia.Service.Impl.UsuarioSvcImpl;
import com.ia.chatbotia.dto.LoginRequest;
import com.ia.chatbotia.dto.ResponseDto;
import com.nimbusds.jose.JOSEException;
import com.ia.chatbotia.components.Exceptiones;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Oscar
 */
@RestController
@Slf4j
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioSvcImpl servicio;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository repository;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveUsuario(@RequestBody Usuarios dato) {
        try {
            servicio.saveUsuario(dato);
            ResponseDto response = new ResponseDto("El usuario fue ingresado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exceptiones ex) {
            ResponseDto response = new ResponseDto("El usuario ingresado ya existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws JOSEException {
        //crearUsuarioAdmi();
        return ResponseEntity.ok(servicio.logueo(loginRequest)).getBody();
    }

    @GetMapping(value = "/findUsuarioByusername/{username}")
    public Usuarios findUsuarioByusername(@PathVariable(required = true) String username) {
        return ResponseEntity.ok(servicio.findUsuarioByUsername(username)).getBody();
    }

  
}
