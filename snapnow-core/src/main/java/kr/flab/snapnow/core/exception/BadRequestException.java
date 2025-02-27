package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ResultCode;
import kr.flab.snapnow.core.enums.ExceptionType;

public class BadRequestException extends SnapnowException {

    public BadRequestException() {
        super(ExceptionType.BAD_REQUEST);
    }

    public BadRequestException(ResultCode resultCode) {
        super(resultCode);
    }

    public BadRequestException(String message) {
        super(ExceptionType.BAD_REQUEST, message);
    }

    public BadRequestException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public BadRequestException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public BadRequestException(String message, Throwable cause) {
        super(ExceptionType.BAD_REQUEST, message, cause);
    }

    public BadRequestException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}
