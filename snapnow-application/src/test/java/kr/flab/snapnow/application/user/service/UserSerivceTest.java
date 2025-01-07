package kr.flab.snapnow.application.user.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import kr.flab.snapnow.core.exception.ForbiddenException;
import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.user.model.userAccount.credential.*;
import kr.flab.snapnow.application.auth.service.*;
import kr.flab.snapnow.application.user.fixture.UserFixture;
import kr.flab.snapnow.application.user.output.UserOutputPort;
import kr.flab.snapnow.application.user.usecase.dto.UserCreateDto;
import kr.flab.snapnow.application.email.VerificationType;
import kr.flab.snapnow.application.email.service.EmailService;

@ExtendWith(MockitoExtension.class)
public class UserSerivceTest {

    @Mock
    private AuthService authService;
    @Mock
    private CredentialService credentialService;
    @Mock
    private EmailService emailService;
    @Mock
    private UserOutputPort userOutputPort;
    @Mock
    private UserProfileService userProfileService;
    @Mock
    private UserInfoService userInfoService;
    @Mock
    private UserSettingService userSettingService;
    @Mock
    private UserDeviceService userDeviceService;
    @InjectMocks
    private UserService userService;

    @Test
    public void signUp() {
        // given
        Long userId = 1L;
        UserCreateDto user = UserFixture.createUserCreateDto();
        when(emailService.isSuccess(
            user.getCredential().getEmail(),
                VerificationType.SIGNUP)).thenReturn(true);
        when(userOutputPort.insert()).thenReturn(userId);
        when(authService.signIn(userId, user.getDevice().getDeviceId()))
            .thenReturn(new Token("accessToken" + userId, "refreshToken" + userId));

        // when & then
        assertEquals(userService.signUp(user), new Token("accessToken" + userId, "refreshToken" + userId));
        verify(credentialService).insert(user.getCredential());
        verify(userProfileService).insert(user.getProfile());
        verify(userDeviceService).insert(userId, user.getDevice());
        verify(userInfoService).insert(userId);
        verify(userSettingService).insert(userId);
    }

    @Test
    public void failSignUpEmailNotVerified() {
        // given
        UserCreateDto user = UserFixture.createUserCreateDto();
        when(emailService.isSuccess(user.getCredential().getEmail(),
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

        when(credentialService.get(userId)).thenReturn(credential);
        when(credentialService.isPasswordMatch(userId, password)).thenReturn(true);

        // when & then
        userService.deleteEmailUser(userId, password, null);
        verify(credentialService).delete(userId);
        verify(userProfileService).delete(userId);
        verify(userDeviceService).deleteAll(userId);
        verify(userInfoService).delete(userId);
        verify(userSettingService).delete(userId);
        verify(userOutputPort).delete(userId, null);
    }
    
    @Test
    public void deleteOAuthUser() {
        // given
        Long userId = 1L;
        String deleteReason = "test";
        OAuthCredential credential = UserFixture.createOAuthCredential();

        when(credentialService.get(userId)).thenReturn(credential);
        when(emailService.isSuccess(credential.getEmail(), VerificationType.DELETE_ID))
            .thenReturn(true);

        // when & then
        userService.deleteOAuthUser(userId, deleteReason);
        verify(credentialService).delete(userId);
        verify(userProfileService).delete(userId);
        verify(userDeviceService).deleteAll(userId);
        verify(userInfoService).delete(userId);
        verify(userSettingService).delete(userId);
        verify(userOutputPort).delete(userId, deleteReason);
    }
}
