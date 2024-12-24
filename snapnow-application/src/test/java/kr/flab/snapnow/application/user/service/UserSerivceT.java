package kr.flab.snapnow.application.user.service;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import kr.flab.snapnow.core.exception.ForbiddenException;
import kr.flab.snapnow.domain.auth.DeviceCredential;
import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.user.model.User;
import kr.flab.snapnow.domain.user.model.userAccount.credential.*;
import kr.flab.snapnow.application.auth.service.*;
import kr.flab.snapnow.application.user.fixture.UserFixture;
import kr.flab.snapnow.application.user.output.UserOutputPort;
import kr.flab.snapnow.application.email.VerificationType;
import kr.flab.snapnow.application.email.service.EmailService;

public class UserSerivceT {

    @Mock
    private AuthService authService;
    @Mock
    private CredentialService credentialService;
    @Mock
    private DeviceCredentialService deviceCredentialService;
    @Mock
    private EmailService emailService;
    @Mock
    private UserOutputPort userOutputPort;
    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void signUp() {
        // given
        Long userId = 1L;
        User user = UserFixture.createUser();
        Email email = user.getAccount().getCredential().getEmail();
        DeviceCredential deviceCredential = DeviceCredential.builder()
                .userId(userId)
                .deviceId(user.getUserDevice().getDevices().get(0).getDeviceId())
                .build();
        EmailCredential userCredential = EmailCredential.builder()
                .userId(userId)
                .email(user.getAccount().getCredential().getEmail())
                .password(((EmailCredential) user.getAccount().getCredential()).getPassword())
                .build();

        when(credentialService.get(email))
            .thenReturn(userCredential);
        when(emailService.isSuccess(
            user.getAccount().getCredential().getEmail(),
            VerificationType.SIGNUP)).thenReturn(true);
        when(authService.signIn(
                user.getAccount().getCredential().getEmail(),
                ((EmailCredential) user.getAccount().getCredential()).getPassword(),
                user.getUserDevice().getDevices().get(0).getDeviceId()))
            .thenReturn(new Token("accessToken", "refreshToken"));

        // when & then
        assertEquals(userService.signUp(user), new Token("accessToken", "refreshToken"));
        verify(deviceCredentialService).insert(deviceCredential);
        verify(userOutputPort).insert(user);
    }

    @Test
    public void failSignUpEmailNotVerified() {
        // given
        User user = UserFixture.createUser();
        when(emailService.isSuccess(user.getAccount().getCredential().getEmail(),
                VerificationType.SIGNUP)).thenReturn(false);

        // when & then
        assertThrows(ForbiddenException.class, () -> userService.signUp(user));
    }
    
    @Test
    public void deleteEmailUser() {
        // given
        Long userId = 1L;
        String password = "password";
        EmailCredential credential = UserFixture.createEmailCredential();
        DeviceCredential deviceCredential1 = DeviceCredential.builder()
                .userId(userId)
                .deviceId("device1")
                .build();
        DeviceCredential deviceCredential2 = DeviceCredential.builder()
                .userId(userId)
                .deviceId("device2")
                .build();

        when(deviceCredentialService.getAll(userId))
            .thenReturn(Arrays.asList(deviceCredential1, deviceCredential2));
        when(credentialService.get(userId)).thenReturn(credential);
        when(credentialService.isPasswordMatch(userId, password)).thenReturn(true);

        // when & then
        userService.deleteEmailUser(userId, password, null);
        verify(deviceCredentialService).delete(userId, deviceCredential1.getDeviceId());
        verify(deviceCredentialService).delete(userId, deviceCredential2.getDeviceId());
        verify(userOutputPort).delete(userId, null);
    }
    
    @Test
    public void deleteOAuthUser() {
        // given
        Long userId = 1L;
        String deleteReason = "test";
        OAuthCredential credential = UserFixture.createOAuthCredential();
        DeviceCredential deviceCredential1 = DeviceCredential.builder()
                .userId(userId)
                .deviceId("device1")
                .build();
        DeviceCredential deviceCredential2 = DeviceCredential.builder()
                .userId(userId)
                .deviceId("device2")
                .build();

        when(deviceCredentialService.getAll(userId))
            .thenReturn(Arrays.asList(deviceCredential1, deviceCredential2));
        when(credentialService.get(userId)).thenReturn(credential);
        when(emailService.isSuccess(credential.getEmail(), VerificationType.DELETE_ID))
            .thenReturn(true);

        // when & then
        userService.deleteOAuthUser(userId, deleteReason);
        verify(deviceCredentialService).delete(userId, deviceCredential1.getDeviceId());
        verify(deviceCredentialService).delete(userId, deviceCredential2.getDeviceId());
        verify(userOutputPort).delete(userId, deleteReason);
    }
}
