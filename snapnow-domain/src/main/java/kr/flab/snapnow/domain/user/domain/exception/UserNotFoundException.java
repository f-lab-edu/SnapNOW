package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.exception.NotFoundException;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        super(UserExceptionType.USER_NOT_FOUND);
    }

    public UserNotFoundException(UserExceptionType userExceptionType) {
        super(userExceptionType);
    }

    public UserNotFoundException(String message) {
        super(UserExceptionType.USER_NOT_FOUND, message);
    }

    public UserNotFoundException(Throwable cause) {
        super(UserExceptionType.USER_NOT_FOUND, cause);
    }
}
