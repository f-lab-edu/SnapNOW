package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.exception.UnAuthorizedException;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

public class EmailVerificationException extends UnAuthorizedException {

    public EmailVerificationException() {
        super(UserExceptionType.EMAIL_NOT_VERIFIED);
    }

    public EmailVerificationException(UserExceptionType exceptionType) {
        super(exceptionType);
    }

    public EmailVerificationException(String message) {
        super(UserExceptionType.EMAIL_NOT_VERIFIED, message);
    }

    public EmailVerificationException(Throwable cause) {
        super(UserExceptionType.EMAIL_NOT_VERIFIED, cause);
    }

    
}
