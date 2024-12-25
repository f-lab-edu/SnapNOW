package kr.flab.snapnow.application.auth.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.auth.exception.InvalidTokenException;
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

    // TODO: OAuth Login 추가

    public Token signIn(Email email, String password, String deviceId) {
        if (!credentialService.isPasswordMatch(email, password)) {
            throw new WrongPasswordException();
        }
        EmailCredential userCredential = (EmailCredential) credentialService.get(email);

        Token token = issue(userCredential.getUserId(), deviceId);
        TokenPayload payload = jwtProvider.getPayload(token.getRefreshToken());
        LocalDateTime expiredAt = payload.getExpiredAt().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        deviceCredentialService.login(
            userCredential.getUserId(), deviceId, token.getRefreshToken(), expiredAt);

        return token;
    }

    public Token reissue(Token token) {
        TokenPayload payload = jwtProvider.getPayload(token.getAccessToken());
        TokenPayload refreshTokenPayload = jwtProvider.getPayload(token.getRefreshToken());

        if (!payload.getUserId().equals(refreshTokenPayload.getUserId()) 
            || !payload.getDeviceId().equals(refreshTokenPayload.getDeviceId())) {
            throw new InvalidTokenException("Access token and refresh token are not matched");
        }

        Token newToken = issue(payload.getUserId(), payload.getDeviceId());
        TokenPayload newPayload = jwtProvider.getPayload(newToken.getRefreshToken());
        LocalDateTime newExpiredAt = newPayload.getExpiredAt().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        deviceCredentialService.reissue(payload.getUserId(), payload.getDeviceId(),
                newToken.getRefreshToken(), newExpiredAt);

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

        System.out.println("AuthService.issue() payload.getExpiredAt(): " + payload.getExpiredAt());
        return jwtProvider.createToken(payload);
    }
}

