package kr.flab.snapnow.auth.model.exception;

import kr.flab.snapnow.auth.model.enums.AuthExceptionType;
import kr.flab.snapnow.core.exception.UnAuthorizedException;

public class InvalidTokenException extends UnAuthorizedException {

    public InvalidTokenException() {
        super(AuthExceptionType.INVALID_TOKEN);
    }

    public InvalidTokenException(AuthExceptionType authExceptionType) {
        super(authExceptionType);
    }

    public InvalidTokenException(String message) {
        super(AuthExceptionType.INVALID_TOKEN, message);
    }

    public InvalidTokenException(Throwable cause) {
        super(AuthExceptionType.INVALID_TOKEN, cause);
    }
}
