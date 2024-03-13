/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.dto;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import lombok.Data;

/**
 *
 * @author Oscar
 */

@Data
public class GastoDto {
     private Long gastoId;
    private String nitUsuario;
    private int tipoGasto;
    private BigDecimal montoGasto;
    private Date fechaGasto;
}
