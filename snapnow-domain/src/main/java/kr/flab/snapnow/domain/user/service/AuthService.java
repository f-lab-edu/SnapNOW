package kr.flab.snapnow.domain.user.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.domain.user.useCase.AuthUseCase;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserAccount;
import kr.flab.snapnow.domain.user.domain.model.userProfile.UserProfile;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final UserCredentialService userCredentialService;

    public void signUp(UserAccount userAccount, UserProfile userProfile) {

    }

    public boolean signIn(String email, String password) {
        return false;
    }

    public String getRefreshToken(Long userId) {
        return null;
    }

    public void updateRefreshToken(Long userId, String refreshToken) {

    }

    public void signOut(Long userId) {

    }

    public void delete(Long userId, String verifiedCode) {

    }
}
