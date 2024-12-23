package kr.flab.snapnow.application.auth.service;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.application.auth.jwt.JwtProvider;
import kr.flab.snapnow.application.auth.jwt.TokenPayload;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;

public class AuthServiceT {

    private JwtProvider jwtProvider = new JwtProvider();

    @Mock
    private CredentialService credentialService;

    @Mock
    private DeviceCredentialService deviceCredentialService;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void signIn() {
        // given
        Long userId = 1L;
        Email email = new Email("test@test.com");
        String password = "password";
        String deviceId = "deviceId";
        when(credentialService
                .isPasswordMatch(userId, password)).thenReturn(true);

        // when
        Token token = authService.signIn(email, password, deviceId);

        // then
        verify(deviceCredentialService).login(userId, deviceId, token.getRefreshToken());
        assertEquals(jwtProvider.getPayload(token.getAccessToken()).getUserId(), userId);
        assertEquals(jwtProvider.getPayload(token.getAccessToken()).getDeviceId(), deviceId);
        assertEquals(jwtProvider.getPayload(token.getRefreshToken()).getUserId(), userId);
        assertEquals(jwtProvider.getPayload(token.getRefreshToken()).getDeviceId(), deviceId);
    }

    @Test
    void issue() {
        // given
        Long userId = 1L;
        String deviceId = "deviceId";

        //when
        Token token = authService.issue(userId, deviceId);

        //then
        verify(deviceCredentialService).reissue(userId, deviceId, token.getRefreshToken());
        assertEquals(jwtProvider.getPayload(token.getAccessToken()).getUserId(), userId);
        assertEquals(jwtProvider.getPayload(token.getAccessToken()).getDeviceId(), deviceId);
        assertEquals(jwtProvider.getPayload(token.getRefreshToken()).getUserId(), userId);
        assertEquals(jwtProvider.getPayload(token.getRefreshToken()).getDeviceId(), deviceId);
    }

    @Test
    void reissue() {
        // given
        Long userId = 1L;
        String deviceId = "deviceId";
        Token token = new Token("accessToken", "refreshToken");
        TokenPayload tokenPayload = TokenPayload.builder()
            .userId(userId)
            .deviceId(deviceId)
            .issuedAt(new Date())
            .build();

        //when
        Token newToken = authService.reissue(token, deviceId);

        //then
        verify(deviceCredentialService).reissue(userId, deviceId, token.getRefreshToken());
        assertEquals(jwtProvider.getPayload(newToken.getAccessToken()).getUserId(), tokenPayload.getUserId());
        assertEquals(jwtProvider.getPayload(newToken.getAccessToken()).getDeviceId(), tokenPayload.getDeviceId());
        assertEquals(jwtProvider.getPayload(newToken.getRefreshToken()).getUserId(), tokenPayload.getUserId());
        assertEquals(jwtProvider.getPayload(newToken.getRefreshToken()).getDeviceId(), tokenPayload.getDeviceId());
    }

    @Test
    void signOut() {
        // given
        Long userId = 1L;
        String deviceId = "deviceId";

        //when
        authService.signOut(userId, deviceId);

        //then
        verify(deviceCredentialService).logout(userId, deviceId);
    }
}

