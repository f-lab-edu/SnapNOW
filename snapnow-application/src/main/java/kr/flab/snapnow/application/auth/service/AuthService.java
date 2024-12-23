package kr.flab.snapnow.application.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.user.model.userAccount.credential.EmailCredential;
import kr.flab.snapnow.application.auth.jwt.JwtProvider;
import kr.flab.snapnow.application.auth.service.DeviceCredentialService;
import kr.flab.snapnow.application.auth.usecase.AuthUseCase;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final JwtProvider jwtProvider;
    private final CredentialService credentialService;
    private final DeviceCredentialService deviceCredentialService;

    public Token signIn(Email email, String password, String deviceId) {
        EmailCredential userCredential = (EmailCredential) credentialService.get(email);

        if (!credentialService.isPasswordMatch(userCredential.getUserId(), password)) {
            throw new WrongPasswordException();
        }
    }

    public Token issue(Long userId, String deviceId) {
        return null;
    }

    public Token reissue(Token token, String deviceId) {
        return null;
    }

    public void signOut(Long userId, String deviceId) {
    }
}

