package kr.flab.snapnow.core.exception;

import kr.flab.snapnow.core.enums.ExceptionCode;
import kr.flab.snapnow.core.enums.ResultCode;

public class InternalServerErrorException extends SnapnowException {

    public InternalServerErrorException() {
        super(ExceptionCode.INTERNAL_SERVER_ERROR);
    }

    public InternalServerErrorException(ResultCode resultCode) {
        super(resultCode);
    }

    public InternalServerErrorException(String message) {
        super(ExceptionCode.INTERNAL_SERVER_ERROR, message);
    }

    public InternalServerErrorException(ResultCode resultCode, String message) {
        super(resultCode, message);
    }

    public InternalServerErrorException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(ExceptionCode.INTERNAL_SERVER_ERROR, message, cause);
    }

    public InternalServerErrorException(ResultCode resultCode, String message, Throwable cause) {
        super(resultCode, message, cause);
    }
}
