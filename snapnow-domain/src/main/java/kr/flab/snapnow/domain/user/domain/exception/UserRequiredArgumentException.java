package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.exception.IllegalArgumentException;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

public class UserRequiredArgumentException extends IllegalArgumentException {

    public UserRequiredArgumentException() {
        super(UserExceptionType.USER_REQUIRED_ARGUMENT);
    }

    public UserRequiredArgumentException(UserExceptionType userExceptionType) {
        super(userExceptionType);
    }

    public UserRequiredArgumentException(String message) {
        super(UserExceptionType.USER_REQUIRED_ARGUMENT, message);
    }

    public UserRequiredArgumentException(Throwable cause) {
        super(UserExceptionType.USER_REQUIRED_ARGUMENT, cause);
    }
}
