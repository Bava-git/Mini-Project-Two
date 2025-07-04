package com.miniprojecttwo.jwt;

import com.miniprojecttwo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.jsonwebtoken.JwtParser;

@Component
public class JwtUtil {
    //    private final Key SECRET = Keys.hmacShaKeyFor("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".getBytes());
    private final String SECRET = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
    private final long expirationTime = 1000 * 60 * 60;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(UserDetails userDetails, String UserID) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities().stream().map(Object::toString).toList());
        claims.put("userId", UserID);

        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("roles", userDetails.getAuthorities().stream().map(Object::toString).toList())
                .claim("userId", UserID)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        return token;
    }

    public String extractUsername(String token) {

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(SECRET)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println("Extracted claims: " + claims);
            String username = claims.getSubject();
            System.out.println("Extracted Username: " + username);
            return username;

        } catch (Exception e) {
            System.out.println("Token Parsing Error: " + e.getMessage());
            return null;
        }

    }

    public List<String> extractRoles(String token) {
        return (List<String>) Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token).getBody().get("roles");
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        boolean isVaild = extractUsername(token).equals(userDetails.getUsername());
        System.out.println(isVaild);
        return isVaild;
    }

//
//    public boolean validateToken(String token, UserDetails userDetails) {
//        Claims claims = jwtParser.parseClaimsJws(token).getBody();
//
//        return claims.getExpiration().after(new Date()) // ✅ Ensure token is not expired
//                && claims.getSubject().equals(userDetails.getUsername());
//    }

}
