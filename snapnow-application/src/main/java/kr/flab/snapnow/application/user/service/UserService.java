package kr.flab.snapnow.application.user.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.core.exception.ForbiddenException;
import kr.flab.snapnow.domain.auth.Token;
import kr.flab.snapnow.domain.user.model.User;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.user.model.userDevice.Device;
import kr.flab.snapnow.application.user.usecase.DeleteIdUseCase;
import kr.flab.snapnow.application.user.usecase.SignUpUseCase;
import kr.flab.snapnow.application.user.output.UserOutputPort;
import kr.flab.snapnow.application.auth.service.AuthService;
import kr.flab.snapnow.application.email.VerificationType;
import kr.flab.snapnow.application.email.service.EmailService;

@Service
@RequiredArgsConstructor
public class UserService implements SignUpUseCase, DeleteIdUseCase {

    private final AuthService authService;
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
        return authService.issue(email, device.getDeviceId());
    }

}
