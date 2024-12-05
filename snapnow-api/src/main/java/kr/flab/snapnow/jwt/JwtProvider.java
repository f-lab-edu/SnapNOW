package kr.flab.snapnow.jwt;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import kr.flab.snapnow.auth.model.dto.response.TokenResponse;
import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;

@Component
public class JwtProvider {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.access-token-expiration}")
    private Long accessTokenExpiration;

    @Value("${jwt.refresh-token-expiration}")
    private Long refreshTokenExpiration;

    public TokenResponse createToken(Long userId) {
        return new TokenResponse(createAccessToken(userId), createRefreshToken(userId));
    }

    public String createAccessToken(Long userId) {
        return Jwts.builder()
            .setSubject(userId.toString())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

    public String createRefreshToken(Long userId) {
        return Jwts.builder()
            .setSubject(userId.toString())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpiration))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

    public String createSecurityToken(String providerId, AuthProvider authProvider) {
        return Jwts.builder()
            .setSubject(providerId)
            .claim("authProvider", authProvider)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

    public Long getUserId(String token) {
        return Long.parseLong(Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token)
            .getBody()
            .getSubject());
    }

    public Authentication getAuthentication(String token) {
        Long userId = getUserId(token);
        UserDetails userDetails = User.withUsername(userId.toString())
                .password("")
                .build();

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public boolean validateToken(String token) 
            throws ExpiredJwtException, MalformedJwtException, SignatureException,
            UnsupportedJwtException, IllegalArgumentException {
        Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

        return true;
    }
}
