package com.checklistback.checklist.security.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.checklistback.checklist.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

import static java.nio.charset.StandardCharsets.US_ASCII;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${checklist.app.jwtSecret}")
    private String jwtSecret;

    @Value("${checklist.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(jwtSecret.getBytes(US_ASCII)))
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret.getBytes()).parseClaimsJws(authToken).getBody();
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    private JwtUtils() {
        // Hide default constructor
    }

    public String getUsernameFromToken(String token) {
        return extractClaims(token).getSubject();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        UserDetailsImpl user = (UserDetailsImpl) userDetails;
        final String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    public Date getIssuedAtDateFromToken(String token) {
        return extractClaims(token).getIssuedAt();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<String, Object>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(createdDate)
                .setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + jwtExpirationMs * 1000L);
    }

    public static String createToken(String username, Date issueDate) {
        String jwtToken = Jwts.builder().setSubject(username).setIssuedAt(issueDate)
                .setExpiration(new Date(issueDate.getTime() + EXPIRATION_IN_SECONDS))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();

        return jwtToken;
    }

    public static String getSubject(String token) {
        Claims claims = extractClaims(token);
        return claims.getSubject();
    }

    public static String refreshToken(String token, long expirationInSeconds) {
        final Claims claims = extractClaims(token);

        Date now = new Date();
        claims.setIssuedAt(now);
        claims.setExpiration(new Date(now.getTime() + EXPIRATION_IN_SECONDS));

        return createTokenFromClaims(claims);
    }

    public static boolean isTokenExpired(String token) {
        final Claims claims = extractClaims(token);
        Date now = new Date();

        return now.after(claims.getExpiration());
    }

    private static String createTokenFromClaims(Claims claims) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
    }

    private static Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(JWT_SECRET.getBytes()).parseClaimsJws(token).getBody();
    }
}