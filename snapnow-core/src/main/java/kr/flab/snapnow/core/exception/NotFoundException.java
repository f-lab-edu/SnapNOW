package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ExceptionType;
import kr.flab.snapnow.core.enums.ResultCode;

public class NotFoundException extends SnapnowException {

    public NotFoundException() {
        super(ExceptionType.NOT_FOUND);
    }

    public NotFoundException(ResultCode resultCode) {
        super(resultCode);
    }

    public NotFoundException(String message) {
        super(ExceptionType.NOT_FOUND, message);
    }

    public NotFoundException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public NotFoundException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public NotFoundException(String message, Throwable cause) {
        super(ExceptionType.NOT_FOUND, message, cause);
    }

    public NotFoundException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}
