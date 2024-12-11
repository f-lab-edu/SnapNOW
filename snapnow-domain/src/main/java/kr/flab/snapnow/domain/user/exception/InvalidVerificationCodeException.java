package kr.flab.snapnow.domain.user.exception;

import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.user.enums.UserExceptionType;

public class InvalidVerificationCodeException extends BadRequestException {

    public InvalidVerificationCodeException() {
        super(UserExceptionType.INVALID_VERIFICATION_CODE);
    }

    public InvalidVerificationCodeException(String message) {
        super(UserExceptionType.INVALID_VERIFICATION_CODE, message);
    }

    public InvalidVerificationCodeException(Throwable cause) {
        super(UserExceptionType.INVALID_VERIFICATION_CODE, cause);
    }

    public InvalidVerificationCodeException(String message, Throwable cause) {
        super(UserExceptionType.INVALID_VERIFICATION_CODE, message, cause);
    }
}
