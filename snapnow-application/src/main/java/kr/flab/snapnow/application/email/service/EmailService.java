package kr.flab.snapnow.application.email.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.application.email.VerificationType;
import kr.flab.snapnow.application.email.usecase.EmailSendUseCase;
import kr.flab.snapnow.application.email.usecase.EmailVerificationUseCase;
import kr.flab.snapnow.application.email.output.EmailVerificationOutputPort;
import kr.flab.snapnow.application.email.output.EmailSendOutputPort;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailSendUseCase, EmailVerificationUseCase {

    private final EmailSendOutputPort emailSendOutputPort;
    private final EmailVerificationOutputPort emailVerificationOutputPort;

    public void sendEmail(String email, String content) {}

    public void sendVerificationEmail(Email email, VerificationType type) {}

    public boolean verifyVerificationCode(Email email, String code, VerificationType type) {
        return false;
    }

    public boolean isSuccess(Email email, VerificationType type) {
        return false;
    }

    public void sendVerificationCode(Email email, VerificationType type) {}
}