package kr.flab.snapnow.domain.user.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import kr.flab.snapnow.domain.user.domain.enums.AuthProvider;
import kr.flab.snapnow.domain.user.domain.model.User;
import kr.flab.snapnow.domain.user.domain.model.userAccount.Email;
import kr.flab.snapnow.domain.user.domain.model.userAccount.Password;
import kr.flab.snapnow.domain.user.domain.model.userAccount.EmailCredential;
import kr.flab.snapnow.domain.user.domain.model.userAccount.OAuthCredential;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserCredential;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccountInfo;
import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.repository.UserRepository;

public class UserServiceTest {

    private User testUser;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        UserAccount testUserAccount = createUserAccount("email");
        UserProfile testUserProfile = createUserProfile();
        testUser = User.builder()
                .account(testUserAccount)
                .profile(testUserProfile)
                .build();
    }

    @Test
    public void testSignUp() {
        userService.signUp(testUser);
        verify(userRepository, times(1)).insert(testUser);
    }

    public User createUser() {
        return User.builder().userId(1L).build();
    }

    public UserProfile createUserProfile() {
        return UserProfile.builder()
                .userName("testUserName")
                .profileImageUrl("testProfileImageUrl")
                .build();
    }

    public UserAccount createUserAccount(String type) {
        UserCredential userCredential;
        if (type.equals("email")) {
            userCredential = createEmailCredential();
        } else {
            userCredential = createOAuthCredential();
        }
        UserAccountInfo userAccountInfo = UserAccountInfo.builder().build();
        return UserAccount.builder()
                .credential(userCredential)
                .info(userAccountInfo)
                .build();
    }

    public EmailCredential createEmailCredential() {
        return EmailCredential.builder()
                .email(new Email("test@test.com"))
                .password(new Password("test1234"))
                .build();
    }

    public OAuthCredential createOAuthCredential() {
        return OAuthCredential.builder()
                .authProvider(AuthProvider.GOOGLE)
                .providerId("testProviderId")
                .email(new Email("test@test.com"))
                .build();
    }
}
