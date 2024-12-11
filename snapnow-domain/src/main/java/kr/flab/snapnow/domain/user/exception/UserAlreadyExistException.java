package kr.flab.snapnow.domain.user.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.user.enums.UserExceptionType;

public class UserAlreadyExistException extends BadRequestException {

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
