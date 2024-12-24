package kr.flab.snapnow.domain.auth.exception;

import kr.flab.snapnow.core.exception.UnAuthorizedException;
import kr.flab.snapnow.domain.auth.enums.AuthExceptionType;

public class EmailVerificationException extends UnAuthorizedException {

    public EmailVerificationException() {
        super(AuthExceptionType.EMAIL_NOT_VERIFIED);
    }

    public EmailVerificationException(AuthExceptionType exceptionType) {
        super(exceptionType);
    }

    public EmailVerificationException(String message) {
        super(AuthExceptionType.EMAIL_NOT_VERIFIED, message);
    }

    public EmailVerificationException(Throwable cause) {
        super(AuthExceptionType.EMAIL_NOT_VERIFIED, cause);
    }

    public EmailVerificationException(String message, Throwable cause) {
        super(AuthExceptionType.EMAIL_NOT_VERIFIED, message, cause);
    }

}
