/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.security;

import lombok.Data;

/**
 *
 * @author Oscar
 */
@Data
public class LoginResponse {

    private String accessToken;
    private String tokenType = "Bearer";
    private String nit;

    public LoginResponse(String accessToken, String nit) {
        this.accessToken = accessToken;
        this.nit = nit;
    }
}
