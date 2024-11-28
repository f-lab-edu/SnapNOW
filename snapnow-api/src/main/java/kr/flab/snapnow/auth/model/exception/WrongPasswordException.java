package kr.flab.snapnow.auth.model.exception;

import kr.flab.snapnow.auth.model.enums.AuthExceptionType;
import kr.flab.snapnow.core.exception.BadRequestException;

public class WrongPasswordException extends BadRequestException {

    public WrongPasswordException() {
        super(AuthExceptionType.WRONG_PASSWORD);
    }

    public WrongPasswordException(AuthExceptionType authExceptionType) {
        super(authExceptionType);
    }

    public WrongPasswordException(String message) {
        super(AuthExceptionType.WRONG_PASSWORD, message);
    }

    public WrongPasswordException(Throwable cause) {
        super(AuthExceptionType.WRONG_PASSWORD, cause);
    }
}
