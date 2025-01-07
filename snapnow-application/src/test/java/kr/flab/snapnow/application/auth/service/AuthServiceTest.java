package kr.flab.snapnow.application.auth.service;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.lang.reflect.Field;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import kr.flab.snapnow.application.auth.jwt.JwtProvider;
import kr.flab.snapnow.application.auth.jwt.TokenPayload;
import kr.flab.snapnow.application.auth.usecase.dto.EmailSignInRequest;
import kr.flab.snapnow.application.auth.usecase.dto.ReissueRequest;
import kr.flab.snapnow.application.auth.usecase.dto.SignOutRequest;
import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.user.model.userAccount.credential.EmailCredential;

public class AuthServiceTest {

    private JwtProvider jwtProvider;

    @Mock
    private CredentialService credentialService;

    @Mock
    private PasswordService passwordService;

    @Mock
    private DeviceCredentialService deviceCredentialService;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.openMocks(this);
        jwtProvider = new JwtProvider();
        authService = new AuthService(jwtProvider, credentialService, passwordService, deviceCredentialService);

        Field secretKeyfield = JwtProvider.class.getDeclaredField("secretKey");
        secretKeyfield.setAccessible(true);
        secretKeyfield.set(jwtProvider,
                "SecretKeyForTestakfjafafkdfkajfldjfdfldafjdalfkdlfjdlkfjakfldjklfjdfdkfafdjaf");
        Field accessTokenExpirationField = JwtProvider.class.getDeclaredField("accessTokenExpiration");
        accessTokenExpirationField.setAccessible(true);
        accessTokenExpirationField.set(jwtProvider, 3600L);
        Field refreshTokenExpirationField = JwtProvider.class.getDeclaredField("refreshTokenExpiration");
        refreshTokenExpirationField.setAccessible(true);
        refreshTokenExpirationField.set(jwtProvider, 86400L);
    }

    @Test
    void signIn() {
        // given
        Long userId = 1L;
        Email email = new Email("test@test.com");
        String password = "password";
        String deviceId = "deviceId";
        EmailCredential credential = EmailCredential.builder()
            .userId(userId)
            .email(email)
            .password(password)
            .build();

        when(credentialService.get(email)).thenReturn(credential);
        when(passwordService.isPasswordMatch(password, password)).thenReturn(true);

        // when
        Token token = authService.signIn(EmailSignInRequest.builder()
            .email(email.getValue())
            .password(password)
            .deviceId(deviceId)
            .build());

        // then
        verify(deviceCredentialService).login(userId, deviceId, token.getRefreshToken());
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
        TokenPayload tokenPayload = TokenPayload.builder()
            .userId(userId)
            .deviceId(deviceId)
            .issuedAt(new Date())
            .build();
        Token token = jwtProvider.createToken(tokenPayload);
        when(deviceCredentialService.isLogin(userId, deviceId)).thenReturn(true);

        //when
        Token newToken = authService.reissue(ReissueRequest.builder()
            .accessToken(token.getAccessToken())
            .refreshToken(token.getRefreshToken())
            .deviceId(deviceId)
            .build());

        //then
        verify(deviceCredentialService).updateRefreshToken(userId, deviceId, token.getRefreshToken());
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
        authService.signOut(SignOutRequest.builder()
            .userId(userId)
            .deviceId(deviceId)
            .build());

        //then
        verify(deviceCredentialService).logout(userId, deviceId);
    }
}

