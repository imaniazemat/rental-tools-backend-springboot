package com.godin.locationSpring.util;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    private static final String jwtToken = "locationGODIN123locationGODIN123locationGODIN123";

    public static String createToken(Integer userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken)
                .setClaims(claims) // body data
                .setIssuedAt(new Date()) // date
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 60 * 1000)); // un jour
        String token = jwtBuilder.compact();
        return token;
    }

    public static Map<String, Object> checkToken(String token) {
        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
