package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.exception.IllegalArgumentException;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

public class UserAlreadyExistException extends IllegalArgumentException {

    public UserAlreadyExistException() {
        super(UserExceptionType.USER_ALREADY_EXISTS);
    }

    public UserAlreadyExistException(UserExceptionType userExceptionType) {
        super(userExceptionType);
    }

    public UserAlreadyExistException(String message) {
        super(UserExceptionType.USER_ALREADY_EXISTS, message);
    }

    public UserAlreadyExistException(Throwable cause) {
        super(UserExceptionType.USER_ALREADY_EXISTS, cause);
    }
}
