package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ExceptionCode;
import kr.flab.snapnow.core.enums.ResultCode;

public class NotFoundException extends SnapnowException {

    public NotFoundException() {
        super(ExceptionCode.NOT_FOUND);
    }

    public NotFoundException(ResultCode resultCode) {
        super(resultCode);
    }

    public NotFoundException(String message) {
        super(ExceptionCode.NOT_FOUND, message);
    }

    public NotFoundException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public NotFoundException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public NotFoundException(String message, Throwable cause) {
        super(ExceptionCode.NOT_FOUND, message, cause);
    }

    public NotFoundException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}
