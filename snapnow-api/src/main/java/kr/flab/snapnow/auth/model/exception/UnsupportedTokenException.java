package kr.flab.snapnow.auth.model.exception;

import kr.flab.snapnow.auth.model.enums.AuthExceptionType;
import kr.flab.snapnow.core.exception.BadRequestException;

public class UnsupportedTokenException extends BadRequestException {

    public UnsupportedTokenException() {
        super(AuthExceptionType.UNSUPPORTED_TOKEN);
    }

    public UnsupportedTokenException(AuthExceptionType authExceptionType) {
        super(authExceptionType);
    }

    public UnsupportedTokenException(String message) {
        super(AuthExceptionType.UNSUPPORTED_TOKEN, message);
    }

    public UnsupportedTokenException(Throwable cause) {
        super(AuthExceptionType.UNSUPPORTED_TOKEN, cause);
    }
}
