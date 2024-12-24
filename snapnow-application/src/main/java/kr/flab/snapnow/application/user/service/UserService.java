package kr.flab.snapnow.application.user.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.core.exception.ForbiddenException;
import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.auth.exception.WrongPasswordException;
import kr.flab.snapnow.domain.user.enums.account.AuthProvider;
import kr.flab.snapnow.domain.user.model.User;
import kr.flab.snapnow.domain.user.model.userAccount.credential.*;
import kr.flab.snapnow.domain.user.model.userDevice.Device;
import kr.flab.snapnow.application.user.usecase.DeleteIdUseCase;
import kr.flab.snapnow.application.user.usecase.SignUpUseCase;
import kr.flab.snapnow.application.user.output.UserOutputPort;
import kr.flab.snapnow.application.auth.service.AuthService;
import kr.flab.snapnow.application.auth.service.CredentialService;
import kr.flab.snapnow.application.email.VerificationType;
import kr.flab.snapnow.application.email.service.EmailService;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements SignUpUseCase, DeleteIdUseCase {

    private final AuthService authService;
    private final CredentialService credentialService;
    private final EmailService emailService;
    private final UserOutputPort userOutputPort;

    public Token signUp(User user) {
        Email email = user.getAccount().getCredential().getEmail();
        Device device = user.getUserDevice().getDevices().get(0);

        if (!emailService.isSuccess(
                email, VerificationType.SIGNUP)) {
            throw new ForbiddenException("Email verification is needed before signing up");
        }

        userOutputPort.insert(user);
        return authService.signIn(email, ((EmailCredential) user.getAccount().getCredential()).getPassword(), device.getDeviceId());
    }

    public void deleteEmailUser(Long userId, String password, String deleteReason) {
        EmailCredential credential = (EmailCredential) credentialService.get(userId);

        if (credential.getAuthProvider() != AuthProvider.EMAIL) {
            throw new BadRequestException("This request is not allowed for OAuth users");
        }
        if (!credentialService.isPasswordMatch(userId, password)) {
            throw new WrongPasswordException();
        }

        delete(userId, deleteReason);
    }

    public void deleteOAuthUser(Long userId, String deleteReason) {
        OAuthCredential credential = (OAuthCredential) credentialService.get(userId);

        if (credential.getAuthProvider() == AuthProvider.EMAIL) {
            throw new BadRequestException("This request is not allowed for email users");
        }
        if (!emailService.isSuccess(credential.getEmail(), VerificationType.DELETE_ID)) {
            throw new ForbiddenException(
                    "Email verification is needed before deleting OAuth account");
        }

        delete(userId, deleteReason);
    }

    private void delete(Long userId, String deleteReason) {
        userOutputPort.delete(userId, deleteReason);
    }
}

