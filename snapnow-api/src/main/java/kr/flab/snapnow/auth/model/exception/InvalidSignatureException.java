package kr.flab.snapnow.auth.model.exception;

import kr.flab.snapnow.auth.model.enums.AuthExceptionType;
import kr.flab.snapnow.core.exception.UnAuthorizedException;

public class InvalidSignatureException extends UnAuthorizedException {

    public InvalidSignatureException() {
        super(AuthExceptionType.INVALID_SIGNATURE);
    }

    public InvalidSignatureException(AuthExceptionType authExceptionType) {
        super(authExceptionType);
    }

    public InvalidSignatureException(String message) {
        super(AuthExceptionType.INVALID_SIGNATURE, message);
    }

    public InvalidSignatureException(Throwable cause) {
        super(AuthExceptionType.INVALID_SIGNATURE, cause);
    }
}
