/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.dto;

import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author Oscar
 */

@Data
public class LimiteDto {
    private Long limiteId;
    private String nitUsuario;
    private Integer tipoLimiteId;
    private BigDecimal montoLimite;
}
