package kr.flab.snapnow.domain.auth.exception;

import kr.flab.snapnow.domain.auth.enums.AuthExceptionType;
import kr.flab.snapnow.core.exception.BadRequestException;

public class ExpiredTokenException extends BadRequestException {

    public ExpiredTokenException() {
        super(AuthExceptionType.EXPIRED_TOKEN);
    }

    public ExpiredTokenException(String message) {
        super(AuthExceptionType.EXPIRED_TOKEN, message);
    }

    public ExpiredTokenException(Throwable cause) {
        super(AuthExceptionType.EXPIRED_TOKEN, cause);
    }

    public ExpiredTokenException(String message, Throwable cause) {
        super(AuthExceptionType.EXPIRED_TOKEN, message, cause);
    }
}
