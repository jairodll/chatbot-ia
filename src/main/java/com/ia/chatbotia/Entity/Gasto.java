/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Oscar
 */

@Data
@Entity
@Table(name = "gastos", schema = "cash_boot")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gasto_id")
    private Long gastoId;

    @Column(name = "nit_usuario")
    private String nitUsuario;

    @Column(name = "tipo_gasto")
    private String tipoGasto;

    @Column(name = "monto_gasto", nullable = false)
    private BigDecimal montoGasto;

    @Column(name = "fecha_gasto", nullable = false)
    private Date fechaGasto;

    @Column(name = "fecha_adicion", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaAdicion;

    @Column(name = "usuario_adicion")
    private String usuarioAdicion;

    @Column(name = "fecha_modificacion")
    private Timestamp fechaModificacion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

}
