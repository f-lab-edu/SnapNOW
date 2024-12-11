package kr.flab.snapnow.application.auth.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Component;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;

@Component
public class JwtProvider {

    public Token createToken(UserCredential userCredential) {
        return new Token(createAccessToken(userCredential), createRefreshToken(userCredential));
    }

    public Token createToken(Token token) {
        return new Token(createAccessToken(token), createRefreshToken(token));
    }

    private String createAccessToken(UserCredential userCredential) {
        return null;
    }

    private String createAccessToken(Token token) {
        return null;
    }

    private String createRefreshToken(UserCredential userCredential) {
        return null;
    }

    private String createRefreshToken(Token token) {
        return null;
    }

    public boolean validateToken(String token) {
        return false;
    }
}
