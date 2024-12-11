package kr.flab.snapnow.application.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.application.auth.usecase.AuthUseCase;
import kr.flab.snapnow.application.auth.output.TokenOutputPort;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final TokenOutputPort tokenOutputPort;

    public Token signIn(Email email, String password, String deviceId) {
        return null;
    }

    public Token issue(Email email, String deviceId) {
        return null;
    }

    public Token reissue(Token token, String deviceId) {
        return null;
    }

    public void signOut(Email email, String deviceId) {
    }
}

