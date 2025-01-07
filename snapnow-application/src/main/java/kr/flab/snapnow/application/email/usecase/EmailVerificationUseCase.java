package kr.flab.snapnow.application.email.usecase;

import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.application.email.VerificationType;

public interface EmailVerificationUseCase {

    void sendVerificationCode(Email email, VerificationType type);

    boolean verifyVerificationCode(Email email, String code, VerificationType type);
}

