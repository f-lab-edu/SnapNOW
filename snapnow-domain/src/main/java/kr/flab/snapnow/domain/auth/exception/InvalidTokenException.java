package kr.flab.snapnow.domain.auth.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.auth.enums.AuthExceptionType;

public class InvalidTokenException extends BadRequestException {

    public InvalidTokenException() {
        super(AuthExceptionType.INVALID_TOKEN);
    }

    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(Throwable cause) {
        super(AuthExceptionType.INVALID_TOKEN, cause);
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(AuthExceptionType.INVALID_TOKEN, message, cause);
    }
}
