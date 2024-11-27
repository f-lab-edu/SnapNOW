package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ExceptionType;
import kr.flab.snapnow.core.enums.ResultCode;

public class UnAuthorizedException extends SnapnowException {

    public UnAuthorizedException() {
        super(ExceptionType.UNAUTHORIZED);
    }

    public UnAuthorizedException(ResultCode resultCode) {
        super(resultCode);
    }

    public UnAuthorizedException(String message) {
        super(ExceptionType.UNAUTHORIZED, message);
    }

    public UnAuthorizedException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public UnAuthorizedException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public UnAuthorizedException(String message, Throwable cause) {
        super(ExceptionType.UNAUTHORIZED, message, cause);
    }

    public UnAuthorizedException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}
