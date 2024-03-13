/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ia.chatbotia.Repository;

import com.ia.chatbotia.Entity.Usuarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Oscar
 */
public interface UsuarioRepository extends CrudRepository<Usuarios, Object>{

    @Query(value = "select * from cash_boot.usuarios u where u.nombre_usuario=? limit 1",
            nativeQuery = true)
    public Usuarios findUsuarioByusername(String username);
    
}
