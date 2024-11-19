package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ExceptionCode;
import kr.flab.snapnow.core.enums.ResultCode;

public class UnAuthorizedException extends SnapnowException {

    public UnAuthorizedException() {
        super(ExceptionCode.UNAUTHORIZED);
    }

    public UnAuthorizedException(ResultCode resultCode) {
        super(resultCode);
    }

    public UnAuthorizedException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public UnAuthorizedException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public UnAuthorizedException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}
