package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

public class DeletedUserException extends BadRequestException {

    public DeletedUserException() {
        super(UserExceptionType.DELETED_USER);
    }

    public DeletedUserException(UserExceptionType userExceptionType) {
        super(userExceptionType);
    }

    public DeletedUserException(String message) {
        super(UserExceptionType.DELETED_USER, message);
    }

    public DeletedUserException(Throwable cause) {
        super(UserExceptionType.DELETED_USER, cause);
    }
}
