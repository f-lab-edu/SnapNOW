package kr.flab.snapnow.application.user.service;

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
        User user = UserFixture.createUser();
        when(emailService.isSuccess(
            user.getAccount().getCredential().getEmail(),
            VerificationType.SIGNUP)).thenReturn(true);
        when(authService.issue(
            user.getAccount().getCredential().getEmail(),
            user.getUserDevice().getDevices().get(0).getDeviceId()))
            .thenReturn(new Token("accessToken", "refreshToken"));

        // when & then
        assertEquals(userService.signUp(user), new Token("accessToken", "refreshToken"));
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

        System.out.println("credential.getAuthProvider(): " + credential.getAuthProvider());
        when(credentialService.getCredential(userId)).thenReturn(credential);
        when(credentialService.isPasswordMatch(userId, password)).thenReturn(true);

        // when & then
        userService.deleteEmailUser(userId, password, null);
        verify(userOutputPort).delete(userId, null);
    }
    
    @Test
    public void deleteOAuthUser() {
        // given
        Long userId = 1L;
        String deleteReason = "test";
        OAuthCredential credential = UserFixture.createOAuthCredential();

        when(credentialService.getCredential(userId)).thenReturn(credential);
        when(emailService.isSuccess(credential.getEmail(), VerificationType.DELETE_ID))
            .thenReturn(true);

        // when & then
        userService.deleteOAuthUser(userId, deleteReason);
        verify(userOutputPort).delete(userId, deleteReason);
    }
}
