package com.ari.hms.config.security.services.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${security.secret-key}")
    private String secretKey;

    @Value("${security.issuer-id}")
    private String issuerId;

    @Value("${security.jwt.expiration.length}")
    private String expirationLength;

    @Value("${security.jwt.expiration.time-type}")
    private String timeType;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {

        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setIssuer(issuerId)
                .setExpiration(calculateExpirationDate())
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        final String issuer = extractClaim(token, Claims::getIssuer);
        return ((username.equals(userDetails.getUsername())) && !isTokenExpired(token) && isIssuerValid(issuer));
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public boolean isIssuerValid(String issuer) {
        return issuerId.equals(issuer);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Date calculateExpirationDate() {

        long length;

        int expiration = Integer.parseInt(expirationLength);

        switch (timeType) {
            case "hours":
                length = TimeUnit.HOURS.toMillis(expiration);
                break;
            case "days":
                length = TimeUnit.DAYS.toMillis(expiration);
                break;
            default:
                length = TimeUnit.MINUTES.toMillis(expiration);
                break;
        }

        return new Date(System.currentTimeMillis() + length);
    }
}
