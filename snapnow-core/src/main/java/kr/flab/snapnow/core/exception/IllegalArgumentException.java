package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ExceptionType;
import kr.flab.snapnow.core.enums.ResultCode;

public class IllegalArgumentException extends SnapnowException {

    public IllegalArgumentException() {
        super(ExceptionType.ILLEGAL_ARGUMENT);
    }

    public IllegalArgumentException(ResultCode resultCode) {
        super(resultCode);
    }
    
    public IllegalArgumentException(String message) {
        super(ExceptionType.ILLEGAL_ARGUMENT, message);
    }

    public IllegalArgumentException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public IllegalArgumentException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public IllegalArgumentException(String message, Throwable cause) {
        super(ExceptionType.ILLEGAL_ARGUMENT, message, cause);
    }

    public IllegalArgumentException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}