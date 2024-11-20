package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ExceptionCode;
import kr.flab.snapnow.core.enums.ResultCode;

public class TimeoutException extends SnapnowException {

    public TimeoutException() {
        super(ExceptionCode.TIMEOUT);
    }

    public TimeoutException(ResultCode resultCode) {
        super(resultCode);
    }

    public TimeoutException(String message) {
        super(ExceptionCode.TIMEOUT, message);
    }

    public TimeoutException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public TimeoutException(String message, Throwable cause) {
        super(ExceptionCode.TIMEOUT, message, cause);
    }

    public TimeoutException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}
