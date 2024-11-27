package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.exception.IllegalArgumentException;
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;

public class InvalidSettingException extends IllegalArgumentException {

    public InvalidSettingException() {
        super(UserExceptionType.INVALID_SETTING);
    }

    public InvalidSettingException(UserExceptionType userExceptionType) {
        super(userExceptionType);
    }

    public InvalidSettingException(String message) {
        super(UserExceptionType.INVALID_SETTING, message);
    }

    public InvalidSettingException(Throwable cause) {
        super(UserExceptionType.INVALID_SETTING, cause);
    }
}
