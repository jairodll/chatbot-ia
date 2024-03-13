/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Oscar
 */
@Data
@NoArgsConstructor
public class IngresoDto {
    private Long ingresoId;
    private String nitUsuario;
    private BigDecimal montoIngreso;
    private int mesIngreso;
}
