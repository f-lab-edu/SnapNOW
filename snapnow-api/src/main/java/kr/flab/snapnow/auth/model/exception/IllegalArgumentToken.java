package kr.flab.snapnow.auth.model.exception;

import kr.flab.snapnow.auth.model.enums.AuthExceptionType;
import kr.flab.snapnow.core.exception.IllegalArgumentException;

public class IllegalArgumentToken extends IllegalArgumentException {

    public IllegalArgumentToken() {
        super(AuthExceptionType.ILLEGAL_ARGUMENT_TOKEN);
    }

    public IllegalArgumentToken(AuthExceptionType authExceptionType) {
        super(authExceptionType);
    }

    public IllegalArgumentToken(String message) {
        super(AuthExceptionType.ILLEGAL_ARGUMENT_TOKEN, message);
    }

    public IllegalArgumentToken(Throwable cause) {
        super(AuthExceptionType.ILLEGAL_ARGUMENT_TOKEN, cause);
    }
}
