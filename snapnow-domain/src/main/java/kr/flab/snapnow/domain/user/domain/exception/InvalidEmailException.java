package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.exception.IllegalArgumentException;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

public class InvalidEmailException extends IllegalArgumentException {

    public InvalidEmailException() {
        super(UserExceptionType.INVALID_EMAIL);
    }

    public InvalidEmailException(UserExceptionType userExceptionType) {
        super(userExceptionType);
    }

    public InvalidEmailException(String message) {
        super(UserExceptionType.INVALID_EMAIL, message);
    }

    public InvalidEmailException(UserExceptionType userExceptionType, String message) {
        super(userExceptionType, message);
    }

    public InvalidEmailException(Throwable cause) {
        super(UserExceptionType.INVALID_EMAIL, cause);
    }

    public InvalidEmailException(
        UserExceptionType userExceptionType, String message, Throwable cause) {
        super(userExceptionType, message, cause);
    }
}
