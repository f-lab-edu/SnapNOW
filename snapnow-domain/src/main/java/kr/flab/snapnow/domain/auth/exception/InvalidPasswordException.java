package kr.flab.snapnow.domain.auth.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.auth.enums.AuthExceptionType;

public class InvalidPasswordException extends BadRequestException {

    public InvalidPasswordException() {
        super(AuthExceptionType.INVALID_PASSWORD);
    }

    public InvalidPasswordException(String message) {
        super(AuthExceptionType.INVALID_PASSWORD, message);
    }

    public InvalidPasswordException(Throwable cause) {
        super(AuthExceptionType.INVALID_PASSWORD, cause);
    }

    public InvalidPasswordException(String message, Throwable cause) {
        super(AuthExceptionType.INVALID_PASSWORD, message, cause);
    }
}
