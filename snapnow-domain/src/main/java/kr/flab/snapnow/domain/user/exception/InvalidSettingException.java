package kr.flab.snapnow.domain.user.exception;

import kr.flab.snapnow.core.enums.ResultCode;
import kr.flab.snapnow.core.exception.IllegalArgumentException;
import kr.flab.snapnow.domain.user.enums.UserExceptionCode;

public class InvalidSettingException extends IllegalArgumentException {

    public InvalidSettingException() {
        super(UserExceptionCode.INVALID_SETTING);
    }

    public InvalidSettingException(ResultCode resultCode) {
        super(resultCode);
    }

    public InvalidSettingException(String message) {
        super(UserExceptionCode.INVALID_SETTING, message);
    }

    public InvalidSettingException(Throwable cause) {
        super(UserExceptionCode.INVALID_SETTING, cause);
    }

    public InvalidSettingException(String message, Throwable cause) {
        super(UserExceptionCode.INVALID_SETTING, message, cause);
    }
}
