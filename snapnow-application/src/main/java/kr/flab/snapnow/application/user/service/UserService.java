package kr.flab.snapnow.application.user.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.core.exception.ForbiddenException;
import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.auth.exception.UserNotMatchPasswordException;
import kr.flab.snapnow.domain.user.enums.account.AuthProvider;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.user.model.userAccount.credential.UserCredential;
import kr.flab.snapnow.domain.user.model.userProfile.UserProfile;
import kr.flab.snapnow.domain.user.model.userDevice.Device;
import kr.flab.snapnow.application.user.usecase.dto.UserCreateDto;
import kr.flab.snapnow.application.user.usecase.DeleteIdUseCase;
import kr.flab.snapnow.application.user.usecase.SignUpUseCase;
import kr.flab.snapnow.application.user.output.UserOutputPort;
import kr.flab.snapnow.application.auth.service.AuthService;
import kr.flab.snapnow.application.auth.service.CredentialService;
import kr.flab.snapnow.application.email.VerificationType;
import kr.flab.snapnow.application.email.service.EmailService;
import kr.flab.snapnow.application.auth.usecase.dto.IssueRequest;

@Service
@RequiredArgsConstructor
public class UserService implements SignUpUseCase, DeleteIdUseCase {

    private final UserDeviceService userDeviceService;
    private final CredentialService credentialService;
    private final UserProfileService userProfileService;
    private final UserInfoService userInfoService;
    private final UserSettingService userSettingService;
    private final AuthService authService;
    private final EmailService emailService;
    private final UserOutputPort userOutputPort;

    public Token signUp(UserCreateDto userCreateDto) {
        Email email = userCreateDto.getCredential().getEmail();

        if (!emailService.isSuccess(
            email, VerificationType.SIGNUP)) {
            throw new ForbiddenException("Email verification is needed before signing up");
        }

        Long userId = createUser(userCreateDto);
        return authService.issue(IssueRequest.builder()
            .userId(userId)
            .deviceId(userCreateDto.getDevice().getDeviceId())
            .build());
    }

    public void deleteEmailUser(Long userId, String password, String deleteReason) {
        UserCredential credential = credentialService.getCredential(userId);

        if (credential.getAuthProvider() != AuthProvider.EMAIL) {
            throw new BadRequestException("This request is not allowed for OAuth users");
        }
        if (!credentialService.isPasswordMatch(userId, password)) {
            throw new UserNotMatchPasswordException();
        }

        delete(userId, deleteReason);
    }

    public void deleteOAuthUser(Long userId, String deleteReason) {
        UserCredential credential = credentialService.getCredential(userId);

        if (credential.getAuthProvider() == AuthProvider.EMAIL) {
            throw new BadRequestException("This request is not allowed for email users");
        }
        if (!emailService.isSuccess(credential.getEmail(), VerificationType.DELETE_ID)) {
            throw new ForbiddenException(
                    "Email verification is needed before deleting OAuth account");
        }

        delete(userId, deleteReason);
    }

    @Transactional
    private Long createUser(UserCreateDto userCreateDto) {
        Long userId = userOutputPort.insert();
        Device device = userCreateDto.getDevice();
        UserCredential userCredential = userCreateDto.getCredential();
        UserProfile userProfile = userCreateDto.getProfile();

        credentialService.insert(userCredential);
        userProfileService.insert(userProfile);
        userDeviceService.insert(userId, device);
        userInfoService.insert(userId);
        userSettingService.insert(userId);

        return userId;
    }

    private void delete(Long userId, String deleteReason) {
        userOutputPort.delete(userId, deleteReason);
    }
}
