package kr.flab.snapnow.domain.user.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.user.enums.UserExceptionType;

public class EmailAuthAttemptExceededException extends BadRequestException {

    public EmailAuthAttemptExceededException() {
        super(UserExceptionType.EMAIL_AUTH_ATTEMPT_EXCEEDED);
    }

    public EmailAuthAttemptExceededException(String message) {
        super(UserExceptionType.EMAIL_AUTH_ATTEMPT_EXCEEDED, message);
    }

    public EmailAuthAttemptExceededException(Throwable cause) {
        super(UserExceptionType.EMAIL_AUTH_ATTEMPT_EXCEEDED, cause);
    }

    public EmailAuthAttemptExceededException(String message, Throwable cause) {
        super(UserExceptionType.EMAIL_AUTH_ATTEMPT_EXCEEDED, message, cause);
    }
}
