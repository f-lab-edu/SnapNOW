package kr.flab.snapnow.application.auth.jwt;

import java.util.Map;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import kr.flab.snapnow.domain.auth.Token;

@Component
public class JwtProvider {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.access-token-expiration}")
    private Long accessTokenExpiration;

    @Value("${jwt.refresh-token-expiration}")
    private Long refreshTokenExpiration;

    public Token createToken(TokenPayload payload) {
        return new Token(createAccessToken(payload), 
                createRefreshToken(payload));
    }

    public String createAccessToken(TokenPayload payload) {
        return Jwts.builder()
            .setSubject(payload.getUserId().toString())
            .addClaims(Map.of("deviceId", payload.getDeviceId()))
            .setIssuedAt(payload.getIssuedAt())
            .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

    public String createRefreshToken(TokenPayload payload) {
        return Jwts.builder()
            .setSubject(payload.getUserId().toString())
            .addClaims(Map.of("deviceId", payload.getDeviceId()))
            .setIssuedAt(payload.getIssuedAt())
            .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpiration))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

    public TokenPayload getPayload(String token) {
        Claims claims = Jwts.parserBuilder()
            .setSigningKey(secretKey.getBytes())
            .build()
            .parseClaimsJws(token)
            .getBody();

        return TokenPayload.builder()
            .userId(Long.parseLong(claims.getSubject()))
            .deviceId(claims.get("deviceId", String.class))
            .issuedAt(claims.getIssuedAt())
            .build();
    }

    public Authentication getAuthentication(String token) {
        TokenPayload payload = getPayload(token);
        UserDetails userDetails = User.withUsername(payload.getUserId().toString()).build();

        return new UsernamePasswordAuthenticationToken(
            userDetails, "", userDetails.getAuthorities());
    }

    public boolean validateToken(String token) {
        Jwts.parserBuilder()
            .setSigningKey(secretKey.getBytes())
            .build()
            .parseClaimsJws(token);
        return true;
    }
}
