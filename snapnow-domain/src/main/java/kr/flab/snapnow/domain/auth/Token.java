package kr.flab.snapnow.domain.auth;

import java.util.Objects;

import lombok.Getter;

@Getter
public class Token {

    private String accessToken;
    private String refreshToken;

    public Token(String accessToken, String refreshToken) {
        if (accessToken == null || refreshToken == null) {
            throw new IllegalArgumentException("Access token and refresh token are required");
        }
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Token token = (Token) obj;
        return Objects.equals(accessToken, token.accessToken)
                && Objects.equals(refreshToken, token.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, refreshToken);
    }
}
