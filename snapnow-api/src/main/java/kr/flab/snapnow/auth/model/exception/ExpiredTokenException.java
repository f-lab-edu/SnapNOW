package kr.flab.snapnow.auth.model.exception;

import kr.flab.snapnow.auth.model.enums.AuthExceptionType;
import kr.flab.snapnow.core.exception.UnAuthorizedException;

public class ExpiredTokenException extends UnAuthorizedException {

    public ExpiredTokenException() {
        super(AuthExceptionType.EXPIRED_TOKEN);
    }

    public ExpiredTokenException(AuthExceptionType authExceptionType) {
        super(authExceptionType);
    }

    public ExpiredTokenException(String message) {
        super(AuthExceptionType.EXPIRED_TOKEN, message);
    }

    public ExpiredTokenException(Throwable cause) {
        super(AuthExceptionType.EXPIRED_TOKEN, cause);
    }
}
