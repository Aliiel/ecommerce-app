package com.insy2s.ecommerce_backend.security;

import com.insy2s.ecommerce_backend.model.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration-time}")
    private long expirationTime;


    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    public String extractUsername(String token) {

        return extractClaim(token, Claims::getSubject);
    }


    public String buildToken(Map<String, Object> extraClaims,
                             User user, long expirationTime) {

        return Jwts
                .builder()
                .setClaims(extraClaims)
                .claim("roles", user.getAuthorities())
                .claim("id", user.getId())
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public String generateToken(User user) {
        return generateToken(new HashMap<>(), user);
    }


    public String generateToken(Map<String, Object> extraClaims, User user) {

        return buildToken(extraClaims, user, expirationTime);
    }


    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    private Date extractExpirationTime(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    private boolean isTokenExpired(String token) {
        return extractExpirationTime(token).before(new Date());
    }
}
