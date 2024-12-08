package kr.flab.snapnow.domain.user.service;

import org.springframework.stereotype.Service;
import kr.flab.snapnow.domain.user.domain.model.userAccount.UserCredential;
import kr.flab.snapnow.domain.user.useCase.UserCredentialUseCase;

@Service
public class UserCredentialService implements UserCredentialUseCase {

    public UserCredential getCredential(Long userId) {
        return null;
    }

    public void sendVerificationCode(String email) {

    }

    public void verifyCode(String email, String code) {

    }

    public void updatePassword(Long userId, String originalPassword, String newPassword) {
        
    }
}
