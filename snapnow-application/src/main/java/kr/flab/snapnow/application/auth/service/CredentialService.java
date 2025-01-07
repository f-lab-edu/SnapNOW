package kr.flab.snapnow.application.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.flab.snapnow.application.auth.output.CredentialOutputPort;
import kr.flab.snapnow.application.auth.usecase.CredentialUseCase;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CredentialService implements CredentialUseCase {

    private final CredentialOutputPort credentialOutputPort;

    @Transactional
    public void insert(UserCredential userCredential) {
        credentialOutputPort.insert(userCredential);
    }

    public UserCredential getCredential(Long userId) {
        return credentialOutputPort.get(userId);
    }

    public boolean isPasswordMatch(Long userId, String password) {
        return false;
    }

    public boolean isPasswordMatch(Email email, String password) {
        return false;
    }

    public void updatePassword(Long userId, String originalPassword, String newPassword) {
    }
}
