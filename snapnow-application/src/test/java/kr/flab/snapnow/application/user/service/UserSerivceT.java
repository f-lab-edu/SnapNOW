package kr.flab.snapnow.application.user.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertThrows;

import kr.flab.snapnow.core.exception.ForbiddenException;
import kr.flab.snapnow.domain.user.model.User;
import kr.flab.snapnow.application.user.output.UserOutputPort;
import kr.flab.snapnow.application.email.VerificationType;
import kr.flab.snapnow.application.email.output.EmailVerificationOutputPort;
import kr.flab.snapnow.application.user.fixture.UserFixture;

public class UserSerivceT {

    @Mock
    private UserOutputPort userOutputPort;
    @Mock
    private EmailVerificationOutputPort emailVerificationOutputPort;
    @InjectMocks
    private UserService userService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSignUp() {
        // given
        User user = UserFixture.createUser();

        // when
        userService.signUp(user);

        // then
        verify(userOutputPort).insert(user);
    }

    @Test
    public void failSignUpEmailNotVerified() {
        // given
        User user = UserFixture.createUser();
        when(emailVerificationOutputPort.isSuccess(
            user.getAccount().getCredential().getEmail().getValue(),
            VerificationType.SIGNUP)).thenReturn(false);

        // when & then
        assertThrows(ForbiddenException.class, () -> userService.signUp(user));
    }
}
