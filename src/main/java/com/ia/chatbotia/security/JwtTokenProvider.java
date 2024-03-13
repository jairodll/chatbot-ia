/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ia.chatbotia.security;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.util.Base64;
import java.util.Date;
import java.text.ParseException;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    private String jwtSecret = "GEavVBSE14llI/V6yusCYxbQXJzaI/kHjqGQC4k8TJlRxIZwAj7MCWR3wV8cfkd4q6PQmgkApfJJFid8YdLBzg==";

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    private final byte[] secretBytes;
    private final JWSSigner signer;

    public JwtTokenProvider() throws KeyLengthException {
        logger.info("El bean JwtTokenProvider ha sido creado correctamente.");
        secretBytes = Base64.getDecoder().decode(jwtSecret);
        signer = new MACSigner(secretBytes);
    }

    public String generateToken(String username) throws JOSEException {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issueTime(now)
                .expirationTime(expiryDate)
                .build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
        signedJWT.sign(signer);

        return signedJWT.serialize();
    }

    public String getUsernameFromJWT(String token) throws ParseException, java.text.ParseException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        return signedJWT.getJWTClaimsSet().getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(authToken);
            JWSVerifier verifier = new MACVerifier(secretBytes); // Debes usar un JWSVerifier adecuado para tu firma
            return signedJWT.verify(verifier);
        } catch (java.text.ParseException | JOSEException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
