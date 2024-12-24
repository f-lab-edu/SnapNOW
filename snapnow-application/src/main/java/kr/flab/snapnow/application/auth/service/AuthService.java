package kr.flab.snapnow.application.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.auth.exception.WrongPasswordException;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.user.model.userAccount.credential.EmailCredential;
import kr.flab.snapnow.application.auth.jwt.TokenPayload;
import kr.flab.snapnow.application.auth.jwt.JwtProvider;
import kr.flab.snapnow.application.auth.usecase.AuthUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final JwtProvider jwtProvider;
    private final CredentialService credentialService;
    private final DeviceCredentialService deviceCredentialService;

    public Token signIn(Email email, String password, String deviceId) {
        if (!credentialService.isPasswordMatch(email, password)) {
            throw new WrongPasswordException();
        }
        EmailCredential userCredential = (EmailCredential) credentialService.get(email);

        Token token = issue(userCredential.getUserId(), deviceId);

        deviceCredentialService.login(
            userCredential.getUserId(), deviceId, token.getRefreshToken());

        return token;
    }

    public Token reissue(Token token, String deviceId) {
        return null;
    }
    
    public void signOut(Long userId, String deviceId) {
        deviceCredentialService.logout(userId, deviceId);
    }

    private Token issue(Long userId, String deviceId) {
        TokenPayload payload = TokenPayload.builder()
            .userId(userId)
            .deviceId(deviceId)
            .build();

        return jwtProvider.createToken(payload);
    }
}

