package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.exception.IllegalArgumentException;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

public class IdentityRequiredException extends IllegalArgumentException {

    public IdentityRequiredException() {
        super(UserExceptionType.IDENTITY_REQUIRED);
    }

    public IdentityRequiredException(UserExceptionType userExceptionType) {
        super(userExceptionType);
    }

    public IdentityRequiredException(String message) {
        super(UserExceptionType.IDENTITY_REQUIRED, message);
    }

    public IdentityRequiredException(Throwable cause) {
        super(UserExceptionType.IDENTITY_REQUIRED, cause);
    }
}
