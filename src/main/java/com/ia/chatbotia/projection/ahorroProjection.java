/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ia.chatbotia.projection;

import java.util.Date;

/**
 *
 * @author jairo
 */
public interface ahorroProjection {
    
    Integer getMontoAhorro();
    Integer getMayorGasto();
    Date getFechaGasto();
    String getMes();
    String getTotalAhorros();
}
