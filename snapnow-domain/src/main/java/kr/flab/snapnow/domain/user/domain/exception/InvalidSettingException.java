package kr.flab.snapnow.domain.user.domain.exception;

import kr.flab.snapnow.core.enums.ResultCode;
import kr.flab.snapnow.core.exception.IllegalArgumentException;
<<<<<<< HEAD:snapnow-domain/src/main/java/kr/flab/snapnow/domain/user/exception/InvalidSettingException.java
import kr.flab.snapnow.domain.user.enums.UserExceptionCode;
=======
import kr.flab.snapnow.domain.user.domain.enums.UserExceptionType;
>>>>>>> 24e91f7 (rename(model): Move model (domain) files into model (domain) folder):snapnow-domain/src/main/java/kr/flab/snapnow/domain/user/domain/exception/InvalidSettingException.java

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
