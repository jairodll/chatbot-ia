/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.Service.Impl;

import com.ia.chatbotia.Entity.Usuarios;
import com.ia.chatbotia.Repository.UsuarioRepository;
import com.ia.chatbotia.dto.LoginRequest;
import com.nimbusds.jose.JOSEException;
import com.ia.chatbotia.components.Exceptiones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ia.chatbotia.security.JwtTokenProvider;
import com.ia.chatbotia.security.LoginResponse;

/**
 * Servicio para operaciones relacionadas con usuarios.
 *
 * @author Oscar
 */
@Service
public class UsuarioSvcImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Usuarios findUsuarioByUsername(String userame) {
        return repository.findUsuarioByusername(userame);
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param dato El usuario a registrar.
     */
    public void saveUsuario(Usuarios dato) {
        Usuarios usuario = this.repository.findUsuarioByusername(dato.getUsuario());
        /*if (!usuario.getDpi().equals(null)) {
            throw new Exceptiones();
        }*/
        // Hashea la contraseña antes de guardarla
        String hashedPassword = passwordEncoder.encode(dato.getContraseña());
        dato.setContraseña(hashedPassword);

        this.repository.save(dato);
    }

    /**
     * Autentica a un usuario y genera un token JWT para él.
     *
     * @param loginRequest Los datos de inicio de sesión del usuario.
     * @return Un ResponseEntity con el token JWT y otros datos si la
     * autenticación es exitosa.
     */
    public ResponseEntity<?> logueo(LoginRequest loginRequest) throws JOSEException {
        System.out.println("Usuario:::" + loginRequest.getUsername());
        Usuarios user = repository.findUsuarioByusername(loginRequest.getUsername());

        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        System.out.println("PASA POR ACA");
        // Verificar si la contraseña proporcionada coincide con la almacenada en la base de datos
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getContraseña())) {

            System.out.println("Credeciales iivallidas");
            throw new BadCredentialsException("Credenciales incorrectas");
        }
        // Autenticación exitosa, generar el token JWT y devolver los datos adicionales
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("pasa por aca");
        String jwt = generateJwtToken(loginRequest.getUsername());

        LoginResponse loginResponse = new LoginResponse(jwt,user.getNit());
        return ResponseEntity.ok(loginResponse);
    }

    public String generateJwtToken(String authentication) throws JOSEException {
        return jwtTokenProvider.generateToken(authentication);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuarios user = this.repository.findUsuarioByusername(username);
        if (user == null) {
            throw new Exceptiones();
        }
        // Devuelve un UserDetails personalizado que representa al usuario cargado desde la base de datos
        return new User(
                user.getUsuario(),
                user.getContraseña(),
                Collections.emptyList()
        );
    }
}
