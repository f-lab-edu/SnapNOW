package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ExceptionCode;
import kr.flab.snapnow.core.enums.ResultCode;

public class IllegalArgumentException extends SnapnowException {

    public IllegalArgumentException() {
        super(ExceptionCode.ILLEGAL_ARGUMENT);
    }

    public IllegalArgumentException(ResultCode resultCode) {
        super(resultCode);
    }
    
    public IllegalArgumentException(String message) {
        super(ExceptionCode.ILLEGAL_ARGUMENT, message);
    }

    public IllegalArgumentException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public IllegalArgumentException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public IllegalArgumentException(String message, Throwable cause) {
        super(ExceptionCode.ILLEGAL_ARGUMENT, message, cause);
    }

    public IllegalArgumentException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}