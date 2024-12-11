package kr.flab.snapnow.domain.auth.exception;

import kr.flab.snapnow.core.enums.ResultCode;
import kr.flab.snapnow.core.exception.BadRequestException;
import kr.flab.snapnow.domain.auth.AuthExceptionType;

public class UserNotMatchPasswordException extends BadRequestException {

    public UserNotMatchPasswordException() {
        super(AuthExceptionType.USER_NOT_MATCH_PASSWORD);
    }

    public UserNotMatchPasswordException(ResultCode resultCode) {
        super(resultCode);
    }

    public UserNotMatchPasswordException(String message) {
        super(AuthExceptionType.USER_NOT_MATCH_PASSWORD, message);
    }

    public UserNotMatchPasswordException(Throwable cause) {
        super(AuthExceptionType.USER_NOT_MATCH_PASSWORD, cause);
    }
}
