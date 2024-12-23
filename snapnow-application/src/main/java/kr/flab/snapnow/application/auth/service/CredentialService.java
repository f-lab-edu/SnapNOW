package kr.flab.snapnow.application.auth.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.application.auth.output.CredentialOutputPort;
import kr.flab.snapnow.application.auth.usecase.GetCredentialUseCase;
import kr.flab.snapnow.application.auth.usecase.UpdatePasswordUseCase;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.user.model.userAccount.credential.EmailCredential;
import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;

@Service
@RequiredArgsConstructor
public class CredentialService implements GetCredentialUseCase, UpdatePasswordUseCase {

    private final CredentialOutputPort credentialOutputPort;
    private final PasswordService passwordService;

    public UserCredential get(Long userId) {
        return credentialOutputPort.get(userId);
    }

    public UserCredential get(Email email) {
        return credentialOutputPort.get(email);
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

        passwordService.updatePassword(userCredential, newPassword);
        credentialOutputPort.updatePassword(userId, newPassword);
    }
}
