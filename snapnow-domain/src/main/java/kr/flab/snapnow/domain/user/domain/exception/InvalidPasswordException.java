package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.exception.IllegalArgumentException;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

public class InvalidPasswordException extends IllegalArgumentException {

    public InvalidPasswordException() {
        super(UserExceptionType.INVALID_PASSWORD);
    }

    public InvalidPasswordException(UserExceptionType userExceptionType) {
        super(userExceptionType);
    }

    public InvalidPasswordException(String message) {
        super(UserExceptionType.INVALID_PASSWORD, message);
    }

    public InvalidPasswordException(Throwable cause) {
        super(UserExceptionType.INVALID_PASSWORD, cause);
    }
}
