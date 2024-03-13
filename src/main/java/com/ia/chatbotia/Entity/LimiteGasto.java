/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.Data;

/**
 *
 * @author Oscar
 */

@Data
@Entity
@Table(name = "limite_gastos", schema = "cash_boot")
public class LimiteGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "limite_id")
    private Long limiteId;

    @Column(name = "nit_usuario")
    private String nitUsuario;

     @Column(name = "tipo_limite_id")
    private Integer tipoLimiteId;

    @Column(name = "monto_limite")
    private BigDecimal montoLimite;

    @Column(name = "fecha_adicion", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaAdicion;

    @Column(name = "usuario_adicion")
    private String usuarioAdicion;

    @Column(name = "fecha_modificacion")
    private Timestamp fechaModificacion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    

}
