package kr.flab.snapnow.application.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.application.auth.output.CredentialOutputPort;
import kr.flab.snapnow.application.auth.usecase.GetCredentialUseCase;
import kr.flab.snapnow.application.auth.usecase.UpdatePasswordUseCase;
import kr.flab.snapnow.domain.user.model.userAccount.credential.EmailCredential;
import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;

@Service
@RequiredArgsConstructor
public class CredentialService implements GetCredentialUseCase, UpdatePasswordUseCase {

    private final CredentialOutputPort credentialOutputPort;
    private final PasswordService passwordService;

    public UserCredential getCredential(Long userId) {
        return credentialOutputPort.get(userId);
    }

    public boolean isPasswordMatch(Long userId, String password) {
        return false;
    }

    public void updatePassword(Long userId, String originalPassword, String newPassword) {
    }
}
