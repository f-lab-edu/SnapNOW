package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ResultCode;
import kr.flab.snapnow.core.enums.ExceptionCode;

public class BadRequestException extends SnapnowException{

    public BadRequestException() {
        super(ExceptionCode.BAD_REQUEST);
    }

    public BadRequestException(ResultCode resultCode) {
        super(resultCode);
    }

    public BadRequestException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public BadRequestException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public BadRequestException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}
