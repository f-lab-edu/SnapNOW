package kr.flab.snapnow.application.auth.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.auth.exception.InvalidTokenException;
import kr.flab.snapnow.domain.auth.exception.WrongPasswordException;
import kr.flab.snapnow.application.auth.usecase.dto.EmailSignInRequest;
import kr.flab.snapnow.application.auth.usecase.dto.OAuthSignInRequest;
import kr.flab.snapnow.application.auth.usecase.dto.IssueRequest;
import kr.flab.snapnow.application.auth.usecase.dto.ReissueRequest;
import kr.flab.snapnow.application.auth.usecase.dto.SignOutRequest;
import kr.flab.snapnow.domain.user.model.userAccount.credential.EmailCredential;
import kr.flab.snapnow.domain.user.model.userAccount.credential.OAuthCredential;
import kr.flab.snapnow.application.auth.jwt.TokenPayload;
import kr.flab.snapnow.application.auth.jwt.JwtProvider;
import kr.flab.snapnow.application.auth.usecase.AuthUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final JwtProvider jwtProvider;
    private final CredentialService credentialService;
    private final PasswordService passwordService;
    private final DeviceCredentialService deviceCredentialService;

    public Token signIn(EmailSignInRequest request) {
        EmailCredential credential = (EmailCredential) credentialService.get(new Email(request.getEmail()));
        if (!passwordService.isPasswordMatch(credential.getPassword(), request.getPassword())) {
            throw new WrongPasswordException();
        }

        return signIn(credential.getUserId(), request.getDeviceId());
    }

    public Token signIn(OAuthSignInRequest request) {
        OAuthCredential credential = credentialService.get(request.getProviderId());
        return signIn(credential.getUserId(), request.getDeviceId());
    }

    public Token signIn(Long userId, String deviceId) {
        Token token = issue(IssueRequest.builder()
            .userId(userId)
            .deviceId(deviceId)
            .build());

        deviceCredentialService.login(userId, deviceId, token.getRefreshToken());

        return token;
    }

    public Token reissue(ReissueRequest request) {
        TokenPayload payload = jwtProvider.getPayload(request.getAccessToken());
        TokenPayload refreshTokenPayload = jwtProvider.getPayload(request.getRefreshToken());

        if (!payload.getUserId().equals(refreshTokenPayload.getUserId()) 
            || !payload.getDeviceId().equals(refreshTokenPayload.getDeviceId())) {
            throw new InvalidTokenException("Access token and refresh token are not matched");
        }
        if (!deviceCredentialService.isLogin(payload.getUserId(), request.getDeviceId())) {
            throw new LogoutDeviceException();
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

    public void signOut(SignOutRequest request) {
        deviceCredentialService.logout(request.getUserId(), request.getDeviceId());
    }

    private Token issue(IssueRequest request) {
        TokenPayload payload = TokenPayload.builder()
            .userId(request.getUserId())
            .deviceId(request.getDeviceId())
            .issuedAt(new Date())
            .build();

        System.out.println("AuthService.issue() payload.getExpiredAt(): " + payload.getExpiredAt());
        return jwtProvider.createToken(payload);
    }
}

