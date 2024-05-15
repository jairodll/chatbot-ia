/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author jairo
 */

@Data
@Entity
@Table(name = "ahorros", schema = "cash_boot")
public class Ahorros {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ahorro_id")
    private Long ahorroId;
    
    @Column(name = "nit_usuario")
    private String nitUsuario;
    
    @Column(name = "monto_ahorro")
    private String montoAhorro;
    
    @Column(name = "fecha_ahorro")
    private Date fechaAhorro;
    
    @Column(name = "usuario_adicion")
    private String usuarioAdicion;
    
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
}
