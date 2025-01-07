package kr.flab.snapnow.application.auth.service;

import java.util.Date;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.auth.exception.LogoutDeviceException;
import kr.flab.snapnow.domain.auth.exception.InvalidTokenException;
import kr.flab.snapnow.domain.auth.exception.WrongPasswordException;
import kr.flab.snapnow.application.auth.usecase.dto.EmailSignInRequest;
import kr.flab.snapnow.application.auth.usecase.dto.OAuthSignInRequest;
import kr.flab.snapnow.application.auth.usecase.dto.IssueRequest;
import kr.flab.snapnow.application.auth.usecase.dto.ReissueRequest;
import kr.flab.snapnow.application.auth.usecase.dto.SignOutRequest;
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

    // TODO: OAuth Login 추가

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
        TokenPayload payload = jwtProvider.getPayload(token.getAccessToken());
        TokenPayload refreshTokenPayload = jwtProvider.getPayload(token.getRefreshToken());

        if (!payload.getUserId().equals(refreshTokenPayload.getUserId()) 
            || !payload.getDeviceId().equals(refreshTokenPayload.getDeviceId())) {
            throw new InvalidTokenException("Access token and refresh token are not matched");
        }
        if (!deviceCredentialService.isLogin(payload.getUserId(), deviceId)) {
            throw new LogoutDeviceException();
        }

        Token newToken = issue(payload.getUserId(), deviceId);
        deviceCredentialService.updateRefreshToken(payload.getUserId(), deviceId, newToken.getRefreshToken());

        return newToken;
    }

    public void signOut(Long userId, String deviceId) {
        deviceCredentialService.logout(userId, deviceId);
    }

    private Token issue(Long userId, String deviceId) {
        TokenPayload payload = TokenPayload.builder()
            .userId(userId)
            .deviceId(deviceId)
            .issuedAt(new Date())
            .build();

        return jwtProvider.createToken(payload);
    }
}

