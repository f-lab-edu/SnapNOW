package kr.flab.snapnow.domain.auth.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.auth.enums.AuthExceptionType;

public class InvalidVerificationCodeException extends BadRequestException {

    public InvalidVerificationCodeException() {
        super(AuthExceptionType.INVALID_VERIFICATION_CODE);
    }

    public InvalidVerificationCodeException(String message) {
        super(AuthExceptionType.INVALID_VERIFICATION_CODE, message);
    }

    public InvalidVerificationCodeException(Throwable cause) {
        super(AuthExceptionType.INVALID_VERIFICATION_CODE, cause);
    }

    public InvalidVerificationCodeException(String message, Throwable cause) {
        super(AuthExceptionType.INVALID_VERIFICATION_CODE, message, cause);
    }
}
