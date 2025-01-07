package kr.flab.snapnow.domain.auth.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.auth.enums.AuthExceptionType;

public class WrongPasswordException extends BadRequestException {

    public WrongPasswordException() {
        super(AuthExceptionType.WRONG_PASSWORD);
    }

    public WrongPasswordException(String message) {
        super(AuthExceptionType.WRONG_PASSWORD, message);
    }

    public WrongPasswordException(Throwable cause) {
        super(AuthExceptionType.WRONG_PASSWORD, cause);
    }

    public WrongPasswordException(String message, Throwable cause) {
        super(AuthExceptionType.WRONG_PASSWORD, message, cause);
    }
}
