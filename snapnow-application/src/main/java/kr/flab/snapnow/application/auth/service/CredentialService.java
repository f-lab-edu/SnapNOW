package kr.flab.snapnow.application.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.flab.snapnow.application.auth.output.CredentialOutputPort;
import kr.flab.snapnow.application.auth.usecase.GetCredentialUseCase;
import kr.flab.snapnow.application.auth.usecase.UpdatePasswordUseCase;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.user.model.userAccount.credential.EmailCredential;
import kr.flab.snapnow.domain.user.model.userAccount.credential.OAuthCredential;
import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CredentialService implements GetCredentialUseCase, UpdatePasswordUseCase {

    private final CredentialOutputPort credentialOutputPort;
    private final PasswordService passwordService;

    @Transactional
    public void insert(UserCredential userCredential) {
        credentialOutputPort.insert(userCredential);
    }

    public UserCredential get(Long userId) {
        return credentialOutputPort.get(userId);
    }

    public UserCredential get(Email email) {
        return credentialOutputPort.get(email);
    }

    public OAuthCredential get(String providerId) {
        return credentialOutputPort.get(providerId);
    }

    public boolean isPasswordMatch(Long userId, String password) {
        EmailCredential userCredential = (EmailCredential) credentialOutputPort.get(userId);

        return passwordService.isPasswordMatch(userCredential.getPassword(), password);
    }

    public boolean isPasswordMatch(Email email, String password) {
        EmailCredential userCredential = (EmailCredential) credentialOutputPort.get(email);

        return passwordService.isPasswordMatch(userCredential.getPassword(), password);
    }

    public void updatePassword(Long userId, String originalPassword, String newPassword) {
        EmailCredential userCredential = (EmailCredential) credentialOutputPort.get(userId);

        passwordService.updatePassword(userCredential, originalPassword, newPassword);
        credentialOutputPort.updatePassword(userId, newPassword);
    }

    public void delete(Long userId) {
        credentialOutputPort.delete(userId);
    }
}
