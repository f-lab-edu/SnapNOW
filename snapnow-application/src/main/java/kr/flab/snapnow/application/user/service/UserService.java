package kr.flab.snapnow.application.user.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.core.exception.ForbiddenException;
import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.auth.DeviceCredential;
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
import kr.flab.snapnow.application.auth.service.DeviceCredentialService;
import kr.flab.snapnow.application.auth.service.PasswordService;
import kr.flab.snapnow.application.email.VerificationType;
import kr.flab.snapnow.application.email.service.EmailService;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements SignUpUseCase, DeleteIdUseCase {

    private final PasswordService passwordService;
    private final AuthService authService;
    private final CredentialService credentialService;
    private final DeviceCredentialService deviceCredentialService;
    private final EmailService emailService;
    private final UserOutputPort userOutputPort;

    public Token signUp(User user) {
        Email email = user.getAccount().getCredential().getEmail();
        if (!emailService.isSuccess(
                email, VerificationType.SIGNUP)) {
            throw new ForbiddenException("Email verification is needed before signing up");
        }

        String encodedPassword = passwordService.validateAndEncodePassword(
                ((EmailCredential) user.getAccount().getCredential()).getPassword());
        ((EmailCredential) user.getAccount().getCredential()).updatePassword(encodedPassword);

        userOutputPort.insert(user);

        UserCredential userCredential = credentialService.get(email);
        Device device = user.getUserDevice().getDevices().get(0);
        DeviceCredential deviceCredential = DeviceCredential.builder()
                .userId(userCredential.getUserId())
                .deviceId(device.getDeviceId())
                .build();
        deviceCredentialService.insert(deviceCredential);

        return authService.signIn(
                email,
                encodedPassword,
                device.getDeviceId());
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
        // TODO: UserCredential, UserDevice, UserSetting, UserProfile, UserAccount 모두 삭제
        // TODO: follow, post 비동기 삭제
        List<DeviceCredential> deviceCredentials = deviceCredentialService.getAll(userId);

        for (DeviceCredential deviceCredential : deviceCredentials) {
            deviceCredentialService.delete(userId, deviceCredential.getDeviceId());
        }
        userOutputPort.delete(userId, deleteReason);
    }
}

