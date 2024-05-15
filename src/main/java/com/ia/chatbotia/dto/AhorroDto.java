/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.dto;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author jairo
 */
@Data
public class AhorroDto {
   private Long ahorroId;
   private String nitUsuario;
   private String montoUsuario;
   private Date fechaAhorro;
   private String usuarioAdicion;
   private Date fechaModificacion;
   private String usuarioModificacion;
}
