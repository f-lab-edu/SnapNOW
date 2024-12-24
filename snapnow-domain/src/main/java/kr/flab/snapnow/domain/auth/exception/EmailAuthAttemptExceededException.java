package kr.flab.snapnow.domain.auth.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.auth.enums.AuthExceptionType;

public class EmailAuthAttemptExceededException extends BadRequestException {

    public EmailAuthAttemptExceededException() {
        super(AuthExceptionType.EMAIL_AUTH_ATTEMPT_EXCEEDED);
    }

    public EmailAuthAttemptExceededException(String message) {
        super(AuthExceptionType.EMAIL_AUTH_ATTEMPT_EXCEEDED, message);
    }

    public EmailAuthAttemptExceededException(Throwable cause) {
        super(AuthExceptionType.EMAIL_AUTH_ATTEMPT_EXCEEDED, cause);
    }

    public EmailAuthAttemptExceededException(String message, Throwable cause) {
        super(AuthExceptionType.EMAIL_AUTH_ATTEMPT_EXCEEDED, message, cause);
    }
}
